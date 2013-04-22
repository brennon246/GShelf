package com.derpicons.gshelf;

import java.sql.Date;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddDeal extends Activity {

	private String Username;
	private int UserKey;
	private ArrayList<Integer> GameKeys;
	private ArrayList<Games> SelectedGames;
	private Context ctx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_deal);
		
		ctx = this;
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
				startActivityForResult(i, 1);
			}
		});
		
		Submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String src = Source.getText().toString();
				String des = Description.getText().toString();
				boolean complete = true;
				
				if (src.length() == 0) {
					SourceText.setTextColor(Color.RED);
					complete = false;
				} else
					SourceText.setTextColor(Color.WHITE);
				if (des.length() == 0) {
					DescriptionText.setTextColor(Color.RED);
					complete = false;
				} else
					DescriptionText.setTextColor(Color.WHITE);
				if(complete)
				{
					//Add deal
					Date exp = new Date(2015, 3, 2);
					if(GameKeys != null)
					{
						new Network(ctx).addToDeals(GameKeys, src, des, UserKey, exp);
						finish();
					}
				}
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if (resultCode == Activity.RESULT_OK) {
	        ArrayList<Integer> Selected = data.getIntegerArrayListExtra("SelectedGames");
	        GameKeys = Selected;	        
	        // load the game objects
	    }
	}

}
