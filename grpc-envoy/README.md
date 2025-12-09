# proyecto-aos-grpc

Repositorio para la realización del taller avanzado de gRPC y Envoy.

## Resumen
Esta colección de artefactos y ejemplos muestra cómo:
- Desarrollar servicios gRPC en Java (JDK 17+).
- Generar artefactos Protocol Buffers (.pb) para uso con gRPC y Envoy.
- Ejecutar Envoy y servicios en contenedores Docker.
- Conectar máquinas mediante ZeroTier para pruebas distribuídas.

## Requisitos (resumido)
- Java Development Kit (JDK) 17 o superior.  
- Apache Maven.  
- Docker Desktop (Windows: requiere WSL 2).  
- Protocol Buffers Compiler (`protoc`) — genera los archivos `.pb` para gRPC y Envoy.  
- ZeroTier (opcional, para redes privadas entre máquinas).

> Elementos críticos:
> - <span style="color:red">JDK 17+</span>  
> - <span style="color:red">Docker Desktop + WSL 2 (Windows)</span>  
> - <span style="color:red">protoc → genera .pb para Envoy</span>

## Recursos y ayudas
- JDK / Temurin: https://adoptium.net  
- Maven: https://maven.apache.org  
- Docker Desktop: https://www.docker.com/products/docker-desktop  
- Protocol Buffers: https://developers.google.com/protocol-buffers  
- ZeroTier: https://www.zerotier.com/download/

