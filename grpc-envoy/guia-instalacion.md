# Guía de Instalación de Dependencias

Este documento detalla el software necesario para ejecutar el proyecto del taller de gRPC. Las instrucciones están separadas por sistema operativo (Windows, macOS y Linux).

## Resumen de Software

1.  **Java Development Kit (JDK)**: <span style="color:red">**Versión 17 o superior**</span>.
2.  **Apache Maven**: Para compilar y gestionar el proyecto Java.
3.  **Docker**: Para ejecutar el proxy Envoy en un contenedor.
4.  **Protocol Buffers Compiler (`protoc`)**: Para compilar los archivos `pb`.
5.  **ZeroTier**: Para crear una red virtual segura entre máquinas.

---

## 1. Java Development Kit (JDK 17)

![Java Logo](https://www.oracle.com/a/ocom/img/cb71-java-logo.png)

<span style="color:red">**Es fundamental para compilar y ejecutar la aplicación gRPC.**</span>

### Windows

La forma más sencilla es usar el gestor de paquetes Chocolatey.

```powershell
# 1. Abre PowerShell como Administrador
# 2. Ejecuta el comando de instalación
choco install openjdk17
```

**Alternativa manual**: Descarga el instalador desde la página web oficial de [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)


### macOS

La forma recomendada es usar el gestor de paquetes Homebrew.

```bash
# 1. Abre tu terminal
# 2. Ejecuta el comando de instalación
brew install openjdk@17

# 3. Sigue las instrucciones que mostrará Homebrew para añadir Java al PATH
```

### Linux (Debian/Ubuntu)

```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

---

## 2. Apache Maven

![Maven Logo](https://maven.apache.org/images/maven-logo-black-on-white.png)

Herramienta para la construcción y gestión de dependencias del proyecto Java.

### Windows

```powershell
# Usando Chocolatey
choco install maven
```

**Alternativa manual**:
1. Descarga la distribución binaria desde [Apache Maven](https://maven.apache.org/download.cgi)
2. Descomprime el archivo en una carpeta (ej: `C:\Program Files\apache-maven`)
3. <span style="color:red">**Añade la carpeta `bin` a la variable de entorno `Path`**</span>
4. Verifica la instalación: `mvn -v`

### macOS

```bash
# Usando Homebrew
brew install maven
```

**Alternativa manual**:
1. Descarga la distribución binaria desde [Apache Maven](https://maven.apache.org/download.cgi)
2. Descomprime el archivo en una carpeta (ej: `~/apache-maven`)
3. <span style="color:red">**Añade la carpeta `bin` al `PATH` en tu `~/.zshrc` o `~/.bash_profile`:**</span>
   ```bash
   export PATH="$PATH:~/apache-maven/bin"
   ```
4. Recarga la configuración: `source ~/.zshrc`
5. Verifica la instalación: `mvn -v`

### Linux (Debian/Ubuntu)

```bash
sudo apt update
sudo apt install maven
```

---

## 3. Docker

![Docker Logo](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJl4fp0SkQbTPU5ZxVl6AKWYuKCwM0gIhNtQ&s)

Necesario para ejecutar el proxy Envoy y otros servicios en contenedores.

### Windows

<span style="color:red">**WSL 2 (Windows Subsystem for Linux 2) es requerido antes de instalar Docker Desktop.**</span>

#### Instalación de WSL 2

1. Abre **PowerShell como Administrador**
2. Ejecuta el siguiente comando:
   ```powershell
   wsl --install
   ```
3. <span style="color:red">**Reinicia tu sistema cuando se solicite**</span>
4. Después del reinicio, se instalará Ubuntu automáticamente
5. Configura tu usuario y contraseña en Ubuntu
6. Verifica la instalación: `wsl --list --verbose`

#### Instalación de Docker Desktop

<span style="color:red">**La mejor opción es **Docker Desktop**. Descárgalo desde la web oficial y sigue el asistente de instalación.**</span>

1. Descarga el instalador desde [Docker Desktop](https://www.docker.com/products/docker-desktop)
2. Ejecuta el instalador `.exe` y sigue las instrucciones
3. <span style="color:red">**Reinicia tu sistema si es necesario**</span>
4. Verifica la instalación: `docker --version`

### macOS

<span style="color:red">**La mejor opción es **Docker Desktop**. Descárgalo desde la web oficial y sigue el asistente de instalación.**</span>

**Alternativa manual para macOS**:
1. Descarga Docker Desktop desde [Docker Hub](https://www.docker.com/products/docker-desktop)
2. Abre el archivo `.dmg` y arrastra Docker a Applications
3. Ejecuta Docker desde Applications
4. Verifica la instalación: `docker --version`

### Linux

Se recomienda seguir la guía oficial para instalar Docker Engine desde los repositorios de Docker.

1.  **Sigue la guía para tu distribución**: Instalación de Docker en Ubuntu.
2.  <span style="color:red">**(Recomendado)** Completa los pasos post-instalación para Linux para poder ejecutar Docker sin `sudo`.</span>

---

## 4. Protocol Buffers Compiler (`protoc`)

![Protocol Buffers Logo](https://miro.medium.com/0*ZcxyFvZ3JB5Lxsb2.png)

<span style="color:red">**Compilador para los archivos de definición de servicios `.proto` que genera los archivos `.pb` necesarios para gRPC y Envoy.**</span>

### Windows

1.  Ve a la página de releases de Protobuf en GitHub.
2.  <span style="color:red">**Descarga el archivo `protoc-x.x.x-win64.zip` (usa la última versión estable).**</span>
3.  Descomprime el archivo.
4.  <span style="color:red">**Añade la ruta a la carpeta `bin` que acabas de descomprimir a la variable de entorno `Path` de tu sistema.**</span>

### macOS

```bash
# Usando Homebrew
brew install protobuf
```

**Alternativa manual**:
1. Ve a la [página de releases de Protobuf](https://github.com/protocolbuffers/protobuf/releases)
2. <span style="color:red">**Descarga el archivo `protoc-x.x.x-osx-x86_64.zip` (o versión ARM si usas Mac M1/M2)**</span>
3. Descomprime el archivo en una carpeta (ej: `~/protobuf`)
4. <span style="color:red">**Añade la carpeta `bin` al `PATH` en tu `~/.zshrc` o `~/.bash_profile`:**</span>
   ```bash
   export PATH="$PATH:~/protobuf/bin"
   ```
5. Recarga la configuración: `source ~/.zshrc`
6. Verifica la instalación: `protoc --version`

### Linux (Debian/Ubuntu)

```bash
sudo apt update
sudo apt install protobuf-compiler
```

### Uso de `protoc`

<span style="color:red">**`protoc` compila los archivos `.proto` y genera los archivos `.pb` (Protocol Buffers binarios) que son utilizados por:**</span>
- <span style="color:red">**gRPC**</span>: Para la serialización y deserialización de mensajes entre cliente y servidor
- <span style="color:red">**Envoy**</span>: Para la configuración y enrutamiento de servicios

Ejemplo de uso:
```bash
protoc --java_out=. --grpc-java_out=. archivo.proto
```

---

## 5. ZeroTier

![ZeroTier Logo](https://upload.wikimedia.org/wikipedia/commons/f/f1/ZeroTier_Logo.png)

Software para crear una red virtual privada (VPN) que permite conectar máquinas de forma segura sin configurar puertos o firewalls.

### Windows

```powershell
# Usando Chocolatey
choco install zerotier-one
```

**Alternativa manual**:
1. Descarga el instalador desde [ZeroTier](https://www.zerotier.com/download/)
2. Ejecuta el instalador `.msi` y sigue las instrucciones
3. Reinicia tu sistema si es necesario
4. Verifica la instalación: `zerotier-cli info` en PowerShell

**Uso de la interfaz gráfica (UI)**:
1. <span style="color:red">**Después de instalar, ZeroTier aparecerá como un icono en la **barra de tareas** (esquina inferior derecha)**</span>
2. Haz clic derecho sobre el icono de ZeroTier para abrir el menú contextual
3. En la ventana que se abre, puedes:
   - <span style="color:red">**Ver tu dirección de identidad (10 caracteres)**</span>
   - Unirte a una red introduciendo el ID de la red
   - Ver el estado de las redes a las que estás conectado

### macOS

```bash
# Usando Homebrew
brew install zerotier-one
```

**Alternativa manual**:
1. Descarga el instalador `.pkg` desde [ZeroTier](https://www.zerotier.com/download/)
2. Abre el archivo y sigue las instrucciones de instalación

### Linux (Debian/Ubuntu)

```bash
# Instalación automática
curl https://install.zerotier.com | sudo bash

# O manual desde repositorios
sudo apt update
sudo apt install zerotier-one
```

### Configuración común (Windows, macOS y Linux)

Después de instalar ZeroTier:

1.  <span style="color:red">**Obtén tu dirección de identidad:**</span>
    ```bash
    zerotier-cli info
    ```
    <span style="color:red">**Anota la dirección de 10 caracteres que aparece.**</span>

2.  **Únete a una red** (reemplaza `networkId` con tu ID de red):
    ```bash
    zerotier-cli join <networkId>
    ```

3.  **Verifica tu conexión**:
    ```bash
    zerotier-cli listnetworks
    ```

4.  **(Opcional)** Para una mejor experiencia, puedes usar la aplicación de escritorio de ZeroTier disponible en [zerotier.com](https://www.zerotier.com/download/)
