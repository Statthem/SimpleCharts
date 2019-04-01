package e.alex.simplecharts;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;


public class MyScrollView extends HorizontalScrollView{

    private int mLastMotionX;

    private boolean mIsBeingDragged = false;

    private int mActivePointerId = INVALID_POINTER;
    /**
     * Sentinel value for no current active pointer.
     * Used by {@link #mActivePointerId}.
     */
    private static final int INVALID_POINTER = -1;

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

    }

    @Override
    public void scrollBy(int x, int y) {
        super.scrollBy(x, y);
        Log.i("scrolling", "scrollBy " + x + ", " + y);
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
        Log.i("scrolling", "scrollTo " + x + ", " + y);
     //  Log.i("scrolling", " " + getChildAt(0).getWidth());
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

      return true;
    }
}
