# wallpaper_calc

#### Build jar: 
`./gradlew build`
#### Run jar: 
`java -jar build/libs/wallpaper_calc-1.0-SNAPSHOT.jar ./sample-input.txt`


#### Install GraalVM with Native Image: 
`bash <(curl -sL https://get.graalvm.org/jdk)`

#### Build GraalVM Native Image:
`./gradlew nativeRun`

#### Run GraalVM Native Image:
`./build/native/nativeCompile/wallpaper_calc ./sample-input.txt`
