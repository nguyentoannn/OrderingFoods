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

public class ChangePasswordActivity extends AppCompatActivity {

    EditText newPassword, reNewPassword;
    Button changePassword;
    TextView returnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        newPassword = findViewById(R.id.change_pwd_new);
        reNewPassword = findViewById(R.id.change_pwd_reNew);
        changePassword = findViewById(R.id.btn_change_newPassword);
        returnProfile = findViewById(R.id.btn_return_profile);

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newPwd, reNewPwd;
                newPwd = newPassword.getText().toString();
                reNewPwd = reNewPassword.getText().toString();

                if(TextUtils.isEmpty(newPwd) || TextUtils.isEmpty(reNewPwd)){
                    Toast.makeText(ChangePasswordActivity.this, "All fields must be required", Toast.LENGTH_SHORT).show();
                }else{
                    if(newPwd.equals(reNewPwd)){
                        if(newPwd.length() >= 6 || newPwd.length() <= 20){
                            //function update password >> not yet create on Database.
                        }else{
                            Toast.makeText(ChangePasswordActivity.this, "The password length must be from 6 to 20 characters", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(ChangePasswordActivity.this, "The password are not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        returnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChangePasswordActivity.this, UserInformationActivity.class));
            }
        });

    }
}