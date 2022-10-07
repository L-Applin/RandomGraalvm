package ca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.utils.cache.CachedSupplier;
import software.amazon.awssdk.utils.cache.RefreshResult;

// demo class for testing runtime initialization of the static Random field reference of CachedSupplier class
// for GraalVM
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        log.info("================================================");
        log.info("Application starts");
        try (CachedSupplier<String> supp = CachedSupplier.builder(() -> RefreshResult.builder("Hello World").build()).build();
                SdkHttpClient client = UrlConnectionHttpClient.builder().build();
                SdkAsyncHttpClient netty = NettyNioAsyncHttpClient.builder().build()) {
            log.info(client.clientName());
            log.info(netty.clientName());
            log.info(supp.get());
        }
        log.info("Application finishes");
        log.info("================================================");
    }
}
