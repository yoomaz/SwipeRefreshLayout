package com.graypn.swiperefreshlayout.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author ZhuLei
 * @date 2018/1/8
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_refresh_01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JQMainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_refresh_02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JDMainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_refresh_03).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SJDMainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_refresh_04).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BtzzMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
