package com.example.demo.controller.bs;

import com.example.demo.entity.Campus;
import com.example.demo.entity.Test;
import com.example.demo.service.CampusService;
import com.example.demo.service.TestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("bs")
public class TestController {
    @Autowired
    private TestService testService;
    @Autowired
    private CampusService campusService;
    @RequestMapping("session")
    @RequiresPermissions("204")
    public String getUser(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, @RequestParam(defaultValue = "0",value = "mid") int mid,@RequestParam(defaultValue = "null",value = "kcdz") String kcdz) {

        PageHelper.startPage(pageNum, 5);


        if(mid != 0 ) {
            System.out.println(kcdz);
            System.out.println("sdfsdfdfs");
            List<Test> testList = testService.selectmid(mid);
            List<Campus> campusList = campusService.selectcampuses();
            //System.out.println(testList);
            PageInfo<Test> pageInfo = new PageInfo<Test>(testList);
            //  List<Campuses> campusesList =campusesService.selectmid(testList);
            model.addAttribute("campus",campusList);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("test", testList);
     }
        else if (!"null".equals(kcdz)){
            System.out.println(kcdz);
            System.out.println("12312313212");
            List<Test> testList = testService.selectkcdz(kcdz);
            List<Campus> campusList = campusService.selectcampuses();
            //System.out.println(testList);
            PageInfo<Test> pageInfo = new PageInfo<Test>(testList);
            //  List<Campuses> campusesList =campusesService.selectmid(testList);
            model.addAttribute("campus",campusList);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("test", testList);
        }
        else {
            System.out.println(kcdz);
        System.out.println("jdfdkf852852");
        List<Test> testList = testService.selecttest();
        List<Campus> campusList = campusService.selectcampuses();
        //System.out.println(testList);
        PageInfo<Test> pageInfo = new PageInfo<Test>(testList);
        //  List<Campuses> campusesList =campusesService.selectmid(testList);
        model.addAttribute("campus", campusList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("test", testList);
        }
        return "bs/test";
    }
    @RequestMapping("changemid")
    @ResponseBody
    public int changemid(int mid,int tid){
        System.out.println(mid);
        Test test = new Test();
        test.setmId(mid);
        test.settId(tid);
        return testService.changemid(test);
    }
    @RequestMapping("123456")
    public String kk123456(){
        return "bs/123456";
    }
    @RequestMapping("sessiondel")
    @ResponseBody
    public int delectsession(Integer tid) {
        // System.out.println(tid);
        return testService.delectsession(tid);
    }

    @RequestMapping("addsession")
    public String addsession(Model model) {
//        List<Test> testList = testService.selecttest();
//        model.addAttribute("test", testList);
        List<Campus> campusesList = campusService.selectcampuses();
        model.addAttribute("campuses",campusesList);
        return "bs/addsession";
    }
    @RequestMapping("sessionAdd")
    @ResponseBody
    public int sessionAdd(int kch, String kcdz, int kcrs,int xzxq) {
        if (testService.selectkch(kch) == null) {
            Test test = new Test();
            test.setmId(xzxq);
            test.settNum(kch);
            test.settHall(kcdz);
            test.settLimited(kcrs);
            return testService.insert(test);
        } else {
            return 0;
        }
    }
    @RequestMapping("changesession")
    public String changesession(Model model,int kid) {
//        Test test = testService.selectid(tid);
//        model.addAttribute("test", test);
//        System.out.println(tid);
//        System.out.println(test);
//        System.out.println(kcdz);
//        Test test= new Test();
//        test.settNum(kch);
//        test.settHall(kcdz);
//        test.settLimited(kcrs);
//        test.settId(kid);
        Test test =testService.selectid(kid);
        model.addAttribute("test",test);
        System.out.println(test);
        return "bs/changesession";
    }


    @RequestMapping("sessionchange")
    @ResponseBody
    public int sessionchange(int kch,String kcdz,int kcrs,int kid){

        Test test =new Test();
        test.settId(kid);
        test.settNum(kch);
        test.settHall(kcdz);
        test.settLimited(kcrs);
        if(kch !=0&&kcdz !=null&&kcrs <= 30){
       return testService.updatesession(test);
        }else{return 0;}

       // Test test = testService.selectkch(kch);
     //   testService.updatesession(test);
//        System.out.println(kch);
//        Test test = new Test();
//        test.settNum(kch);
//        test.settHall(kcdz);
//        test.settLimited(kcrs);
//        System.out.println(kcdz);
//        model.addAttribute("test",test);
//        return "bs/sessionchange";
        }

}
