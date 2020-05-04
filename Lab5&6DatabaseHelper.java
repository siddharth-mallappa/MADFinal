package com.example.lab5and6;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public  static final String DATABASE_NAME="StudentDatabase.db";
    public  static final String TABLE_NAME="Student_table";
    public  static final String COL1="ID";
    public  static final String COL2="NAME";
    public  static final String COL3="MARKS";
    SQLiteDatabase db;
    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_query="create table if not exists "+TABLE_NAME+
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT,MARKS INTEGER)";
        db.execSQL(sql_query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insert_record(String name, int marks){
        ContentValues cv = new ContentValues();
        cv.put(COL2,name);
        cv.put(COL3,marks);

        long result= db.insert(TABLE_NAME,null,cv);
        if (result==-1)
            return false;
        else
            return true;

    }
    public Cursor display_all_records() {

        Cursor res = db.rawQuery("SELECT * FROM  Student_table", null);
        return res;

    }
    public void update_record(String name, int marks){
        String query = "UPDATE Student_table SET Marks=" + marks + " WHERE Name='" + name + "';";
        db.execSQL(query);

    }
    public void delete_record(String name){
        String query="DELETE FROM student_table WHERE Name='"+name+"';";
        db.execSQL(query);
    }


}
