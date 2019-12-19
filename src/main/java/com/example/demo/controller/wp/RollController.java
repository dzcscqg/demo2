package com.example.demo.controller.wp;

import com.example.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("wp/secret")
public class RollController {
    @Autowired
    private CandidateService candidateService;

    @RequestMapping("roll")
    public String roll(HttpSession httpSession){
       return "wp/roll";

    }
}
