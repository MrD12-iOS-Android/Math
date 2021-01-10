package com.example.sherlock;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Geometriya extends AppCompatActivity {

    Animation anim_btn_next,anim_imageView,anim_btn_back01,topa_title;
    Button btn_next;
    ImageView imageView,btn_back01;
    TextView textView;


    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geometriya);

// Here Animation Start
        anim_btn_next = AnimationUtils.loadAnimation(this, R.anim.anim_geometriya_page);
        anim_imageView = AnimationUtils.loadAnimation(this, R.anim.anim_geometriya_page_image);
        anim_btn_back01 = AnimationUtils.loadAnimation(this, R.anim.anim_geo_page_btn_back);
        topa_title = AnimationUtils.loadAnimation(this, R.anim.anim_top_title);


        btn_back01 = findViewById(R.id.btn_back01);
        btn_back01.setAnimation(anim_btn_back01);

        btn_next = findViewById(R.id.btn_next);
        btn_next.setAnimation(anim_btn_next);

        imageView = findViewById(R.id.imageView4);
        imageView.setAnimation(anim_imageView);

        textView = findViewById(R.id.top_title);
        textView.setAnimation(topa_title);
// Here Animation End




























        //Here ID: Button Back btnGeometriya Start

        btn_back01 = findViewById(R.id.btn_back01);
        btn_back01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                   Intent intent = new Intent(Geometriya.this, MainActivity.class);
              startActivity(intent);finish();
    }catch (Exception e){

                }
            }
        });



        //Here ID: Button Back btnGeometriya End



        //Here Next ID:   btn_back Start

        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Geometriya.this, Bolimlar.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });



        //Here Next  ID: btn_back End


        //Here FULLSCREEN Start

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Here FULLSCREEN End
    }
    // Here System Button Back Start

    @Override
    public  void onBackPressed(){
        try {
            Intent intent = new Intent(Geometriya.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
    // Here System Button End


}