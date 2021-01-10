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

public class Mavzu5masalartoplami extends AppCompatActivity {

    Animation anim_btn_next,anim_btn_back01,top_title,anim_btn_next2;
    Button btn_next,btn_next2;
    ImageView imageView,btn_back01;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mavzu5masalalartoplami);





        anim_btn_next = AnimationUtils.loadAnimation(this, R.anim.anim_mavzular_page_btn_next);
        anim_btn_next2 = AnimationUtils.loadAnimation(this, R.anim.anim_mavzular_page_btn_next2);
        anim_btn_back01 = AnimationUtils.loadAnimation(this, R.anim.anim_geo_page_btn_back);
        top_title = AnimationUtils.loadAnimation(this, R.anim.anim_top_title);


        btn_back01 = findViewById(R.id.btn_back01);
        btn_back01.setAnimation(anim_btn_back01);

        btn_next = findViewById(R.id.btn_next);
        btn_next.setAnimation(anim_btn_next);

        btn_next2 = findViewById(R.id.btn_next2);
        btn_next2.setAnimation(anim_btn_next2);

        textView = findViewById(R.id.top_title);
        textView.setAnimation(top_title);


























        //Here ID: Button Top Back  Start

        @SuppressLint("WrongViewCast")
        ImageView btn_back01 = (ImageView) findViewById(R.id.btn_back01);
        btn_back01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                   Intent intent = new Intent(Mavzu5masalartoplami.this, Mavzular.class);
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
                    Intent intent = new Intent(Mavzu5masalartoplami.this, Mavzu5masalalar01.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        //Here Next  ID: btn_next End




        //Here Next ID:   btn_next Start

        Button btn_next2 = (Button) findViewById(R.id.btn_next2);
        btn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Mavzu5masalartoplami.this, Mavzu5masalalar02.class);
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
            Intent intent = new Intent(Mavzu5masalartoplami.this, Mavzular.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
    // Here System Button End


}