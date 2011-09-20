package com.chandroid;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalendarView extends LinearLayout {

	private String calendarId;
	private TextView title;
	private LinearLayout eventContainer;
	
	public CalendarView(Context context) {
		this(context, "UNKOWN");
	}
	
	public CalendarView(Context context, String calendarId) {
		super(context);
		this.calendarId = calendarId;
		
		setOrientation(LinearLayout.VERTICAL);  
		setGravity(Gravity.CENTER);
		LinearLayout.LayoutParams calendarParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
	    calendarParams.weight = .25f;
	    calendarParams.leftMargin = 5;
	    calendarParams.rightMargin = 5;
	    setLayoutParams(calendarParams);
		
	    title = new TextView(context);
	    title.setTextSize(50);
	    title.setText(calendarId);
	    title.setGravity(Gravity.CENTER);
	    LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
	    titleParams.bottomMargin = 10;
	    title.setLayoutParams(titleParams);
	    
	    eventContainer = new LinearLayout(context);
	    eventContainer.setBackgroundDrawable(getResources().getDrawable(R.drawable.calendar_background));
	    eventContainer.setOrientation(LinearLayout.VERTICAL); 
	    LinearLayout.LayoutParams eventContainerParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
	    eventContainerParams.weight = .25f;
	    eventContainerParams.leftMargin = 5;
	    eventContainerParams.rightMargin = 5;
	    eventContainer.setLayoutParams(eventContainerParams);
	    
	    addView(title);
	    addView(eventContainer);
	}
	
	public String getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(String id) {
		this.calendarId = id;
	}

	public void addEvent(EventView child) {
		eventContainer.addView(child);
	}
	
	public void removeAllEvents() {
		eventContainer.removeAllViews();
	}

}
