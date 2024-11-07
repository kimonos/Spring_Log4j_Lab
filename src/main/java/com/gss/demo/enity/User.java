package com.gss.demo.enity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Transient
    private char[] password;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public char[] getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
