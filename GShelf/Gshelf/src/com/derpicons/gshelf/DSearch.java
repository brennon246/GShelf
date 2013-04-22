package com.derpicons.gshelf;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

public class DSearch extends Base_Activity {

	private ListView listViewGames;
	private Context ctx;
	private ArrayList<Game> AGames;
	private ArrayList<Integer> SelectedGames;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu
		getMenuInflater().inflate(R.menu.search, menu);

		return true;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dsearch);

		// ActionBar actionBar = getActionBar();
		// actionBar.setDisplayHomeAsUpEnabled(true);

		SelectedGames = new ArrayList<Integer>();
		final EditText SearchText = (EditText) findViewById(R.id.editTextSearch);
		Button SearchButton = (Button) findViewById(R.id.buttonSearch);
		Button AddDeal = (Button) findViewById(R.id.buttonDeal);
		ctx = this;

		Intent intent = getIntent();
		String Username = intent.getStringExtra("UserName");
		int Userkey = intent.getIntExtra("UKey", 0);

		// ArrayList<Game> AGames = new ArrayList<Game>();

		// Display list of games
		listViewGames = (ListView) findViewById(R.id.result_item);
		listViewGames.setClickable(true);

		// Display list of games

		SearchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String search = SearchText.getText().toString();
				AGames = new ArrayList<Game>();
				if (search.length() != 0) {
					AGames = new Network(ctx).getGames(search);
				}
				listViewGames.setAdapter(new SearchListAdapter(ctx,
						R.layout.dresult_item, AGames));

			}
		});

		listViewGames.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

				CheckBox cBox = (CheckBox) view.findViewById(R.id.RCheckBox);
				cBox.toggle();
				if (cBox.isActivated()) {
					SelectedGames
							.add(new Integer(AGames.get(position).getKey()));
				} else {
					SelectedGames.remove(new Integer(AGames.get(position)
							.getKey()));
				}
			}
		});

		AddDeal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult(Activity.RESULT_OK,
						new Intent().putExtra("SelectedGames", SelectedGames));
				finish();

			}
		});

	}

}
