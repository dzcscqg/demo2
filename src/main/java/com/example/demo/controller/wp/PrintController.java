package com.example.demo.controller.wp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wp/secret")
public class PrintController {
    @RequestMapping("print")
    public String getPrint(){
        return "wp/Print";
    }
}
