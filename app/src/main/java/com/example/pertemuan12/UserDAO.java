package com.example.pertemuan12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class UserDAO {
    // dao - data access object = tempat untuk fungsi select, insert

    public ArrayList<User> getUsers(Context mCtx){
        ArrayList<User> users = new ArrayList<>();

        MySqliteHelper helper = new MySqliteHelper(mCtx);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor resultCursor = db.query(
                "msUser", null,
                null, null,
                null, null, null);

        while(resultCursor.moveToNext()){
            User tempUser = new User();
            tempUser.username = resultCursor.getString(0);
            tempUser.password = resultCursor.getString(1);
            users.add(tempUser);
        }

        return users;
    }

    public void addUser(Context mCtx, User user){
        MySqliteHelper helper = new MySqliteHelper(mCtx);
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("username", user.username);
        cv.put("password", user.password);

        db.insertWithOnConflict("msUser", null, cv, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }
}
