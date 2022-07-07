package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MyController {

    private final MyService myService;

    @GetMapping("/mark/{willFail}")
    public ResponseEntity<String> mark(@PathVariable final boolean willFail) {
        myService.mark(willFail);
        return ResponseEntity.ok("Marked");
    }
}
