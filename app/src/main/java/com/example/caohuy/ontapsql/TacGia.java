package com.example.caohuy.ontapsql;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.io.Serializable;

/**
 * Created by Cao Huy on 03/11/2018.
 */

public class TacGia implements Serializable {
    private int maTG;
    private String tenTG;

    public TacGia(int maTG, String tenTG) {
        this.maTG = maTG;
        this.tenTG = tenTG;
    }

    public int getMaTG() {
        return maTG;
    }

    public void setMaTG(int maTG) {
        this.maTG = maTG;
    }

    public String getTenTG() {
        return tenTG;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    @Override
    public String toString() {
        return maTG +"_"+tenTG;
    }

    public boolean ThemTacGia(SQLiteDatabase database){
        ContentValues contentValues=new ContentValues();
        contentValues.put("matacgia", maTG);
        contentValues.put("tentacgia", tenTG);
        database.beginTransaction();

        long id=database.insert("tblTacGia", null, contentValues);
        database.setTransactionSuccessful();
        database.endTransaction();
        if(id==-1) return false;
        return true;

    }
}
