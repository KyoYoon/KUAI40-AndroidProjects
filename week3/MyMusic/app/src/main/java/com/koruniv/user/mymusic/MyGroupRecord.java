package com.koruniv.user.mymusic;

/**
 * Created by User on 2018-03-13.
 */

public class MyGroupRecord {

    private String gName;
    private int gNumber;

    public MyGroupRecord(String gName) {
        this.gName = gName;
        this.gNumber = 1;
    }

    public MyGroupRecord(String gName, int gNumber) {
        this.gName = gName;
        this.gNumber = gNumber;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getgNumber() {
        return gNumber;
    }

    public void setgNumber(int gNumber) {
        this.gNumber = gNumber;
    }
}
