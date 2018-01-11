package com.graypn.swiperefreshlayout.demo.view.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.graypn.swiperefreshlayout.demo.R;
import com.graypn.swiperefreshlayout.layout.SwipeRefreshHeaderLayout;

/**
 * Created by ZhuLei on 2017/10/9.
 * Email: zhuleineuq@gmail.com
 */

public class BtzzRefreshHeaderView extends SwipeRefreshHeaderLayout {

    private static final String TAG = "BtzzRefreshHeaderView";

    private ImageView ivSunCycle;
    private FrameLayout flSun;

    private ValueAnimator mValueAnimator;

    private int mTriggerOffset;

    public BtzzRefreshHeaderView(Context context) {
        this(context, null);
    }

    public BtzzRefreshHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BtzzRefreshHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mTriggerOffset = context.getResources().getDimensionPixelOffset(R.dimen.refresh_header_height_jd);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        flSun = (FrameLayout) findViewById(R.id.fl_sun);
        ivSunCycle = (ImageView) findViewById(R.id.iv_sun_cycle);
    }

    @Override
    public void onRefresh() {
        if (ivSunCycle != null) {
            mValueAnimator = ValueAnimator.ofFloat(0, 100);
            mValueAnimator.setDuration(10 * 1000);
            mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float value = (float) animation.getAnimatedValue();
                    ivSunCycle.setRotation(value * 1500);
                }
            });
            mValueAnimator.start();
        }
    }

    @Override
    public void onPrepare() {
        if (mValueAnimator != null) {
            mValueAnimator.end();
        }
    }

    @Override
    public void onMove(int y, boolean isComplete, boolean automatic) {
        float sunPercent = y / (float) mTriggerOffset;
        float cyclePercent = sunPercent;
        if (sunPercent < 0) {
            sunPercent = 0;
        }
        if (sunPercent > 1) {
            sunPercent = 1;
        }
        float translationY = (1 - sunPercent) * 2 * mTriggerOffset;
        if (flSun != null) {
            flSun.setTranslationY(translationY);
        }
        if (ivSunCycle != null) {
            ivSunCycle.setRotation(cyclePercent * 1500);
        }
    }

    @Override
    public void onRelease() {
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onReset() {
        if (mValueAnimator != null) {
            mValueAnimator.end();
        }
    }
}
