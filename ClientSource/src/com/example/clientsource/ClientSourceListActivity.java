/*package com.example.clientsource;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.clientsource.ClientSourceDatabase.Child;
import com.example.clientsource.ClientSourceDatabase.Parent;
import com.example.clientsource.ClientSourceDatabase.Time;

public class ClientSourceListActivity extends ClientSourceActivity {


	protected Cursor mCursor;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.showchilds);
		
		// Fill ListView from database
		
		fillChildList();
		
		// Handle Go enter more pets button
		final Button gotoEntry = (Button) findViewById(R.id.ButtonEnterMoreKids);
		gotoEntry.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// We're done here. Finish and return to the entry screen
				finish();
			}
		});
	}

	public void fillChildList() {
	
		// SQL Query
		SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
		queryBuilder.setTables(Child.CHILD_TABLE_INFO + ", "
				+ Parent.PARENT_TABLE_NAME + ", " + Time.TIME_TABLE_NAME);
		queryBuilder.appendWhere(Child.CHILD_TABLE_INFO + "."
				+ Child.CHILD_ID + "=" + Parent.PARENT_ID + "."
				+ Parent._ID);

		// Get the database and run the query
		String asColumnsToReturn[] = {
				Child.CHILD_TABLE_INFO + "." + Child.LAST_NAME,
				Child.CHILD_TABLE_INFO + "." + Child.FIRST_NAME,
				Child.CHILD_TABLE_INFO + "." + Child._ID,
				Child.CHILD_TABLE_INFO + "." + Child.DATEOF_BIRTH,
				Child.CHILD_TABLE_INFO + "." + Child.SEX,
				Child.CHILD_TABLE_INFO + "." + Child.SS_NUMBER,
				
				Parent.PARENT_TABLE_NAME + "." + Parent.LAST_NAME,
				Parent.PARENT_TABLE_NAME + "." + Parent.FIRST_NAME,
				Parent.PARENT_TABLE_NAME + "." + Parent.DATEOF_BIRTH,
				Parent.PARENT_TABLE_NAME + "." + Parent.SEX,
				Parent.PARENT_TABLE_NAME + "." + Parent.SS_NUMBER,
				Parent.PARENT_TABLE_NAME + "." + Parent.PHONE_NUMBER,
				Parent.PARENT_TABLE_NAME + "." + Parent._ID,
		};
		
		mCursor = queryBuilder.query(mDB, asColumnsToReturn, null, null,
				null, null, Child.DEFAULT_SORT_ORDER);
		startManagingCursor(mCursor);
		
		
		// Use an adapter to bind the data to a ListView, where each item is
				// shown as a pet_item layout
		        ChildListAdapter adapter = new ChildListAdapter(this, mCursor, false);	
				ListView av = (ListView) findViewById(R.id.petList);
				av.setAdapter(adapter);
				
				
				// Listen for clicks on our ListView
				av.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						
						final long deleteChildId = id;

						// Use an Alert dialog to confirm delete operation
						new AlertDialog.Builder(ClientSourceListActivity.this).setMessage(
								"Delete Child Record?").setPositiveButton("Delete",
								new DialogInterface.OnClickListener() {

									public void onClick(DialogInterface dialog,
											int which) {

										// Delete that pet
										deleteChild(deleteChildId);
										// refresh our listview with a cursor requery
										refillChildList(); 
									}
								}).show();
					}
				});
			}

	
	// We refresh our ListAdapter as necessary
		public void refillPetList() {
			
			mCursor.requery();
			ChildListAdapter adapter = new ChildListAdapter(this, mCursor, false);
			ListView av = (ListView) findViewById(R.id.childList);
			av.setAdapter(adapter);

		}
		
		
		// Delete a pet by id
		public void deletePet(Long id) {
			String astrArgs[] = { id.toString() };
			mDB.delete(Child.CHILD_TABLE_INFO, Child._ID + "=?", astrArgs);
		}
		
		
		
		public class ChildListAdapter extends CursorAdapter {
		    
		    private final int colIndexPetType;
		    private final int colIndexPetName;
		    private final int colIndexPetImageUri;
		    private final LayoutInflater inflater;

	        public ChildListAdapter(Context context, Cursor c, boolean autoRequery) {
	            super(context, c, autoRequery);
	            colIndexPetType = c.getColumnIndex(Parent.PARENT_TABLE_NAME);
	            colIndexPetName = c.getColumnIndex(Child.LAST_NAME);
	            colIndexPetImageUri = c.getColumnIndex(Child.FIRST_NAME);
	            
	            inflater = (LayoutInflater)context.getSystemService
	                    (Context.LAYOUT_INFLATER_SERVICE);
	        }

			@Override
			public void bindView(View view, Context context, Cursor cursor) {
				// TODO Auto-generated method stub
				
				
				RelativeLayout childItem = (RelativeLayout) view;
	            ChildListItemContainer petItemHolder = (ChildListItemContainer)childItem.getTag();
	            setchildItem(cursor, petItemHolder);
			}
			
			

			@Override
			public View newView(Context context, Cursor cursor, ViewGroup parent) {
				// TODO Auto-generated method stub
				
				RelativeLayout childItem = (RelativeLayout) inflater.inflate(R.layout.child_item, parent, false);
	            ChildListItemContainer childViewHolder = new ChildListItemContainer();
	            childViewHolder = new ChildListItemContainer();
	            childViewHolder.lastNameView = (TextView) childItem.findViewById(R.id.TextView_LastName);
	            //childViewHolder.petTypeView = (TextView) childItem.findViewById(R.id.TextView_Parent);
	            
	            childItem.setTag(childViewHolder);
	            
	            setChildItem(cursor, childViewHolder);
	            
				return childItem;
			}

			private void setChildItem(Cursor cursor, ChildListItemContainer childItemHolder) {
	            String lastName = cursor.getString(colIndexLastName);
	            String firstName = cursor.getString(colIndexFirstName);
	            //String petImageUri = cursor.getString(colIndexPetImageUri);
	            
	            Child.CHILD_TABLE_INFO + "." + Child.LAST_NAME,
				Child.CHILD_TABLE_INFO + "." + Child.FIRST_NAME,
				Child.CHILD_TABLE_INFO + "." + Child._ID,
				Child.CHILD_TABLE_INFO + "." + Child.DATEOF_BIRTH,
				Child.CHILD_TABLE_INFO + "." + Child.SEX,
				Child.CHILD_TABLE_INFO + "." + Child.SS_NUMBER,

	            
	            childItemHolder.lastNameView.setText(lastName);
	            childItemHolder.firstNameView.setText(firstName);
	            // TODO: this should be done on a background thread, setImageURI blocks
	           // petItemHolder.petImageView.setImageURI(Uri.parse(petImageUri));
	        }

				
			private class ChildListItemContainer  {
	            TextView firstNameView; 
	            TextView lastNameView; 
	            //ImageView petImageView; 	
				
		
	}
		}
}


*/