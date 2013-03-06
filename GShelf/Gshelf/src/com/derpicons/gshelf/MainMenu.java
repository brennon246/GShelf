package com.derpicons.gshelf;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_menu, menu);
		return true;
	}
	

	public void dealsClicked(View v)
	{
		Toast.makeText(this, "Deals Clicked", Toast.LENGTH_SHORT).show();
	}
	public void libraryClicked(View v)
	{
		Toast.makeText(this, "Library Clicked", Toast.LENGTH_SHORT).show();

	}
	public void settingsClicked(View v)
	{
		Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();

	}
	public void tradeClicked(View v)
	{
		Toast.makeText(this, "Trade Clicked", Toast.LENGTH_SHORT).show();

	}
	public void anchorClicked(View v)
	{
		
		String aString = "You think you fly I know you not";
		Toast.makeText(this, aString, Toast.LENGTH_SHORT).show();

	}


}
