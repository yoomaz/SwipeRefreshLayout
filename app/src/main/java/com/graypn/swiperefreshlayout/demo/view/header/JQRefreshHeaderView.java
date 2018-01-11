package com.graypn.swiperefreshlayout.demo.view.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.graypn.swiperefreshlayout.demo.R;
import com.graypn.swiperefreshlayout.layout.SwipeRefreshHeaderLayout;

public class JQRefreshHeaderView extends SwipeRefreshHeaderLayout {

    private static final String TAG = "JdRefreshHeaderView";

    private ImageView ivHead;
    private ImageView ivLine;

    private int mTriggerOffset;
    private Animation mRotateAnim;

    public JQRefreshHeaderView(Context context) {
        this(context, null);
    }

    public JQRefreshHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JQRefreshHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mTriggerOffset = context.getResources().getDimensionPixelOffset(R.dimen.refresh_header_height_jd);
    }

    @Override
    protected void onFinishInflate() {

        super.onFinishInflate();
        ivHead = (ImageView) findViewById(R.id.ivHead);
        ivLine = (ImageView) findViewById(R.id.ivLine);
        mRotateAnim = AnimationUtils.loadAnimation(getContext(), R.anim.rotate_refresh_jq);
    }

    @Override
    public void onRefresh() {
        ivLine.setVisibility(VISIBLE);
        ivLine.startAnimation(mRotateAnim);
    }

    @Override
    public void onPrepare() {
        ivLine.clearAnimation();
        ivLine.setVisibility(GONE);
    }

    @Override
    public void onMove(int y, boolean isComplete, boolean automatic) {
        float percent = y / (float) mTriggerOffset;
        if (percent > 1) {
            percent = 1.0f;
        }
        ivHead.setScaleX(percent);
        ivHead.setScaleY(percent);
    }

    @Override
    public void onRelease() {
    }

    @Override
    public void onComplete() {
    }

    @Override
    public void onReset() {
        ivLine.clearAnimation();
        ivLine.setVisibility(GONE);
    }
}
