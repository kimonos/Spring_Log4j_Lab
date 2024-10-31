package com.gss.demo.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@Scope(value = "prototype")
public class log4jController {
    private Logger log = LogManager.getLogger(log4jController.class);

//    @PostMapping("/login")
//    public String login(@RequestBody Map req) {
//
//        //-Dcom.sun.jndi.ldap.object.trustURLCodebase=true
//        String user = req.get("user").toString();
//        String password = req.get("password").toString();
//
//        log.error("user:{},password:{}", user, password);
//
//        return "login";
//    }
@PostMapping("/login")
    public String login(@RequestBody Map req) {
        String user = req.get("user").toString();
        char[] password = req.get("password").toString().toCharArray(); // 使用 char[]

        try {
            log.error("user:{}, password:{}", user, new String(password)); // 這樣日誌仍然可以記錄
            // 其他處理邏輯
        } finally {
            // 清除密碼
            Arrays.fill(password, '0'); // 將密碼清空
        }

        return "login";
    }
}
