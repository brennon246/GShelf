package com.derpicons.gshelf;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GamesLibrary extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_games_library);

		// Get list of games
		
		final ArrayList<Game> AGames = new ArrayList<Game>();
		final Games LGames = new Games(AGames);
		
		// Display list of games

		Button LGame = (Button) findViewById(R.id.LGame);
		Button Search = (Button) findViewById(R.id.Search);

		LGame.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// Will bring user to the games page sending games info

				int index = 1;

				// Intent i = new Intent(getApplicationContext(),
				// GameView.class);
				Intent i = new Intent(getApplicationContext(), Login.class);
				i.putExtra("key", LGames.getShowGames().get(index).getKey());
				i.putExtra("title", LGames.getShowGames().get(index).getTitle());
				i.putExtra("platform", LGames.getShowGames().get(index).getPlatform());
				i.putExtra("overview", LGames.getShowGames().get(index).getOverview());
				i.putExtra("genre", LGames.getShowGames().get(index).getGenre());
				i.putExtra("developer", LGames.getShowGames().get(index).getDeveloper());
				startActivity(i);
			}
		});

		Search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String Type = "title";
				final EditText SearchEditText = (EditText) findViewById(R.id.Search);

				String LSearch = SearchEditText.getText().toString()
						.toLowerCase();
				Type.toLowerCase();

				if (LSearch.length() != 0) {
					Tag SearchTag = new Tag(LSearch, Type);
					LGames.Search(SearchTag);
				} else {
					LGames.Refresh();
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.games_library, menu);
		return true;
	}

}
