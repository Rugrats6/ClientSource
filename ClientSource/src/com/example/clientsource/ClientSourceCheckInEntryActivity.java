package com.example.clientsource;


import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.Toast;

import com.example.clientsource.ClientSourceDatabase.Child;


//@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ClientSourceCheckInEntryActivity extends ClientSourceActivity implements
        LoaderManager.LoaderCallbacks<Cursor> {
    private static final int GALLERY_CURSOR_LOADER_ID = 0x1001;
    private static final String GALLERY_CURSOR_URI_ARG = "GALLERY_CURSOR_URI_ARG";
    protected Cursor mCursorAutoComplete;
    protected Cursor mThumbnailImagesCursor;

    private Gallery imagePickerGallery;
//    private ImageUriAdapter mGalleryAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // use this to note how the setImageURI method is bad
        /*StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll().penaltyFlashScreen().penaltyLog().build());
        
*/
        setContentView(R.layout.check_in);

        // Fill our Gallery from pictures available on the SD Card
//        setGalleryAdapter();

        // Fill AutoComplete word list from database
//        fillAutoComplete();

//        imagePickerGallery = (Gallery) findViewById(R.id.GalleryOfPics);

        // Handle Save Button
        final Button saveChild = (Button) findViewById(R.id.button1);
        saveChild.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final EditText parentlastName = (EditText) findViewById(R.id.EditparentlastName);
                final EditText childlastName = (EditText) findViewById(R.id.EditlastName);
                final EditText checkInDate = (EditText) findViewById(R.id.txtcheckInDate);
                final EditText checkinTime = (EditText) findViewById(R.id.txtcheckinTime);
                final EditText checkoutTime = (EditText) findViewById(R.id.txtcheckoutTime);
                
                Toast.makeText(ClientSourceCheckInEntryActivity.this,childlastName.getText().toString().toLowerCase()+" ---- "+childlastName.getText().toString(), Toast.LENGTH_SHORT).show();
                
                Toast.makeText(ClientSourceCheckInEntryActivity.this,parentlastName.getText().toString().toLowerCase()+" ---- "+parentlastName.getText().toString(), Toast.LENGTH_SHORT).show();
                
                String strchildlastName = childlastName.getText().toString().toLowerCase();
                String strparentlastName = parentlastName.getText().toString();
                String strcheckInDate = checkInDate.getText().toString();
                String strcheckinTime = checkinTime.getText().toString();
                String strcheckoutTime = checkoutTime.getText().toString();
                
                
                ChildRecord newRecord = new ChildRecord(childlastName,);
                updateChildRecord(newRecord);
                
                ParentRecord newParentRecord = new ParentRecord(parentlastName,);
                updateParentRecord(newParentRecord);
                
                TimeRecord newTimeRecord = new TimeRecord(checkInDate, checkinTime, checkoutTime,);
                updateTimeRecord(newRecord);
                
               // private String lastName; 
                //private String firstName; 
                //private String dateofBirth; 
                //private String seX;
                //private String ssNumber;
                //private String parentId;
               // private String timeId;
                
                // reset form
                parentlastName.setText(null);
                childlastName.setText(null);
                checkInDate.setText(null);
                checkinTime.setText(null);
                checkoutTime.setText(null);
            }
        });

//        // Handle Go to List button
//        final Button gotoList = (Button) findViewById(R.id.ButtonShowPets);
//        gotoList.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                // Go to other activity that displays pet list
//                Intent intent = new Intent(PetTrackerEntryActivity.this,
//                        PetTrackerListActivity.class);
//                startActivity(intent);
//            }
//        });
    }
protected void updateChildRecord(ChildRecord newRecord) {
		// TODO Auto-generated method stub
		
	}
protected void updateParentRecord(ParentRecord newParentRecord) {
		// TODO Auto-generated method stub
		
	}
protected void updateTimeRecord(TimeRecord newRecord) {
		// TODO Auto-generated method stub
		
	}
@Override
public Loader<Cursor> onCreateLoader(int id, Bundle args) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
	// TODO Auto-generated method stub
	
}
@Override
public void onLoaderReset(Loader<Cursor> loader) {
	// TODO Auto-generated method stub
}

// Save new records, since we're saving multiple records, let's do a
// transaction so it's all or nothing
mDB.beginTransaction();
try {

    // check if child name exists already
    long rowChildId = 0;

    // SQL Query -> "select * from table_pettype where
    // PetType.pettype_name='string'
    SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
    queryBuilder.setTables(Child.CHILD_TABLE_INFO);
    queryBuilder.appendWhere(Child.LAST_NAME + "='"
            + newRecord.getChildName() + "'");

    // run the query since it's all ready to go
    Cursor c = queryBuilder.query(mDB, null, null, null, null, null,
            null);

    if (c.getCount() == 0) {
        // add the new child to our list
        ContentValues typeRecordToAdd = new ContentValues();
        typeRecordToAdd.put(Child.FIRST_NAME,
                newRecord.getChildName());
        typeRecordToAdd.put(Child.LAST_NAME,
                newRecord.getChildLastName());
        rowChildId = mDB.insert(Child.CHILD_TABLE_INFO,
        		Child.FIRST_NAME, typeRecordToAdd);

    } else {
        // Type already exists, grab the row id to refer to below
        c.moveToFirst();
        rowChildId = c.getLong(c.getColumnIndex(Child._ID));
    }

    c.close();
    
    // update existing child records
    String strFilter = "_id=" + rowChildId;
    ContentValues childRecordToAdd = new ContentValues();
    childRecordToAdd.put(Child.FIRST_NAME, newRecord.getChildName());
    childRecordToAdd.put(Child.FIRST_NAME, newRecord.getChildName());
    mDB.update(Child.CHILD_TABLE_INFO, childRecordToAdd, strFilter, null);

    mDB.setTransactionSuccessful();
} finally {
    mDB.endTransaction();
}
}


    //
//    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//	private void setGalleryAdapter() {
//
//        // The base URI for SD Card content
//        Uri thumbnailUri = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
//
//        mGalleryAdapter = new ImageUriAdapter(this, null, false, thumbnailUri);
//
//        // Assign the adapter to our Gallery to display the images
//        final Gallery pictureGal = (Gallery) findViewById(R.id.GalleryOfPics);
//        pictureGal.setAdapter(mGalleryAdapter);
//
//        // use a loader to get the cursor and assign it to this adapter
//        Bundle args = new Bundle();
//        args.putString(GALLERY_CURSOR_URI_ARG, thumbnailUri.toString());
//        getLoaderManager().initLoader(GALLERY_CURSOR_LOADER_ID, args, this);
//    }
//
//    private void fillAutoComplete() {
//        mCursorAutoComplete = mDB.query(PetType.PETTYPE_TABLE_NAME,
//                new String[] { PetType.PET_TYPE_NAME, PetType._ID }, null,
//                null, null, null, PetType.DEFAULT_SORT_ORDER);
//
//        startManagingCursor(mCursorAutoComplete);
//
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
//                android.R.layout.simple_dropdown_item_1line,
//                mCursorAutoComplete, new String[] { PetType.PET_TYPE_NAME },
//                new int[] { android.R.id.text1 });
//
//        // I just want the text splatted into the edittext, not the textview
//        // object
//        // so I implemented a CursorToStringConverter and a FilterQueryProvider
//        // CursorToStringConverter - controls what "value" is returned when an
//        // AutoText option is chosen
//        // in this case, the text itself, not the id to the text
//        // FilterQueryProvider - interface to get control over the filtering
//        // process, which we implement a custom matching function
//        adapter.setCursorToStringConverter(new MyCursorToStringConverter());
//        adapter.setFilterQueryProvider(new MyFilterQueryProvider());
//
//        AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.EditTextSpecies);
//        text.setAdapter(adapter);
//
//    }
//
//    // This controls what column to place in the edittext when selected. The
//    // default textview.tostring, not helpful
//    class MyCursorToStringConverter implements
//            SimpleCursorAdapter.CursorToStringConverter {
//
//        public CharSequence convertToString(Cursor cursor) {
//            return cursor.getString(cursor
//                    .getColumnIndex(PetType.PET_TYPE_NAME));
//        }
//    }
//
//    // Our custom filter finds all substring matches, not just the beginning of
//    // the string, just for kicks
//    // There's a bit of a workaround here, since this function does not handle
//    // Cursor refreshing appropriately
//    class MyFilterQueryProvider implements FilterQueryProvider {
//
//        public Cursor runQuery(CharSequence constraint) {
//
//            if ((constraint != null) && (mCursorAutoComplete != null)) {
//                String strWhere = PetType.PET_TYPE_NAME + " LIKE ?";
//
//                stopManagingCursor(mCursorAutoComplete);
//                mCursorAutoComplete = mDB
//                        .query(PetType.PETTYPE_TABLE_NAME, new String[] {
//                                PetType.PET_TYPE_NAME, PetType._ID }, strWhere,
//                                new String[] { "%" + constraint.toString()
//                                        + "%" }, null, null,
//                                PetType.DEFAULT_SORT_ORDER);
//                startManagingCursor(mCursorAutoComplete);
//            }
//
//            return mCursorAutoComplete;
//        }
//    }
//
    // Add appropriate records to the database (Pet and Pet_Type)
    /*private void addChildRecord(ChildRecord newRecord) {

        // Save new records, since we're saving multiple records, let's do a
        // transaction so it's all or nothing
        mDB.beginTransaction();
        try {

            // check if child name exists already
            long rowChildId = 0;

            // SQL Query -> "select * from table_pettype where
            // PetType.pettype_name='string'
            SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
            queryBuilder.setTables(Child.CHILD_TABLE_INFO);
            queryBuilder.appendWhere(Child.FIRST_NAME + "='"
                    + newRecord.getLastName() + "'");

            // run the query since it's all ready to go
            Cursor c = queryBuilder.query(mDB, null, null, null, null, null,
                    null);

            if (c.getCount() == 0) {
                // add the new type to our list
                ContentValues typeRecordToAdd = new ContentValues();
                typeRecordToAdd.put(Child.FIRST_NAME,
                        newRecord.getLastName());
                rowChildId = mDB.insert(Child.CHILD_TABLE_INFO,
                		Child.FIRST_NAME, typeRecordToAdd);

            } else {
                // Type already exists, grab the row id to refer to below
                c.moveToFirst();
                rowChildId = c.getLong(c.getColumnIndex(Child._ID));
            }

            c.close();

            // Always insert new child records, even if the names clash
            ContentValues childRecordToAdd = new ContentValues();
            childRecordToAdd.put(Child.FIRST_NAME, newRecord.getLastName());
            childRecordToAdd.put(Child._ID, rowChildId);
            mDB.insert(Child.CHILD_TABLE_INFO, Child.FIRST_NAME, childRecordToAdd);

            mDB.setTransactionSuccessful();
        } finally {
            mDB.endTransaction();
        }*/
    

//    public class ImageUriAdapter extends CursorAdapter {
//
//        private int colIndexMediaId;
//        private final Uri baseUri;
//        private final int mGalleryItemBackground;
//
//        public ImageUriAdapter(Context context, Cursor c, boolean autoRequery,
//                Uri baseUri) {
//            super(context, c, autoRequery);
//            if (c != null) {
//                colIndexMediaId = c
//                        .getColumnIndex(MediaStore.Images.Thumbnails._ID);
//            }
//            this.baseUri = baseUri;
//            
//            TypedArray a = obtainStyledAttributes(R.styleable.default_gallery);
//            mGalleryItemBackground = a.getResourceId(R.styleable.default_gallery_android_galleryItemBackground, 0);
//            a.recycle();
//        }
//
//        @Override
//        public void bindView(View view, Context context, Cursor cursor) {
//            long id = cursor.getLong(colIndexMediaId);
//
//            // TODO: this should be done on a background thread; it blocks
//            Uri imageUri = Uri.withAppendedPath(baseUri, String.valueOf(id));
//            ((ImageView) view).setImageURI(imageUri);
//            view.setTag(imageUri);
//        }
//
//        @Override
//        public View newView(Context context, Cursor cursor, ViewGroup parent) {
//            ImageView imageView = new ImageView(context);
//            long id = cursor.getLong(colIndexMediaId);
//
//            // TODO: this should be done on a background thread; it blocks
//            Uri imageUri = Uri.withAppendedPath(baseUri, String.valueOf(id));
//            imageView.setImageURI(imageUri);
//
//            // Constrain the images so they all look the same size/ratio
//            imageView.setLayoutParams(new Gallery.LayoutParams(
//                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
//
//            imageView.setTag(imageUri);
//            
//            imageView.setBackgroundResource(mGalleryItemBackground);
//
//            return imageView;
//        }
//
//        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
//		@Override
//        public Cursor swapCursor(Cursor newCursor) {
//            if (newCursor != null) {
//                colIndexMediaId = newCursor
//                        .getColumnIndex(MediaStore.Images.Thumbnails._ID);
//            }
//            return super.swapCursor(newCursor);
//        }
//    }
//
//    @Override
//    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
//        switch (id) {
//        case GALLERY_CURSOR_LOADER_ID:
//            // An array specifying which columns to return.
//            String[] projection = new String[] { MediaStore.Images.Thumbnails._ID };
//
//            // The base URI for SD Card content
//            Uri thumbnailUri = Uri
//                    .parse(args.getString(GALLERY_CURSOR_URI_ARG));
//
//            // thumbnails of all external images in the media store
//            // Best way to retrieve a cursor; performs operation on a background
//            // thread
//            CursorLoader loader = new CursorLoader(this, thumbnailUri,
//                    projection, null, null,
//                    MediaStore.Images.Thumbnails.DEFAULT_SORT_ORDER
//                            //+ " limit 50"
//                            );
//            return loader;
//        }
//
//        return null;
//
//    }
//
//    @Override
//    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
//        switch (cursorLoader.getId()) {
//        case GALLERY_CURSOR_LOADER_ID:
//            mGalleryAdapter.swapCursor(cursor);
//            break;
//        }
//
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Cursor> cursorLoader) {
//        switch (cursorLoader.getId()) {
//        case GALLERY_CURSOR_LOADER_ID:
//            mGalleryAdapter.swapCursor(null);
//            break;
//        }
//    }
}

