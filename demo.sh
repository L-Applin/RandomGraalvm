set -e

# works using 22.2.r17-grl
./gradlew clean shadowJar
native-image --verbose --no-fallback \
    --initialize-at-build-time=org.slf4j \
    --initialize-at-run-time=io.netty.handler.ssl.BouncyCastleAlpnSslUtils \
    -jar build/libs/RandomGraalvm-all.jar \
    build/main
build/main