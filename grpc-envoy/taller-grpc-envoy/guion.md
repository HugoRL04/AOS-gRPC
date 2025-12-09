# Guía Rápida / Cheat Sheet - Taller gRPC y Envoy

Esta lista asume el escenario "Modo Desarrollo" que configuramos al final: tú ejecutas Java en tu ordenador (para ver logs y debuggear) y Envoy en Docker.

## Prerrequisitos

Tener abierta la terminal en la carpeta raíz `taller-grpc-envoy`.

## Fase 1: Preparación y Construcción (Solo Terminal 1)

Ejecuta estos comandos una sola vez para preparar los binarios.

1.  **Generar el descriptor `.pb` para Envoy:** (Es una sola línea)

    ```bash
    protoc -I=src/main/proto --include_imports --include_source_info --descriptor_set_out=envoy/proto.pb src/main/proto/order_service.proto
    ```

2.  **Compilar el código Java y crear el JAR:**

    ```bash
    mvn clean package -DskipTests
    ```

## Fase 2: Ejecución (Necesitas 2 Terminales)

### Terminal 1: Levantar Envoy (El Proxy)

Asegúrate de que tu `docker-compose.yml` tiene la configuración `extra_hosts` y no levanta `java-app`.

```bash
docker-compose up
```

(Espera a que diga "starting workers" y déjala abierta).

### Terminal 2: Levantar Java (Tu Servidor)

Ejecutamos el JAR que compilamos en la Fase 1.

```bash
java -jar target/grpc-native-workshop-1.0-SNAPSHOT.jar
```

(Espera a que diga "Servidor gRPC iniciado en el puerto 9090").

## Fase 3: Pruebas (Terminal 3)

Ejecutar el script de test:

```bash
pruebas_grpc_envoy.bat
```

## Fase 4: Limpieza (Al terminar el taller)

*   **Terminal Java:** Presiona `Ctrl + C`.
*   **Terminal Docker:** Presiona `Ctrl + C` y luego ejecuta:

    ```bash
    docker-compose down
    ```