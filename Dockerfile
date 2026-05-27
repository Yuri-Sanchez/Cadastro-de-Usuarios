FROM eclipse-temurin:21
LABEL maintainer="contato@yurijava.dev"
WORKDIR /app
COPY target/CrudDeUsuarios-0.0.1-SNAPSHOT.jar /app/crud-usuarios.jar
ENTRYPOINT ["java", "-jar", "crud-usuarios.jar"]