package com.example.dyb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthCheckController {
    @GetMapping(value = "/healthcheck")
    public String healthCheck() {
        return "OK";
    }

    @PutMapping(value = "/healthcheck", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> healthCheckPut(@RequestParam String format) {

        if ("full".equals(format)) {
            return new ResponseEntity<>(String.valueOf(System.currentTimeMillis()), HttpStatus.OK);
        }
        if ("short".equals(format)) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/healthcheck")
    public HttpStatus healthCheckPost() {
        return HttpStatus.BAD_REQUEST;
    }


    @DeleteMapping(value = "/healthcheck")
    public void healthCheckDelete() {
        return;
    }
}
