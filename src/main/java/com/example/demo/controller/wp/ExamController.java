package com.example.demo.controller.wp;

import com.example.demo.entity.Exam;
import com.example.demo.service.CandidateService;
import com.example.demo.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("wp")
public class ExamController {
    @Autowired
    private ExamService examService;
    @Autowired
    private CandidateService candidateService;
    @RequestMapping("Exam")
    public String  Exam(Model model, HttpSession httpSession){

        String account =(String)httpSession.getAttribute("account");
        if(account==null){
            httpSession.setAttribute("sign","si");
            return "redirect:login";
        }else{
            int keys=(int) httpSession.getAttribute("keys");
            List<Exam> exams=examService.selectAllByStateAndAccount(keys);

            model.addAttribute("exam",exams);
            return "wp/Exam";

        }

    }
}
