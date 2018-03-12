package com.koruniv.user.mymenu1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);


    }

    /**
     * 최초에 메뉴키가 눌렀을 때 호출
     * @param menu
     * @return boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, 1, 0, "배경색 (빨강)");
        menu.add(0, 2, 0, "배경색 (초록)");
        menu.add(0, 3, 0, "배경색 (파랑)");

        SubMenu subMenu = menu.addSubMenu("버튼 변경 >>>");

        subMenu.add(0,4,0, "버튼 45도 변경");
        subMenu.add(0,5,0, "버튼 2배 확대");

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 메뉴 아이템이 클릭되었을 때
     * @param item - 사용자가 클릭한 메뉴 아이템 정보
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case 1: // 배경색 (빨강)
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case 2: // 배경색 (초록)
                baseLayout.setBackgroundColor(Color.GREEN);
                return true;
            case 3: // 배경색 (파랑)
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case 4:
                button1.setRotation(45); // 45도 회전
                return true;
            case 5:
                button1.setScaleX(2); // X축 기준으로 2배 증가시킴 (폭)
                button1.setScaleY(2); // Y축 기준으로 2배 증가시킴 (높이)
                return true;

        }

        //return super.onOptionsItemSelected(item);
        return false;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }
}
