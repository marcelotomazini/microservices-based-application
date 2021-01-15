FROM java:openjdk-8u91-jdk
ARG VERSION
CMD java ${JAVA_OPTS} -jar house-service-${VERSION}.jar
EXPOSE 8080
COPY target/house-service-${VERSION}.jar .
