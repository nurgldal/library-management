# Temel imaj: OpenJDK 17
FROM openjdk:17-jdk-slim
# JAR dosyasını konteynerin içine kopyala
COPY target/libraryManagement-0.0.1-SNAPSHOT.jar app.jar

# Uygulama çalıştırma komutu
ENTRYPOINT ["java", "-jar", "app.jar"]

