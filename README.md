# CALCULATOR APP 

### 1. Introducción
En este proyecto se desarrolla una calculadora con operaciones básicas de suma y resta, utilizando como puerta de entrada una API REST.
Para llevar a cabo el desarrollo del microservicio se han utilizado las siguiente tecnologías software:
- Java 8
- Spring Boot 2.2.11
- Maven 3.6.3
- JUnit 5
- Mockito
- IntelliJ
- Git Flow
- Repositorio GitHub

### 2. Creación del proyecto
Se ha utilizado _Spring initializr_ para generar el proyecto Maven y se ha importado después en IntelliJ.

A continuación se ha generado un repositorio en GitHub para alojar el código del proyecto. Y de esta forma poder gestionar mediante Git el control de cambios.

### 2. Dependencias del proyecto
Se han integrado las siguientes dependencias a través de Maven:
- Spring-boot-starter
- Spring-boot-starter-test
- Spring-boot-starter-web
- Lombok
- Swagger-UI
- Apache commons lang3

Además se ha incorporado la librería externa *_tracer_*, cuyos ficheros _.jar_ han sido proporcionados inicialmente. Con esta librería se ha mostrado la traza de ciertas operaciones.

Pasos seguidos para instalar la librería *_tracer_*:
- Crear carpeta _/lib_, dentro de la carpeta _/src_ del proyecto
- Alojar los ficheros _.jar_ proporcionados en dicha carpeta
- Añadir en el fichero _pom.xml_ la siguiente dependencia:
```
<dependency>
    <groupId>io.corp.calculator</groupId>
    <artifactId>tracer</artifactId>
    <version>1.0</version>
    <scope>system</scope>
    <systemPath>${pom.basedir}/src/lib/tracer-1.0.0.jar</systemPath>
</dependency>
```

Por último, al actualizar el proyecto Maven se observa como la librería está incluida en las dependencias del proyecto.