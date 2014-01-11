package org.pickfordfamily.sh.db;

import org.pickfordfamily.sh.db.ScriptureHelperContract.Volume;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class InitData {

	private Context context;
	
	public InitData(Context context){
		this.context = context;
	}
	
	public void init(){
		
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
		
		values = new ContentValues();
		values.put(Volume.COLUMN_NAME_VOLUME_ID, 2);
		values.put(Volume.COLUMN_NAME_NAME, "New Testament");
		insert(db,values);
		
		values = new ContentValues();
		values.put(Volume.COLUMN_NAME_VOLUME_ID, 3);
		values.put(Volume.COLUMN_NAME_NAME, "Book of Mormon");
		insert(db,values);

		values = new ContentValues();
		values.put(Volume.COLUMN_NAME_VOLUME_ID, 4);
		values.put(Volume.COLUMN_NAME_NAME, "Doctrine and Covenants");
		insert(db,values);
		
		values = new ContentValues();
		values.put(Volume.COLUMN_NAME_VOLUME_ID, 5);
		values.put(Volume.COLUMN_NAME_NAME, "Pearl of Great Price");
		insert(db,values);		
		
	}
	
	private void insert(SQLiteDatabase db, ContentValues values){
		db.insert(Volume.TABLE_NAME, null, values);
	}
	
}
