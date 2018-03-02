# Week1

## 1. FourButton 앱
* 4개의 버튼을 배치한 후 버튼 클릭시 이벤트 실행
* 브라우저를 실행하여 특정 URL로 이동시키는 버튼, 안드로이드폰 내의 연락처 앱을 실행시키는 버튼, 안드로이드폰 내의 갤러리 앱을 실행시키는 버튼 및 앱 종료 버튼으로 구성됨

## 2. 주요 소스 코드

     * activity_main.xml

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.koruniv.user.fourbutton.MainActivity"
    android:orientation="vertical">

    <Button
        android:id="@+id/btnDaum"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#ff0000"
        android:text="다음 홈페이지 열기"/>

    <Button
        android:id="@+id/btn911"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#ff00ff"
        android:text="911 응급전화 걸기"/>

    <Button
        android:id="@+id/btnGal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#00ff00"
        android:text="갤러리 열기"/>

    <Button
        android:id="@+id/btnEnd"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#00ffff"
        android:text="끝내기"/>

    </LinearLayout>

---

    * MainActivity.java
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

## 3. 실행화면

* 초기 화면


![실행화면1](/week1/images/fourbutton1.jpg)


* 크롬 브라우저내에서 다음 웹사이트로 이동했을 때


![실행화면2](/week1/images/fourbutton2.jpg)


* 연락처(911 응급전화) 실행했을 때


![실행화면3](/week1/images/fourbutton3.jpg)


* 갤러리 열었을 때


![실행화면4](/week1/images/fourbutton4.jpg)


* 앱 종료 후


![실행화면5](/week1/images/fourbutton5.jpg)
