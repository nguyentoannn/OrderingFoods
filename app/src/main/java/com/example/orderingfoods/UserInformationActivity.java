package com.example.orderingfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UserInformationActivity extends AppCompatActivity {

    ImageView back_to_home;
    TextView logout, edit_profile, change_pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        back_to_home = findViewById(R.id.btn_backHome);
        logout = findViewById(R.id.ToLogOut);
        edit_profile = findViewById(R.id.btn_edit_i4);
        change_pwd = findViewById(R.id.btn_change_password_i4);

        back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserInformationActivity.this, MainActivity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //none
            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //none
            }
        });

        change_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserInformationActivity.this, ChangePasswordActivity.class));
            }
        });

    }
}