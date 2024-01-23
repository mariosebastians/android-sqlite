package com.example.pertemuan12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView tvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvUsers = findViewById(R.id.tvUsers);

        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = userDAO.getUsers(this);

        String sUsers = "";

        for(int i = 0; i < users.size(); i++){
            sUsers = sUsers + users.get(i).username + " " + users.get(i).password + " || ";
        }

        tvUsers.setText(sUsers);
    }
}