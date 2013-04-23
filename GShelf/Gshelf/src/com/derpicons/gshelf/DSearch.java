package com.derpicons.gshelf;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class DSearch extends Activity {

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
				if (cBox.isChecked()) {
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

	private final String TAG = "Base_Activity";
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case R.id.action_search:
			Log.i(TAG, "Action Search Clicked");
			
			Intent i = new Intent(getApplicationContext(), SearchActivity.class);
			startActivity(i);

			return true;
			
		case R.id.action_settings:
			Log.i(TAG, "Action Settings Clicked");
			return true;
			
		case R.id.action_logout:
			Log.i(TAG, "Action Logout Clicked");
			
			//delete shared preferences
			SharedPreferences settings = getSharedPreferences("GSHELF_LOGIN", Activity.MODE_PRIVATE);
			SharedPreferences.Editor editor = settings.edit();
				editor.remove("username");
				editor.remove("password");
				editor.commit();
			
			//intent return to login
			Intent j = new Intent(getApplicationContext(), Login.class);
			j.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS | Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(j);
			
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	//return true;	
	}
	
}
