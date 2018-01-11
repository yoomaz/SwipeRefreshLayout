package com.graypn.swiperefreshlayout.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.graypn.swiperefreshlayout.layout.OnLoadMoreListener;
import com.graypn.swiperefreshlayout.layout.OnRefreshListener;
import com.graypn.swiperefreshlayout.layout.SwipeRefreshLayout;

/**
 * @author ZhuLei
 * @date 2018/1/8
 */
public class JDMainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeToLoadLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jd);

        swipeToLoadLayout = (SwipeRefreshLayout) findViewById(R.id.swipeToLoadLayout);

        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeToLoadLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeToLoadLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                swipeToLoadLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeToLoadLayout.setLoadingMore(false);
                    }
                }, 3000);
            }
        });

    }
}
