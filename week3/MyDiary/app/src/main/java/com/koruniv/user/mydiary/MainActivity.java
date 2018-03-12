package com.koruniv.user.mydiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker;
    EditText editDiary;
    Button btnWrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("일기장");

        datePicker = (DatePicker) findViewById(R.id.dataPicker1);
        editDiary = (EditText) findViewById(R.id.editDiary);
        btnWrite = (Button) findViewById(R.id.btnWrite);

        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        // 저장할 파일이름
        fileName = Integer.toString(cYear) + "-"
                + Integer.toString(cMonth+1) + "-"
                + Integer.toString(cDay) + ".txt";

        String str = readDiary(fileName);
        editDiary.setText(str);


    }

    private String readDiary(String fileName) {

        return null;

    }



}
