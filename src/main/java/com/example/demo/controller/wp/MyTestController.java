package com.example.demo.controller.wp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wp/secret")
public class MyTestController {
    @RequestMapping("MyTest")
    public String MyTest() {
        return "wp/MyTest";
    }
}
