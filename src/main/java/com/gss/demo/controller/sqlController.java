package com.gss.demo.controller;


import com.gss.demo.enity.User;
import com.gss.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sqlController {

    @Autowired
    private userRepository userRepository;

    @GetMapping("/user/{id}")
    public User findUserFromId(@PathVariable("id") Long id){

//        return userRepository.findById(id).orElse(null);
        return userRepository.findById(id)
                .map(ResponseEntity::ok) // 返回用戶對象
                .orElse(ResponseEntity.notFound().build()).getBody();
    }
}
