@echo off
setlocal EnableDelayedExpansion
CLS

REM --- CONFIGURACION ---
set "URL=http://localhost:8080/v1/orders"

echo ========================================================
echo   TEST TALLER gRPC-REST (Modo Verboso)
echo ========================================================
echo.

REM ---------------------------------------------------------
REM PASO 1: CREAR ORDEN (POST)
REM ---------------------------------------------------------
echo [PASO 1] Creando una Orden...
echo.

REM 1. Preparamos el JSON en un archivo (para evitar problemas de comillas en CMD)
set "JSON_CONTENT={"customer_id": "Cliente_CMD_Visual", "items": [{"product_id": "Laptop_Pro", "quantity": 1, "price": 1200.50}]}"
echo %JSON_CONTENT% > orden_temp.json

REM 2. Mostramos el comando que vamos a ejecutar (Simulacion visual)
echo --------------------------------------------------------
echo [COMANDO A EJECUTAR]:
echo curl -X POST %URL% ^
echo      -H "Content-Type: application/json" ^
echo      -d '%JSON_CONTENT%'
echo --------------------------------------------------------
echo.

REM 3. Ejecutamos el comando real
curl -X POST %URL% -H "Content-Type: application/json" -d @orden_temp.json

echo.
echo.
echo ========================================================
echo  ARRIBA DEBERIAS VER EL JSON DE RESPUESTA.
echo  BUSCA EL "order_id" Y COPIALO.
echo ========================================================
echo.

REM --- INPUT MANUAL ---
set /p id=">> PEGA EL ID AQUI Y DALE ENTER: "
echo.

REM ---------------------------------------------------------
REM PASO 2: CONSULTAR (GET)
REM ---------------------------------------------------------
echo.
echo [PASO 2] Consultando la Orden...
echo.

REM Mostramos el comando
echo --------------------------------------------------------
echo [COMANDO A EJECUTAR]:
echo curl -X GET %URL%/%id%
echo --------------------------------------------------------
echo.

REM Ejecutamos
curl -X GET %URL%/%id%

echo.
echo.

REM ---------------------------------------------------------
REM PASO 3: PROBAR ERROR 404
REM ---------------------------------------------------------
echo.
echo [PASO 3] Probando Error 404 (ID Inexistente)...
echo.

REM Mostramos el comando
echo --------------------------------------------------------
echo [COMANDO A EJECUTAR]:
echo curl -v -X GET %URL%/ID_FALSO_123
echo --------------------------------------------------------
echo.

REM Ejecutamos (filtramos para resaltar el 404 si es posible, o mostramos todo)
curl -v -X GET %URL%/ID_FALSO_123 2>&1 | findstr "HTTP/1.1 404"

echo.
echo.
echo [FIN DEL TEST]
REM Limpieza
if exist orden_temp.json del orden_temp.json
pause