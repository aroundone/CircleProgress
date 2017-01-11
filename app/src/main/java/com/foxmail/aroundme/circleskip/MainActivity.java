package com.foxmail.aroundme.circleskip;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

public class MainActivity extends AppCompatActivity {

    private CircleProgress circleProgress;
    private CircleProgress circleProgress1;
    private CircleProgress circleProgress2;
    private Subscription subscription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleProgress = (CircleProgress) findViewById(R.id.custom_progress);
        circleProgress1 = (CircleProgress) findViewById(R.id.custom_progress1);
        circleProgress2 = (CircleProgress) findViewById(R.id.custom_progress2);

        circleProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
            }
        });

        circleProgress.setOnLoadingComplete(new CircleProgress.IOnLoadingComplete() {
            @Override
            public void OnLoadingComplete() {
                Toast.makeText(MainActivity.this, "Complete", Toast.LENGTH_LONG).show();
            }
        });
        circleProgress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
            }
        });

        circleProgress1.setOnLoadingComplete(new CircleProgress.IOnLoadingComplete() {
            @Override
            public void OnLoadingComplete() {
                Toast.makeText(MainActivity.this, "Complete", Toast.LENGTH_LONG).show();
            }
        });
        circleProgress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click", Toast.LENGTH_LONG).show();
            }
        });

        circleProgress2.setOnLoadingComplete(new CircleProgress.IOnLoadingComplete() {
            @Override
            public void OnLoadingComplete() {
                Toast.makeText(MainActivity.this, "Complete", Toast.LENGTH_LONG).show();
            }
        });




    }

}
