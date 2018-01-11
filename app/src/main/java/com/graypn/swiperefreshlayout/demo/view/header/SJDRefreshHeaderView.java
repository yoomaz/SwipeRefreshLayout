package com.graypn.swiperefreshlayout.demo.view.header;

import android.content.Context;
import android.util.AttributeSet;

import com.graypn.swiperefreshlayout.demo.R;
import com.graypn.swiperefreshlayout.demo.view.SingleBounce;
import com.graypn.swiperefreshlayout.layout.SwipeRefreshHeaderLayout;

/**
 * Created by ZhuLei on 2017/10/9.
 * Email: zhuleineuq@gmail.com
 */

public class SJDRefreshHeaderView extends SwipeRefreshHeaderLayout {

    private static final String TAG = "SJDRefreshHeaderView";

    private SingleBounce ivBall;

    public SJDRefreshHeaderView(Context context) {
        this(context, null);
    }

    public SJDRefreshHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SJDRefreshHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ivBall = (SingleBounce) findViewById(R.id.iv_ball);
    }

    @Override
    public void onRefresh() {
        ivBall.setVisibility(VISIBLE);
        ivBall.startAnim();
    }

    @Override
    public void onPrepare() {
        ivBall.endAnim();
        ivBall.setVisibility(GONE);
    }

    @Override
    public void onMove(int y, boolean isComplete, boolean automatic) {
    }

    @Override
    public void onRelease() {
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onReset() {
        ivBall.endAnim();
        ivBall.setVisibility(GONE);
    }
}
