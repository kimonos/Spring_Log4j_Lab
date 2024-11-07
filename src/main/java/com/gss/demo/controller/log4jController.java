package com.gss.demo.controller;


import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Scope(value = "prototype")
public class log4jController {
    private Logger log = LogManager.getLogger(log4jController.class);

    @PostMapping("/login")
    public String login(@RequestBody Map req) {

        //-Dcom.sun.jndi.ldap.object.trustURLCodebase=true
        String user = req.get("user").toString();
        // 清理用戶輸入，避免日誌偽造
        String sanitizedUser = StringEscapeUtils.escapeJava(user);

        log.error("user:{}", sanitizedUser);

        return "login";
    }
}
