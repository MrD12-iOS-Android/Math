package com.example.sherlock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Welcome_Page extends AppCompatActivity {

    private static int SPLASH_SCREEN = 4000;

    // Variables
    Animation image_Anim;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__page);


        image_Anim = AnimationUtils.loadAnimation(this, R.anim.welcome_animation);

        //Hooks
        image = findViewById(R.id.logo);
        image.setAnimation(image_Anim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome_Page.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);







        //Here FULLSCREEN Start

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Here FULLSCREEN End
    }
}



















