FROM java:openjdk-8u91-jdk
ARG VERSION
CMD java ${JAVA_OPTS} -jar character-service-${VERSION}.jar
EXPOSE 8080
COPY target/character-service-${VERSION}.jar .
