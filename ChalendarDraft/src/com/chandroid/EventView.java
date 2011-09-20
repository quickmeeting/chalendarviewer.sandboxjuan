package com.chandroid;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EventView extends TextView {

	public EventView(Context context) {
		this(context, "UNKNOWN");
	}
	
	public EventView(Context context, String text) {
		super(context);
	    if("LIBRE".equalsIgnoreCase(text)) setTextSize(40);
	    else setTextSize(20);	    
	    setTextColor(Color.BLACK);
	    setGravity(Gravity.CENTER);
	    
	    //setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
	    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
	    lp.bottomMargin = 10;
	    setLayoutParams(lp);

	    setBackgroundDrawable(getResources().getDrawable(R.drawable.event_background));
	    setText(text);
	}

}
