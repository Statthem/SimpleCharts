package e.alex.simplecharts;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import e.alex.simplecharts.MyScrollView;
import e.alex.simplecharts.R;

public class ScrollerLayout extends RelativeLayout{

    private MyScrollView myScrollView;

    public ScrollerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ScrollerLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setScrollerView(MyScrollView myScrollView){
        this.myScrollView = myScrollView;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int LastMotionX = (int) event.getRawX();
        int scrollViewWidth = myScrollView.getChildAt(0).getWidth();
        int k = scrollViewWidth/this.getWidth();

        myScrollView.scrollTo(LastMotionX * k, 0);
        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }
}
