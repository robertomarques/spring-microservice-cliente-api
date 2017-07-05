FROM java:8
VOLUME tmp
ADD . /tmp
EXPOSE 8080
CMD ["java", "-jar", "/tmp/build/libs/cliente-api.jar"]