package com.github.bruce_mig.twilio_sms_otp;

import com.github.bruce_mig.twilio_sms_otp.config.TwilioConfig;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioSmsOtpApplication {

    private final TwilioConfig twilioConfig;

    public TwilioSmsOtpApplication(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    @PostConstruct
    public void initTwilio(){
        Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
    }

    public static void main(String[] args) {
        SpringApplication.run(TwilioSmsOtpApplication.class, args);
    }

}
