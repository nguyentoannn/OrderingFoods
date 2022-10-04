package com.example.orderingfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username, fullName, password, confirmPassword, address, email, phone;
    Button register;
    TextView btn_toLogin;
    DatabaseManagement dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.login_Username);
        fullName = findViewById(R.id.register_fullName);
        password = findViewById(R.id.register_password);
        confirmPassword = findViewById(R.id.register_confirm);
        address = findViewById(R.id.register_Address);
        email = findViewById(R.id.register_Email);
        phone = findViewById(R.id.register_phone);
        register = findViewById(R.id.button_register);
        btn_toLogin = findViewById(R.id.ToLogin);
        dataBase = new DatabaseManagement(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, name, pwd, confirm, add, mail, numberPhone;
                user = username.getText().toString();
                name = fullName.getText().toString();
                pwd = password.getText().toString();
                confirm = confirmPassword.getText().toString();
                add = address.getText().toString();
                mail = email.getText().toString();
                numberPhone = phone.getText().toString();

                if(TextUtils.isEmpty(user) || TextUtils.isEmpty(name) ||
                   TextUtils.isEmpty(pwd) || TextUtils.isEmpty(confirm) ||
                   TextUtils.isEmpty(add) || TextUtils.isEmpty(mail) ||
                   TextUtils.isEmpty(numberPhone)){

                    Toast.makeText(RegisterActivity.this, "All fields must be required", Toast.LENGTH_SHORT).show();

                }else{
                    if(pwd.equals(confirm)){
                        Boolean checkUser = dataBase.checkDataUser(user);
                        if(checkUser){
                            Toast.makeText(RegisterActivity.this, "User already existed", Toast.LENGTH_SHORT).show();
                        }else{
                            Boolean addUser = dataBase.insertUser(user, name, pwd, confirm, add, mail, numberPhone);
                            if(pwd.length() >= 6 && pwd.length() <= 20) {
                                if (addUser) {
                                    Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(RegisterActivity.this, "The password length must be from 6 to 20 characters", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "Password are not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btn_toLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
}