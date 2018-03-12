package com.koruniv.user.mydiary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

        // 저장할 파일이름 (오늘 저장된 파일)
        fileName = Integer.toString(cYear) + "-"
                + Integer.toString(cMonth+1) + "-"
                + Integer.toString(cDay) + ".txt";

        String str = readDiary(fileName);
        editDiary.setText(str);

        datePicker.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "-"
                        + Integer.toString(monthOfYear + 1) + "-"
                        + Integer.toString(dayOfMonth) + ".txt";

                String str = readDiary(fileName);
                editDiary.setText(str);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = editDiary.getText().toString();
                    outputStream.write(str.getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(),fileName+"이 저장되었음", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(),"파일을 쓰는 중 Error 가 발생함 - "+e.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private String readDiary(String fileName) {

        String diaryStr = null;
        FileInputStream fileInputStream;

        try {

            fileInputStream = openFileInput(fileName);
            byte[] txt = new byte[500];
            fileInputStream.read(txt);
            fileInputStream.close();
            diaryStr = (new String(txt).trim());
            btnWrite.setText("수정");

        } catch (IOException e) {
            editDiary.setHint("오늘 저장된 파일 없음");
            btnWrite.setText("새로 저장");
        }

        return diaryStr;

    }



}
