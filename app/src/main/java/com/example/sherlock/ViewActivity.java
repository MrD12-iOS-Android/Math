package com.example.sherlock;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;

public class ViewActivity extends AppCompatActivity {

    PDFView pdfView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        pdfView = (PDFView)findViewById(R.id.pdf_viewer);

        if (getIntent()  != null){
            String viewType = getIntent().getStringExtra("ViewType");
            if (viewType != null || !TextUtils.isEmpty(viewType)){
                if (viewType.equals("assets")){
                    pdfView.fromAsset("m.pdf")
                            .password(null)
                            .defaultPage(0)
                            .enableSwipe(true)
                            .swipeHorizontal(false)
                            .enableDoubletap(true)
                            .onDrawAll(new OnDrawListener() {
                                @Override
                                public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                                }
                            })
                            .onDrawAll(new OnDrawListener() {
                                @Override
                                public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                                }
                            })
                            .onPageError(new OnPageErrorListener() {
                                @Override
                                public void onPageError(int page, Throwable t) {
                                    Toast.makeText(ViewActivity.this, "Error" +page, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .onPageChange(new OnPageChangeListener() {
                                @Override
                                public void onPageChanged(int page, int pageCount) {

                                }
                            })
                            .onTap(new OnTapListener() {
                                @Override
                                public boolean onTap(MotionEvent e) {
                                    return true;
                                }
                            })
                            .onRender(new OnRenderListener() {
                                @Override
                                public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                    pdfView.fitToWidth();

                                }
                            })
                            .enableAnnotationRendering(true)
                            .invalidPageColor(Color.WHITE)
                            .load();

                }

                else if (viewType.equals("storage")){
                    Uri pdfFile = Uri.parse(getIntent().getStringExtra("FileUri"));

                    pdfView.fromUri(pdfFile)
                            .password(null)
                            .defaultPage(0)
                            .enableSwipe(true)
                            .swipeHorizontal(false)
                            .enableDoubletap(true)
                            .onDrawAll(new OnDrawListener() {
                                @Override
                                public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                                }
                            })
                            .onDrawAll(new OnDrawListener() {
                                @Override
                                public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                                }
                            })
                            .onPageError(new OnPageErrorListener() {
                                @Override
                                public void onPageError(int page, Throwable t) {
                                    Toast.makeText(ViewActivity.this, "Error" +page, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .onPageChange(new OnPageChangeListener() {
                                @Override
                                public void onPageChanged(int page, int pageCount) {

                                }
                            })
                            .onTap(new OnTapListener() {
                                @Override
                                public boolean onTap(MotionEvent e) {
                                    return true;
                                }
                            })
                            .onRender(new OnRenderListener() {
                                @Override
                                public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                    pdfView.fitToWidth();

                                }
                            })
                            .enableAnnotationRendering(true)
                            .invalidPageColor(Color.BLACK)
                            .load();

                }


            }
        }


    }

    // System Back Start
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(ViewActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }

    // System Back End
}