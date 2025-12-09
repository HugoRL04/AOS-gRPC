#!/bin/bash

# Limpiamos la pantalla
clear

# --- CONFIGURACION ---
URL="http://localhost:8080/v1/orders"

echo "========================================================"
echo "   TEST TALLER gRPC-REST (Modo Verboso - Linux/Mac)"
echo "========================================================"
echo ""

# ---------------------------------------------------------
# PASO 1: CREAR ORDEN (POST)
# ---------------------------------------------------------
echo "[PASO 1] Creando una Orden..."
echo ""

# 1. Preparamos el JSON en un archivo
# Nota: Usamos comillas simples en 'JSON_CONTENT' para que bash no interprete las comillas dobles internas
JSON_CONTENT='{"customer_id": "Cliente_Bash_Visual", "items": [{"product_id": "Laptop_Pro", "quantity": 1, "price": 1200.50}]}'
echo "$JSON_CONTENT" > orden_temp.json

# 2. Mostramos el comando (Simulacion visual)
echo "--------------------------------------------------------"
echo "[COMANDO A EJECUTAR]:"
echo "curl -X POST $URL \\"
echo "      -H \"Content-Type: application/json\" \\"
echo "      -d '$JSON_CONTENT'"
echo "--------------------------------------------------------"
echo ""

# 3. Ejecutamos el comando real
curl -X POST "$URL" -H "Content-Type: application/json" -d @orden_temp.json

echo ""
echo ""
echo "========================================================"
echo "  ARRIBA DEBERIAS VER EL JSON DE RESPUESTA."
echo "  BUSCA EL 'order_id' Y COPIALO."
echo "========================================================"
echo ""

# --- INPUT MANUAL ---
# 'read -p' es el equivalente a 'set /p'
read -p ">> PEGA EL ID AQUI Y DALE ENTER: " id
echo ""

# ---------------------------------------------------------
# PASO 2: CONSULTAR (GET)
# ---------------------------------------------------------
echo ""
echo "[PASO 2] Consultando la Orden..."
echo ""

# Mostramos el comando
echo "--------------------------------------------------------"
echo "[COMANDO A EJECUTAR]:"
echo "curl -X GET $URL/$id"
echo "--------------------------------------------------------"
echo ""

# Ejecutamos
curl -X GET "$URL/$id"

echo ""
echo ""

# ---------------------------------------------------------
# PASO 3: PROBAR ERROR 404
# ---------------------------------------------------------
echo ""
echo "[PASO 3] Probando Error 404 (ID Inexistente)..."
echo ""

# Mostramos el comando
echo "--------------------------------------------------------"
echo "[COMANDO A EJECUTAR]:"
echo "curl -v -X GET $URL/ID_FALSO_123"
echo "--------------------------------------------------------"
echo ""

# Ejecutamos.
# Nota: '2>&1' redirige stderr a stdout. 'grep' reemplaza a 'findstr'.
curl -v -X GET "$URL/ID_FALSO_123" 2>&1 | grep "HTTP/1.1 404"

echo ""
echo ""
echo "[FIN DEL TEST]"

# Limpieza
if [ -f orden_temp.json ]; then
    rm orden_temp.json
fi

# Pausa final (read sin variable espera un enter)
read -p "Presiona ENTER para salir..."