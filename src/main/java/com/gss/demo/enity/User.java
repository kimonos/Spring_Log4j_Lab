package com.gss.demo.enity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    private String password;
    private char[] password; // 使用 char[]

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public String getPassword() {
//        return password;
//    }
    public char[] getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setPassword(String password) {
//        this.password = password;
//    }
    public void setPassword(char[] password) {
        this.password = password;
    }

    public void clearPassword() {
        if (this.password != null) {
            Arrays.fill(this.password, '0'); // 清空密碼
            this.password = null;
        }
    }
}
