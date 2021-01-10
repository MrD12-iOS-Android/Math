package com.example.sherlock;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final int PICK_OPEN_CODE = 1000;
    //Variables
    Animation anim_image,anim_Kirish,anim_Algebra,anim_Geometriya,anim_Pdf_Formatda,anim_PDF_File;
    ImageView imageview;
    Button btnKirish,btn_open_assets,btn_open_storage;

    LottieAnimationView lottie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottie = findViewById(R.id.lottie_layer_name);

        //Here ID: btnKirish Start

        btnKirish = findViewById(R.id.btnKirish);
        btnKirish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, Kirish.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        //Here ID: btnKirish End





        //Here ID: btnAlgebra Start
        Button btnAlgebra = (Button) findViewById(R.id.btnAlgebra);
        btnAlgebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, Algebra.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        //Here ID: btnAlgebra End



        //Here ID: btnGeometriya Start
        Button btnGeometriya = (Button) findViewById(R.id.btnGeometriya);
        btnGeometriya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, Geometriya.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });
        //Here ID: btnAlgebra End




        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new BaseMultiplePermissionsListener(){
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        super.onPermissionsChecked(report);
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        super.onPermissionRationaleShouldBeShown(permissions, token);
                    }
                }).check();

        btn_open_assets = (Button)findViewById(R.id.btn_open_assets);
        btn_open_assets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewActivity.class);
                intent.putExtra("ViewType", "assets");
                startActivity(intent);
                finish();
            }
        });

        btn_open_storage = (Button)findViewById(R.id.btn_open_storage);
        btn_open_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserPDF = new Intent(Intent.ACTION_GET_CONTENT);
                browserPDF.setType("application/pdf");
                browserPDF.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(Intent.createChooser(browserPDF, "Select PDF"), PICK_OPEN_CODE);



            }
        });




        //Animation
        anim_image = AnimationUtils.loadAnimation(this,R.anim.menu_top_image);
        anim_Kirish = AnimationUtils.loadAnimation(this,R.anim.anim_kirish);
        anim_Algebra = AnimationUtils.loadAnimation(this,R.anim.anim_algebra);
        anim_Geometriya = AnimationUtils.loadAnimation(this,R.anim.anim_geometriya);
        anim_Pdf_Formatda = AnimationUtils.loadAnimation(this,R.anim.anim_pdf_formatda);
        anim_PDF_File = AnimationUtils.loadAnimation(this,R.anim.anim_pdf_file);

        //Animation Top Image + id + anim connect
        imageview = findViewById(R.id.imageView);
        imageview.setAnimation(anim_image);


        //Animation Kirish + anim connect
        btnKirish.setAnimation(anim_Kirish);

        //Animation Algebra + anim connect
        btnAlgebra.setAnimation(anim_Algebra);

        //Animation Geometriya + anim connect
        btnGeometriya.setAnimation(anim_Geometriya);

        //Animation About + anim connect
        Button btn_open_assets = (Button) findViewById(R.id.btn_open_assets);
        btn_open_assets.setAnimation(anim_Pdf_Formatda);

        //Animation PDF File + anim connect
        btn_open_storage.setAnimation(anim_PDF_File);






        //Here FULLSCREEN Start

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Here FULLSCREEN End
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_OPEN_CODE && resultCode == RESULT_OK && data != null){
            Uri selectPDF = data.getData();
            Intent intent = new Intent(MainActivity.this,ViewActivity.class);
            intent.putExtra("ViewType", "storage");
            intent.putExtra("FileUri",selectPDF.toString());
            startActivity(intent);
            finish();
        }

    }


}