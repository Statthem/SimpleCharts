package e.alex.simplecharts;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import e.alex.simplecharts.charts.Chart;
import e.alex.simplecharts.charts.Deserializer;
import e.alex.simplecharts.utils.IOUtils;

import static e.alex.simplecharts.utils.IOUtils.convert;
import static e.alex.simplecharts.utils.IOUtils.readJsonFromFile;

public class MainActivity extends Activity{
    DrawView drawView;
    MyScrollView myScrollView;
    ScrollerLayout scrollerLayout;
    MyScrollBar myScrollBar;

    public static ConstraintLayout mainLayaout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ConstraintLayout rootLayout = (ConstraintLayout) findViewById(R.id.root);
        mainLayaout = rootLayout;

        drawView = (DrawView) findViewById(R.id.DrawView);
        drawView.setBackgroundColor(Color.GRAY); //IT'S OMNIPOTENT(EXTRA IMPORTANT)

        myScrollView = (MyScrollView) findViewById(R.id.MyScrollView);
        scrollerLayout = (ScrollerLayout) findViewById(R.id.ScrollerLayaout);
        myScrollBar = (MyScrollBar) findViewById(R.id.ScrollBar);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200, 200);
        myScrollBar.setLayoutParams(layoutParams);
        myScrollBar.setOnTouchListener(new MyOnTouchListener());

        this.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        IOUtils.writeToFile(loadBitmapFromView(myScrollView.getChildAt(0), 600, 200),this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    public static Bitmap loadBitmapFromView(View v, int width, int height) {
        Bitmap b = Bitmap.createBitmap(width , height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        //v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
        v.draw(c);
        return b;
    }



}