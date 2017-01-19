package com.inet.Abraj_English.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHelper {

    public static final String LOGTAG="Abraj";
    private static final String DATABASE_NAME ="Abraj.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Years_Zodic";
    private static final String COL_ID = "ID";

    public static final String COL_HORONAME = "horoscope_name";
    public static final String COL_HORODES = "horoscope_desc";
    public static final String COL_HOROIMG = "horoscope_img";

    private static final String TABLE_CREATE=
            "CREATE TABLE "+TABLE_NAME+ " ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +COL_HORONAME+" TEXT , "
                    +COL_HORODES+" TEXT , "
                     +COL_HOROIMG+" INT );";


    private static final String[] all = {COL_ID,COL_HORONAME,COL_HORODES,COL_HOROIMG};

    // Variable to hold the database instance
    private SQLiteDatabase db;
    private final Context context;
    // Database open/upgrade helper
    private myDbHelper dbHelper;

    // CONSTRUCTOR
    public DBHelper (Context _context) {
        context = _context;

        dbHelper = new myDbHelper(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }

    // OPEN
    public DBHelper open() throws SQLException
    {

        Log.e(LOGTAG,"open");
        db = dbHelper.getWritableDatabase();
        return this;
    }

    // CLOSE
    public void close() {
        db.close();
    }

    // insert
    public long insertEntry(ContentValues contentValues) {

        Log.e(LOGTAG, "insert");
        return db.insert(TABLE_NAME, null, contentValues);

    }

    // remove
    public boolean removeEntry(Integer _rowIndex) {

        return db.delete(TABLE_NAME, COL_ID +
                "=" + _rowIndex , null ) > 0;

    }

    public boolean removeallEntries ()
    {
        return db.delete(TABLE_NAME, null , null) > 0;
    }


    public Cursor getAllEntries () {
        Cursor d=db.query(TABLE_NAME, all,
                null, null, null, null, null);

        return d;
    }

    public Object getEntry(long _rowIndex) {

        // TODO Return a cursor to a row from the database and
        // use the values to populate an instance of MyObject
        return null;
    }

    public int updateEntry(long _rowIndex, Object _myObject) {
        String where = COL_ID + "=" + _rowIndex;
        ContentValues contentValues = new ContentValues();
        // TODO fill in the ContentValue based on the new object
        return db.update(TABLE_NAME, contentValues, where, null);
    }

    ////////////////////////////////////////    Helper Class    ///////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    private static class myDbHelper extends SQLiteOpenHelper {

        // CONSTR
        public myDbHelper(Context context, String name,
                          CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        // Called when no database exists in
        // disk and the helper class needs
        // to create a new one.

        @Override
        public void onCreate(SQLiteDatabase _db) {
            Log.i(LOGTAG,"  DataBase created Successfully .. ");
            _db.execSQL(TABLE_CREATE);
            // TODO Auto-generated method stub

        }

        // Called when there is a database version mismatch meaning that
        // the version of the database on disk needs to be upgraded to
        // the current version.
        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {

            // Upgrade the existing database to conform to the new version.
            // Multiple previous versions can be handled by comparing
            // _oldVersion and _newVersion values.
            // The simplest case is to drop the old table and create a
            // new one.
            _db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            // Create a new one.
            onCreate(_db);
            // TODO Auto-generated method stub

        }

    }

}
