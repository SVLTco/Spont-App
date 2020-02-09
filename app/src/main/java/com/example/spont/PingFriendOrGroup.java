package com.example.spont;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PingFriendOrGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ping_friend_or_group);
    }

    public void pingFriend( View view ) {
        startActivity(new Intent(PingFriendOrGroup.this, Map.class));
    }

    public void pingGroup( View view ) {
        startActivity(new Intent(PingFriendOrGroup.this, Map.class));
    }
}
