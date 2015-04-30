package com.example.clientsource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.clientsource.ClientSourceDatabase.Child;
import com.example.clientsource.ClientSourceDatabase.Parent;
import com.example.clientsource.ClientSourceDatabase.Time;


// FYI: This is the same setup as PetTracker, although we have added two new columns to the Pets table to store the image URI information
class ClientSourceDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pet_tracker.db";
    private static final int DATABASE_VERSION = 3; // if you make changes to the schema, just increment the version and all the tables are dropped for you

        
    ClientSourceDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		// Create the Child table
		db.execSQL("CREATE TABLE " + Child.CHILD_TABLE_INFO+ " ("
                + Child._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Child.LAST_NAME + " TEXT"
                + Child.FIRST_NAME + " TEXT"
                + Child.DATEOF_BIRTH + " DATE"
                + Child.SEX + " TEXT"
                + Child.SS_NUMBER + " INTEGER"
                + ");");
		
		// Create the Parents table
		db.execSQL("CREATE TABLE " + Parent.PARENT_TABLE_NAME + " ("
                + Parent._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Parent.LAST_NAME + " TEXT"
                + Parent.FIRST_NAME + " TEXT"
                + Parent.DATEOF_BIRTH + " DATE"
                + Parent.SS_NUMBER + " INTEGER"
                + Parent.PHONE_NUMBER + " INTEGER"
                + Parent.CHILD_ID + " INTEGER" // this is a foreign key to the Child table
                + ");");
		
		// Create the Time table
		db.execSQL("CREATE TABLE " + Time.TIME_TABLE_NAME + " ("
		        + Time._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
		        + Time.DATE + " TEXT"
		        + Time.CHECK_IN + " DATE"
		        + Time.CHECK_OUT + " DATE"
		        + Parent.CHILD_ID + " INTEGER" // this is a foreign key to the Child table
		        + Parent.PARENT_ID + " INTEGER" // this is a foreign key to the PARENT table
		        + ");");
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Housekeeping here.
		// Implement how "move" your application data during an upgrade of schema versions		
		// ALTER Tables as necessary, or move data, or delete data. Your call.
        Log.i("MediaPetTrackerDatabaseHelper", "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", dropping all tables");
        db.execSQL("DROP TABLE IF EXISTS "+ Child.CHILD_TABLE_INFO);
        db.execSQL("DROP TABLE IF EXISTS "+ Parent.PARENT_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ Time.TIME_TABLE_NAME);
        onCreate(db);
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}
}
