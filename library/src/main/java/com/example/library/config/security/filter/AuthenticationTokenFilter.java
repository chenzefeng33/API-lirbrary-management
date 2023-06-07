package com.example.library.config.security.filter;

import cn.hutool.core.util.StrUtil;
import com.example.library.config.security.enums.TokenEnum;
import com.example.library.config.security.user.PermitResource;
import com.example.library.config.security.utils.RequestUtil;
import com.example.library.config.security.utils.TokenUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.whms.framework.security.filter 0.0.1
 */
@Component
@AllArgsConstructor
public class AuthenticationTokenFilter extends OncePerRequestFilter {

    private final PermitResource permitResource;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 自定义过滤器放行白名单
        if (permitResource.isPermit(request.getServletPath())) {
            chain.doFilter(request, response);
            return;
        }

        String accessToken = RequestUtil.getAccessToken(request);
        String refreshToken = RequestUtil.getRefreshToken(request);
        // 验证JWT
        if (StrUtil.isBlank(accessToken) || StrUtil.isBlank(refreshToken)) {
            throw new BadCredentialsException("AccessToken not exist in request header");
        } else if (!TokenUtil.verify(accessToken)) {
            if (TokenUtil.verify(refreshToken)) {
                // 重新生成token
                TokenUtil.TokenTuple tokenTuple = TokenUtil.regenerate(accessToken, refreshToken);
                String newAccessToken = tokenTuple.getAccessToken();
                String newRefreshToken = tokenTuple.getRefreshToken();

                // 将新token放入响应头
                response.setHeader(TokenEnum.ACCESS_TOKEN.getTokenName(), newAccessToken);
                response.setHeader(TokenEnum.REFRESH_TOKEN.getTokenName(), newRefreshToken);

                chain.doFilter(request, response);
            } else {
                // token失效
                throw new BadCredentialsException("AccessToken and RefreshToken are both invalid");
            }
        }

        chain.doFilter(request, response);
    }
}
