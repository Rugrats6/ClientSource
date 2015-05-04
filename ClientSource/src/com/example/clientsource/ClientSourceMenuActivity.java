package com.example.clientsource;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
 
public class ClientSourceMenuActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_client_source);
    }
     
    // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu_client_source, menu);
        return true;
    }
     
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
         
        switch (item.getItemId())
        {
        case R.id.menu_add:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            Toast.makeText(ClientSourceMenuActivity.this, "Add is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_save:
            Toast.makeText(ClientSourceMenuActivity.this, "Save is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_search:
            Toast.makeText(ClientSourceMenuActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_help:
            Toast.makeText(ClientSourceMenuActivity.this, "Help is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_upload:
            Toast.makeText(ClientSourceMenuActivity.this, "Upload is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_more:
            Toast.makeText(ClientSourceMenuActivity.this, "More is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }    
 
}