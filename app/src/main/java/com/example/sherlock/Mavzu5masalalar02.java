package com.example.sherlock;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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

import java.util.concurrent.TimeUnit;

public class Mavzu5masalalar02 extends AppCompatActivity {

    Animation anim_btn_Yechim,anim_imageView,anim_btn_back01,topa_title,anim_bt_play;
    ImageView imageView,imageView_02, btPlay,btPause,btn_back,btn_back01,mavzu_5_7_masala_2_img;
    Context context;
    MediaPlayer mediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;
    TextView textView;
    Button btn_Yechim;

    @SuppressLint({"ClickableViewAccessibility", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mavzu5masalalar02);

        btPlay = findViewById(R.id.bt_play);
        btPause = findViewById(R.id.bt_pause);
        mavzu_5_7_masala_2_img = findViewById(R.id.mavzu_5_7_masala_2_img);
        btn_Yechim = findViewById(R.id.btn_yechim);

// Here Animation Start

        anim_imageView = AnimationUtils.loadAnimation(this, R.anim.anim_geometriya_page_image);
        anim_btn_back01 = AnimationUtils.loadAnimation(this, R.anim.anim_geo_page_btn_back);
        topa_title = AnimationUtils.loadAnimation(this, R.anim.anim_top_title);
        anim_bt_play = AnimationUtils.loadAnimation(this, R.anim.anim_bolimlar_page_btn_next);
        anim_btn_Yechim = AnimationUtils.loadAnimation(this, R.anim.anim_bolimlar_page_btn_next);

        btn_back01 = findViewById(R.id.btn_back_end);
        btn_back01.setAnimation(anim_btn_back01);

        btPlay = findViewById(R.id.bt_play);
        btPlay.setAnimation(anim_bt_play);

        btPause = findViewById(R.id.bt_pause);
        btPause.setAnimation(anim_bt_play);

        textView = findViewById(R.id.masala_text);
        textView.setAnimation(anim_btn_back01);

        textView = findViewById(R.id.yechim_text);
        textView.setAnimation(anim_btn_back01);

        imageView = findViewById(R.id.mavzu_5_7_masala_1_img);
        imageView.setAnimation(anim_imageView);

        imageView_02 = findViewById(R.id.mavzu_5_7_masala_2_img);
        imageView_02.setAnimation(anim_imageView);

        textView = findViewById(R.id.top_title);
        textView.setAnimation(topa_title);

        btn_Yechim = findViewById(R.id.btn_yechim);
        btn_Yechim.setAnimation(anim_btn_Yechim);
// Here Animation End









        // Here Zoom Img Start
        context = this;

        imageView = findViewById(R.id.mavzu_5_7_masala_1_img);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Here create the dialog
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_5_mavzu_7_masala_1_img);
                dialog.show();
            }
        });

        imageView_02 = findViewById(R.id.mavzu_5_7_masala_2_img);
        imageView_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Here create the dialog
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_5_mavzu_7_masala_2_img);
                dialog.show();
            }
        });
        // Here Zoom Img End









        // This Image Hidden Start
        btn_Yechim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_Yechim.setVisibility(View.GONE);
                mavzu_5_7_masala_2_img.setVisibility(View.VISIBLE);
            }
        });
        // Image Hidden End


        // Initialize  media player
        mediaPlayer = MediaPlayer.create(this,R.raw.misol3);





        //get duration of media player
        final int duration = mediaPlayer.getDuration();
        // convert millisecond to minute and second
        String sDuration = convertFormat(duration);


        btPlay.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Hide play button
                btPlay.setVisibility(View.GONE);
                //Show pause button
                btPause.setVisibility(View.VISIBLE);
                // Start media player
                mediaPlayer.start();

                handler.postDelayed(runnable, 0);


            }
        });


        btPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Hide pause
                btPause.setVisibility(View.GONE);
                //Hide play
                btPlay.setVisibility(View.VISIBLE);
                //Hide media player
                mediaPlayer.pause();
                //Stop handler
                handler.removeCallbacks(runnable);
            }
        });
























        //Here ID: btn_back Start
        @SuppressLint("WrongViewCast")
        ImageView btn_back = (ImageView) findViewById(R.id.btn_back_end);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Mavzu5masalalar02.this, Mavzu5masalartoplami.class);
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




    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return  String.format("%02d:%02d"
                , TimeUnit.MILLISECONDS.toMinutes(duration)
                ,TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));

    }


    // Here System Button Back Start

    @Override
    public  void onBackPressed(){
        try {
            mediaPlayer.pause();
            Intent intent = new Intent(Mavzu5masalalar02.this, Mavzu5masalartoplami.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
    // Here System Button End


}