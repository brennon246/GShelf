package com.derpicons.gshelf;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class AddDeal extends Activity {

	private String Username;
	private int UserKey;
	private ArrayList<Integer> GameKeys;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_deal);
		
		final EditText Description = (EditText) findViewById(R.id.editTextDescription);
		final EditText Source = (EditText) findViewById(R.id.editTextSource);
		final TextView DescriptionText = (TextView) findViewById(R.id.textViewDescription);
		final TextView SourceText = (TextView) findViewById(R.id.textViewSource);
		Button AddGames = (Button) findViewById(R.id.buttonAdd);
		Button Submit = (Button) findViewById(R.id.buttonSubmit);
		
		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		UserKey = intent.getIntExtra("UKey", 0);
		if(intent.hasExtra("GameKeyArray"))
		{
			GameKeys = intent.getIntegerArrayListExtra("GameKeyArray");
		}
		//Use network call to get games from keylist
		
		AddGames.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(getApplicationContext(), DSearch.class);
				startActivity(i);
			}
		});
		
		Submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(getApplicationContext(), DealsView.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.add_deal, menu);
		return true;
	}

}
