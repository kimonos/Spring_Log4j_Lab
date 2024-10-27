package com.gss.demo.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class demoController {

    @GetMapping("/view")
    public String view() {
        return "hello";
    }
}
