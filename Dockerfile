FROM openjdk:11-stretch

ARG DEPENDENCY=boot/build
ENV JAVA_OPTS="-Xmx256m -Xms128m"

RUN mkdir -p /opt/application/properties

ADD ${DEPENDENCY}/libs/*.jar /opt/application/app.jar

VOLUME /tmp
VOLUME /opt/app/properties

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /opt/application/app.jar" ]