echo Running the application on JVM
time java -jar -server target/simple-cli-1.0-SNAPSHOT-jar-with-dependencies.jar


echo Running the native built application
time ./simple-cli-1.0-SNAPSHOT-jar-with-dependencies
