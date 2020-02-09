package com.example.spont;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void goToMap(View view) {

        EditText logInUsername = (EditText) findViewById(R.id.username);
        EditText logInPassword = (EditText) findViewById(R.id.password);
        String input1 = logInUsername.getText().toString();
        String input2 = logInPassword.getText().toString();
        if ((input1.length() == 0 &&input2.length() == 0) || (input1.length() != 0 && input2.length() == 0)
            || (input1.length() == 0 && input2.length() != 0)) {
            System.out.println("empty");
        }
        else {
            System.out.println("non empty");
            startActivity(new Intent(Login.this, Map.class));
        }
    }

    public void goToSignUp(View view) {
        startActivity(new Intent(Login.this, SignUp.class));
    }
}
