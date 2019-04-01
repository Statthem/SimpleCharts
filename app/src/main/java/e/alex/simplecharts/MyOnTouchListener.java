package e.alex.simplecharts;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MyOnTouchListener implements View.OnTouchListener {

    private int _xDelta;
    private int _yDelta;

    public boolean onTouch(View view, MotionEvent event) {
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                _xDelta = X - lParams.leftMargin;
                _yDelta = Y - lParams.topMargin;
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                Log.i("action","" + X + " " + _xDelta + " " + layoutParams.leftMargin);

                    if((X - _xDelta) <= 0 | (X - _xDelta) >= 520) break;
                    layoutParams.leftMargin = X - _xDelta;
                    view.setLayoutParams(layoutParams);

                    ((ScrollerLayout) view.getParent()).onTouchEvent(event);
                break;
        }
        ((ScrollerLayout) view.getParent()).invalidate();
        return true;
    }
}
