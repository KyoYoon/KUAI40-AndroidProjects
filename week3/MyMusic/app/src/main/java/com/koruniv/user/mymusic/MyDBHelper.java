package com.koruniv.user.mymusic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 2018-03-13.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    private static final String TABLE_groupTBL = "groupTBL";

    private static final String KEY_NAME = "gName";
    private static final String KEY_NUMBER = "gNumber";

    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE groupTBL "+
                "(gName CHAR(20) PRIMARY KEY, "+
                "gNumber integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS groupTBL");
        onCreate(sqLiteDatabase);
    }


    public void insert(MyGroupRecord myGroupRecord) {
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = this.getWritableDatabase();
        // DB에 입력한 값으로 행 추가

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, myGroupRecord.getgName());
        values.put(KEY_NUMBER, myGroupRecord.getgNumber());

        db.insert(TABLE_groupTBL, null, values);
        db.close();
    }

    public void update(MyGroupRecord myGroupRecord) {

        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NUMBER, myGroupRecord.getgNumber());

        db.update(TABLE_groupTBL, values, KEY_NAME + "=?", new String[]{myGroupRecord.getgName()});
        db.close();


    }

    public void delete(String name) {

        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_groupTBL, KEY_NAME + "=?", new String[]{name});
        db.close();

    }

    public String getNameResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM groupTBL", null);
        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    + "\n";
        }

        return result;
    }

    public String getNumberResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM groupTBL", null);
        while (cursor.moveToNext()) {
            result += Integer.toString(cursor.getInt(1))
                    + "\n";
        }

        return result;
    }

}
