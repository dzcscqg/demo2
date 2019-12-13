package com.example.demo.controller.wp;

import com.example.demo.entity.Order;
import com.example.demo.entity.Permis;
import com.example.demo.mapper.PermisMapper;
import com.example.demo.service.PermisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("wp/secret")
public class MyTestController {
    @Autowired
    private PermisService permisService;
    @RequestMapping("MyTest")
    public String MyTest(HttpSession httpSession, Model model) {
        int Keys=(int)httpSession.getAttribute("keys");
        List<Order> orders=permisService.selectUnite(Keys);
        model.addAttribute("orders",orders);
        return "wp/MyTest";
    }
}
