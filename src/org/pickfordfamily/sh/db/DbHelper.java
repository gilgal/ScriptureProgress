package org.pickfordfamily.sh.db;

import org.pickfordfamily.sh.db.ScriptureHelperContract.Volume;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ScriptureHelper.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + Volume.TABLE_NAME + " (" +
        Volume._ID + " INTEGER PRIMARY KEY," +
        Volume.COLUMN_NAME_VOLUME_ID + TEXT_TYPE + COMMA_SEP +
        Volume.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
        " )";
    
    private Context context;

    private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + Volume.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    
    public void init(){
//    	DbHelper mDbHelper = new DbHelper(context);
		SQLiteDatabase db = getWritableDatabase();

		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(Volume.COLUMN_NAME_VOLUME_ID, 1);
		values.put(Volume.COLUMN_NAME_NAME, "Old Testament");

		// Insert the new row, returning the primary key value of the new row
		long newRowId;
		newRowId = db.insert(
		         Volume.TABLE_NAME,
		         null,
		         values);
    }
}
