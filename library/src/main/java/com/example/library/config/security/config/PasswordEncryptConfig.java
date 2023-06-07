package com.example.library.config.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author RuKunHe(jom4ker @ aliyun.com)
 * @version com.whms.framework.security.config 0.0.1
 */
@Configuration
public class PasswordEncryptConfig {
    @Bean
    public PasswordEncoder passwordEncrypt() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
