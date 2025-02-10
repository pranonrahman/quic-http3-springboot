package net.pranonrahman.http3client.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author Raian Rahman
 * @since 2024.6.4.0
 */
@RestController
@RequiredArgsConstructor
public class RemoteController {

    private final WebClient http3WebClient;

    @RequestMapping("/remote")
    public Mono<String> getRemoteResponse() {
        return http3WebClient
                .get()
                .uri("https://localhost:8443/hello/raian")
                .retrieve()
                .bodyToMono(String.class);
    }
}