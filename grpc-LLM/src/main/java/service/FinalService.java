package service;

import com.grpc.ej3.*;
import io.grpc.stub.StreamObserver;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONObject;


public class FinalService extends ResponseServiceGrpc.ResponseServiceImplBase {

    private static final String API_KEY = "AIzaSyDFa8nSiWoqG0xeozY34Ax_lcrn53Hwo8w";
    private static final boolean MODO_LOCAL = false;
    private static final String OLLAMA_MODEL = "gemma3:4b";
    private static final double TEMPERATURE = 0.2;

    @Override
    public void responder(Pregunta req, StreamObserver<Respuesta> obs) {

        String pregunta = req.getMensaje();

        System.out.println("[FinalService] Recibida pregunta: " + pregunta);

        String respuestaLLM;

        if (MODO_LOCAL) {
            respuestaLLM = llamarOllama(pregunta);
        } else {
            respuestaLLM = llamarGemini(pregunta);
        }

        Respuesta resp = Respuesta.newBuilder()
                .setMensaje(respuestaLLM)
                .build();

        System.out.println("[FinalService] Enviando respuesta: " + respuestaLLM);

        obs.onNext(resp);
        obs.onCompleted();
    }

    private String llamarGemini(String preguntaUsuario) {

        String promptBase = "Responde de forma breve, clara y directa: ";
        String prompt = promptBase + preguntaUsuario;

        try {
            HttpClient client = HttpClient.newHttpClient();

            // Body JSON requerido por Gemini
            String body = """
            {
            "contents": [{
                "parts":[{"text":"%s"}]
            }],
            "generationConfig": {
                "temperature": %.2f
            }
            }
            """.formatted(prompt, TEMPERATURE);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(
                        "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key=" 
                        + API_KEY
                    ))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response = client.send(
                    request, HttpResponse.BodyHandlers.ofString()

            );

            // Parsear JSON
            JSONObject json = new JSONObject(response.body());
            JSONArray candidates = json.getJSONArray("candidates");
            JSONObject content = candidates.getJSONObject(0)
                    .getJSONObject("content");

            String texto = content
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");

            return texto;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al consultar Gemini: " + e.getMessage();
        }
    }

    private String llamarOllama(String preguntaUsuario) {

        String systemPrompt = "Responde de forma breve, clara y directa: ";

        try {
            HttpClient client = HttpClient.newHttpClient();

            // JSON para Ollama
            String body = """
            {
            "model": "%s",
            "system": "%s",
            "prompt": "%s",
            "temperature": %.2f
            }
            """.formatted(
                    OLLAMA_MODEL,
                    systemPrompt,
                    preguntaUsuario,
                    TEMPERATURE
            );

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:11434/api/generate"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("=== OLLAMA RESPONSE ===");
            System.out.println(response.body());
            System.out.println("===========================");

            StringBuilder respuestaFinal = new StringBuilder();

            String[] lineas = response.body().split("\n");

            for (String linea : lineas) {
                if (linea.isBlank()) continue;

                JSONObject json = new JSONObject(linea);

                if (json.has("response")) {
                    respuestaFinal.append(json.getString("response"));
                }

                if (json.optBoolean("done", false)) {
                    break;
                }
            }

            return respuestaFinal.toString().trim();

        } catch (Exception e) {
            return "Error al consultar modelo local Ollama: " + e.getMessage();
        }
    }
}
