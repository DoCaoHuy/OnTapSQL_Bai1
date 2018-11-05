package com.example.caohuy.ontapsql;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnThem, btnXem, btnQL;
    private Database dataBase;
    private SQLiteDatabase reader;
    private SQLiteDatabase writer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThem= (Button) findViewById(R.id.btnThemTG);
        btnXem= (Button) findViewById(R.id.btnXemTG);
        btnQL= (Button) findViewById(R.id.btnQL);

        dataBase=new Database(this);
        reader=dataBase.getReadableDatabase();
        writer=dataBase.getWritableDatabase();


        btnThem.setOnClickListener(this);
        btnXem.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThemTG:
                Fragment_ThemTacGia dialog=new Fragment_ThemTacGia();
                dialog.show(getSupportFragmentManager(), "Them Tac Gia");
                //Intent intent=new Intent(this, ThemTacGiaActivity.class);
                //startActivity(intent);

                break;
            case R.id.btnXemTG:
                Intent intent1=new Intent(this, DanhSachTacGiaActivity.class);
                startActivity(intent1);
                break;
        }


    }
}
