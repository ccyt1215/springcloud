FROM openjdk:8
ENV APP_HOME=/apps
WORKDIR $APP_HOME
COPY ./gateway-1.0-SNAPSHOT.jar ./gateway.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar"]
CMD ["gateway.jar"]
