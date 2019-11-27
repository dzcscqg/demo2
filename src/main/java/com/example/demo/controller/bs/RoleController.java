package com.example.demo.controller.bs;

import com.example.demo.config.AllException;
import com.example.demo.entity.Logs;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Rj;
import com.example.demo.entity.Role;
import com.example.demo.service.AuthorityService;
import com.example.demo.service.RjService;
import com.example.demo.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.jdbc.result.UpdatableResultSet;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("bs")
public class RoleController extends AllException {
    @Autowired
    private RoleService roleService;
    @Autowired
    private RjService rjService;
    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("role")    /*页面权限 和查询权限 由菜单确定*/
    public String role(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                       @RequestParam(defaultValue = "null", value = "search") String search) {

        PageHelper.startPage(pageNum, 5);

        List<Role> roleList = roleService.selectAll(search);
        PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("roles", roleList);
        return "bs/role";
    }

    @RequestMapping(value = "/roleAlter")
    @RequiresPermissions("10503")
    @ResponseBody
    public int alter(int rId, String rRole) {
        Role role = new Role();
        role.setrId(rId);
        role.setrRole(rRole);
        return roleService.updateSelect(role);

    }

    @RequestMapping(value = "/roleDel")
    @RequiresPermissions("10503")
    @ResponseBody
    public int del(int rId) {

        return roleService.del(rId);

    }

    @RequestMapping(value = "/roleAdd")
    @RequiresPermissions("10501")
    @ResponseBody
    public int add(String rRole) {
        Role role = new Role();

        role.setrRole(rRole);
        return roleService.add(role);

    }

    @RequestMapping(value = "/roleAlloc")
    @RequiresPermissions("10504")

    public String roleAlloc(int rid, String rRole, Model model) {
        List<Menu> menuList = authorityService.selectAll();

        model.addAttribute("menu", menuList);
        model.addAttribute("rid", rid);
        model.addAttribute("rRole", rRole);
        return "bs/alloc";

    }

    @RequestMapping(value = "/roleAllocT")
    @RequiresPermissions("10504")
    @ResponseBody
    public int roleAllocT(@RequestParam int rid, @RequestParam(value = "jid[]") int[] jid) {



        return rjService.updateAll(rid,jid);

    }
}
