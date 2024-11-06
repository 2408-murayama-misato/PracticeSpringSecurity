package com.example.PracticeSpringSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("hoge")
    public String getHoge() {
        return "hoge";
    }

    @GetMapping("fuga")
    public String getFuga() {
        return "fuga";
    }

    @GetMapping("piyo")
    public String getPiyo() {
        return "piyo";
    }
}
