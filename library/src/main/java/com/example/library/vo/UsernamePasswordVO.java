package com.example.library.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.example.library.vo 0.0.1
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsernamePasswordVO {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
