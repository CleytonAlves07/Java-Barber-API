FROM maven:3.9.6-eclipse-temurin-21-alpine

ENV INSTALL_PATH /barber-shop-api

RUN mkdir $INSTALL_PATH

WORKDIR $INSTALL_PATH

COPY . .

RUN mvn clean install -DskipTests

CMD ["mvn", "spring-boot:run"]