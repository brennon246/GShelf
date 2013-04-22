package com.derpicons.gshelf;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class AddDeal extends Activity {

	private String Username;
	private int UserKey;
	private ArrayList<Integer> GameKeys;
	private ArrayList<Game> SelectedGames;
	private Context ctx;
	private ListView listViewGames;
	private SearchListAdapter SelectedSearchListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_deal);

		ctx = this;
		final EditText Description = (EditText) findViewById(R.id.editTextDescription);
		final EditText Source = (EditText) findViewById(R.id.editTextSource);
		final TextView DescriptionText = (TextView) findViewById(R.id.textViewDescription);
		final EditText ExpDate = (EditText) findViewById(R.id.editTextExpirationDate);
		final TextView ExpDateText = (TextView) findViewById(R.id.textViewExpirationDate);
		final TextView SourceText = (TextView) findViewById(R.id.textViewSource);
		Button AddGames = (Button) findViewById(R.id.buttonAdd);
		Button Submit = (Button) findViewById(R.id.buttonSubmit);
		listViewGames = (ListView) findViewById(R.id.games_added_list);
		listViewGames.setClickable(true);
		SelectedGames = new ArrayList<Game>();

		// SelectedGames.add(new Game("Dino Chase", "Chase dinos around"));
		// SelectedGames.add(new Game("Half Life 4", "They just skipped 3"));
		// SelectedGames.add(new Game("Rock Band", "Rock your socks off"));
		// SelectedGames.add(new Game("Blah", "Blah blah blah"));
		// SelectedGames.add(new Game("Disco", "Dance"));
		// SelectedGames.add(new Game("Thermonuclear Warfare",
		// "There is only one winning move"));
		// listViewGames.setAdapter(new SearchListAdapter(ctx,
		// R.layout.result_item, SelectedGames));
		SelectedSearchListAdapter = new SearchListAdapter(ctx,
				R.layout.result_item, SelectedGames);
		listViewGames.setAdapter(SelectedSearchListAdapter);
		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		UserKey = intent.getIntExtra("UKey", 0);
		if (intent.hasExtra("GameKeyArray")) {
			GameKeys = intent.getIntegerArrayListExtra("GameKeyArray");
		}
		// Use network call to get games from keylist

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
				String exp = ExpDate.getText().toString();
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
				if (exp.length() == 0) {
					ExpDateText.setTextColor(Color.RED);
					complete = false;
				} else
					ExpDateText.setTextColor(Color.WHITE);
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				java.util.Date dateObject = new java.util.Date();
				try {
					dateObject = formatter.parse(exp);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					ExpDateText.setTextColor(Color.RED);
					complete = false;
				}
				
				if (complete) {
					// Add deal
					java.sql.Date expD = new java.sql.Date(dateObject.getTime());
					//Date exp1 = new Date(2015, 3, 2);
					if (GameKeys != null) {
						// new Network(ctx).addToDeals(GameKeys, src, des,
						// UserKey, expD);
						// finish();
					}
				}
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == Activity.RESULT_OK) {
			ArrayList<Integer> Selected = data
					.getIntegerArrayListExtra("SelectedGames");
			GameKeys = Selected;
			// load the game objects
			for (Integer item : Selected) {
				SelectedGames.add(new Network(ctx).getGame(item.intValue()));
			}
			SelectedSearchListAdapter.notifyDataSetChanged();

		}
	}
}
