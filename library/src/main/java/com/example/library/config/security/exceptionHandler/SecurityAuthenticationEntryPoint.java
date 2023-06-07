package com.example.library.config.security.exceptionHandler;

import cn.hutool.json.JSONUtil;
import com.example.library.config.security.utils.HttpContextUtil;
import com.example.library.util.R;
import com.example.library.util.ResultEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.whms.framework.security.exceptionHandler 0.0.1
 */
public class SecurityAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());

        response.getWriter().print(JSONUtil.toJsonStr(R.res(ResultEnum.UNAUTHORIZED)));
    }
}
