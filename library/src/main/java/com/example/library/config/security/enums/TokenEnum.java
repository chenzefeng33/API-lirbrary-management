package com.example.library.config.security.enums;

import com.example.library.config.security.constant.Expiration;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.example.library.config.security.enums 0.0.1
 */

@Getter
@AllArgsConstructor
public enum TokenEnum {
    ACCESS_TOKEN("AccessToken", Expiration.HOUR_ONE_EXPIRE),
    REFRESH_TOKEN("RefreshToken", Expiration.HOUR_TWO_EXPIRE);

    private final String tokenName;
    private final long expiration;
}
