package com.projects.achieveit.controller;


import com.projects.achieveit.dto.LoginDTO;
import com.projects.achieveit.dto.RegisterDTO;
import com.projects.achieveit.service.UserService;
import com.projects.achieveit.vo.LoginVO;
import com.projects.achieveit.vo.result.FailResult;
import com.projects.achieveit.vo.result.Result;
import com.projects.achieveit.vo.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 注册
     * 参数通过表单传递
     *
     * @param dto
     * @return
     */
    @PostMapping("/register")
    public Result register(@Valid RegisterDTO dto){
        boolean result = userService.register(dto);
        if(result){
            return new SuccessResult<>();
        }
        return new FailResult();
    }

    /**
     * 登陆接口
     *
     * @return
     */
    @PostMapping("/login")
    public Result login(LoginDTO dto) {
        LoginVO vo = userService.login(dto);
        if (vo == null) {
            return new FailResult();
        }
        return new SuccessResult<>(vo);
    }




}
