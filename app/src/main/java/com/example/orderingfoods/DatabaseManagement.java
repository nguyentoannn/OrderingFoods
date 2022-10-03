package com.example.orderingfoods;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseManagement extends SQLiteOpenHelper {

    public static final String DB_Name = "FoodOrdering.db";

    /**
     * create database
     **/
    public DatabaseManagement(Context ctx) {
        super(ctx, "FoodOrdering.db", null, 1);
    }


    /**
     * create table user contains: username, fullName, pwd, confirmPwd, address, email, phone
     * all of them are text type and not null
     * email and phone are unique
     * username is primary key
    **/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Users(username TEXT primary key, fullName TEXT NOT NULL, password TEXT NOT NULL, confirmPassword TEXT NOT NULL, address TEXT NOT NULL, email TEXT NOT NULL UNIQUE, phone TEXT NOT NULL UNIQUE)");
    }

    /**
     * drop table with name already existed in database
     **/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users");
    }

    public Boolean insertUser(String username, String fullName, String password, String confirmPassword, String address, String email, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("fullName", fullName);
        values.put("password", password);
        values.put("confirmPassword", confirmPassword);
        values.put("address", address);
        values.put("email", email);
        values.put("phone", phone);

        long result = db.insert("Users", null, values);
        if(result == -1) return false;
        else return true;
    }

    public Boolean checkDataUser(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Users WHERE username=?", new String[]{username});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkDataLogin(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Users WHERE username=? and password=?", new String[]{username, password});
        if(cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }
}
