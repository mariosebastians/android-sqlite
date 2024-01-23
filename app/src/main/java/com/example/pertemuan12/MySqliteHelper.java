package com.example.pertemuan12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqliteHelper extends SQLiteOpenHelper {

    static int version = 1;
    public MySqliteHelper(@Nullable Context context) {
        super(context, "mySQLitedb", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qCreate = "CREATE TABLE IF NOT EXISTS 'msUser' ('username' TEXT, 'password' TEXT)";
        db.execSQL(qCreate);

        String qInsert1 = "INSERT INTO 'msUser' ('username', 'password') VALUES ('qqq', 'qqq');";
        db.execSQL(qInsert1);

        String qInsert2 = "INSERT INTO 'msUser' ('username', 'password') VALUES ('www', 'www');";
        db.execSQL(qInsert2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
