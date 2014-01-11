package org.pickfordfamily.sh.db;

import android.database.sqlite.SQLiteDatabase;

public class InitData {

	public void init(){
		
		DbHelper mDbHelper = new DbHelper(getContext());
		SQLiteDatabase db = mDbHelper.getWritableDatabase();

		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(FeedEntry.COLUMN_NAME_ENTRY_ID, id);
		values.put(FeedEntry.COLUMN_NAME_TITLE, title);
		values.put(FeedEntry.COLUMN_NAME_CONTENT, content);

		// Insert the new row, returning the primary key value of the new row
		long newRowId;
		newRowId = db.insert(
		         FeedEntry.TABLE_NAME,
		         FeedEntry.COLUMN_NAME_NULLABLE,
		         values);
	}
	
}
