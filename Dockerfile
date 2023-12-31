# Establecer la imagen base
FROM openjdk:17-jdk

COPY target/NisumApi-1.0.jar app.jar

# Exponer el puerto en el que la aplicación se ejecuta (opcional)
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]

