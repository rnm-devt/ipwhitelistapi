package com.rnmandap.ipwhitelistapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MController {

    @GetMapping
    public String hello(){
        return "Hello, world!";
    }

}
