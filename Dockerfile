FROM openjdk

WORKDIR /root/

COPY . .

RUN mvn package

EXPOSE 80

CMD ["java", "-jar", "DesafioSerasaExperian.jar"]