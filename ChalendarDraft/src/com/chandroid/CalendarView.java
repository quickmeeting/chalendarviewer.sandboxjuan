package com.chandroid;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * CalendarView encapsula la vista de un calendario. Basicamente es un LinearLayout 
 * que contiene el nombre del calendario (ej.'Sala 1') y el contenedor de eventos 
 * del calendario.
 * 
 * @author juanlafuente
 */
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
		title = new TextView(context);
		eventContainer = new LinearLayout(context);
	    addView(title);
	    addView(eventContainer);		
	}
	
	public String getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(String id) {
		this.calendarId = id;
	}

	/**
	 * A–ade un evento al final de un contenedor de eventos.
	 * 
	 * @param child
	 */
	public void addEvent(EventView child) {
		eventContainer.addView(child);
	}
	
	/**
	 * Borra todos los eventos de un calendario.
	 */
	public void removeAllEvents() {
		eventContainer.removeAllViews();
	}
	
	/**
	 * Define la apariencia de cada calendario.
	 * 
	 * @param weight: anchura del calendario en relaci—n a la pantalla.
	 */
	public void setStyle(float weight) {
		//Se configura la apariencia del CalendarView
		setOrientation(LinearLayout.VERTICAL);  
		setGravity(Gravity.CENTER);
		LinearLayout.LayoutParams calendarParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
	    calendarParams.weight = .25f;
	    calendarParams.leftMargin = 5;
	    calendarParams.rightMargin = 5;
	    setLayoutParams(calendarParams);
		
	    //Se configura el titulo del calendario: Sala X ;-)
	    title.setTextSize(50);
	    title.setText(calendarId);
	    title.setGravity(Gravity.CENTER);
	    LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
	    titleParams.bottomMargin = 10;
	    title.setLayoutParams(titleParams);
	    
	    //Se configura la apariencia del contenedor de eventos
	    eventContainer.setBackgroundDrawable(getResources().getDrawable(R.drawable.calendar_background));
	    eventContainer.setOrientation(LinearLayout.VERTICAL); 
	    LinearLayout.LayoutParams eventContainerParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
	    eventContainerParams.weight = weight;
	    eventContainerParams.leftMargin = 5;
	    eventContainerParams.rightMargin = 5;
	    eventContainer.setLayoutParams(eventContainerParams);
	}

}
