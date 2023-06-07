package com.example.library.config.security.utils;

import cn.hutool.core.lang.Tuple;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;
import com.example.library.config.security.enums.TokenEnum;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.whms.framework.security.utils 0.0.1
 */
@Component
public class TokenUtil {
    private static final String JWT_ISSUER = "wgzmb";
    private static final String DEFAULT_SUBJECT = "wgzmb";
    private static final String ENCRYPT_TYPE = "RSA";
    private static final String JWT_PUB = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDiy5jxZrZEQCnlLhODWIQkiYq/i+rA89nitmTJ9J00AH/1/WeEgCwA6KLfBWa+FEP0vLkkg/UW4qjjk75WUeoGqeY5HgAnDCCMYGgxCKyOV1qBAyQ+qm6xy7MuekFryEekmYoK7YPo0+A6z/s9OprbNVmkpDBUk8s9cFqgX5V+QIDAQAB";

    private static final String JWT_PRI = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMOLLmPFmtkRAKeUuE4NYhCSJir+L6sDz2eK2ZMn0nTQAf/X9Z4SALADoot8FZr4UQ/S8uSSD9RbiqOOTvlZR6gap5jkeACcMIIxgaDEIrI5XWoEDJD6qbrHLsy56QWvIR6SZigrtg+jT4DrP+z06mts1WaSkMFSTyz1wWqBflX5AgMBAAECgYAv+N9CnuHkSuWMN1IX4/Sg+BnhBkcPf3nMfyXtkiFxgu5ao9KgGu6MP/gKnEB4ql7IsQnhxWuYv3R9t5XsWljXmQWpDcG+OfrgM6nJh71RYMud/59CSZUrl9R9BoCr+C9q0w6Hoz4C9Tlz1Tq2/hiU99+LsWcAKfZ/P8u/qzWKYQJBAOiRkGOpyQtBsqAKIBmVT5YQEEnuFwQZUkn1GDzQty/z7hr6xob/XS011XB9FreG2xRqD28SkRQYl1N2H4mepU0CQQDXPqp5kGgaGj6BvFT7lWyaf0U7KnOUrpQJb8OJEso7W2FG5fkBUuR4QlnBSdrodzoaQAnWGV/2hSh3KRF5JO1dAkAVPR3jjCDZD1Hhvar6yyDugl8KcVzWuf1C1cg13ZWtImivPBGfSHjY5R6t3C6T6hPdxGXObfKj1C8VpybwKXXNAkEAmJ9gtc4FYuzVAZ0PDU1IsswnxOo3Bmg7o+1R0vI135zN/z22MJAcXIF/ryS1SjywQEjEMMHRX7XPmZ7POv1KKQJATYbJJkE7iOcyk/x4qur7AqoUpQ8390VSvPerURikGCbVrLnT+2NeS1JuMXYCahu9lvtIbpR7WAMjhASFy1cYkA==";

    public static class TokenTuple extends Tuple {
        public TokenTuple(Object... params) {
            super(params);
        }

        public String getAccessToken() {
            return this.get(0);
        }
        public String getRefreshToken() {
            return this.get(1);
        }
    }

    private static String generate(String audience, TokenEnum tokenType, Map<String, Object> additionalPayload) {
        long nowMillis = System.currentTimeMillis();

        JWT jwt = JWT.create();

        jwt.setIssuer(JWT_ISSUER);
        jwt.setIssuedAt(new Date(nowMillis));
        jwt.setAudience(audience);
        jwt.setSubject(DEFAULT_SUBJECT);
        jwt.setCharset(StandardCharsets.UTF_8);

        jwt.setExpiresAt(new Date(nowMillis + tokenType.getExpiration() * 1000));
        if (additionalPayload != null) {
            additionalPayload.forEach(jwt::setPayload);
        }

        PrivateKey privateKey = getPrivateKey();
        JWTSigner signer = JWTSignerUtil.rs256(privateKey);

        return jwt.sign(signer);
    }

    public static TokenTuple generate(String audience, Map<String, Object> additionalPayload) {
        String accessToken = generate(audience, TokenEnum.ACCESS_TOKEN, additionalPayload);
        String refreshToken = generate(audience, TokenEnum.REFRESH_TOKEN, null);
        return new TokenTuple(accessToken, refreshToken);
    }

    public static TokenTuple regenerate(String accessToken, String refreshToken) {
        String audience = getAudience(accessToken);
        String newAccessToken = generate(audience, TokenEnum.ACCESS_TOKEN, null);
        String newRefreshToken = generate(audience, TokenEnum.REFRESH_TOKEN, null);
        return new TokenTuple(newAccessToken, newRefreshToken);
    }

    public static Object getPayload(String jwt, String payloadKey) {
        return JWT.of(jwt).getPayload(payloadKey);
    }

    public static String getAudience(String jwt) {
        return (String) JWT.of(jwt).getPayload(JWT.AUDIENCE);
    }

    public static boolean verify(String jwt) {
        PublicKey publicKey = getPublicKey();
        JWTSigner signer = JWTSignerUtil.rs256(publicKey);
        return JWT.of(jwt).verify(signer);
    }

    @SneakyThrows
    private static PublicKey getPublicKey() {
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(TokenUtil.JWT_PUB));
        KeyFactory keyFactory = KeyFactory.getInstance(ENCRYPT_TYPE);
        return keyFactory.generatePublic(pubKeySpec);
    }

    @SneakyThrows
    private static PrivateKey getPrivateKey() {
        byte[] encodedKey = Base64.getDecoder().decode(TokenUtil.JWT_PRI);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance(ENCRYPT_TYPE);
        return keyFactory.generatePrivate(keySpec);
    }
}
