package net.pranonrahman.nettyserver.config;

import org.springframework.boot.ssl.SslBundle;
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;
import reactor.netty.http.Http3SslContextSpec;
import reactor.netty.http.HttpProtocol;

import java.time.Duration;

/**
 * @author Raian Rahman
 * @since 2024.6.4.0
 */
@Component
class Http3NettyWebServerCustomizer implements WebServerFactoryCustomizer<NettyReactiveWebServerFactory> {

    @Override
    public void customize(NettyReactiveWebServerFactory factory) {
        factory.addServerCustomizers(server -> {
            SslBundle sslBundle = factory.getSslBundles().getBundle("mybundle");
            Http3SslContextSpec sslContextSpec =
                    Http3SslContextSpec.forServer(sslBundle.getManagers().getKeyManagerFactory(), sslBundle.getKey().getPassword());

            return server
                    .protocol(HttpProtocol.HTTP3)
                    .secure(spec -> spec.sslContext(sslContextSpec))
                    .http3Settings(spec -> spec.idleTimeout(Duration.ofSeconds(5))
                            .maxData(10_000_000)
                            .maxStreamDataBidirectionalRemote(1_000_000)
                            .maxStreamsBidirectional(100));
        });
    }
}
