# Usa OpenJDK 23
FROM openjdk:23-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia arquivos essenciais primeiro
COPY gradlew ./
COPY gradle gradle
COPY build.gradle.kts settings.gradle.kts ./

# Dá permissão ao Gradle Wrapper
RUN chmod +x gradlew

# Define o JAVA_HOME corretamente
ENV JAVA_HOME=/usr/local/openjdk-23
ENV PATH="${JAVA_HOME}/bin:${PATH}"

# Verifica a instalação do Java (opcional, mas útil para debug)
RUN java -version

# Baixa as dependências antes de copiar o código-fonte
RUN ./gradlew dependencies --no-daemon

# Copia todo o código depois (para evitar baixar dependências toda vez)
COPY . .

# Exponha a porta da aplicação
EXPOSE ${SERVERPORT}
# Constrói o projeto sem rodar testes
RUN ./gradlew clean build -x test

CMD ["java", "-jar", "build/libs/santander-dev-week-2023-dio-0.0.1-SNAPSHOT.jar"]
