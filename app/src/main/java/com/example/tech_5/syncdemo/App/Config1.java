package com.example.tech_5.syncdemo.App;

public class Config1 {

    public static final String URL_REQUEST_SMS = "https://purposeofliving.000webhostapp.com/android_sms/request_sms.php";
    public static final String URL_VERIFY_OTP = "https://purposeofliving.000webhostapp.com/android_sms/verify_otp.php";

    // SMS provider identification
    // It should match with your SMS gateway origin
    // You can use  MSGIND, TESTER and ALERTS as sender ID
    // If you want custom sender Id, approve MSG91 to get one
    public static final String SMS_ORIGIN = "FSTSMS";

    // special character to prefix the otp. Make sure this character appears only once in the sms
    public static final String OTP_DELIMITER = ":";
}
