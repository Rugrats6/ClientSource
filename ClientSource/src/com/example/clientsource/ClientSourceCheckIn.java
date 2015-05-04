package com.example.clientsource;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class ClientSourceCheckIn extends Activity implements
       OnClickListener {

   // Widget GUI
   Button btnCalendar, btnTimePicker;
   EditText txtDate, txtTime;

   // Variable for storing current date and time
   private int mYear, mMonth, mDay, mHour, mMinute;

   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.check_in);

       btnCalendar = (Button) findViewById(R.id.btnCalendar);
       btnTimePicker = (Button) findViewById(R.id.btnTimePicker);

       txtDate = (EditText) findViewById(R.id.txtDate);
       txtTime = (EditText) findViewById(R.id.txtTime);

       btnCalendar.setOnClickListener(this);
       btnTimePicker.setOnClickListener(this);
   }

   @Override
   public void onClick(View v) {

       if (v == btnCalendar) {

           // Process to get Current Date
           final Calendar c = Calendar.getInstance();
           mYear = c.get(Calendar.YEAR);
           mMonth = c.get(Calendar.MONTH);
           mDay = c.get(Calendar.DAY_OF_MONTH);

           // Launch Date Picker Dialog
           DatePickerDialog dpd = new DatePickerDialog(this,
                   new DatePickerDialog.OnDateSetListener() {

                       @Override
                       public void onDateSet(DatePicker view, int year,
                               int monthOfYear, int dayOfMonth) {
                           // Display Selected date in textbox
                           txtDate.setText(dayOfMonth + "-"
                                   + (monthOfYear + 1) + "-" + year);

                       }
                   }, mYear, mMonth, mDay);
           dpd.show();
       }
       if (v == btnTimePicker) {

           // Process to get Current Time
           final Calendar c = Calendar.getInstance();
           mHour = c.get(Calendar.HOUR_OF_DAY);
           mMinute = c.get(Calendar.MINUTE);

           // Launch Time Picker Dialog
           TimePickerDialog tpd = new TimePickerDialog(this,
                   new TimePickerDialog.OnTimeSetListener() {

                       @Override
                       public void onTimeSet(TimePicker view, int hourOfDay,
                               int minute) {
                           // Display Selected time in textbox
                           txtTime.setText(hourOfDay + ":" + minute);
                       }
                   }, mHour, mMinute, false);
           tpd.show();
       }
   }
}