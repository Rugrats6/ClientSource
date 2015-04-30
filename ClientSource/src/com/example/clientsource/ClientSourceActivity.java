package com.example.clientsource;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class ClientSourceActivity extends Activity {

	protected ClientSourceDatabaseHelper mDatabase = null; 
	protected SQLiteDatabase mDB = null;
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mDatabase = new ClientSourceDatabaseHelper(this.getApplicationContext());
		mDB = mDatabase.getWritableDatabase();
		
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		if(mDB != null)
		{
			mDB.close();
		}
		
		if(mDatabase != null)
		{
			mDatabase.close();
		}
	}
}