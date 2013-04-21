package com.derpicons.gshelf;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Marketplace extends Base_Activity {

	private ListView listViewOwned;
	private ListView listViewWTB;
	private ListView listViewTrades;
	private Context ctx;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_marketplace);
		
		Button SearchButton = (Button) findViewById(R.id.buttonSearch);
		final EditText SearchText = (EditText) findViewById(R.id.editTextSearch);
		ctx = this;

		Intent intent = getIntent();
		String Username = intent.getStringExtra("UserName");
		int Userkey = intent.getIntExtra("UKey", 0);

		// Get list of trades
				
		ArrayList<Trade> ownedTrades = new ArrayList<Trade>();
		ArrayList<Trade> WTBTrades = new ArrayList<Trade>();

		// Display list of owned trades
		listViewOwned = (ListView) findViewById(R.id.owned_list);
		listViewOwned.setAdapter(new TradeListAdapter(ctx, R.layout.trade_item,
				ownedTrades));
		
		// Display list of wtb trades
		listViewWTB = (ListView) findViewById(R.id.wtb_list);
		listViewWTB.setAdapter(new TradeListAdapter(ctx, R.layout.trade_item,
				WTBTrades));
		
		listViewTrades = (ListView) findViewById(R.id.trade_list);
		listViewOwned.setClickable(true);
		listViewWTB.setClickable(true);
		listViewTrades.setClickable(true);

		listViewOwned.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

				Toast.makeText(getApplicationContext(),
						"Click GameItemNumber " + position, Toast.LENGTH_LONG)
						.show();
				// Takes user to GameView page with required data.
				
				//Intent i = new Intent(getApplicationContext(), GameInfo.class);
				//i.putExtra("GameKey", LGames.getShowGames().get(position).getKey());
				//startActivity(i);
				
			}
		});
		
		listViewWTB.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

				Toast.makeText(getApplicationContext(),
						"Click GameItemNumber " + position, Toast.LENGTH_LONG)
						.show();
				// Takes user to GameView page with required data.
				
				//Intent i = new Intent(getApplicationContext(), GameInfo.class);
				//i.putExtra("GameKey", LGames.getShowGames().get(position).getKey());
				//startActivity(i);
				
			}
		});
		
		SearchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String search = SearchText.getText().toString();
				ArrayList<Trade> TradeGames = new ArrayList<Trade>();
				if (search.length() != 0) {
					//TradeGames = new Network(ctx).getTrades(search);
				}
				listViewTrades.setAdapter(new TradeListAdapter(ctx, R.layout.trade_item,
						TradeGames));
				
			}
		});

		listViewTrades.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

				Toast.makeText(getApplicationContext(),
						"Click GameItemNumber " + position, Toast.LENGTH_LONG)
						.show();
				// Takes user to GameView page with required data.
				/*
				 * Intent i = new Intent(getApplicationContext(),
				 * GameView.class); i.putExtra("key",
				 * LGames.getShowGames().get(position).getKey());
				 * i.putExtra("title", LGames.getShowGames().get(position)
				 * .getTitle()); i.putExtra("platform",
				 * LGames.getShowGames().get(position) .getPlatform());
				 * i.putExtra("overview", LGames.getShowGames().get(position)
				 * .getOverview()); i.putExtra("genre",
				 * LGames.getShowGames().get(position) .getGenre());
				 * i.putExtra("developer", LGames.getShowGames().get(position)
				 * .getDeveloper()); startActivity(i);
				 */
		
			}
		});
	}

}
