package com.mybatis.domain;


import lombok.Data;

@Data
public class User {

    private Long id;


    private String userName;

    private String password;


    public User() {
    }




    public User( String userName, String password) {
        this.userName = userName;
        this.password = password;
    }



}
