package com.gss.demo.controller;


import com.gss.demo.enity.User;
import com.gss.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
    private userRepository userRepository;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserFromId(
            @PathVariable("id")
            Long id) {
            Optional<User> userOptional = userRepository.findById(id);
            return userOptional.map(user -> ResponseEntity.ok(user))
                    .orElse(ResponseEntity.notFound().build());
    }
}
