package com.chandroid;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

public class ChalendarDraftActivity extends Activity implements OnClickListener {
	
	private ArrayList<CalendarView> calendars = new ArrayList<CalendarView>();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainLayout = new LinearLayout(this);  
        mainLayout.setOrientation(LinearLayout.HORIZONTAL);  
        mainLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));      
        
        //calendars.add(0, (LinearLayout)this.getLayoutInflater().inflate(R.layout.calendar_1, mainLayout, false));
        //calendars.add(1, (LinearLayout)this.getLayoutInflater().inflate(R.layout.calendar_2, mainLayout, false));
        //calendars.add(2, (LinearLayout)this.getLayoutInflater().inflate(R.layout.calendar_3, mainLayout, false));
        //calendars.add(3, (LinearLayout)this.getLayoutInflater().inflate(R.layout.calendar_4, mainLayout, false));
        
        calendars.add(new CalendarView(this, "Sala 1"));
        calendars.add(new CalendarView(this, "Sala 2"));
        calendars.add(new CalendarView(this, "Sala 3"));
        calendars.add(new CalendarView(this, "Sala 4"));
        
        for(LinearLayout l: calendars) {
        	mainLayout.addView(l);
        }
        
        calendars.get(0).addEvent(new EventView(this, "8:00 - 10:00 \nP-722: Revisi—n"));
        calendars.get(0).addEvent(new EventView(this, "LIBRE"));
        calendars.get(1).addEvent(new EventView(this, "LIBRE"));
        calendars.get(2).addEvent(new EventView(this, "9:20 - 11:20 \nReuni—n de R-Team"));   
        calendars.get(2).addEvent(new EventView(this, "12:20 - 13:30 \nReuni—n de Jefes de proyectos (peri—dica)"));
        calendars.get(3).addEvent(new EventView(this, "8:00 - 15:00 \nSr. Ruesga"));
        
        setContentView(mainLayout);
        
        mainLayout.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
        TextView tv = (TextView) this.getLayoutInflater().inflate(R.layout.event, calendars.get(3), false);
        tv.setText("Event inserted!");
        calendars.get(3).removeAllEvents();
        EventView tv2 = new EventView(this, "Event inserted!");
        calendars.get(3).addEvent(tv2);
	}
}