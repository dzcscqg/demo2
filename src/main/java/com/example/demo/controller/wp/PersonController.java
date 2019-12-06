package com.example.demo.controller.wp;


import com.example.demo.entity.Candidate;
import com.example.demo.service.CandidateService;
import org.apache.tomcat.util.bcel.classfile.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.naming.ldap.PagedResultsControl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Delayed;

@Controller
@RequestMapping("wp/secret")
public class PersonController {
    @Autowired
    private CandidateService candidateService;


    @RequestMapping("PersonalMessage")
    public String getPersonalMessage(HttpSession httpSession, Model model) {
        String account = (String) httpSession.getAttribute("account");
        Candidate candidate = candidateService.selectByAccount(account);
        model.addAttribute("candidate", candidate);
        return "wp/PersonalMessage";
    }

    @RequestMapping(value = "PersonUpLoad", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> PersonUpLoad(MultipartFile file, int keys, HttpServletRequest req) {
        Map<String, Object> map = new HashMap<>();
        if (file == null) {
            map.put("msg", "文件选择为空，请重新选择");
            return map;
        }
        try {
            // 通过ImageReader来解码这个file并返回一个BufferedImage对象
            // 如果找不到合适的ImageReader则会返回null，我们可以认为这不是图片文件
            // 或者在解析过程中报错，也返回false
            Image image = ImageIO.read(file.getInputStream());
            if (image == null) {
                map.put("msg", "只能上传图片类文件");
                return map;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int len = file.getOriginalFilename().length();
        String fileName = System.currentTimeMillis() + keys + file.getOriginalFilename().substring(len - 10, len);
        System.out.println(fileName);
        try {
            //  byte[] bytes = file.getBytes();

            Path path = Paths.get("E:\\2019 junior\\java\\web\\d2\\demo\\target\\classes\\static\\img\\photo\\" + fileName);

            file.transferTo(path);
            // Files.write(path, bytes);
            Candidate candidate = new Candidate();
            candidate.setcId(keys);
            candidate.setcImage("/img/photo/" + fileName);
            candidateService.updateByPrimaryKeySelective(candidate);
            map.put("msg", "修改成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }

    @RequestMapping(value = "PersonAlter", method = RequestMethod.POST)
    @ResponseBody
    public int PersonAlter(String cName, String cIdcard, String cType, String cSchool, String cCollege,
                           String cMajor, String cGrade, String cStuentNum,String cSex, String cClass,HttpSession session) {

        Candidate candidate = new Candidate();
        int cId=(Integer) session.getAttribute("keys");
        if(cIdcard!=null) {
            Candidate candidate1=candidateService.selectByCard(cIdcard);
            if(candidate1==null||candidate1.getcId()==cId) {
                candidate.setcIdcard(cIdcard);
            }else{
                return 204;
            }

        }
        String str[] = {"", "中华人民共和国居民身份证", "台湾居民往来大陆通行证", "港澳居民来往内地通行证", "军人证件", "护照", "香港身份证", "澳门身份证"};
        int type = Integer.parseInt(cType);
        if (type != 0) {
            candidate.setcType(str[type]);
        }
        candidate.setcName(cName);
        candidate.setcCollege(cCollege);
        candidate.setcMajor(cMajor);
        candidate.setcGrade(cGrade);
        candidate.setcStuentNum(cStuentNum);
        candidate.setcId(cId);
        candidate.setcSex(cSex);
        candidate.setcClass(cClass);
        if (candidateService.updateByPrimaryKeySelective(candidate) == 1) {
            return 200;
        }
        return 300;
    }

    @RequestMapping(value = "PersonAlterPwd",method = RequestMethod.POST)
    @ResponseBody
    public int PersonAlterPwd(@RequestParam("oldPwd")  String oldPwd,@RequestParam("newPwd")  String newPwd,HttpSession session){
      int keys=(int)session.getAttribute("keys");

      if(candidateService.selectByPrimaryKeyToPwd(keys).equals(oldPwd)){
          Candidate candidate=new Candidate();
          candidate.setcId(keys);
          candidate.setcPwd(newPwd);
          candidateService.updateByPrimaryKeySelective(candidate);
          return 200;
      }else {
          return 202;
      }

    }
}
