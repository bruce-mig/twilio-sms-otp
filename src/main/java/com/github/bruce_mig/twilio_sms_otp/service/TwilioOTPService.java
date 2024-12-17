package com.github.bruce_mig.twilio_sms_otp.service;

import com.github.bruce_mig.twilio_sms_otp.config.TwilioConfig;
import com.github.bruce_mig.twilio_sms_otp.dto.OtpStatus;
import com.github.bruce_mig.twilio_sms_otp.dto.PasswordResetRequestDto;
import com.github.bruce_mig.twilio_sms_otp.dto.PasswordResetResponseDto;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TwilioOTPService {

    private final TwilioConfig twilioConfig;

    public TwilioOTPService(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    Map<String,String> otpMap = new HashMap<>();  // todo: use redis

    public Mono<PasswordResetResponseDto> sendOTPForPasswordReset(PasswordResetRequestDto passwordResetRequestDto) {
        PasswordResetResponseDto passwordResetResponseDto = new PasswordResetResponseDto();
        try {
            PhoneNumber to = new PhoneNumber(passwordResetRequestDto.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String otp = generateOTP();

            // todo: improve message
            String otpMessage = "Dear Customer , Your OTP is ##" + otp + "##. Use this Passcode to complete your transaction. Thank You.";

            Message message = Message
                    .creator(to,from, otpMessage)
                    .create();
            otpMap.put(passwordResetRequestDto.getUserName(), otp);

            passwordResetResponseDto.setStatus(OtpStatus.DELIVERED);
            passwordResetResponseDto.setMessage(otpMessage);

        } catch (Exception e) {
            passwordResetResponseDto.setStatus(OtpStatus.FAILED);
            passwordResetResponseDto.setMessage(e.getMessage());
        }
        return Mono.just(passwordResetResponseDto);

    }

    public Mono<Boolean> isValidOTP(String userInputOtp, String userName) {
        if (userInputOtp.equals(otpMap.get(userName))) {
            otpMap.remove(userName, userInputOtp);
            return Mono.just(Boolean.TRUE);
        } else {
            return Mono.just(Boolean.FALSE);
        }
    }

    // 6 digit OTP
    private String generateOTP(){
        return new DecimalFormat("000000")
                .format(new Random().nextInt(999999));
    }
}
