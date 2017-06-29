package com.tcs.cmslogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper
{
    public DataBaseHelper(Context context, String name,CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }
    // Called when no database exists in disk and the helper class needs
    // to create a new one.
    @Override
    public void onCreate(SQLiteDatabase _db)
    {
        try {
            _db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE_A);
            _db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);
            _db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE_E);
            //_db.execSQL("INSERT INTO A_LOGIN VALUES ('admin','admin')");

            ContentValues values = new ContentValues();
            values.put("USERNAME", "admin");
            values.put("PASSWORD", "admin");

// Inserting Row
            _db.insert("A_LOGIN", null, values);
        }
        catch(SQLException e)
        {
             e.printStackTrace();
        }


    }
    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.
    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        // Log the version upgrade.
        Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");

        // Upgrade the existing database to conform to the new version. Multiple
        // previous versions can be handled by comparing _oldVersion and _newVersion
        // values.
        // The simplest case is to drop the old table and create a new one.
        _db.execSQL("DROP TABLE IF EXISTS " + "LOGIN");
        _db.execSQL("DROP TABLE IF EXISTS " + "A_LOGIN");
        // Create a new one.
        onCreate(_db);
    }

}
