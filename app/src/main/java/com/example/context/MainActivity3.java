package com.example.context;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView tv_crd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv_crd = (TextView) findViewById(R.id.tv_crd);

        tv_crd.setText("this is credits menu \n teacher:Albert Levi \n student: Ilai Shimoni");
    }
}