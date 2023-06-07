package com.example.library.controller;

import com.example.library.service.UserService;
import com.example.library.util.R;
import com.example.library.vo.TokenVO;
import com.example.library.vo.UsernamePasswordVO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.example.library.controller 0.0.1
 */

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public R register(@RequestBody UsernamePasswordVO usernamePasswordVo) {
        userService.register(usernamePasswordVo);
        return R.ok();
    }

    @PostMapping("/login")
    public R login(@RequestBody UsernamePasswordVO usernamePasswordVo) {
        TokenVO res = userService.loginByUsername(usernamePasswordVo);

        return R.ok().data("token", res);
    }
}
