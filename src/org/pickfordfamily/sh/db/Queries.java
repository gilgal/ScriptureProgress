package org.pickfordfamily.sh.db;

import org.pickfordfamily.sh.db.ScriptureHelperContract.Volume;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Queries {
	
	private Context context;
	
	public Queries(Context context){
		this.context = context;
	}

	public String getVolume(Long volumeId){
		DbHelper dbHelper = new DbHelper(context);
		SQLiteDatabase db = dbHelper.getReadableDatabase();

		// Define a projection that specifies which columns from the database
		// you will actually use after this query.
		String[] projection = {
		    Volume.COLUMN_NAME_VOLUME_ID ,
		    Volume.COLUMN_NAME_NAME
		    };

		// How you want the results sorted in the resulting Cursor
		String sortOrder =
		    Volume.COLUMN_NAME_NAME + " DESC";
		
		String selection = Volume.COLUMN_NAME_VOLUME_ID + " = ?";
		String[] selectionArgs = new String[] {"1"};

		Cursor c = db.query(
		    Volume.TABLE_NAME,  // The table to query
		    projection,                               // The columns to return
		    selection,                                // The columns for the WHERE clause
		    selectionArgs,                            // The values for the WHERE clause
		    null,                                     // don't group the rows
		    null,                                     // don't filter by row groups
		    sortOrder                                 // The sort order
		    );
		
		c.moveToFirst();
		
		System.out.println("Number of rows: " + c.getCount());
		
		System.out.println("Number of columns: " + c.getColumnCount());
		
		String result = c.getString(1);
		
		return result;
	}
	
}
