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
