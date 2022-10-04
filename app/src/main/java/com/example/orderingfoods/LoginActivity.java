package com.example.orderingfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    ImageView btn_toHome;
    TextView btn_toRegister, forgotPassword;
    DatabaseManagement dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_Username);
        password = findViewById(R.id.login_password);
        login = findViewById(R.id.button_login);
        btn_toRegister = findViewById(R.id.ToRegister);
        forgotPassword = findViewById(R.id.forgot_password);
        btn_toHome = findViewById(R.id.close_login);
        dataBase = new DatabaseManagement(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, pwd;
                user = username.getText().toString();
                pwd = password.getText().toString();
                
                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pwd)){
                    Toast.makeText(LoginActivity.this, "All fields must be required", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkLogin = dataBase.checkDataLogin(user, pwd);
                    if(checkLogin){
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btn_toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this , RegisterActivity.class));
            }
        });

        btn_toHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class));
            }
        });
    }
}
