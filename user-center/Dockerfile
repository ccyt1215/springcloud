FROM openjdk:8
ENV APP_HOME=/apps
WORKDIR $APP_HOME
COPY ./user-center-1.0-SNAPSHOT.jar ./user.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar"]
CMD ["user.jar"]
