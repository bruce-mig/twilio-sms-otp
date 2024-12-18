package com.github.bruce_mig.twilio_sms_otp.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class TwilioRouterConfig {

    private final TwilioOTPHandler handler;

    public TwilioRouterConfig(TwilioOTPHandler handler) {
        this.handler = handler;
    }

    @Bean
    public RouterFunction<ServerResponse> handleSMS(){
        return RouterFunctions.route()
                .POST("/route/sendOTP", handler::sendOTP)
                .POST("/route/validateOTP", handler::validateOTP)
                .build();
    }
}
