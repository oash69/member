FROM eclipse-temurin:17
EXPOSE 8080
ADD target/bali-member.jar bali-member.jar
ENTRYPOINT ["java","-jar","/bali-member.jar"]

