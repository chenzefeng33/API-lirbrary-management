package com.example.library.service.impl;

import com.example.library.config.exception.ServerException;
import com.example.library.dao.UserDao;
import com.example.library.pojo.User;
import com.example.library.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.example.library.service.impl 0.0.1
 */
@Service
@AllArgsConstructor
public class UserInfoServiceImpl implements UserDetailsService, UserInfoService {

    private final UserDao userDao;

    @Override
    public void isUsernameExist(String username) {
        User user = userDao.findByUsername(username);
        if (user != null){
            throw new ServerException("用户名已存在");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return user;
    }
}
