package net.pranonrahman.nettyserver.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Raian Rahman
 * @since 2024.6.4.0
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok("Hello World!");
    }

    @RequestMapping("/hello/{name}")
    public ResponseEntity<String> getHelloName(@PathVariable String name) {
        return ResponseEntity.ok("Hello " + name);
    }
}