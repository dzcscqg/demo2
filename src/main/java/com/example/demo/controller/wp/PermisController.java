package com.example.demo.controller.wp;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Branch;
import com.example.demo.entity.Candidate;
import com.example.demo.entity.Permis;
import com.example.demo.service.BranchService;
import com.example.demo.service.CandidateService;
import com.example.demo.service.PermisService;
import com.example.demo.util.RedisUtil;
import com.example.demo.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("wp/secret")
public class PermisController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private BranchService branchService;
    @Autowired
    private PermisService permisService;
    @Autowired
    private RedisUtils redisUtil;

    @RequestMapping("permis")
    public String permis(int eId, String campus, HttpSession httpSession, Model model) {
        String account = (String) httpSession.getAttribute("account");
        int keys = (int) httpSession.getAttribute("keys");
        //  String nickname=(String) httpSession.getAttribute("nickname");
        Candidate candidate = candidateService.selectByAccount(account);
        Permis permis = new Permis();
        if (eId > 0) {


            String name = candidate.getcName();
            String img = candidate.getcImage();
            String card = candidate.getcIdcard();
            String school = candidate.getcSchool();
            String college = candidate.getcCollege();

            if (!name.isEmpty() && !img.isEmpty() && !card.isEmpty() && !campus.isEmpty()) {
                permis.setpName(name);
                permis.setpImg(img);
                permis.setpCard(card);
                permis.seteSchool(school);
                permis.seteCollege(college);
                permis.seteId(eId);
                permis.setpCampus(campus);
                permis.setcId(keys);
                permis.setpState(1);
                //*关键信息 有了 不适用redis */
                //  redisUtil.set(card+eId,permis,1800);

                redisUtil.set(keys + account + eId, JSON.toJSONString(permis));

                //  permisService.insert(permis);

                return "redirect:TestItem?eId=" + eId;

            } else {
                model.addAttribute("msg", "信息不完整");
                return "error/406";
            }


        }

        return "wp/TestItem";
    }

    @RequestMapping("pay")
    public String pay(int id, Model model) {

        model.addAttribute("branch", branchService.selectByPrimaryKey(id));
        return "wp/pay";
    }
    /**/
    @RequestMapping("toPay")
    public String toPay(int eid,HttpSession httpSession){
        int keys = (int) httpSession.getAttribute("keys");
        String account = (String) httpSession.getAttribute("account");
        Permis permis = JSON.parseObject(redisUtil.get(keys + account + eid), Permis.class);
        permis.setpState(2);
        permisService.update(permis);
        return "redirect:MyTest";
    }
    @RequestMapping("payOrSave")
    public String payOrSave(int bid, int eid, int sign, HttpSession httpSession, Model model) {
        int keys = (int) httpSession.getAttribute("keys");
        int i=permisService.selectByThreeId(eid, keys) ;
        if (i == 0) {
            String account = (String) httpSession.getAttribute("account");
            Permis permis = JSON.parseObject(redisUtil.get(keys + account + eid), Permis.class);

            permis.setpState(1);
            permis.setbId(bid);
            permisService.insert(permis);
            redisUtil.set(keys + account + eid,JSON.toJSONString(permis));
        }
        if (sign == 1) {
            /*去往支付界面*/
            return "redirect:pay?id="+bid;
        } else {
            /*保存后去往我的考试界面*/
            return "redirect:MyTest";
        }


    }



    @RequestMapping("TestItem")
    public String getTestItem(int eId, Model model, HttpSession httpSession) {
        int keys = (int) httpSession.getAttribute("keys");
        String account = (String) httpSession.getAttribute("account");
        Permis permis = JSON.parseObject(redisUtil.get(keys + account + eId), Permis.class);
        model.addAttribute("branch", branchService.selectByEid(eId));
        model.addAttribute("school", permis.geteSchool());
        model.addAttribute("campus", permis.getpCampus());
        return "wp/TestItem";
    }
}
