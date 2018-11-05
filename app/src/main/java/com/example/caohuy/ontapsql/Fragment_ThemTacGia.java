package com.example.caohuy.ontapsql;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cao Huy on 02/11/2018.
 */

public class Fragment_ThemTacGia extends DialogFragment implements View.OnClickListener {
    private TextView ma, ten;
    private Button xoaT, themTG;
    private Database database;
    private SQLiteDatabase reader;
    private SQLiteDatabase writer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_themtacgia, container, false);
        ma= (TextView) view.findViewById(R.id.txtMaTG);
        ten= (TextView) view.findViewById(R.id.txtTenTG);
        xoaT= (Button) view.findViewById(R.id.btnXoaTrang);
        themTG= (Button) view.findViewById(R.id.btnThemTGF);
        database=new Database(getActivity());
        reader=database.getReadableDatabase();
        writer=database.getWritableDatabase();

        themTG.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnThemTGF:
                TacGia tg=new TacGia(Integer.parseInt(ma.getText().toString()), ten.getText().toString());
                try{
                if(tg.ThemTacGia(writer)){
                    Toast.makeText(getActivity(), "Da them tac gia!", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(getActivity(), "Loi!", Toast.LENGTH_LONG).show();
            }catch (Exception ex){
                    Toast.makeText(getActivity(), ex.toString(), Toast.LENGTH_LONG).show();
                }
                break;
        }

    }


}
