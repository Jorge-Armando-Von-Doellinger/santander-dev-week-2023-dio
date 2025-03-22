# Use uma imagem base oficial do OpenJDK 19
FROM openjdk:23-jdk-slim

# Instale o Gradle (se não estiver usando o wrapper)
RUN apt-get update && apt-get install -y gradle

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o conteúdo do seu projeto para o diretório de trabalho
COPY . /app/

# Exponha a porta que a aplicação irá rodar
EXPOSE 8080

# Adicione um comando para verificar se a instalação do Gradle foi bem-sucedida
RUN echo "Gradle version: $(gradle -v)"

# Adicione um comando para verificar se o diretório de trabalho está correto
RUN echo "Current working directory: $(pwd)"

# Comando para compilar e rodar o Gradle
CMD ["./gradlew", "clean", "build", "-x", "test"]
