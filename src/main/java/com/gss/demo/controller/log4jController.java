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
//    private Logger log = LogManager.getLogger(log4jController.class);
//
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
private static final Logger log = LogManager.getLogger(log4jController.class);

    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> req) {
        String user = null;
        char[] password = null;

        try {
            user = String.valueOf(req.get("user"));
            // 將密碼轉換為 char array
            String tempPass = String.valueOf(req.get("password"));
            password = tempPass.toCharArray();

            // 進行必要的密碼驗證操作

            // 記錄登入嘗試，但不記錄實際密碼
            log.info("Login attempt for user: {}", user);

            return "login successful";
        } catch (Exception e) {
            log.error("Login error for user: {}", user);
            return "login failed";
        } finally {
            // 清除密碼相關的敏感數據
            if (password != null) {
                Arrays.fill(password, '\0');
            }

            // 強制觸發 GC 建議（開發環境可用，生產環境建議移除）
            // System.gc();
        }
    }
}
