package com.example.spont;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText username;
    String user;
    EditText password;
    String pass;
    EditText confirmPassword;
    String confirmPass;
    Button signInButton;

    boolean success = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void goToMap(View view) {
        /* Declaring Objects */
        username = (EditText)findViewById(R.id.username);
        user = username.getText().toString();
        password = (EditText)findViewById(R.id.password);
        pass = password.getText().toString();
        confirmPassword = (EditText)findViewById(R.id.confirmPassword);
        confirmPass = confirmPassword.getText().toString();


        if (user.length() != 0 && pass.length() != 0 && confirmPass.length() != 0) {
            startActivity(new Intent(SignUp.this, Map.class));
        }
        else {
            System.out.println("error");
        }



    }


}
