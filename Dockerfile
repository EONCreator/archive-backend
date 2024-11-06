FROM gradle:jdk21 AS build
WORKDIR /app
COPY gradlew ./
COPY gradle/ ./gradle/
COPY build.gradle ./
COPY settings.gradle ./
COPY src ./src

# Делаем gradlew исполняемым
RUN chmod +x gradlew
RUN ./gradlew clean bootJar --refresh-dependencies

# Создаем финальный образ
FROM gradle:jdk21

WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]