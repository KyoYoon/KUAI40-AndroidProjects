package com.koruniv.user.mymenu2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int rotation = 0;
    TextView textView;
    ImageView imageView;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("메뉴 살펴보기");

        textView = (TextView) findViewById(R.id.textView1);
        imageView = (ImageView) findViewById(R.id.image1);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);




    }


    //@Override
    //public boolean onPrepareOptionsMenu(Menu menu) {
     //   MenuInflater menuInflater = getMenuInflater();
     //   menuInflater.inflate(R.menu.menu, menu);
     //   return super.onPrepareOptionsMenu(menu);
    //}


    /**
     * 메뉴 접근시 호출
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mnuRed:
                relativeLayout.setBackgroundColor(Color.rgb(255,0,0));
                break;
            case R.id.mnuBlue:
                relativeLayout.setBackgroundColor(Color.rgb(0,0,255));
                break;
            case R.id.mnuYellow:
                relativeLayout.setBackgroundColor(Color.rgb(255, 255, 0));
                break;
            case R.id.item_rotation:
                rotation += 30;
                if (rotation >= 360) {
                    rotation = 360;
                }
                imageView.setRotation(rotation);
                break;
            case R.id.item_expansion:
                if (item.isChecked()) {
                    item.setChecked(false);
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                } else {
                    item.setChecked(true);
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                }
                break;
            case R.id.item_title:
                if (item.isChecked()) {
                    item.setChecked(false);
                    textView.setVisibility(View.GONE);
                } else {
                    item.setChecked(true);
                    textView.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.cat:
                item.setChecked(true);
                textView.setText("귀여운 고양이");
                imageView.setImageResource(R.drawable.cat);
                break;
            case R.id.dog:
                item.setChecked(true);
                textView.setText("귀여운 강아지");
                imageView.setImageResource(R.drawable.dog);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
