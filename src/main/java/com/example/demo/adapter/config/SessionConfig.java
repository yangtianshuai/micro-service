package com.example.demo.adapter.config;

import api.config.session.ServerSession;
import api.config.session.SessionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig {

    @Bean
    public ServerSession useSession() {
        int out_time_seconds = 60*60*4;
        ServerSession session = new SessionService(out_time_seconds);
        //session.setTokenkey("sso_token");
        return session;
    }
}
