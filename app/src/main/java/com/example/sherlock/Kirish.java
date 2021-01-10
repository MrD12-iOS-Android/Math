package com.example.sherlock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Kirish extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kirish);









        //Here ID: back_Kirish Start

        ImageButton back_Kirish = (ImageButton) findViewById(R.id.back_Kirish);
        back_Kirish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(Kirish.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });



        //Here ID: btnBackKirish End




        //Here FULLSCREEN Start

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Here FULLSCREEN End
    }




    // Here System Button Back Start

    @Override
    public  void onBackPressed(){
        try {
            Intent intent = new Intent(Kirish.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
    // Here System Button End


}