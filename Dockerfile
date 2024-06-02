# Usar una imagen base de OpenJDK
FROM openjdk:8-jre-slim

# Establecer el directorio de trabajo en /app
WORKDIR /app

# Copiar el JAR de la aplicación al contenedor
COPY target/comitentes-proy-jar.jar app.jar

# Exponer el puerto en el que tu aplicación Spring Boot está configurada para escuchar
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]