package com.nisha.calendarviewattendanse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnDateSelectedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.util.Calendar;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    // Initialize variable
    CustomCalendar customCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign variable
        customCalendar=findViewById(R.id.custom_calendar);

        // Initialize description hashmap
        HashMap<Object, Property> descHashMap=new HashMap<>();

        // Initialize default property
        Property defaultProperty=new Property();

        // Initialize default resource
        defaultProperty.layoutResource=R.layout.default_view;

        // Initialize and assign variable
        defaultProperty.dateTextViewResource=R.id.text_view;

        // Put object and property
        descHashMap.put("default",defaultProperty);

        // for current date
        Property currentProperty=new Property();
        currentProperty.layoutResource=R.layout.current_view;
        currentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("current",currentProperty);

        // for present date
        Property presentProperty=new Property();
        presentProperty.layoutResource=R.layout.present_view;
        presentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("present",presentProperty);

        // For absent
        Property absentProperty =new Property();
        absentProperty.layoutResource=R.layout.absent_view;
        absentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("absent",absentProperty);

        // set desc hashmap on custom calendar
        customCalendar.setMapDescToProp(descHashMap);

        // Initialize date hashmap
        HashMap<Integer,Object> dateHashmap=new HashMap<>();

        // initialize calendar
        Calendar calendar=  Calendar.getInstance();

        // Put values
        dateHashmap.put(calendar.get(Calendar.DAY_OF_MONTH),"current");
        dateHashmap.put(1,"present");
        dateHashmap.put(2,"absent");
        dateHashmap.put(3,"present");
        dateHashmap.put(4,"absent");
        dateHashmap.put(20,"present");
        dateHashmap.put(30,"absent");

        // set date
        customCalendar.setDate(calendar,dateHashmap);

        customCalendar.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(View view, Calendar selectedDate, Object desc) {
                // get string date
                String sDate=selectedDate.get(Calendar.DAY_OF_MONTH)
                        +"/" +(selectedDate.get(Calendar.MONTH)+1)
                        +"/" + selectedDate.get(Calendar.YEAR);

                // display date in toast
                Toast.makeText(getApplicationContext(),sDate, Toast.LENGTH_SHORT).show();
            }
        });
    }

}