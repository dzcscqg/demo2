package com.example.demo.controller.bs;

import com.example.demo.config.AllException;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Role;
import com.example.demo.service.AdminService;
import com.example.demo.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("bs")
public class UserController extends AllException {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @RequestMapping("user")
    @RequiresPermissions("101")
    public String getUser(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Admin> adminList = adminService.selectAll2();
        PageInfo<Admin> pageInfo = new PageInfo<Admin>(adminList);


        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("admin", adminList);
        return "bs/user";
    }

    @RequestMapping("changeState")
    @RequiresPermissions("10103")
    @ResponseBody
    public int changestate(int a_id, boolean a_state) {
        return adminService.updateByIdTostate(a_state, a_id);
    }

    @RequestMapping("admindel")
    @RequiresPermissions("10102")
    @ResponseBody
    public int del(int a_id) {
        return adminService.deleteByPrimaryKey(a_id);
    }

    @RequestMapping("selectRoleAll")
    @RequiresPermissions("10105")
    public String selectRoleAll(Model model,int userid){
        Admin admin=adminService.selectByPrimaryKey(userid);
        Role roles=roleService.getInfo(admin.getaLimited());
        List<Role> roleList=roleService.selectAll2();
        model.addAttribute("role2",roles);
        model.addAttribute("role",roleList);
        model.addAttribute("admin",admin);
        return "bs/alterUser";
    }

    @RequestMapping(value = "userAlter",method = RequestMethod.GET)
    @RequiresPermissions("10105")
    @ResponseBody
    public int userAlter(int selected, Boolean state, String email, String password, int aid, String nickname){
        Admin admin=new Admin();
        admin.setaMail(email);
        admin.setaLimited(selected);
        admin.setaState(state);
        admin.setaPassword(password);
        admin.setaId(aid);
        admin.setaName(nickname);

        return adminService.update(admin);

    }
}
