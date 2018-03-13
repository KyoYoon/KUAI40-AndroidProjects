package com.koruniv.user.myfilelist1;

import android.Manifest;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActivityCompat.requestPermissions(this,
        //        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
        //        MODE_PRIVATE);

        Button btnFileList;
        final EditText editFileList;

        btnFileList = (Button) findViewById(R.id.btnFileList);
        editFileList = (EditText) findViewById(R.id.editFileList);

        btnFileList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sysDir = Environment.getRootDirectory().getAbsolutePath();

                File[] sysFiles = (new File(sysDir).listFiles());

                String strFname;

                for (int i=0; i < sysFiles.length; i++) {
                    if (sysFiles[i] .isDirectory() == true) {
                        strFname = "<폴더> "+sysFiles[i].toString();
                    } else {
                        strFname = "<파일> "+sysFiles[i].toString();
                    }

                    editFileList.setText(editFileList.getText() + "\n" + strFname);

                }

            }
        });



    }
}
