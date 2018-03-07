package com.koruniv.user.showtext;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT
        );

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setBackgroundColor(Color.rgb(255, 255, 255)); // white

        setContentView(linearLayout, layoutParams);
        setTitle("XML기반 글자 보여주기 프로그램");

        final EditText editText = new EditText(this);
        editText.setHint("글자를 입력하세요.");
        editText.setBackgroundColor(Color.MAGENTA);
        editText.setGravity(Gravity.CENTER);

        linearLayout.addView(editText);

        Button showButton = new Button(this);
        showButton.setText("Show");
        showButton.setBackgroundColor(Color.BLUE);

        linearLayout.addView(showButton);

        final TextView textView = new TextView(this);
        textView.setHint("출력결과 표시");
        textView.setTextSize(20);
        textView.setGravity(Gravity.CENTER);

        textView.setHeight(70);
        textView.setBackgroundColor(Color.CYAN);

        linearLayout.addView(textView);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textView.setText("");
                textView.setText(editText.getText().toString());


            }
        });



    }
}
