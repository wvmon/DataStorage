package com.example.test.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView TextElement;
    int num;
    public static final String fileName = "DataBase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextElement = (TextView) findViewById(R.id.count);
        SharedPreferences data = getPreferences(MODE_PRIVATE);
        int gather  = data.getInt("numberToAdd", 0);

        num = gather;

        setText();

    }

    public void setText() {
        String number  = Integer.toString(num);
        TextElement.setText(number);
    }

    public void advanceNum(View v) {
        num++;
        setText();
    }

    public void savePref(View v) {
        SharedPreferences out = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = out.edit();
        editor.putInt("numberToAdd", num);
        editor.commit();
    }
}
