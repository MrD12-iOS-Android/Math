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

public class Bolimlar extends AppCompatActivity {
    Animation anim_btn_next,anim_btn_back01,topa_title;
    Button btn_next;
    ImageView imageView,btn_back01;
    TextView textView;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bolimlar);


        anim_btn_next = AnimationUtils.loadAnimation(this, R.anim.anim_geometriya_page);
        anim_btn_back01 = AnimationUtils.loadAnimation(this, R.anim.anim_geo_page_btn_back);
        topa_title = AnimationUtils.loadAnimation(this, R.anim.anim_top_title);


        btn_back01 = findViewById(R.id.btn_back01);
        btn_back01.setAnimation(anim_btn_back01);

        btn_next = findViewById(R.id.btn_next);
        btn_next.setAnimation(anim_btn_next);

        textView = findViewById(R.id.top_title);
        textView.setAnimation(topa_title);































        //Here ID: Button Top Back  Start

        btn_back01 = findViewById(R.id.btn_back01);
        btn_back01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                   Intent intent = new Intent(Bolimlar.this, Geometriya.class);
              startActivity(intent);finish();
    }catch (Exception e){

                }
            }
        });



        //Here ID: Button Top Back End



        //Here Next ID:   btn_next Start

        Button btn_next = (Button) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Bolimlar.this, Mavzular.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });



        //Here Next  ID: btn_next End


        //Here FULLSCREEN Start

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Here FULLSCREEN End
    }
    // Here System Button Back Start

    @Override
    public  void onBackPressed(){
        try {
            Intent intent = new Intent(Bolimlar.this, Geometriya.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
    // Here System Button End


}