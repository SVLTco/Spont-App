package com.example.spont;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;



public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        ImageView loadImage = (ImageView) findViewById(R.id.logo);
        int imageSource = getResources().getIdentifier("@drawable/svlt", null,
                this.getPackageName());
        loadImage.setImageResource(imageSource);

        //delay
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        startActivity(new Intent(LoadingScreen.this, Login.class));


    }

}
