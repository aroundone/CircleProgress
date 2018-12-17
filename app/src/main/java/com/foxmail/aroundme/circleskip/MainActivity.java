package com.foxmail.aroundme.circleskip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.library.CircleProgress;


public class MainActivity extends Activity {

    private CircleProgress circleProgress1;
    private CircleProgress circleProgress2;
    private CircleProgress circleProgress3;
    private CircleProgress circleProgress4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleProgress1 = (CircleProgress) findViewById(R.id.circleProgress1);
        circleProgress2 = (CircleProgress) findViewById(R.id.circleProgress2);
        circleProgress3 = (CircleProgress) findViewById(R.id.circleProgress3);
        circleProgress4 = (CircleProgress) findViewById(R.id.circleProgress4);
        circleProgress1.start();
        circleProgress2.start();
        circleProgress3.start();
        circleProgress4.start();

        circleProgress1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click 1", Toast.LENGTH_SHORT).show();
            }
        });

        circleProgress1.setOnLoadingComplete(new CircleProgress.OnLoadingComplete() {
            @Override
            public void OnLoadingComplete() {
                Toast.makeText(MainActivity.this, "Complete 1", Toast.LENGTH_SHORT).show();
            }
        });
        circleProgress2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click 2", Toast.LENGTH_SHORT).show();
            }
        });

        circleProgress2.setOnLoadingComplete(new CircleProgress.OnLoadingComplete() {
            @Override
            public void OnLoadingComplete() {
                Toast.makeText(MainActivity.this, "Complete 2", Toast.LENGTH_SHORT).show();
            }
        });
        circleProgress3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click 3", Toast.LENGTH_SHORT).show();
            }
        });

        circleProgress3.setOnLoadingComplete(new CircleProgress.OnLoadingComplete() {
            @Override
            public void OnLoadingComplete() {
                Toast.makeText(MainActivity.this, "Complete 3", Toast.LENGTH_SHORT).show();
            }
        });
        circleProgress4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click 4", Toast.LENGTH_SHORT).show();
            }
        });

        circleProgress4.setOnLoadingComplete(new CircleProgress.OnLoadingComplete() {
            @Override
            public void OnLoadingComplete() {
                Toast.makeText(MainActivity.this, "Complete 4", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
