package com.example.caohuy.ontapsql;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DanhSachTacGiaActivity extends AppCompatActivity {
    private ListView lvTacGia;
    private List<TacGia> lstTacGia;

    private Database database;
    private SQLiteDatabase reader;
    private SQLiteDatabase writer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_tac_gia);

        database=new Database(this);
        reader=database.getReadableDatabase();
        writer=database.getWritableDatabase();

        lvTacGia= (ListView) findViewById(R.id.lvTacGia);

        lstTacGia=new ArrayList<>(); //this Important
        LoadListView();
    }

    private void LoadListView(){
        DSTacGia ds=new DSTacGia();
        lstTacGia.clear();
        try{
            lstTacGia=ds.getAllTacGia(reader, this);
        } catch (Exception e) {
            lstTacGia=new ArrayList<TacGia>();
        }
        ArrayAdapter<TacGia> adapter=new ArrayAdapter<TacGia>(this, android.R.layout.simple_list_item_1, lstTacGia);
        lvTacGia.setAdapter(adapter);
    }

}
