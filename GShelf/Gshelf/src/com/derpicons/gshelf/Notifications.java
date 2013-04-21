package com.derpicons.gshelf;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Notifications extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notifications);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.notifications, menu);
		return true;
	}

}
