# Week2

## 1-1. Calculator 앱
* 사칙연산 및 나머지 연산 수행
* 숫자를 아예 입력하지 않았거나 분모가 0일 경우 나누기연산할 때 예외처리 수행

## 1-2. 주요 소스 코드

     * activity_main.xml

     <?xml version="1.0" encoding="utf-8"?>
     <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
         xmlns:app="http://schemas.android.com/apk/res-auto"
         xmlns:tools="http://schemas.android.com/tools"
         android:layout_width="match_parent"
         android:layout_height="match_parent"
         android:orientation="vertical"
         android:padding="20dp"
         tools:context="com.koruniv.user.calculator.MainActivity">

         <EditText
             android:id="@+id/editTxtNum1"
             android:layout_width="630dp"
             android:layout_height="wrap_content"
             android:layout_margin="0px"
             android:layout_weight="1"
             android:ems="10"
             android:hint="숫자를 입력하세요."
             android:inputType="number"
             android:textSize="14sp" />

         <EditText
             android:id="@+id/editTxtNum2"
             android:layout_width="630dp"
             android:layout_height="wrap_content"
             android:layout_margin="0px"
             android:layout_weight="1"
             android:ems="10"
             android:hint="숫자를 입력하세요."
             android:inputType="number"
             android:textSize="14sp" />

         <TextView
             android:id="@+id/textViewResult"
             android:layout_width="630dp"
             android:layout_height="wrap_content"
             android:layout_margin="5px"
             android:layout_weight="1"
             android:hint="계산결과 표시"
             android:textColor="@android:color/black"
             android:textSize="18sp" />

         <Button
             android:id="@+id/btnAdd"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:layout_weight="1"
             android:layout_margin="5px"
             android:background="#0000ff"
             android:text="더하기" />

         <Button
             android:id="@+id/btnSubtract"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:layout_weight="1"
             android:layout_margin="5px"
             android:background="#ffff00"
             android:text="빼기" />

         <Button
             android:id="@+id/btnMultiply"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:layout_weight="1"
             android:layout_margin="5px"
             android:background="#ff0000"
             android:text="곱하기" />

         <Button
             android:id="@+id/btnDivide"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:layout_weight="1"
             android:layout_margin="5px"
             android:background="#ff00ff"
             android:text="나누기" />

         <Button
             android:id="@+id/btnMod"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:layout_weight="1"
             android:layout_margin="5px"
             android:background="#00ff00"
             android:text="나머지" />

         <Button
             android:id="@+id/btnFinish"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:layout_weight="1"
             android:layout_margin="5px"
             android:background="#00ffff"
             android:text="종료" />


     </LinearLayout>

---

    * MainActivity.java
    package com.koruniv.user.calculator;

    import android.graphics.Color;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.app.Activity;
    import android.content.Intent;
    import android.net.Uri;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {

        EditText editTxtNum1,editTxtNum2;
        TextView textViewResult;
        Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnMod, btnFinish;

        String strNum1, strNum2;
        String strResult;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("계산기");

            // UI Control에 있는 EditText를 받아옴
            editTxtNum1 = (EditText) findViewById(R.id.editTxtNum1);
            editTxtNum2 = (EditText) findViewById(R.id.editTxtNum2);

            // UI Control에 있는 TextView를 받아옴
            textViewResult = (TextView) findViewById(R.id.textViewResult);

            // UI Control에 있는 button 을 받아옴
            btnAdd = (Button) findViewById(R.id.btnAdd);
            btnSubtract = (Button) findViewById(R.id.btnSubtract);
            btnMultiply = (Button) findViewById(R.id.btnMultiply);
            btnDivide = (Button) findViewById(R.id.btnDivide);
            btnMod = (Button) findViewById(R.id.btnMod);
            btnFinish = (Button) findViewById(R.id.btnFinish);

            // btnAdd 을 클릭했을 때 액션 정의
            btnAdd.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //editTxtNum1 = (EditText) findViewById(R.id.editTxtNum1);
                    //editTxtNum2 = (EditText) findViewById(R.id.editTxtNum2);

                    strNum1 = editTxtNum1.getText().toString();
                    strNum2 = editTxtNum2.getText().toString();

                    if (strNum1.trim().equals("") || strNum2.trim().equals("")) {
                        textViewResult.setText("");
                        Toast.makeText(getApplicationContext(),"입력값이 없음!",Toast.LENGTH_SHORT).show();
                    } else {
                        int num1 = Integer.parseInt(strNum1);
                        int num2 = Integer.parseInt(strNum2);

                        int result = num1 + num2;

                        strResult = String.valueOf(result);

                        textViewResult.setText(strNum1+" + "+strNum2+" = "+strResult);
                    }

                }
            });

            // btnSubtract 을 클릭했을 때 액션 정의
            btnSubtract.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    strNum1 = editTxtNum1.getText().toString();
                    strNum2 = editTxtNum2.getText().toString();

                    if (strNum1.trim().equals("") || strNum2.trim().equals("")) {
                        textViewResult.setText("");
                        Toast.makeText(getApplicationContext(),"입력값이 없음!",Toast.LENGTH_SHORT).show();
                    } else {
                        int num1 = Integer.parseInt(strNum1);
                        int num2 = Integer.parseInt(strNum2);

                        int result = num1 - num2;

                        strResult = String.valueOf(result);

                        textViewResult.setText(strNum1+" - "+strNum2+" = "+strResult);
                    }

                }
            });

            // btnMultiply 을 클릭했을 때 액션 정의
            btnMultiply.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    strNum1 = editTxtNum1.getText().toString();
                    strNum2 = editTxtNum2.getText().toString();

                    if (strNum1.trim().equals("") || strNum2.trim().equals("")) {
                        textViewResult.setText("");
                        Toast.makeText(getApplicationContext(),"입력값이 없음!",Toast.LENGTH_SHORT).show();
                    } else {
                        int num1 = Integer.parseInt(strNum1);
                        int num2 = Integer.parseInt(strNum2);

                        int result = num1 * num2;

                        strResult = String.valueOf(result);

                        textViewResult.setText(strNum1+" * "+strNum2+" = "+strResult);
                    }

                }
            });

            // btnDivide 을 클릭했을 때 액션 정의
            btnDivide.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    strNum1 = editTxtNum1.getText().toString();
                    strNum2 = editTxtNum2.getText().toString();

                    if (strNum1.trim().equals("") || strNum2.trim().equals("")) {
                        textViewResult.setText("");
                        Toast.makeText(getApplicationContext(),"입력값이 없음!",Toast.LENGTH_SHORT).show();
                    } else {

                        if (strNum2.trim().equals("0")) {
                            textViewResult.setText("");
                            Toast.makeText(getApplicationContext(),"0으로 나눌 수 없습니다!",Toast.LENGTH_SHORT).show();
                        } else {
                            double num1 = Double.parseDouble(strNum1);
                            double num2 = Double.parseDouble(strNum2);

                            double result = num1 / num2;
                            result = (int)(result * 10) / 10.0; // 소수점 한 자리까지만 표시

                            strResult = String.valueOf(result);

                            textViewResult.setText(strNum1+" / "+strNum2+" = "+strResult);
                        }

                    }

                }
            });

            // btnMod 을 클릭했을 때 액션 정의
            btnMod.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    strNum1 = editTxtNum1.getText().toString();
                    strNum2 = editTxtNum2.getText().toString();

                    if (strNum1.trim().equals("") || strNum2.trim().equals("")) {
                        textViewResult.setText("");
                        Toast.makeText(getApplicationContext(),"입력값이 없음!",Toast.LENGTH_SHORT).show();
                    } else {
                        int num1 = Integer.parseInt(strNum1);
                        int num2 = Integer.parseInt(strNum2);

                        int result = num1 % num2;

                        strResult = String.valueOf(result);

                        textViewResult.setText(strNum1+" % "+strNum2+" = "+strResult);
                    }

                }
            });

            // btnEnd 을 클릭했을 때 액션 정의
            btnFinish.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    finish();
                }
            });

        }
    }


## 1-3. 실행화면

* 초기 화면


![실행화면1](/week2/images/calculator1.jpg)


* 더하기 계산


![실행화면2](/week2/images/calculator2.jpg)


* 빼기 계산


![실행화면3](/week2/images/calculator3.jpg)


* 곱하기 계산


![실행화면4](/week2/images/calculator4.jpg)


* 나누기 계산


![실행화면5](/week2/images/calculator5.jpg)


* 나머지 계산


![실행화면6](/week2/images/calculator6.jpg)
