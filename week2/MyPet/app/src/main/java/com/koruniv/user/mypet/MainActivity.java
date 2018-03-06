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
