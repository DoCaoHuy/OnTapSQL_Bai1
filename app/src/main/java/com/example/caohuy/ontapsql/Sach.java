package com.example.caohuy.ontapsql;

import java.util.Date;

/**
 * Created by Cao Huy on 03/11/2018.
 */

public class Sach  {
    private int maSach;
    private String tuaSach;
    private Date ngayXB;
    private int maTG;

    public Sach(int maSach, String tuaSach, Date ngayXB, int maTG) {
        this.maSach = maSach;
        this.tuaSach = tuaSach;
        this.ngayXB = ngayXB;
        this.maTG = maTG;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getTuaSach() {
        return tuaSach;
    }

    public void setTuaSach(String tuaSach) {
        this.tuaSach = tuaSach;
    }

    public Date getNgayXB() {
        return ngayXB;
    }

    public void setNgayXB(Date ngayXB) {
        this.ngayXB = ngayXB;
    }

    public int getMaTG() {
        return maTG;
    }

    public void setMaTG(int maTG) {
        this.maTG = maTG;
    }

    @Override
    public String toString() {
        return maSach+"_"+tuaSach;
    }
}
