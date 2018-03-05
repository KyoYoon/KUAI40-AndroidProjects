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
