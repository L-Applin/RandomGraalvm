# RandomGraalvm

small demo App to try to reproduce AWS Java SDK v2 [Issue #3323](https://github.com/aws/aws-sdk-java-v2/issues/3323)

With GraalVM `22.2.r17-grl`:

```
gradle shadowJar
native-image --verbose --no-fallback \
    --initialize-at-build-time=org.slf4j \
    --initialize-at-run-time=io.netty.handler.ssl.BouncyCastleAlpnSslUtils \
    -jar build/libs/RandomGraalvm-all.jar \
    build/main
build/main
```

Can also be run with the `demo.sh` script.
