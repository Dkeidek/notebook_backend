FROM gradle:8-jdk21 as builder
WORKDIR /
COPY . ./

ENV JDBC_DATABASE_USERNAME=db_u2o2_user
ENV JDBC_DATABASE_PASSWORD=As3hTws5nBATJ3sO1fY8dkXyZN0MZ6t5

RUN gradle build -x test

FROM openjdk:21-slim
COPY --from=builder build/libs .
ENTRYPOINT ["java","-jar","/todolist_backend-0.0.1-SNAPSHOT.jar"]