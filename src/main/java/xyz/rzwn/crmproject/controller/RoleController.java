package xyz.rzwn.crmproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import xyz.rzwn.crmproject.dto.RoleDto;
import xyz.rzwn.crmproject.service.RoleService;

import java.util.List;

@Controller
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService=roleService;
    }

    @GetMapping("/role")
    public String roleList(Model model){
        List<RoleDto> role = roleService.findAllRole();
        model.addAttribute("role",role);
        model.addAttribute("pageTitle","Role List");
        return "role-list";
    }

}
