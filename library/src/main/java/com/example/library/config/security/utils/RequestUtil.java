package com.example.library.config.security.utils;

import com.example.library.config.security.enums.TokenEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.whms.framework.common.utils 0.0.1
 */
public class RequestUtil {
    public static String getAccessToken(HttpServletRequest request) {
        return request.getHeader(TokenEnum.ACCESS_TOKEN.getTokenName());
    }

    public static String getRefreshToken(HttpServletRequest request) {
        return request.getHeader(TokenEnum.REFRESH_TOKEN.getTokenName());
    }
}
