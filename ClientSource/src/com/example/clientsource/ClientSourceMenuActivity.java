package com.example.clientsource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
 
public class ClientSourceMenuActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
        case R.id.menu_child_entry:
            // Single menu item is selected do something
            // Ex: launching new activity/screen or show alert message
            Toast.makeText(ClientSourceMenuActivity.this, "Child Entry is Selected", Toast.LENGTH_SHORT).show();
            // Go to the other activity that displays the child's information.
            Intent intentChildEntry = new Intent(this, ClientSourceEntryActivity.class);
            startActivity(intentChildEntry);
            return true;
 
        case R.id.menu_check_in:
            Toast.makeText(ClientSourceMenuActivity.this, "Check In is Selected", Toast.LENGTH_SHORT).show();
            // Go to the other activity that displays the child's information.
            Intent intentCheckIn = new Intent(this, ClientSourceEntryActivity.class);
            startActivity(intentCheckIn);
            return true;
 
        case R.id.menu_check_out:
            Toast.makeText(ClientSourceMenuActivity.this, "Check Out is Selected", Toast.LENGTH_SHORT).show();
            // Go to the other activity that displays the child's information.
            Intent intentCheckOut = new Intent(this, ClientSourceEntryActivity.class);
            startActivity(intentCheckOut);
            return true;
 
        case R.id.menu_search:
            Toast.makeText(ClientSourceMenuActivity.this, "Search is Selected", Toast.LENGTH_SHORT).show();
            // Go to the other activity that displays the child's information.
            Intent intentSearch = new Intent(this, ClientSourceEntryActivity.class);
            startActivity(intentSearch);
            return true;
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }    
 
}