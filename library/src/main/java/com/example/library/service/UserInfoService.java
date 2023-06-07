package com.example.library.service;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.example.library.service 0.0.1
 */
public interface UserInfoService {
    /**
     * 判断用户名是否存在
     */
    void isUsernameExist(String username);
}
