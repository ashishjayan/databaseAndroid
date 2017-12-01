package com.ashishjayan.trash2;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish Jayan on 12/1/2017.
 */

public class DBhelper extends SQLiteOpenHelper {

    private static final int DB_VERSION =1;
    private static final String DB_NAME="taskDB";


    //Task name
        private static final String TABLE_TASK ="task";

        private static final String KEY_ID = "id";
        private static final String KEY_TITLE = "title";
        private static final String KEY_DESCRIPTION = "description";


    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TASK_TABLE ="CREATE TABLE "+ TABLE_TASK + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"+ KEY_TITLE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT"+ ")";
        db.execSQL(CREATE_TASK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_TASK);
        onCreate(db);
    }

    public void addTASK(Task task){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(KEY_TITLE,task.getTitle());
        values.put(KEY_DESCRIPTION,task.getDescription());

        db.insert(TABLE_TASK,null,values);
        db.close();
    }

    public List<Task> getALLTASK(){
        List<Task> taskList = new ArrayList<>();

        //select query
        String selectQuery = "SELECT  * FROM " + TABLE_TASK;

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()) {
            do {
                Task task = new Task();
                task.setId(Integer.parseInt(cursor.getString(0)));
                task.setTitle(cursor.getString(1));
                task.setDescription(cursor.getString(2));

                // Adding task to list
                taskList.add(task);
            } while (cursor.moveToNext());
        }
        return taskList;
    }
    public int updateTask(Task task){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE,task.getTitle());
        values.put(KEY_DESCRIPTION,task.getDescription());

        return db.update(TABLE_TASK,values,KEY_ID + " = ?", new String[]{String.valueOf(task.getId())});
    }

    public void deleteFriend(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASK, KEY_ID + " = ?", new String[]{String.valueOf(task.getId())});
        db.close();
    }

    // getting number of records in table
    public int getContactsCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor dataCount = db.rawQuery("select " + KEY_ID + " from " + TABLE_TASK, null);

        int count = dataCount.getCount();
        dataCount.close();
        db.close();

        return count;
    }

}
