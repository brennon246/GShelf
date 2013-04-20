package com.derpicons.gshelf;

import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class Base_Activity extends Activity 
{

	private final String TAG = "Base_Activity";
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case R.id.action_search:
			Log.i(TAG, "Action Search Clicked");
			return true;
			
		case R.id.action_settings:
			Log.i(TAG, "Action Settings Clicked");
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	//return true;	
	}
	
	
}
