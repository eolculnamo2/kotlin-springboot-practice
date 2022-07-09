# kotlin dashboard practice

### First time setup
1. Run docker to create db:
docker-compose up --build -d
2. Build project
./gradlew build
3. Run flywheel migrations:
./gradlew flywheelMigrate -i
4. Run project
./gradlew bootRun


