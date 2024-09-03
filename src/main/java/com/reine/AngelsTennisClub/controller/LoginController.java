package com.reine.AngelsTennisClub.controller;

import com.reine.AngelsTennisClub.model.Role;
import com.reine.AngelsTennisClub.model.User;
import com.reine.AngelsTennisClub.repository.RoleRepository;
import com.reine.AngelsTennisClub.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//Controller class for login operations
@Controller
public class LoginController {

    private final BCryptPasswordEncoder BCryptPasswordEncoder;
    UserRepository userRepository;
    RoleRepository roleRepository;
    @Autowired
    public LoginController(BCryptPasswordEncoder BCryptPasswordEncoder, UserRepository userRepository, RoleRepository roleRepository){
        this.BCryptPasswordEncoder = BCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }
    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request)throws ServletException {
        String password = user.getPassword();
        user.setPassword(BCryptPasswordEncoder.encode(password));
        List<Role>roles = new ArrayList<>();
        Optional<Role> role = roleRepository.findById(2);
        if(role.isPresent()){
            roles.add(role.get());
        }else{
            return "404";
        }
        user.setRoles(roles);
        userRepository.save(user);
        request.login(user.getEmail(), password);
        return "redirect:/";
    }
}