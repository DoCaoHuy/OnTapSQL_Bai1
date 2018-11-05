package com.example.caohuy.ontapsql;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Cao Huy on 03/11/2018.
 */

public class DSTacGia {
    public ArrayList<TacGia> getAllTacGia(SQLiteDatabase database, Activity context) throws Exception{
        ArrayList<TacGia> lstTacGia=new ArrayList<>();
        if(database!=null){
            String ds="SELECT * FROM tblTacGia";
            Cursor c=database.rawQuery(ds, null);
            context.startManagingCursor(c);
            if(c.getCount()==0){
                return lstTacGia;
            }
            c.moveToFirst();
            while (!c.isAfterLast()){
                lstTacGia.add(new TacGia(c.getInt(0), c.getString(1)));
                c.moveToNext();
            }
            c.close();
        }
        return lstTacGia;
    }
}
