package com.koruniv.user.myfilesd1;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        Button btnRead;
        final EditText editSD;

        btnRead = (Button) findViewById(R.id.btnRead);
        editSD = (EditText) findViewById(R.id.editSD);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream fileInputStream = new FileInputStream("/storage/emulated/0/rawtext.txt");
                    byte[] txt = new byte[fileInputStream.available()];
                    fileInputStream.read(txt);
                    editSD.setText(new String(txt));
                    fileInputStream.close();

                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "SD카드에서 읽어들이기 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
