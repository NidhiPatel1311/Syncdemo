//package com.example.tech_5.syncdemo;
//
//import android.content.Intent;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.FirebaseException;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.PhoneAuthCredential;
//import com.google.firebase.auth.PhoneAuthProvider;
//import java.util.concurrent.TimeUnit;
//
//public class FireOtpActivity extends AppCompatActivity {
//
//    Button btnGenerateOTP, btnSignIn;
//    EditText etPhoneNumber, etOTP;
//    String phoneNumber, otp;
//    FirebaseAuth auth;
//   PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
//    private String verificationCode;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fire_otp);
//
//        findViews();
//        StartFirebaseLogin();
//
//        btnGenerateOTP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                phoneNumber=etPhoneNumber.getText().toString();
//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                        phoneNumber,                     // Phone number to verify
//                        60,                           // Timeout duration
//                        TimeUnit.SECONDS,                // Unit of timeout
//                        FireOtpActivity.this,        // Activity (for callback binding)
//                        mCallback);                      // OnVerificationStateChangedCallbacks
//            }
//        });
//
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                otp=etOTP.getText().toString();
//                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otp);
//                SigninWithPhone(credential);
//            }
//        });
//    }
//
//    private void SigninWithPhone(PhoneAuthCredential credential){
//        auth.signInWithCredential(credential)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            startActivity(new Intent(FireOtpActivity.this,SignedIn.class));
//                            finish();
//                        } else {
//                            Toast.makeText(FireOtpActivity.this,"Incorrect OTP",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//    }
//
//    private void StartFirebaseLogin(){
//        auth = FirebaseAuth.getInstance();
//        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//            @Override
//            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
//                Toast.makeText(FireOtpActivity.this,"verification completed",Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onVerificationFailed(FirebaseException e) {
//                Toast.makeText(FireOtpActivity.this,"verification fialed",Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//                super.onCodeSent(s, forceResendingToken);
//                verificationCode = s;
//                Toast.makeText(FireOtpActivity.this,"Code sent",Toast.LENGTH_SHORT).show();
//            }
//        };
//
//    }
//
//    private void findViews() {
//        btnGenerateOTP=findViewById(R.id.btn_generate_otp);
//        btnSignIn=findViewById(R.id.btn_sign_in);
//
//        etPhoneNumber=findViewById(R.id.et_phone_number);
//        etOTP=findViewById(R.id.et_otp);
//    }
//}
