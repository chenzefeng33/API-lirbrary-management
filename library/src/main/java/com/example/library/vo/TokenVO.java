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
public class TokenVO {
    /**
     * 访问令牌
     */
    private String accessToken;
    /**
     * 刷新令牌
     */
    private String refreshToken;
}
