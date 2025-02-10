package net.pranonrahman.http3client.config;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.HttpProtocol;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;
import java.time.Duration;

/**
 * @author Raian Rahman
 * @since 2024.6.4.0
 */
@Configuration
public class WebConfig {

    @Bean
    WebClient http3WebClient(WebClient.Builder builder) throws SSLException {
        SslContext sslContext = SslContextBuilder
                .forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();


        HttpClient client =
                HttpClient.create()
                        .protocol(HttpProtocol.HTTP3)
//                        .secure(spec -> spec.sslContext(sslContext))
                        .http3Settings(spec -> spec
                                .idleTimeout(Duration.ofSeconds(5))
                                .maxData(10_000_000)
                                .maxStreamDataBidirectionalLocal(1_000_000));

        return builder
                .clientConnector(new ReactorClientHttpConnector(client))
                .defaultHeader(HttpHeaders.USER_AGENT, "Mozilla/5.0 (X11; Linux x86_64; rv:103.0) Gecko/20100101 Firefox/103.0")
                .build();
    }
}
