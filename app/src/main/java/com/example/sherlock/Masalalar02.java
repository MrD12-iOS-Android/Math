package com.example.sherlock;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Masalalar02 extends AppCompatActivity {



    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.masalalar02);































        //Here ID: btn_back Start
        @SuppressLint("WrongViewCast") ImageButton btn_back = (ImageButton) findViewById(R.id.btn_next);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Masalalar02.this, Algebra.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        //Here ID: btn_back End






        //Here FULLSCREEN Start

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Here FULLSCREEN End
    }




    // Here System Button Back Start

    @Override
    public  void onBackPressed(){
        try {
            Intent intent = new Intent(Masalalar02.this, Algebra.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
    // Here System Button End


}