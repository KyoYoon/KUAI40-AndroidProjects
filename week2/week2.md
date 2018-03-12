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


## 2-1. MyPet 앱
* 동물 이미지 보여주기 앱
* 체크박스를 체크하면 질문이 나오고 좋아하는 동물이 써있는 라디오버튼을 선택하고 선택 버튼을 클릭하면 해당 이미지를 보여준다.

## 2-2. 주요 소스 코드

     * activity_main.xml
     <?xml version="1.0" encoding="utf-8"?>
      <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:padding="20dp"
        tools:context="com.koruniv.user.mypet.MainActivity">

     <TextView
         android:id="@+id/TextView1"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="선택을 하시겠습니까?"
         android:textSize="20dp"/>

     <CheckBox
         android:id="@+id/ChkAgree"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="시작합니다." />

     <TextView
         android:id="@+id/TextView2"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="좋아하는 애완동물은? "
         android:textSize="20dp"
         android:visibility="invisible" />

     <RadioGroup
         android:id="@+id/RadioGroup1"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:visibility="invisible">

         <RadioButton
             android:id="@+id/RadioDog"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="강아지"/>

         <RadioButton
             android:id="@+id/RadioCat"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="고양이"/>

         <RadioButton
             android:id="@+id/RadioRabbit"
             android:layout_width="wrap_content"
             android:layout_height="wrap_content"
             android:text="토끼"/>

     </RadioGroup>

     <Button
         android:id="@+id/btnOK"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:text="선택완료"
         android:visibility="invisible"/>

     <ImageView
         android:id="@+id/imgPet"
         android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:visibility="invisible"/>


    </LinearLayout>


---

    * MainActivity.java
    package com.koruniv.user.mypet;

    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.CompoundButton;
    import android.widget.ImageView;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.TextView;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        TextView textView1, textView2;
        CheckBox chkAgree;
        RadioGroup radioGroup;
        RadioButton radioDog, radioCat, radioRabbit;
        Button btnOK;
        ImageView imgPet;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("내가 좋아하는 동물은?");

            // 위젯을 변수에 대입
            textView1 = (TextView) findViewById(R.id.TextView1);
            chkAgree = (CheckBox) findViewById(R.id.ChkAgree);

            textView2 = (TextView) findViewById(R.id.TextView2);
            radioGroup = (RadioGroup) findViewById(R.id.RadioGroup1);
            radioDog = (RadioButton) findViewById(R.id.RadioDog);
            radioCat = (RadioButton) findViewById(R.id.RadioCat);
            radioRabbit = (RadioButton) findViewById(R.id.RadioRabbit);

            btnOK = (Button) findViewById(R.id.btnOK);
            imgPet = (ImageView) findViewById(R.id.imgPet);

            // 시작합니다. 체크박스가 변경이 되면 적용할 로직을 기술
            chkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                    // 체크가 되면 모두 보이도록 설정한다.
                    if (chkAgree.isChecked() == true) {
                        textView2.setVisibility(android.view.View.VISIBLE);
                        radioGroup.setVisibility(android.view.View.VISIBLE);
                        btnOK.setVisibility(android.view.View.VISIBLE);
                        imgPet.setVisibility(android.view.View.VISIBLE);
                    } else {
                        textView2.setVisibility(android.view.View.INVISIBLE);
                        radioGroup.setVisibility(android.view.View.INVISIBLE);
                        btnOK.setVisibility(android.view.View.INVISIBLE);
                        imgPet.setVisibility(android.view.View.INVISIBLE);
                    }

                }
            });

            // 선택완료 버튼을 클릭시 이미지뷰에 이미지가 나오게 한다.
            btnOK.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    switch (radioGroup.getCheckedRadioButtonId()) {
                        case R.id.RadioDog:
                            imgPet.setImageResource(R.drawable.dog);
                            break;
                        case R.id.RadioCat:
                            imgPet.setImageResource(R.drawable.cat);
                            break;
                        case R.id.RadioRabbit:
                            imgPet.setImageResource(R.drawable.rabbit);
                            break;
                        default:
                            Toast.makeText(getApplicationContext(), "좋아하는 동물을 선택하여 주세요.", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });


        }
    }


## 2-3. 실행화면

* 초기 화면


![실행화면1](/week2/images/mypet1.jpg)


* 체크박스 체크했을 때


![실행화면2](/week2/images/mypet2.jpg)


* 강아지 선택하고 선택완료 버튼 눌렀을 때


![실행화면3](/week2/images/mypet3.jpg)

## 3-1. ShowAndroidVersion 앱
* 안드로이드 버전 이미지 보여주기 앱
* 스위치를 켜면 안드로이드 버전명이 담긴 라디오버튼들이 나오고 라디오버튼을 선택하자마자 이미지 나오는 앱
* Restart를 누르면 앱 처음 실행된 상태로 초기화되고 Finish를 누르면 앱이 종료됨
* 스크롤뷰를 붙여서 화면이 아래로 밀릴 경우 자동으로 스크롤바가 생김

## 3-2. 주요 소스 코드

    * activity_main.xml
    <?xml version="1.0" encoding="utf-8"?>
    <ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_height="fill_parent"
        android:layout_width="fill_parent" >
        <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
            xmlns:app="http://schemas.android.com/apk/res-auto"
            xmlns:tools="http://schemas.android.com/tools"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent"
            android:orientation="vertical"
            android:paddingRight="5px"
            tools:context="com.koruniv.user.showandroidversion.MainActivity">

            <TextView
                android:id="@+id/TextView1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="선택을 하시겠습니까?"
                android:textAlignment="center"
                android:textSize="20dp" />

            <Switch
                android:id="@+id/SwitchStart"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical|center_horizontal"
                android:checked="false"
                android:text="시작"
                android:textAlignment="center"
                android:textSize="20dp" />

            <TextView
                android:id="@+id/TextView2"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="좋아하는 안드로이드 버전은? "
                android:textAlignment="center"
                android:textSize="20dp"
                android:visibility="invisible" />

            <RadioGroup
                android:id="@+id/RadioGroup1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginLeft="95dp"
                android:visibility="invisible">

                <RadioButton
                    android:id="@+id/RadioAndroid50"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="안드로이드 5.0 롤리팝" />

                <RadioButton
                    android:id="@+id/RadioAndroid60"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="안드로이드 6.0 마시멜로우" />

                <RadioButton
                    android:id="@+id/RadioAndroid70"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="안드로이드 7.0 누가" />

            </RadioGroup>

    <!--        <Button
                android:id="@+id/BtnSelect"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical|center_horizontal"
                android:text="선택"
                android:visibility="invisible" />-->

            <ImageView
                android:id="@+id/ImgAndroid"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:scaleType="fitCenter"
                android:visibility="invisible" />



            <Button
                android:id="@+id/BtnRestart"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical|center_horizontal"
                android:text="Restart"
                android:visibility="invisible" />

            <Button
                android:id="@+id/BtnFinish"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center_vertical|center_horizontal"
                android:text="Finish"
                android:visibility="invisible" />



        </LinearLayout>
    </ScrollView>

---

    * MainActivity.java
    package com.koruniv.user.showandroidversion;

    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.CompoundButton;
    import android.widget.ImageView;
    import android.widget.RadioButton;
    import android.widget.RadioGroup;
    import android.widget.Switch;
    import android.widget.TextView;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        TextView textView1, textView2;
        Switch switchStart;
        RadioGroup radioGroup1;
        RadioButton radioAndroid50, radioAndroid60, radioAndroid70;
        ImageView imgAndroid;
        //Button btnSelect;
        Button btnRestart, btnFinish;

        RadioButton[] radioButtons = new RadioButton[3]; // 라디오버튼 인스턴스를 담을 배열 선언

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("안드로이드 버전 이미지 보여주기");

            // 위젯을 변수에 대입
            textView1 = (TextView) findViewById(R.id.TextView1);
            switchStart = (Switch) findViewById(R.id.SwitchStart);

            textView2 = (TextView) findViewById(R.id.TextView2);
            radioGroup1 = (RadioGroup) findViewById(R.id.RadioGroup1);
            //radioAndroid50 = (RadioButton) findViewById(R.id.RadioAndroid50);
            //radioAndroid60 = (RadioButton) findViewById(R.id.RadioAndroid60);
            //radioAndroid70 = (RadioButton) findViewById(R.id.RadioAndroid70);

            radioButtons[0] = (RadioButton) findViewById(R.id.RadioAndroid50);
            radioButtons[1] = (RadioButton) findViewById(R.id.RadioAndroid60);
            radioButtons[2] = (RadioButton) findViewById(R.id.RadioAndroid70);

            //btnSelect = (Button) findViewById(R.id.BtnSelect);

            imgAndroid = (ImageView) findViewById(R.id.ImgAndroid);

            btnRestart = (Button) findViewById(R.id.BtnRestart);
            btnFinish = (Button) findViewById(R.id.BtnFinish);

            // 스위치를 켜거나 껐을 경우 발생하는 동작 정의
            switchStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    // 체크가 되면 모두 보이도록 설정한다.
                    if (switchStart.isChecked() == true) {
                        textView2.setVisibility(android.view.View.VISIBLE);
                        radioGroup1.setVisibility(android.view.View.VISIBLE);
                        //btnSelect.setVisibility(android.view.View.VISIBLE);
                        imgAndroid.setVisibility(android.view.View.VISIBLE);
                        btnRestart.setVisibility(android.view.View.VISIBLE);
                        btnFinish.setVisibility(android.view.View.VISIBLE);
                    } else {
                        textView2.setVisibility(android.view.View.INVISIBLE);
                        radioGroup1.setVisibility(android.view.View.INVISIBLE);
                        //btnSelect.setVisibility(android.view.View.INVISIBLE);
                        imgAndroid.setVisibility(android.view.View.INVISIBLE);
                        btnRestart.setVisibility(android.view.View.INVISIBLE);
                        btnFinish.setVisibility(android.view.View.INVISIBLE);
                    }
                }
            });

    /*        // 선택완료 버튼을 클릭시 이미지뷰에 이미지가 나오게 한다.
            btnSelect.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    switch (radioGroup1.getCheckedRadioButtonId()) {
                        case R.id.RadioAndroid50:
                            imgAndroid.setImageResource(R.drawable.android50);
                            break;
                        case R.id.RadioAndroid60:
                            imgAndroid.setImageResource(R.drawable.android60);
                            break;
                        case R.id.RadioAndroid70:
                            imgAndroid.setImageResource(R.drawable.android70);
                            break;
                        default:
                            Toast.makeText(getApplicationContext(), "좋아하는 안드로이드 버전을 선택하여 주세요.", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });*/



            // 라디오 버튼 클릭시 해당하는 이미지이름을 배열로 저장한다.
            final int draw[] = {R.drawable.android50, R.drawable.android60, R.drawable.android70};

            // 라디오 버튼을 클릭할 때 해당하는 이미지를 가져온다.
            for (int i=0; i<radioButtons.length; i++) {

                final int index;
                index = i;

                radioButtons[index].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgAndroid.setImageResource(draw[index]);
                    }
                });

            }

            btnRestart.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    switchStart.setChecked(false);
                    textView2.setVisibility(android.view.View.INVISIBLE);
                    radioGroup1.setVisibility(android.view.View.INVISIBLE);
                    //btnSelect.setVisibility(android.view.View.INVISIBLE);
                    imgAndroid.setVisibility(android.view.View.INVISIBLE);
                    btnRestart.setVisibility(android.view.View.INVISIBLE);
                    btnFinish.setVisibility(android.view.View.INVISIBLE);

                    radioGroup1.clearCheck(); // 라디오 버튼에서 선택한 것 초기화
                    imgAndroid.setImageResource(android.R.color.transparent); // 이미지뷰에 있던 이미지 초기화

                }
            });

            btnFinish.setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    finish();
                }
            });

        }
    }


## 3-3. 실행화면

* 초기 화면


![실행화면1](/week2/images/showandroidversion1.jpg)


* 스위치를 켰을 때


![실행화면2](/week2/images/showandroidversion2.jpg)


* 안드로이드 버전 체크박스를 체크했을 때


![실행화면3](/week2/images/showandroidversion3.jpg)

![실행화면4](/week2/images/showandroidversion4.jpg)


* Restart를 눌렀을 때


![실행화면5](/week2/images/showandroidversion5.jpg)

![실행화면6](/week2/images/showandroidversion6.jpg)



## 4-1. MySchedule1 앱
* CalendarView 와 TimePicker 를 활용하여 날짜예약을 하는 앱
* 날짜예약하는 데 걸린 시간을 계산하기 위해 예약시작 버튼을 누르면 타이머가 작동하고 사용자가 캘린더에서 년월일을 예약하고 몇시몇분인지 예약을 하고 예약완료 버튼을 누르면 예약한 년월일시분을 보여주면서 타이머가 중지되면서 그 사이의 시간을 보여줌

## 4-2. 주요 소스 코드

    * activity_main.xml
    <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.koruniv.user.myschedule1.MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <Chronometer
            android:id="@+id/chronometer1"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:format="예약에 걸린 시간 : %s"
            android:gravity="center"
            android:textSize="20dp"/>

        <Button
            android:id="@+id/btnStart"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="예약시작"/>

    </LinearLayout>

    <RadioGroup
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <RadioButton
            android:id="@+id/rdoCal"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="날짜 설정"/>

        <RadioButton
            android:id="@+id/rdoTime"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="시간 설정"/>

    </RadioGroup>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1">

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center">
            <CalendarView
                android:id="@+id/calendarView1"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:showWeekNumber="false"/>

            <TimePicker
                android:id="@+id/timePicker"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:timePickerMode="spinner"/>

        </FrameLayout>


    </LinearLayout>


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#BBBBBB">

        <Button
            android:id="@+id/btnEnd"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="예약완료"/>
        <TextView
            android:id="@+id/tvYear"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="0000"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="년"/>
        <TextView
            android:id="@+id/tvMonth"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="00"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="월"/>
        <TextView
            android:id="@+id/tvDay"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="00"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="일"/>
        <TextView
            android:id="@+id/tvHour"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="00"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="시"/>
        <TextView
            android:id="@+id/tvMinute"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="00"/>
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="분 예약"/>


    </LinearLayout>

</LinearLayout>

---

    * MainActivity.java
    package com.koruniv.user.myschedule1;

    import android.graphics.Color;
    import android.os.SystemClock;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.CalendarView;
    import android.widget.Chronometer;
    import android.widget.RadioButton;
    import android.widget.TextView;
    import android.widget.TimePicker;
    import android.widget.Toast;

    import java.util.Calendar;

    public class MainActivity extends AppCompatActivity {

      Chronometer chronometer;
      Button btnStart, btnEnd;
      RadioButton rdoCal, rdoTime;

      CalendarView calView;
      TimePicker tPicker;
      TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

      String strYear, strMonth, strDay;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);

          setTitle("시간 예약");

          // 버튼
          btnStart = (Button) findViewById(R.id.btnStart);
          btnEnd = (Button) findViewById(R.id.btnEnd);

          // 크로노미터
          chronometer = (Chronometer) findViewById(R.id.chronometer1);

          // 라디오 버튼
          rdoCal = (RadioButton) findViewById(R.id.rdoCal);
          rdoTime = (RadioButton) findViewById(R.id.rdoTime);

          // FrameLayout 에 있는 2개의 위젯
          tPicker = (TimePicker) findViewById(R.id.timePicker);
          calView = (CalendarView) findViewById(R.id.calendarView1);

          // 텍스트뷰 (년도, 월, 일, 시, 분)
          tvYear = (TextView) findViewById(R.id.tvYear);
          tvMonth = (TextView) findViewById(R.id.tvMonth);
          tvDay = (TextView) findViewById(R.id.tvDay);
          tvHour = (TextView) findViewById(R.id.tvHour);
          tvMinute = (TextView) findViewById(R.id.tvMinute);

          //tPicker와 calView는 안 보이게 설정
          tPicker.setVisibility(View.INVISIBLE);
          calView.setVisibility(View.INVISIBLE);

          rdoCal.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  tPicker.setVisibility(View.INVISIBLE);
                  calView.setVisibility(View.VISIBLE);
              }
          });

          rdoTime.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  tPicker.setVisibility(View.VISIBLE);
                  calView.setVisibility(View.INVISIBLE);
              }
          });

          // Timer 시작
          btnStart.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  chronometer.setBase(SystemClock.elapsedRealtime());
                  chronometer.start();
                  chronometer.setTextColor(Color.RED);

              }
          });

          // 년월일을 선택할 때마다 호출되는 메소드로써 사용자 선택한 년, 월, 일을 매개변수로 받는다.
          calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
              public void onSelectedDayChange(CalendarView view, int year,
                                              int month, int dayOfMonth) {
                  Toast.makeText(MainActivity.this, "" + year + "/" +
                          (month + 1) + "/" + dayOfMonth, 0).show();

                  strYear = Integer.toString(year);
                  strMonth = Integer.toString(month+1);
                  strDay = Integer.toString(dayOfMonth);

              }
          });

          // Timer 중지 - 예약완료 버튼이 눌렸을 경우
          btnEnd.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  chronometer.stop();
                  chronometer.setTextColor(Color.BLUE);

                  //java.util.Calendar curDate = java.util.Calendar.getInstance();
                  //curDate.setTimeInMillis(calView.getDate());



                  tvYear.setText(strYear);
                  tvMonth.setText(strMonth);
                  tvDay.setText(strDay);
                  tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                  tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
              }
          });

      }
    }


## 4-3. 실행화면

* 초기 화면


![실행화면1](/week2/images/myschedule1_1.jpg)


* 예약시작 버튼 눌렀을 때


![실행화면2](/week2/images/myschedule1_2.jpg)


* 날짜 설정 체크하고 캘린더에서 년월일을 선택


![실행화면3](/week2/images/myschedule1_3.jpg)


* 시간 설정 체크하고 캘린더에서 오전 혹은 오후, 시간, 분을 선택


![실행화면4](/week2/images/myschedule1_4.jpg)


* 예약완료 버튼을 눌렀을 때


![실행화면5](/week2/images/myschedule1_5.jpg)


## 5-1. MySchedule2 앱
* DatePicker 와 TimePicker 를 활용하여 날짜예약을 하는 앱
* 날짜예약하는 데 걸린 시간을 계산하기 위해 예약시작 버튼을 누르면 타이머가 작동하고 사용자가 캘린더에서 년월일을 예약하고 몇시몇분인지 예약을 하고 예약완료 버튼을 누르면 예약한 년월일시분을 보여주면서 타이머가 중지되면서 그 사이의 시간을 보여줌

## 5-2. 주요 소스 코드

    * activity_main.xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context="com.koruniv.user.myschedule1.MainActivity">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <Chronometer
                android:id="@+id/chronometer1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:format="예약에 걸린 시간 : %s"
                android:gravity="center"
                android:textSize="20dp"/>

            <Button
                android:id="@+id/btnStart"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="예약시작"/>

        </LinearLayout>

        <RadioGroup
            android:layout_width="wrap_content"
            android:layout_height="wrap_content">

            <RadioButton
                android:id="@+id/rdoCal"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="날짜 설정"/>

            <RadioButton
                android:id="@+id/rdoTime"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="시간 설정"/>

        </RadioGroup>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1">

            <FrameLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:gravity="center">

                <!--<CalendarView
                    android:id="@+id/calendarView1"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:showWeekNumber="false"/>-->

                <DatePicker
                    android:id="@+id/datePicker1"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:datePickerMode="spinner"
                    android:gravity="center" />

                <TimePicker
                    android:id="@+id/timePicker"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:timePickerMode="spinner"/>

            </FrameLayout>


        </LinearLayout>


        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="#BBBBBB">

            <Button
                android:id="@+id/btnEnd"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="예약완료"/>
            <TextView
                android:id="@+id/tvYear"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="0000"/>
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="년"/>
            <TextView
                android:id="@+id/tvMonth"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="00"/>
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="월"/>
            <TextView
                android:id="@+id/tvDay"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="00"/>
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="일"/>
            <TextView
                android:id="@+id/tvHour"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="00"/>
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="시"/>
            <TextView
                android:id="@+id/tvMinute"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="00"/>
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="분 예약"/>


        </LinearLayout>

    </LinearLayout>

---

    * MainActivity.java
    package com.koruniv.user.myschedule2;

    import android.graphics.Color;
    import android.os.SystemClock;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.CalendarView;
    import android.widget.Chronometer;
    import android.widget.DatePicker;
    import android.widget.RadioButton;
    import android.widget.TextView;
    import android.widget.TimePicker;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {

        Chronometer chronometer;
        Button btnStart, btnEnd;
        RadioButton rdoCal, rdoTime;

        CalendarView calView;
        DatePicker dPicker;
        TimePicker tPicker;
        TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

        String strYear, strMonth, strDay;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            setTitle("시간 예약 2");

            // 버튼
            btnStart = (Button) findViewById(R.id.btnStart);
            btnEnd = (Button) findViewById(R.id.btnEnd);

            // 크로노미터
            chronometer = (Chronometer) findViewById(R.id.chronometer1);

            // 라디오 버튼
            rdoCal = (RadioButton) findViewById(R.id.rdoCal);
            rdoTime = (RadioButton) findViewById(R.id.rdoTime);

            // FrameLayout 에 있는 2개의 위젯
            tPicker = (TimePicker) findViewById(R.id.timePicker);
            dPicker = (DatePicker) findViewById(R.id.datePicker1);
            //calView = (CalendarView) findViewById(R.id.calendarView1);

            // 텍스트뷰 (년도, 월, 일, 시, 분)
            tvYear = (TextView) findViewById(R.id.tvYear);
            tvMonth = (TextView) findViewById(R.id.tvMonth);
            tvDay = (TextView) findViewById(R.id.tvDay);
            tvHour = (TextView) findViewById(R.id.tvHour);
            tvMinute = (TextView) findViewById(R.id.tvMinute);

            //tPicker와 calView는 안 보이게 설정
            tPicker.setVisibility(View.INVISIBLE);
            dPicker.setVisibility(View.INVISIBLE);
            //calView.setVisibility(View.INVISIBLE);

            rdoCal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tPicker.setVisibility(View.INVISIBLE);
                    dPicker.setVisibility(View.VISIBLE);
                    //calView.setVisibility(View.VISIBLE);
                }
            });

            rdoTime.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tPicker.setVisibility(View.VISIBLE);
                    dPicker.setVisibility(View.INVISIBLE);
                    //calView.setVisibility(View.INVISIBLE);
                }
            });

            // Timer 시작
            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                    chronometer.setTextColor(Color.RED);

                }
            });


            /*calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                public void onSelectedDayChange(CalendarView view, int year,
                                                int month, int dayOfMonth) {
                    Toast.makeText(MainActivity.this, "" + year + "/" +
                            (month + 1) + "/" + dayOfMonth, 0).show();

                    strYear = Integer.toString(year);
                    strMonth = Integer.toString(month+1);
                    strDay = Integer.toString(dayOfMonth);

                }
            });*/

            // Timer 중지 - 예약완료 버튼이 눌렸을 경우
            btnEnd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chronometer.stop();
                    chronometer.setTextColor(Color.BLUE);

                    //java.util.Calendar curDate = java.util.Calendar.getInstance();
                    //curDate.setTimeInMillis(calView.getDate());



                    //tvYear.setText(strYear);
                    //tvMonth.setText(strMonth);
                    //tvDay.setText(strDay);
                    tvYear.setText(Integer.toString(dPicker.getYear()));
                    tvMonth.setText(Integer.toString(1+dPicker.getMonth()));
                    tvDay.setText(Integer.toString(dPicker.getDayOfMonth()));
                    tvHour.setText(Integer.toString(tPicker.getCurrentHour()));
                    tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));
                }
            });

        }
    }


## 5-3. 실행화면

* 초기 화면


![실행화면1](/week2/images/myschedule2_1.jpg)


* 예약시작 버튼 눌렀을 때


![실행화면2](/week2/images/myschedule2_2.jpg)


* 날짜 설정 체크하고 캘린더에서 년월일을 선택


![실행화면3](/week2/images/myschedule2_3.jpg)


* 시간 설정 체크하고 캘린더에서 오전 혹은 오후, 시간, 분을 선택


![실행화면4](/week2/images/myschedule2_4.jpg)


* 예약완료 버튼을 눌렀을 때


![실행화면5](/week2/images/myschedule2_5.jpg)


##6-0. PHP 기반 아파치 서버 시작 및 DB 상태 확인
* PHP 아파치 서버를 다운로드받아서 설치 후 설정 및 준비작업을 완료한다. 자세한 사항은 README.md 파일에 있는 [Apache, PHP 서버 설치 및 MySQL 연동준비](/sqlprojects/sqlprojects.md) 문서를 참고한다.
* 모든 준비가 완료되면 명령 프롬프트를 관리자 권한으로 실행한다.
![실행화면1](/week2/images/mysqlconnect0_1.jpg)

* 콘솔창에서 httpd -k stop 을 실행하여 기존 서버를 정지시키고 httpd -k start 를 눌러 실행한 후 서비스 상태(Apache 2.4)를 확인한다.
![실행화면2](/week2/images/mysqlconnect0_2.jpg)
![실행화면3](/week2/images/mysqlconnect0_3.jpg)
* MySQL 서버가 동작하고 있는지 보기 위해 작업관리자를 열어서 process 탭에서 mysqld 를 확인한다.
![실행화면4](/week2/images/mysqlconnect0_4.jpg)

* MySQL 서버에 접속하여 testdb라는 데이터베이스를 만들고 제대로 만들어졌는지 확인한다. 접속 ID가 root 이고 비밀번호가 1234이므로 mysql -u root -p1234 를 실행하여 접속 후 testdb 라는 데이터베이스를 만들고 show databases 라는 명령어를 통해 생성되었는지 확인한다.
![실행화면5](/week2/images/mysqlconnect0_5.jpg)

## 6-1. MySqlConnect 앱 (레코드 삽입)
* 이름 및 주소를 입력받아 testdb 안의 Person 이라는 테이블에 레코드로 삽입하는 앱
* 앱을 구동하기 전 Person이라는 테이블을 testdb라는 데이터베이스 내에 생성해야 한다. 아래처럼 코드를 작성하여 실행한다.
  - Person.sql

    create table Person (
    id bigint(20) unsigned not null auto_increment,
    name varchar(255) not null,
    address varchar(255) not null,
    primary key (id)
    ) charset=utf8;

* insert 쿼리를 수행하기 위해 insert.php라는 파일을 C:\ApacheServer\Apache24\htdocs 아래에 생성 후 아래와 같이 코드를 작성한다.
  - insert.php

---
    <?php
    error_reporting(E_ALL);
    ini_set('display_errors', 1);

    //데이터베이스에 연결시도후 실패하면 프로그램 종료
    $link = mysqli_connect("localhost", "root", "1234", "testdb");
    if(!$link) {
    echo "MySQL Connect Error....";
    echo mysqli_connect_error();
      exit();
    }

    mysqli_set_charset($link, "utf8");

    //POST 값을 읽어들인다.
    $name = isset($_POST['name']) ? $_POST['name'] : '';
    $address = isset($_POST['address']) ? $_POST['address'] : '';

    //각 컬럼에 데이터가 있는 경우만 테이블에 등록한다.
    if($name != '' and $address != '') {
    $sql = "insert into Person(name, address) values('$name', '$address')";
    $result = mysqli_query($link, $sql);

    if($result) {
      echo "데이터 입력 성공";
    } else {
      echo "데이터 입력 오류";
      echo mysqli_error($link);
    }
    } else {
    echo "데이터를 입력하십시요.";
    }

    mysqli_close($link);
    ?>

    <?php
    //휴대폰으로 접속하지 않은 경우
    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

    if(!$android) {
    ?>

      <html>
      <body>
        <form action="<?php $_PHP_SELF ?>" method="post">
          Name : <input type="text" name="name" />
          Address : <input type="text" name="address" />
          <input type="submit">
        </form>
      </body>
      </html>

    <?php
    }
    ?>
---




## 6-2. 주요 소스 코드

    * AndroidManifest.xml
    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.koruniv.user.mysqlconnect">

        <!-- 권한 획득을 위해 아래 코드 한 줄을 필수로 삽입 -->
        <uses-permission android:name="android.permission.INTERNET" />

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity android:name=".MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>

    * activity_main.xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context="com.koruniv.user.mysqlconnect.MainActivity">

        <TextView
            android:id="@+id/textView_main_name"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="이름: "/>

        <EditText
            android:id="@+id/editText_main_name"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <TextView
            android:id="@+id/textView_main_address"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="주소: "/>

        <EditText
            android:id="@+id/editText_main_address"
            android:layout_width="match_parent"
            android:layout_height="wrap_content" />

        <Button
            android:id="@+id/button_main_insert"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="입력"/>

        <TextView
            android:id="@+id/textView_main_result"
            android:layout_width="match_parent"
            android:layout_height="250dp"
            android:text="전송결과: "/>

    </LinearLayout>


---

    * MainActivity.java
    package com.koruniv.user.mysqlconnect;

    import android.app.ProgressDialog;
    import android.os.AsyncTask;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;

    import java.io.BufferedReader;
    import java.io.InputStream;
    import java.io.InputStreamReader;
    import java.io.OutputStream;
    import java.net.HttpURLConnection;
    import java.net.URL;

    public class MainActivity extends AppCompatActivity {

        private static String TAG = "phptest_MainActivity";

        EditText mEditTextName, mEditTextAddress;
        Button buttonInsert;
        TextView mTextViewResult;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            mEditTextName = (EditText) findViewById(R.id.editText_main_name);
            mEditTextAddress = (EditText) findViewById(R.id.editText_main_address);
            mTextViewResult = (TextView) findViewById(R.id.textView_main_result);

            buttonInsert = (Button) findViewById(R.id.button_main_insert);

            buttonInsert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String name = mEditTextName.getText().toString();
                    String address = mEditTextAddress.getText().toString();

                    InsertData task = new InsertData();
                    task.execute(name,address);

                    mEditTextName.setText("");
                    mEditTextAddress.setText("");

                }
            });

        }

        class InsertData extends AsyncTask<String, Void, String> {

            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressDialog = ProgressDialog.show(MainActivity.this,
                        "Please Wait", null, true, true);
            }


            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                progressDialog.dismiss();
                mTextViewResult.setText(result);
                Log.d(TAG, "POST response  - " + result);
            }


            @Override
            protected String doInBackground(String... params) {

                String name = (String)params[0];
                String address = (String)params[1];

                String serverURL = "http://192.168.0.26/insert.php"; // 본인 아이피로 해야만 들어감.. ipconfig로 확인
                String postParameters = "name=" + name + "&address=" + address;


                try {

                    URL url = new URL(serverURL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestMethod("POST");
                    //httpURLConnection.setRequestProperty("content-type", "application/json");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.connect();


                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(postParameters.getBytes("UTF-8"));
                    outputStream.flush();
                    outputStream.close();


                    int responseStatusCode = httpURLConnection.getResponseCode();
                    Log.d(TAG, "POST response code - " + responseStatusCode);

                    InputStream inputStream;
                    if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                        inputStream = httpURLConnection.getInputStream();
                    }
                    else{
                        inputStream = httpURLConnection.getErrorStream();
                    }


                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    while((line = bufferedReader.readLine()) != null){
                        sb.append(line);
                    }


                    bufferedReader.close();


                    return sb.toString();


                } catch (Exception e) {

                    Log.d(TAG, "InsertData: Error ", e);

                    return new String("Error: " + e.getMessage());
                }

            }

        }
    }



## 6-3. 실행화면

* 초기 화면


![실행화면1](/week2/images/mysqlconnect1_1.jpg)


* 글자 입력 후 전송 버튼 눌렀을 때


![실행화면2](/week2/images/mysqlconnect1_2.jpg)
![실행화면3](/week2/images/mysqlconnect1_3.jpg)


* DB에서 삽입이 되었는지 확인


![실행화면4](/week2/images/mysqlconnect1_4.jpg)


## 7-1. MySqlConnect2 앱 (리스트 보여주기)
* 앱을 구동하면 Person 이라는 테이블에 저장된 레코드들을 리스트 형태로 보여준다.
* 앱을 구동하기 전 Person이라는 테이블을 testdb라는 데이터베이스 내에 생성해야 한다. 아래처럼 코드를 작성하여 실행한다.
  - Person.sql

    create table Person (
    id bigint(20) unsigned not null auto_increment,
    name varchar(255) not null,
    address varchar(255) not null,
    primary key (id)
    ) charset=utf8;

* select 쿼리를 수행하여 리스트 데이터를 json형태로 받아오기 위해 getjson.php라는 파일을 C:\ApacheServer\Apache24\htdocs 아래에 생성 후 아래와 같이 코드를 작성한다.
  - getjson.php

---
    <?php
    // getjson.php
    $link = mysqli_connect("localhost", "root", "1234", "testdb");

    if (!link) {
      echo "MYSQL 접속 에러 : ";
      echo mysqli_connect_error();
      exit();
    }

    mysqli_set_charset($link, "utf8");

    $sql = "select * from Person";

    $result = mysqli_query($link, $sql);
    $data = array();
    if ($result) {

      while ($row = mysqli_fetch_array($result)) {
        array_push($data,
            array('id'=>$row[0],
            'name'=>$row[1],
            'address'=>$row[2]
            ));
      }

      //echo "<pre>";
      //print_r($data);
      //echo "</pre>";

      // 출력형식을 JSON으로 변환
      header('Content-Type: application/json; charset=utf8');
      $json = json_encode(array("webnautes"=>$data), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
      echo  $json;


    } else {
      echo "SQL문 처리 중 에러발생";
      echo mysqli_error($link);
    }

    mysqli_close($link);

    ?>
---




## 7-2. 주요 소스 코드

    * AndroidManifest.xml
    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.koruniv.user.mysqlconnect">

        <!-- 권한 획득을 위해 아래 코드 한 줄을 필수로 삽입 -->
        <uses-permission android:name="android.permission.INTERNET" />

        <application
            android:allowBackup="true"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/AppTheme">
            <activity android:name=".MainActivity">
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />

                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>
        </application>

    </manifest>

    * activity_main.xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context="com.koruniv.user.mysqlconnect2.MainActivity"
        android:layout_margin="15dp"
        android:padding="10dp">

        <ListView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="6"
            android:layout_margin="5dp"
            android:padding="5dp"
            android:id="@+id/ListView_main_list"/>

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="4"
            android:layout_margin="5dp"
            android:padding="5dp"
            android:id="@+id/TextView_main_result"/>

    </LinearLayout>

---
    * item_list.xml
    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_margin="10dp"
        android:padding="15dp">

        <TextView
            android:id="@+id/textView_list_id"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_margin="5dp"
            android:padding="5dp" />


        <TextView
            android:id="@+id/textView_list_name"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="4"
            android:layout_margin="5dp"
            android:padding="5dp" />


        <TextView
            android:id="@+id/textView_list_address"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="5"
            android:layout_margin="5dp"
            android:padding="5dp" />

    </LinearLayout>

---

    * MainActivity.java
    package com.koruniv.user.mysqlconnect2;

    import android.app.ProgressDialog;
    import android.os.AsyncTask;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.util.Log;
    import android.widget.ListAdapter;
    import android.widget.ListView;
    import android.widget.SimpleAdapter;
    import android.widget.TextView;


    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    import java.io.BufferedReader;

    import java.io.IOException;
    import java.io.InputStream;
    import java.io.InputStreamReader;

    import java.net.HttpURLConnection;
    import java.net.URL;
    import java.util.ArrayList;
    import java.util.HashMap;

    public class MainActivity extends AppCompatActivity {

        private static String TAG = "phptest_MainActivity";

        private static final String TAG_JSON="webnautes";
        private static final String TAG_ID = "id";
        private static final String TAG_NAME = "name";
        private static final String TAG_ADDRESS ="address";

        private TextView mTextViewResult;
        ArrayList<HashMap<String, String>> mArrayList;
        ListView mListView;
        String mJsonString;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("Person List 가져오기");

            mTextViewResult = (TextView)findViewById(R.id.TextView_main_result);
            mListView = (ListView) findViewById(R.id.ListView_main_list);
            mArrayList = new ArrayList<>();

            GetData task = new GetData();
            task.execute("http://192.168.0.26/getjson.php");

        }

        private class GetData extends AsyncTask<String, Void, String>{
            ProgressDialog progressDialog;
            String errorString = null;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(MainActivity.this, "Please, Wait", null, true, true);

            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                progressDialog.dismiss();
                Log.d(TAG, "response - "+result);

                if (result == null) {
                    mTextViewResult.setText(errorString);
                } else {
                    mJsonString = result;
                    showResult();
                }
            }

            @Override
            protected String doInBackground(String... params) {

                String serverURL = params[0];

                try {

                    URL url = new URL(serverURL);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                    httpURLConnection.setReadTimeout(5000);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();

                    int responseStatusCode = httpURLConnection.getResponseCode();
                    Log.d(TAG, "response code - "+responseStatusCode);

                    InputStream inputStream;
                    if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                        inputStream = httpURLConnection.getInputStream();
                    } else {
                        inputStream = httpURLConnection.getErrorStream();
                    }

                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                    StringBuilder stringBuilder = new StringBuilder();
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }

                    bufferedReader.close();

                    return stringBuilder.toString().trim();


                } catch (Exception e) {

                    Log.d(TAG, "GetData error: "+e);
                    errorString = e.toString();

                    return null;

                }

            }

        }

        private void showResult() {

            try {

                JSONObject jsonObject = new JSONObject(mJsonString);
                JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

                for (int i=0; i < jsonArray.length(); i++) {

                    JSONObject item = jsonArray.getJSONObject(i);

                    String id = item.getString(TAG_ID);
                    String name = item.getString(TAG_NAME);
                    String address = item.getString(TAG_ADDRESS);

                    HashMap<String, String> hashMap = new HashMap<>();

                    hashMap.put(TAG_ID, id);
                    hashMap.put(TAG_NAME, name);
                    hashMap.put(TAG_ADDRESS, address);

                    mArrayList.add(hashMap);

                }

                // ListView 에 들어갈 데이터를 ListAdapter 형태로 생성
                ListAdapter listAdapter = new SimpleAdapter(MainActivity.this, mArrayList, R.layout.item_list,
                        new String[]{TAG_ID, TAG_NAME, TAG_ADDRESS},
                        new int[]{R.id.textView_list_id, R.id.textView_list_name, R.id.textView_list_address});

                // ListView에 삽입
                mListView.setAdapter(listAdapter);

                // TextView에 삽입
                mTextViewResult.setText(mJsonString);


            } catch (JSONException e) {
                Log.d(TAG, "showResult Error: ", e);
            }

        }



    }




## 7-3. 실행화면

* 초기 화면 - 리스트와 json 출력문자열이 보임


![실행화면1](/week2/images/mysqlconnect2_1.jpg)
