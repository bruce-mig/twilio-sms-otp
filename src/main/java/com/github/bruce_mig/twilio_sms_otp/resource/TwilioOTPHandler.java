package com.github.bruce_mig.twilio_sms_otp.resource;

import com.github.bruce_mig.twilio_sms_otp.dto.PasswordResetRequestDto;
import com.github.bruce_mig.twilio_sms_otp.dto.PasswordResetResponseDto;
import com.github.bruce_mig.twilio_sms_otp.service.TwilioOTPService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TwilioOTPHandler {

    private final TwilioOTPService service;

    public TwilioOTPHandler(TwilioOTPService service) {
        this.service = service;
    }

    public Mono<ServerResponse> sendOTP(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(PasswordResetRequestDto.class)
                .flatMap(dto -> service.sendOTPForPasswordReset(dto))
                .flatMap(dto -> ServerResponse.status(HttpStatus.OK)
                        .body(BodyInsert))
    }
}
