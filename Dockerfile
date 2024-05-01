FROM openjdk:17-oracle
WORKDIR "/finalproject"
COPY "/build/libs/FinalProject-0.0.1-SNAPSHOT.jar" "final-project.jar"
ENTRYPOINT ["java","-jar","final-project.jar"]