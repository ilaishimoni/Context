package com.example.context;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


/**
 * @author		Ilai Shimoni <ilaishimoni@gmail.com>
 * @version	1.6 (current version number of program)
 * sequence calculator ( arithmetic or geometric )
 */

public class MainActivity extends AppCompatActivity {
    Intent gi;
    Switch sw;
    Boolean type;
    EditText et1;
    EditText et2;
    String str1,str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = (Switch) findViewById(R.id.sw);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

    }

    /**
     * checks for wrong input and if so sends message, else continues to the next activity
     *
     * @param	"function" starts when pressing a button (onClick)
     * @return	action checks for wrong input and moves activity when input is acceptable
     */

    public void move(View view) {

        if (sw.isChecked()){
            type = true;
        }
        else{
            type = false;
        }

        str1 = et1.getText().toString(); //x1
        str2 = et2.getText().toString(); //multiplyer/difference
        if (str1.isEmpty() || str2.isEmpty() || str1.equals(".") || str2.equals(".")){
            Toast.makeText(this, "please fill all lines", Toast.LENGTH_SHORT).show();
        }
        else{
            gi = new Intent(this, MainActivity2.class);

            gi.putExtra("type", type);
            gi.putExtra("x1", Double.parseDouble(str1));
            gi.putExtra("x2", Double.parseDouble(str2));

            startActivity(gi);
        }

    }
}