package com.example.demo.controller.bs;

import com.example.demo.entity.Campus;
import com.example.demo.entity.Permis;
import com.example.demo.entity.Test;
import com.example.demo.service.CampusService;
import com.example.demo.service.PermisService;
import com.example.demo.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("bs")
public class PermisController {
    @Autowired
    private PermisService permisService;
    @Autowired
    private CampusService campusService;
//    @Autowired
//    private TestService testService;
    @RequestMapping("/grade")
    public String getGrade(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "null",value = "mname") String mname){
        PageHelper.startPage(pageNum, 5);
        if("null".equals(mname)) {
            List<Permis> permisList = permisService.selectpermis();
            PageInfo<Permis> pageInfo = new PageInfo<Permis>(permisList);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("permis", permisList);
        }else{
            List<Permis> permisList = permisService.selectpermis2(mname);
            PageInfo<Permis> pageInfo = new PageInfo<Permis>(permisList);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("permis", permisList);
           // List<Test> test = testService.selectmid2(mid);
            // for (int i=0;i <test.size();i++)
           // List<Permis> permisList = permisService.selectpermistid(test);
           // PageInfo<Permis> pageInfo = new PageInfo<Permis>(permisList);
          //  model.addAttribute("pageInfo", pageInfo);
            //model.addAttribute("permis", permisList);
        }
        List<Campus> campusList = campusService.selectcampuses();
        model.addAttribute("campus", campusList);

        return "bs/grade";
    }
    @RequestMapping("insertgrade")
    @ResponseBody
    public int updategrade(@RequestParam(defaultValue = "0",value = "pid")Integer pid,@RequestParam(defaultValue = "0" ,value = "grade")Integer grade){
        Permis permis = new Permis();
        permis.setpId(pid);
        permis.setpGoal(grade);
        return permisService.updategrade(permis);
    }
}
