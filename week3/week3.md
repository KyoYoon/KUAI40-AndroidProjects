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
