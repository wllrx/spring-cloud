package com.zoe.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zoe
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity test() throws InterruptedException {
        Thread.sleep(10000);
        return ResponseEntity.ok("ok");
    }
}
