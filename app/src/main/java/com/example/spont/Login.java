package com.example.spont;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToMap(View view) {
        startActivity(new Intent(Login.this, Map.class));
    }

    public void goToSignUp(View view) {
        startActivity(new Intent(Login.this, SignUp.class));
    }
}
