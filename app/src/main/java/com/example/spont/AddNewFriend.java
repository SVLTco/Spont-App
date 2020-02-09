package com.example.spont;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNewFriend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_friend);
    }

    // TODO: Button to Query Database to Find User
    public void returnToMap( View view ) {
        EditText input = (EditText)findViewById(R.id.targetUser);
        String friend = input.getText().toString();
        if ( friend.length() != 0 ) {
            startActivity(new Intent(AddNewFriend.this, Map.class));
        }
    }
}


