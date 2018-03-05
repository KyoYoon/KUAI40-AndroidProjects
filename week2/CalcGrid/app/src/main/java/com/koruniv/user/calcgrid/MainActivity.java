package com.koruniv.user.calcgrid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Integer result;
    Double result2;

    //10개의 숫자 버튼 배열을 사용한다.
    Button[] numButtons = new Button[10];

    //10개 숫자 버튼에 대한 id 값 배열을 만든다.
    Integer[] numBtnIDs = {
            R.id.BtnNum0,
            R.id.BtnNum1,
            R.id.BtnNum2,
            R.id.BtnNum3,
            R.id.BtnNum4,
            R.id.BtnNum5,
            R.id.BtnNum6,
            R.id.BtnNum7,
            R.id.BtnNum8,
            R.id.BtnNum9
    };

    //int i; // 증가값에 사용하기 위해서


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드 계산기");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSubtract);
        btnMul = (Button) findViewById(R.id.BtnMultiply);
        btnDiv = (Button) findViewById(R.id.BtnDivide);

        textResult = (TextView) findViewById(R.id.TextResult);

        btnAdd.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View arg0, MotionEvent arg1) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                textResult.setText("계산결과: "+result.toString());

                return false;

            }
        });

        btnSub.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View arg0, MotionEvent arg1) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                textResult.setText("계산결과: "+result.toString());

                return false;

            }
        });

        btnMul.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View arg0, MotionEvent arg1) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                textResult.setText("계산결과: "+result.toString());

                return false;

            }
        });

        btnDiv.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View arg0, MotionEvent arg1) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //result = Integer.parseInt(num1) / Integer.parseInt(num2);

                result2 = Double.parseDouble(num1) / Double.parseDouble(num2);
                textResult.setText("계산결과: "+result2.toString());

                return false;

            }
        });

        // 숫자버튼 10개를 연결한다.
        for (int i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        // 숫자버튼 10개에 대한 클릭이벤트를 설정한다.
        for (int i = 0; i < numBtnIDs.length; i++) {
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    // focus가 있는 에디트텍스트에 있는 숫자를 가리킨다.
                    if (edit1.isFocused() == true) {
                        if (edit1.getText().toString().equals("") && numButtons[index].getText().toString().equals("0")) {
                            Toast.makeText(getApplicationContext(), "숫자의 첫 자리로 0을 입력할 수 없습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                            edit1.setText(num1);
                        }


                    } else if (edit2.isFocused() == true) {

                        if (edit2.getText().toString().equals("") && numButtons[index].getText().toString().equals("0")) {
                            Toast.makeText(getApplicationContext(), "숫자의 첫 자리로 0을 입력할 수 없습니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                            edit2.setText(num2);
                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "먼저 숫자입력란을 선택하세요.", Toast.LENGTH_SHORT).show();
                    }
                }

            });
        }

    }
}
