package com.github.bruce_mig.twilio_sms_otp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class PasswordResetRequestDto {
    @JsonProperty("phone_number")
     private String phoneNumber;
    @JsonProperty("user_name")
     private String userName;
    @JsonProperty("otp")
     private String oneTimePassword;

    public PasswordResetRequestDto(String phoneNumber, String userName, String otp) {
        this.phoneNumber = phoneNumber;
        this.userName = userName;
        this.oneTimePassword = otp;
    }

    public PasswordResetRequestDto() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOneTimePassword() {
        return oneTimePassword;
    }

    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }

    @Override
    public String toString() {
        return "PasswordResetRequestDto{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", userName='" + userName + '\'' +
                ", oneTimePassword='" + oneTimePassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PasswordResetRequestDto that = (PasswordResetRequestDto) o;
        return Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(userName, that.userName) && Objects.equals(oneTimePassword, that.oneTimePassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, userName, oneTimePassword);
    }
}
