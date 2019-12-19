package com.example.demo.controller.bs;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Role;
import com.example.demo.service.AdminService;
import com.example.demo.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("bs")
public class AddUserController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("addUser")
    @RequiresPermissions("10101")
    public String addUser(Model model) {
        List<Role> roleList = roleService.selectAll2();
        model.addAttribute("role", roleList);
        return "bs/addUser";
    }

    @RequestMapping("userAdd")
    @RequiresPermissions("10101")
    @ResponseBody
    public int userAdd(int selected, Boolean state, String email, String password, String nickname, String phone) {

        if (adminService.selectByAccount(phone) == 0) {
            Admin admin = new Admin();
            admin.setaMail(email);
            admin.setaLimited(selected);
            admin.setaState(state);
            admin.setaPassword(password);

            admin.setaName(nickname);
            admin.setaPhone(phone);
            Date date = new Date();
            admin.setaPhoto("/img/avatar-0.jpg");
            admin.setaCt(getDate());
            return adminService.insert(admin);
        }else {
            return 0;
        }
    }

    public Date getDate() {
        Date date = new Date();
        date.getTime();
        return date;
    }
}
