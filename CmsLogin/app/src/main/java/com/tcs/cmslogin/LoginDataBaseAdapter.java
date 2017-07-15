package com.tcs.cmslogin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

<<<<<<< HEAD
=======
<<<<<<< HEAD
import java.util.ArrayList;

public class LoginDataBaseAdapter
{
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 7;
=======
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
public class LoginDataBaseAdapter
{
    static final String DATABASE_NAME = "login.db";
    static final int DATABASE_VERSION = 2;
<<<<<<< HEAD
=======
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
    public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table "+"LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text); ";

    static final String DATABASE_CREATE_A = "create table "+"A_LOGIN"+
            "( " +"ID"+" integer primary key autoincrement,"+ "USERNAME  text,PASSWORD text) ";
<<<<<<< HEAD
=======

    static final String DATABASE_CREATE_E = "create table "+"E_LOGIN"+
<<<<<<< HEAD
            "( " + "EMPID text primary key,NAME  text, EMAILID text,  PASSWORD text, DEPARTMENT text) ";
=======
            "( " +"ID"+" integer  autoincrement,"+ "NAME  text, EMAILID text, EMPID text, PASSWORD text, DEPARTMENT text) ";
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
    // Variable to hold the database instance
    public  SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;
    public  LoginDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  LoginDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String userName,String password)
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);

        // Insert the row into your table
        db.insert("LOGIN", null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }

<<<<<<< HEAD
    public void insertEntryA()
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("USERNAME", "admin");
        newValues.put("PASSWORD","admin");

        // Insert the row into your table
        db.insert("A_LOGIN", null, newValues);
=======
<<<<<<< HEAD
    public void insertEntryE(String empid,String name,String emailid,String pass,String dept)
=======
    public void insertEntryE(String name,String emailid,String empid,String pass,String dept)
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
    {
        ContentValues newValues = new ContentValues();
        // Assign values for each row.
        newValues.put("NAME", name);
        newValues.put("EMAILID", emailid);
        newValues.put("EMPID", empid);
        newValues.put("PASSWORD",pass);
        newValues.put("DEPARTMENT", dept);

        // Insert the row into your table
        db.insert("E_LOGIN", null, newValues);
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public int deleteEntry(String UserName)
    {
        //String id=String.valueOf(ID);
        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete("LOGIN", where, new String[]{UserName}) ;
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }
    public String getSingleEntry(String userName)
    {
        Cursor cursor=db.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD

    /******** METHOD TO GET THE ID OF EMPLOYEE ***********/

    public ArrayList getEmpId()
    {
        db=dbHelper.getReadableDatabase();
        ArrayList<String> empid=new ArrayList<>();
        Cursor cursor;
        cursor = db.rawQuery("select EMPID,NAME,DEPARTMENT from E_LOGIN",null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            String id=cursor.getString(cursor.getColumnIndex("EMPID"));
             empid.add(id);
            cursor.moveToNext();
        }
        cursor.close();
        return empid;
    }

    /******** METHOD TO GET THE NAME OF EMPLOYEE ***********/

    public ArrayList getEmpName()
    {
        db=dbHelper.getReadableDatabase();
        ArrayList<String> emp_name=new ArrayList<>();
        Cursor cursor;
        cursor = db.rawQuery("select EMPID,NAME,DEPARTMENT from E_LOGIN",null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            String name=cursor.getString(cursor.getColumnIndex("NAME"));
            emp_name.add(name);
            cursor.moveToNext();
        }
        cursor.close();
        return emp_name;
    }

    /******** METHOD TO GET THE DEPARTMENT OF EMPLOYEE ***********/

    public ArrayList<String> getEmpDept()
    {
        db=dbHelper.getReadableDatabase();
        ArrayList<String> emp_dept=new ArrayList<>();
        Cursor cursor;
        cursor = db.rawQuery("select DEPARTMENT from E_LOGIN",null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return null;
        }
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            String name=cursor.getString(cursor.getColumnIndex("DEPARTMENT"));
            emp_dept.add(name);
            cursor.moveToNext();
        }
        cursor.close();
        return emp_dept;
    }


=======
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
    public String getSingleEntryA(String userName)
    {
        Cursor cursor=db.query("A_LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD

    public String getSingleEntryE(String userName)
    {
        Cursor cursor=db.query("E_LOGIN", null, " EMPID=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }


=======
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
    public void  updateEntry(String userName,String password)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        db.update("LOGIN",updatedValues, where, new String[]{userName});
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD

    public void  updateEntryA(String password)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        //updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        db.update("A_LOGIN",updatedValues, where, new String[]{"admin"});
    }

=======
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
}