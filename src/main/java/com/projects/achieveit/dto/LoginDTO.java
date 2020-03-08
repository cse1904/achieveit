package com.projects.achieveit.dto;

import lombok.Data;

@Data
public class LoginDTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;
}