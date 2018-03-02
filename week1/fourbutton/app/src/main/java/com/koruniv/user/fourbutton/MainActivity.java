package com.koruniv.user.fourbutton;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Button instance를 받아올 변수 선언
    Button btnDaum, btn911, btnGal, btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI Control에 있는 버튼을 받아옴
        btnDaum = (Button) findViewById(R.id.btnDaum);
        btn911 = (Button) findViewById(R.id.btn911);
        btnGal = (Button) findViewById(R.id.btnGal);
        btnEnd = (Button) findViewById(R.id.btnEnd);

        // 사용자 컬러 지정 (버튼)
        btnDaum.setBackgroundColor(Color.GRAY);
        btn911.setBackgroundColor(Color.GREEN);
        btnGal.setBackgroundColor(Color.BLUE);
        btnEnd.setBackgroundColor(Color.YELLOW);

        // btnDaum 을 클릭했을 때 액션 정의
        btnDaum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.daum.net"));
                startActivity(mIntent);
            }
        });

        // btn911 을 클릭했을 때 액션 정의
        btn911.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/911"));
                startActivity(mIntent);
            }
        });

        // btnGal 을 클릭했을 때 액션 정의
        btnGal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(mIntent);
            }
        });

        // btnEnd 을 클릭했을 때 액션 정의
        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });


    }




}
