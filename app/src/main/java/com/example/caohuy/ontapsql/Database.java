package com.example.caohuy.ontapsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cao Huy on 03/11/2018.
 */

public class Database extends SQLiteOpenHelper {
    private static final int DB_VERSION=1;
    private static String DBName="QuanLySach.db";
    private static final String DropDB="DROP DATABASE IF EXISTS QuanLySach.db";

    private static final String tblTacGia= "CREATE TABLE IF NOT EXISTS tblTacGia (" +
            "matacgia integer primary key autoincrement, " +
            "tentacgia nvarchar(50));";

    private static final String tblSach="CREATE TABLE IF NOT EXISTS tblSach(" +
            "masach integer primary key autoincrement, " +
            "tuasach nvarchar(50), " +
            "ngayxuatban date, " +
            "matacgia integer not null " +
            "constraint matacgia references tblTacGia(matacgia) on update cascade on delete cascade)";

    private static final String DropTbtSach="DROP TABLE tblSach";
    private static final String DropTbtTacGia="DROP TABLE tblTacGia";

    public Database(Context context) {
        super(context, DBName, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tblTacGia);
        db.execSQL(tblSach);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DropTbtSach);
        db.execSQL(DropTbtTacGia);
        onCreate(db);
    }
}
