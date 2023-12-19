package xyz.rzwn.crmproject.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import xyz.rzwn.crmproject.dto.UserDto;
import xyz.rzwn.crmproject.model.User;
import xyz.rzwn.crmproject.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model){
        List<UserDto> users = userService.findAllUser();
        model.addAttribute("users",users);
        // Set a title for page
        model.addAttribute("pageTitle", "User List");
        //System.out.println(users);
        return "users-list";
    }

    @GetMapping("/users/new")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("PageTitle","Add User");
        return "users-create";
    }

    @PostMapping("/users/new")
    public String saveUser(@Valid @ModelAttribute("user")UserDto userDto,
                           BindingResult result, Model model){
        if(result.hasErrors()){
            System.out.println("Error in saving user: " + result.getAllErrors());
            model.addAttribute("user",userDto);
            return "users-create";
        }
        userService.saveUser(userDto);
        return "redirect:/users";
    }

    @GetMapping("/users/{userID}/edit")
    public String editUser(@PathVariable("userID")long userID, Model model){
        UserDto user = userService.findUserByID(userID);
        model.addAttribute("user",user);
        model.addAttribute("PageTitle","Edit User");
        return "users-edit";
    }

    @PostMapping("/users/{userID}/edit")
    public String updateUser(@PathVariable("userID")long userID,
                             @Valid @ModelAttribute("user") UserDto user,
                             BindingResult result ){
        if(result.hasErrors()){
            return "users-edit";
        }
        user.setUserID(userID);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{userID}/delete")
    public String deleteUser(@PathVariable("userID") Long userID) {
        userService.delete(userID);
        return "redirect:/users";
    }

}
