package com.SalJobs.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.SalJobs.backend.model.User;
import com.SalJobs.backend.repository.UserRepository;

/*
 * API methods go here. @PostMapping means it's a post method, @GetMapping means
 * get method. etc. etc. 
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signIn")
    public String signIn(@RequestBody User user){
    	userRepository.findAll();//u can make queries to the database like this
    	return "";
    }

    // build create employee REST API
    @PostMapping("/signUp")
    public String signUp(@RequestBody User user){
    	userRepository.save(user);//save new users like this
        return "";
    }
    

}
