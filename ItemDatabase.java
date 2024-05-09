package com.example.test.repo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class ItemDatabase extends SQLiteOpenHelper {

    public ItemDatabase(Context context) {
        super(context, "Items.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table ItemDetails(name TEXT primary key, quantity TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Itemdetails");
    }

    // CREATE: Create item data
    public Boolean insertItemData(String name, String quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("quantity", quantity);
        long result = db.insert("Itemdetails", null, contentValues);

        return result != -1;
    }

    public Boolean deleteItemData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete("Itemdetails", "name=?", new String[]{name});

        return result != -1;
    }

    // Return data from DB
    public Cursor getData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        // Pass all of Itemdetails table into cursor

        return db.rawQuery("Select * from Itemdetails", null);
    }
}
