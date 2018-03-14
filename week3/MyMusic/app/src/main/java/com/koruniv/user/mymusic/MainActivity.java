package com.koruniv.user.mymusic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {

    MyDBHelper myDBHelper;
    EditText editName, editNumber, editNameResult, editNumberResult;
    Button btnInit, btnInsert, btnUpdate, btnDelete, btnSelect;
    SQLiteDatabase sqLiteDatabase;
    //String oldName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그룹 관리 DB (Sqlite 사용)");

        // widget => variable 에 할당
        editName = (EditText) findViewById(R.id.editName);
        editNumber = (EditText) findViewById(R.id.editNumber);
        editNameResult = (EditText) findViewById(R.id.editNameResult);
        editNumberResult = (EditText) findViewById(R.id.editNumberResult);

        btnInit = (Button) findViewById(R.id.btnInit);
        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnSelect = (Button) findViewById(R.id.btnSelect);



        // SQLite DB 연결
        final MyDBHelper myDBHelper = new MyDBHelper(getApplicationContext(), "testDB.db", null, 1);

        //final MyDBHelper dbHelper = new MyDBHelper(getApplicationContext(), "testDB.db", null, 1);

        // 각 버튼 클릭시 발생하는 이벤트 정의
        // 초기화 버튼 클릭시
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 입력한 값 초기화
                //editName.setText("");
                //editNumber.setText("");
                //editNameResult.setText("");
                //editNumberResult.setText("");
                myDBHelper.onUpgrade(sqLiteDatabase, 1, 2);

                Toast.makeText(getApplicationContext(), "테이블 생성 및 초기화 완료", Toast.LENGTH_SHORT).show();
            }
        });



        // 입력 버튼 클릭시
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editName.getText().toString().trim();
                int num = Integer.parseInt(editNumber.getText().toString().trim());

                // 사용자가 입력한 값으로 구성된 레코드 객체를 이용하여 테이블에 삽입
                myDBHelper.insert(new MyGroupRecord(name, num));

                //Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();

                editNameResult.setText(myDBHelper.getNameResult());
                editNumberResult.setText(myDBHelper.getNumberResult());

                //btnSelect.callOnClick();
            }
        });

        // 수정 버튼 클릭시
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editName.getText().toString().trim();
                int num = Integer.parseInt(editNumber.getText().toString().trim());

                // 사용자가 입력한 인원으로 수정
                myDBHelper.update(new MyGroupRecord(name, num));

                editNameResult.setText(myDBHelper.getNameResult());
                editNumberResult.setText(myDBHelper.getNumberResult());

            }
        });

        // 삭제 버튼 클릭시
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString().trim();

                // 레코드 삭제
                myDBHelper.delete(name);

                editNameResult.setText(myDBHelper.getNameResult());
                editNumberResult.setText(myDBHelper.getNumberResult());
            }
        });

        // 조회 버튼 클릭시
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editNameResult.setText(myDBHelper.getNameResult());
                editNumberResult.setText(myDBHelper.getNumberResult());

            }
        });

    }



}
