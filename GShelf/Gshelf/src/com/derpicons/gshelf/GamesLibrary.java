package com.derpicons.gshelf;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class GamesLibrary extends Base_Activity {

	private ListView listViewGames;
	private Context ctx;
	private SearchListAdapter SelectedSearchListAdapter;
	private String Username;
	private int Userkey;
	private Games LGames;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_games_library);
		ctx = this;

		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);

		// Get list of games

		ArrayList<Game> AGames = new ArrayList<Game>();
		LocalDatabase LD = new LocalDatabase(ctx);
		AGames = LD.getGamesFromDb(Userkey);
		LD.close();

		LGames = new Games(AGames);

		// Display list of games
		listViewGames = (ListView) findViewById(R.id.game_item);
		SelectedSearchListAdapter = new SearchListAdapter(ctx,
				R.layout.result_item, LGames.getShowGames());
		listViewGames.setAdapter(SelectedSearchListAdapter);

		listViewGames.setClickable(true);

		listViewGames.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

				// Toast.makeText(getApplicationContext(),
				// "Click GameItemNumber " + position, Toast.LENGTH_LONG)
				// .show();
				// Takes user to GameView page with required data.

				Intent i = new Intent(getApplicationContext(), GameInfo.class);
				i.putExtra("GameKey", LGames.getShowGames().get(position)
						.getKey());
				i.putExtra("UserName", Username);
				i.putExtra("UKey", Userkey);
				startActivity(i);

			}
		});

		// Button Search = (Button) findViewById(R.id.Search);
		/*
		 * Search Function
		 * 
		 * Search.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { // TODO Auto-generated method
		 * stub
		 * 
		 * String Type = "title"; final EditText SearchEditText = (EditText)
		 * findViewById(R.id.Search);
		 * 
		 * String LSearch = SearchEditText.getText().toString() .toLowerCase();
		 * Type.toLowerCase();
		 * 
		 * if (LSearch.length() != 0) { Tag SearchTag = new Tag(LSearch, Type);
		 * LGames.Search(SearchTag); } else { LGames.Refresh(); } } });
		 */
	}

	@Override
	protected void onResume() {
		super.onResume();
	
		ArrayList<Game> AGames = new ArrayList<Game>();
		LocalDatabase LD = new LocalDatabase(ctx);
		AGames = LD.getGamesFromDb(Userkey);
		LD.close();
		LGames.setShowGames(AGames);
		if(LGames.getShowGames() != null)
		{
			SelectedSearchListAdapter.notifyDataSetChanged();
		}
		

	}

}
