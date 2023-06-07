package com.example.library.service.impl;

import com.example.library.config.exception.ServerException;
import com.example.library.config.security.utils.TokenUtil;
import com.example.library.dao.UserDao;
import com.example.library.pojo.User;
import com.example.library.service.UserInfoService;
import com.example.library.service.UserService;
import com.example.library.vo.TokenVO;
import com.example.library.vo.UsernamePasswordVO;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.example.library.service.impl 0.0.1
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final AuthenticationProvider authenticationProvider;
    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;
    private final UserInfoService userInfoService;

    @Override
    public TokenVO loginByUsername(UsernamePasswordVO usernamePasswordVo) {
        Authentication authentication;
        try {
            // 用户认证
            authentication = authenticationProvider.authenticate(
                    new UsernamePasswordAuthenticationToken(usernamePasswordVo.getUsername(), usernamePasswordVo.getPassword()));
        } catch (BadCredentialsException e) {
            throw new ServerException("用户名或密码错误");
        }

        User user = (User) authentication.getPrincipal();
        TokenUtil.TokenTuple tokenTuple = TokenUtil.generate(user.getUsername(), null);

        return new TokenVO(tokenTuple.getAccessToken(), tokenTuple.getRefreshToken());
    }

    @Override
    public void register(UsernamePasswordVO usernamePasswordVo) {
        userInfoService.isUsernameExist(usernamePasswordVo.getUsername());

        String encodedPassword = passwordEncoder.encode(usernamePasswordVo.getPassword());
        User newUser = new User(usernamePasswordVo.getUsername(), encodedPassword);
        userDao.insert(newUser);
    }
}
