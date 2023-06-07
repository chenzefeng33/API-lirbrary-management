package com.example.library.service;

import com.example.library.vo.TokenVO;
import com.example.library.vo.UsernamePasswordVO;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.example.library.service 0.0.1
 */
public interface UserService {
    /**
     * 账号密码登录
     *
     * @param usernamePasswordVo 账号密码VO
     * @return token
     */
    TokenVO loginByUsername(UsernamePasswordVO usernamePasswordVo);

    /**
     * 账号密码注册
     *
     * @param usernamePasswordVo 账号密码VO
     */
    void register(UsernamePasswordVO usernamePasswordVo);
}
