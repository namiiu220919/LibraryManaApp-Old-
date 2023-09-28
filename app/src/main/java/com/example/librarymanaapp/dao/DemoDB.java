package com.example.librarymanaapp.dao;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.librarymanaapp.database.DbHelper;
import com.example.librarymanaapp.model.ThanhVien;

public class DemoDB {
    private SQLiteDatabase db;
    ThanhVienDAO thanhVienDAO;
    public DemoDB(Context context){
        DbHelper dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
        thanhVienDAO = new ThanhVienDAO(context);
    }
    public void thanhVien(){
        ThanhVien tv = new ThanhVien(1,"Phương Nam","2004");
        if(thanhVienDAO.insert(tv) > 0){
            Log.i(TAG,"Thêm thành viên thành công");
        }else{
            Log.i(TAG,"Thêm thành viên thất bại");
        }
        Log.i(TAG,"Tổng sô thành viên:" +thanhVienDAO.getAll().size());
    }
}
