package com.koruniv.user.myfileraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead;
        final EditText editRaw;

        btnRead = (Button) findViewById(R.id.btnRead);
        editRaw = (EditText) findViewById(R.id.editRaw);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.rawtext);
                    byte[] txt = new byte[inputStream.available()]; // 파일의 사이즈만큼 크기를 정해서 바이트 배열 선언 (available() 함수 사용)
                    inputStream.read(txt);
                    editRaw.setText(new String(txt));
                    inputStream.close();

                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "파일읽기 실패...", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
