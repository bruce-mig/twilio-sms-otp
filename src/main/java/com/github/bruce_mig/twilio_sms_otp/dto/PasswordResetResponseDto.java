package com.github.bruce_mig.twilio_sms_otp.dto;

import java.util.Objects;

public class PasswordResetResponseDto {

    private OtpStatus status;
    private String message;

    public PasswordResetResponseDto(OtpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public PasswordResetResponseDto() {
    }

    public OtpStatus getStatus() {
        return status;
    }

    public void setStatus(OtpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PasswordResetResponseDto{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PasswordResetResponseDto that = (PasswordResetResponseDto) o;
        return status == that.status && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }
}
