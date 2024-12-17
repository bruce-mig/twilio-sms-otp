package com.github.bruce_mig.twilio_sms_otp.dto;

public class PasswordResetRequestDto {
     private String phoneNumber;
     private String userName;
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
}
