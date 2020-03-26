package com.projects.achieveit.service;

import com.projects.achieveit.dao.UserMapper;
import com.projects.achieveit.dto.LoginDTO;
import com.projects.achieveit.dto.RegisterDTO;
import com.projects.achieveit.po.User;
import com.projects.achieveit.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public boolean register(RegisterDTO dto){
        //随机盐
        String salt= UUID.randomUUID().toString();
        User user=new User();
        user.setUsername(dto.getUserName());
        user.setUserpassword(DigestUtils.md5DigestAsHex((dto.getUserPassword()+salt).getBytes()));

        user.setSalt(salt);
        return 1==userMapper.insert(user);
    }

    /**
     * 根据用户名查询用户
     *
     * @param name
     * @return
     */
    private User getUserByName(String name) {
        User user = new User();
        user.setUsername(name);
        System.out.println(name);
        return userMapper.selectOne(user);
    }

    /**
     * 登陆
     *
     * @param dto
     */
    public LoginVO login(LoginDTO dto) {
        User user = getUserByName(dto.getUserName());

        String loginPassword =  DigestUtils.md5DigestAsHex((dto.getUserPassword()+user.getSalt()).getBytes());
        LoginVO vo = new LoginVO();
        if(!user.getUserpassword().equals(loginPassword)) {
          return vo;
        }
        //密码一致登陆成功，将用户信息存储在redis中
        String token = UUID.randomUUID().toString();
//        redisOperator.set(token, user, applicationProperty.getSessionTtl());

        vo.setUserName(user.getUsername());
        vo.setToken(token);
        return vo;
    }

}
