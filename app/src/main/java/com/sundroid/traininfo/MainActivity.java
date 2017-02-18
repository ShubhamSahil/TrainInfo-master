package com.sundroid.traininfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sundroid.traininfo.webservices.WebServicesCallBack;

public class MainActivity extends AppCompatActivity implements WebServicesCallBack {
    private final static String CALLAPI = "callapi";
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.callapi);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onGetMsg(String[] msg) {

    }
}