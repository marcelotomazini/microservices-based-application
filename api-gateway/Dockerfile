FROM java:openjdk-8u91-jdk
CMD java ${JAVA_OPTS} -jar api-gateway-${VERSION}.jar
EXPOSE 8080
COPY target/api-gateway-${VERSION}.jar .
