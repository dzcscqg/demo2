package com.example.demo.controller.wp;

import com.example.demo.entity.Candidate;
import com.example.demo.service.CampusService;
import com.example.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("wp/secret")
public class RollController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private CampusService  campusService;
    @RequestMapping("roll")
    public String roll(int eId, HttpSession httpSession, Model model){
        String account=(String) httpSession.getAttribute("account");
        Candidate candidate=candidateService.selectByAccount(account);
        model.addAttribute("candidate",candidate);
        model.addAttribute("eId",eId);
        model.addAttribute("campus",campusService.selectAll());
       return "wp/roll";
    }
}
