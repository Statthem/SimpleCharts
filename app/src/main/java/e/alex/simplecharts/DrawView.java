package e.alex.simplecharts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import e.alex.simplecharts.charts.Chart;
import e.alex.simplecharts.charts.Deserializer;
import e.alex.simplecharts.exceptions.IncorrectJsonException;

public class DrawView extends FrameLayout{
    Paint paint = new Paint();
    List<Chart> chartsList;

    private void init() {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(8);

        Deserializer deserializer = new Deserializer();

        InputStream is = this.getResources().openRawResource(R.raw.chart_data);

        StringBuilder sb = new StringBuilder();
        String json = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.defaultCharset()))) {
            json = br.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }


            chartsList = deserializer.deserialize(json);
    }

    public DrawView(Context context) {
        super(context);
        init();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public void onDraw(Canvas canvas) {
        Log.i("DrawView", "onDraw");
        this.setLayoutParams(new FrameLayout.LayoutParams(400, 400));
        canvas.drawLine(0, 0, 400, 400, paint);
        canvas.drawLine(400, 0, 0, 400, paint);


    }

}