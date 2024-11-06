package com.gss.demo.controller;


import com.gss.demo.enity.User;
import com.gss.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;
import java.util.Optional;

//@RestController
//public class sqlController {
//
//    @Autowired
//    private userRepository userRepository;
//
//    @GetMapping("/user/{id}")
//    public User findUserFromId(@PathVariable("id") Long id){
//
////        return userRepository.findById(id).orElse(null);
//        // 使用 Optional 進行查詢
//        Optional<User> userOptional = userRepository.findById(id);
//
//        // 處理查詢結果
//        return userOptional
//                .map(user -> userRepository.ok(user)) // 如果存在用戶，返回200及用戶信息
//                .orElse(ResponseEntity.status(404).body("User not found.")); // 如果不存在，返回404狀態
//    }
//}
@RestController
@Validated
public class sqlController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserFromId(@PathVariable("id") @Positive Long id) {

        // 查詢用戶
        Optional<User> userOptional = userRepository.findUserById(id);
        return userOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // 返回 404 Not Found
    }
}
