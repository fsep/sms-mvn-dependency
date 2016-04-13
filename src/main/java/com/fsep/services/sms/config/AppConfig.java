package com.fsep.services.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 15.01.16
 * AppConfig
 *
 * @author Marsel Sidikov (First Software Engineering Platform)
 * @version v1.0
 */

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public String getUrl() {
        return "http://gate.smsaero.ru";
    }
}
