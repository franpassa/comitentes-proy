# Etapa 1: Construcción
FROM maven:3.8.1-openjdk-8-slim AS build
WORKDIR /app

# Copiar el pom.xml y descargar las dependencias
COPY pom.xml .
RUN mvn -B dependency:resolve

# Copiar el código fuente y construir el proyecto
COPY src ./src
RUN mvn -B package -DskipTests

# Etapa 2: Ejecución
FROM openjdk:8-jre-slim
WORKDIR /app

# Copiar el JAR desde la etapa de construcción
COPY --from=build /app/target/comitentes-proy-1.0-SNAPSHOT.jar app.jar

# Exponer el puerto en el que tu aplicación Spring Boot está configurada para escuchar
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]