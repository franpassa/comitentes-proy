# Etapa 1: Construcción
FROM maven:3.8.1-openjdk-8-slim AS build
WORKDIR /app

# Definir las variables de entorno para la conexión a la base de datos
ENV DATASOURCE_HOST=dpg-cpe8o4tds78s73esbcag-a
ENV DATASOURCE_PORT=5432
ENV DATASOURCE_NAME=comitentesdb
ENV DATASOURCE_USER=admin
ENV DATASOURCE_PASSWORD=Gr9qcAnJIPtjw6Vq6Raqv8J0Tl3hhhiV

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