package com.example.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "STUDENT";
    public static final String COL_0 = "ID";
    public static final String COL_1 = "NAME";
    public static final String COL_2 = "SURNAME";
    public static final String COL_3 = "MARKS";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String query = "CREATE TABLE " + TABLE_NAME + "(" + COL_0 + " INTEGER PRIMARY KEY " +
//                       "AUTOINCREMENT, " + COL_1 + " TEXT, " + COL_2 + " TEXT, " + COL_3 + " TEXT)";
        String query = "create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, MARKS TEXT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }

    public boolean InsertData(String name, String surname, String Marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, surname);
        contentValues.put(COL_3, Marks);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Integer UpdateData(String id, String name, String surname, String Marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_0, id);
        contentValues.put(COL_1, name);
        contentValues.put(COL_2, surname);
        contentValues.put(COL_3, Marks);
        return db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
    }

    public Integer DeleteRecord(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }


    public Cursor GetAllRecords()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =  db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }
}
