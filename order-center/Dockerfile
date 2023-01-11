FROM openjdk:8
ENV APP_HOME=/apps
WORKDIR $APP_HOME
COPY ./order-center-1.0-SNAPSHOT.jar ./order.jar
EXPOSE 8002
ENTRYPOINT ["java","-jar"]
CMD ["order.jar"]
