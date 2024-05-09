package com.example.test.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.repo.LoginDatabase;

public class LoginActivity extends AppCompatActivity {
    EditText usernameText, passwordText;
    Button registerButton, loginButton;
    LoginDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameText = findViewById(R.id.editTextUsername);
        passwordText = findViewById(R.id.editTextPassword);
        registerButton = findViewById(R.id.buttonCreateAccount);
        loginButton = findViewById(R.id.buttonLogin);
        database = new LoginDatabase(this);

        // User registration upon registerButton click
        registerButton.setOnClickListener(v -> {
            String username = usernameText.getText().toString();
            String password = passwordText.getText().toString();

            // First check if username or password fields are empty
            if (username.equals("") || password.equals("")) {
                Toast.makeText(LoginActivity.this, "Enter your username and password", Toast.LENGTH_SHORT).show();
            }
            // If not empty
            else {
                Boolean checkUser = database.checkUsername(username);
                // If checked username is not in DB, create user
                if (!checkUser) {
                    Boolean insert = database.insertData(username, password);
                    // If successful, output success toast
                    if (insert) {
                        Toast.makeText(LoginActivity.this, "Successfully registered user", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    // If unsuccessful, output fail toast
                    else {
                        Toast.makeText(LoginActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
                // If username is in DB already, output sign in prompt
                else {
                    Toast.makeText(LoginActivity.this, "User already exists, please sign in", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // User login upon loginButton click
        loginButton.setOnClickListener(v -> {
            String username = usernameText.getText().toString();
            String password = passwordText.getText().toString();

            // First check if username or password fields are empty
            if (username.equals("") || password.equals("")) {
                Toast.makeText(LoginActivity.this, "Enter your username and password", Toast.LENGTH_SHORT).show();
            }
            // If not empty
            else {
                Boolean checkAuth = database.checkUsernamePassword(username, password);
                // If checked username and password matches, sign in
                if (checkAuth) {
                    Toast.makeText(LoginActivity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                // oOutput invalid credentials
                else {
                    Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

}
