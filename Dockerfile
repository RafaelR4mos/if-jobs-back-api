FROM openjdk:17-alpine
COPY . .
# Instalar o Node.js e npm
RUN apk add --update maven
RUN mvn clean package -Dmaven.test.skip=true
# Definir o diretório de trabalho
WORKDIR /app
# Copiar o arquivo JAR do projeto Spring Boot para o contêiner
RUN cp /target/if-jobs-0.0.1-SNAPSHOT.jar /app/if-jobs.jar

EXPOSE 8080

# Definir o comando padrão para iniciar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "if-jobs.jar"]