package org.pickfordfamily.sh.db;

import org.pickfordfamily.sh.db.ScriptureHelperContract.Volume;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class InitData {

	public void init(Context context){
		
		DbHelper mDbHelper = new DbHelper(context);
		SQLiteDatabase db = mDbHelper.getWritableDatabase();

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
