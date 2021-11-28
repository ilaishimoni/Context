package com.example.context;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemLongClickListener{
    ListView lv;
    Intent si;
    boolean type;
    Double x1;
    Double x2;
    String[] str = new String[20];
    TextView tv;
    Double sum = 0.0;
    Intent zi;


    /**
     * function gets values from Intent into variables and fills Array accordingly
     *
     * @param	"function" starts when activity is created (and gets the saved instance from activity )
     * @return	function fills array and shows the array on the app
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lv = (ListView) findViewById(R.id.lv);
        tv = (TextView) findViewById(R.id.tv);


        si = getIntent();

        type = si.getBooleanExtra("type", false);
        x1 = si.getDoubleExtra("x1", 99999999);
        x2 = si.getDoubleExtra("x2", 99999999);

        //handasit
        if (type == true){
            for (int i=0; i<str.length; i++){
                str[i] = String.valueOf(x1*Math.pow(x2,i));
            }
        }
        //heshbonit
        else{
            for (int i=0; i<str.length; i++){
                str[i] = String.valueOf(x1+((i)*x2));
            }
        }


        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemLongClickListener(this);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,str);
        lv.setAdapter(adp);

    }


    /**
     * creates AlertDialog, shows the number or index depends on user's choice
     *
     *
     * @param	"function" gets the selected item's parent, view, position, id
     * @return	"function" sets Textview text to the index or sum (between the first number and the selected number) for the selected Item
     */

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        AlertDialog.Builder adb = new AlertDialog.Builder(this);

        adb.setMessage("choose between showing the selected item's index or sum between x1 and your number");
        adb.setTitle("choose another parameter");
        adb.setPositiveButton("index", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv.setText("the index of the selected number is: " + String.valueOf(position));
            }
        });
        adb.setNegativeButton("sum", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i = 0; i<=position; i++){
                    sum = sum + Double.valueOf(str[i]);
                }
                tv.setText("sum of all number until the selected number is: " + String.valueOf(sum));
                sum=0.0;

            }
        });




        AlertDialog ad=adb.create();
        ad.show();

        return false;
    }

    /**
     * goes back to activity without information (Variables)
     * <p>
     *
     * @param	"function" gets and starts on button click (called "back to main activity")
     * @return	"function goes back to main activity"
     */
    public void goback(View view) {
        finish();
    }
    /**
     *  creates Intent and moves to credits activity
     * <p>
     *
     * @param	"function" gets and starts on button click (called "credits")
     * @return	"function goes to credits activity"
     */
    public void credits(View view) {
        zi = new Intent(this, MainActivity3.class);
        startActivity(zi);
    }
}