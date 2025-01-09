rm build/libs/*.jar
./gradlew bootjar
docker build -t laloja:latest .
docker tag laloja:latest edurbs/laloja:latest
docker push edurbs/laloja:latest
ssh root@192.168.21.201 '/root/deployLaloja.sh'