package com.example.orderingfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView btn_ToRegister = findViewById(R.id.ToRegister);
        btn_ToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        Button btn_Login = findViewById(R.id.button_login);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, UserInformationActivity.class));
            }
        });
    }
}
//
//
//    EditText username;
//    EditText password;
//    Button button;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        username = findViewById(R.id.register_Username);
//        password = findViewById(R.id.password);
//        button = findViewById(R.id.button_login);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//            }
//        });
//
//        TextView btn_ToRegister = findViewById(R.id.register);
//        btn_ToRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//                clickLogin();
//            }
//        });
//    }
//
//    private void clickLogin() {
//        String email = username.getText().toString().trim();
//        String pwd = password.getText().toString().trim();
//        User user = new User(email, pwd);
//        if (user.isEmail() && user.isPassword()) {
//            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//        } else {
//            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//        }
//    }