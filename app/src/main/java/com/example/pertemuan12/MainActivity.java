package com.example.pertemuan12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUsername, etPassword;
    Button btnLogin, btnRegister;
    ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        // isi data
        UserDAO userDAO = new UserDAO();
        users = userDAO.getUsers(this);
        // selesai isi data
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnLogin){

            UserDAO userDAO = new UserDAO();
            users = userDAO.getUsers(this);

            Intent niatPindah = new Intent(this, MainActivity2.class);

            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            for(int i = 0; i < users.size(); i++) {
                if (users.get(i).username.compareTo(username) == 0
                        && users.get(i).password.compareTo(password) == 0) {
                    startActivity(niatPindah);
                }
            }
        }else if(v.getId() == R.id.btnRegister){
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            User tempUserForReg = new User();
            tempUserForReg.username = username;
            tempUserForReg.password = password;

            UserDAO userDAO = new UserDAO();
            userDAO.addUser(this, tempUserForReg);
            Toast.makeText(this, "reg berhasil", Toast.LENGTH_LONG).show();
        }
    }
}