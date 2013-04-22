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

	private ListView listViewTrades;
	private Context ctx;
	String Username;
	int Userkey;
	ArrayList<Game> TradeGames;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_marketplace);
		
		Button SearchButton = (Button) findViewById(R.id.buttonSearch);
		Button YourTradesButton = (Button) findViewById(R.id.buttonYourTrades);
		final EditText SearchText = (EditText) findViewById(R.id.editTextSearch);
		ctx = this;

		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);
		
		listViewTrades = (ListView) findViewById(R.id.trade_list);
		listViewTrades.setClickable(true);
		
		YourTradesButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						YourTrades.class);
				i.putExtra("UserName", Username);
				i.putExtra("UKey", Userkey);
				startActivity(i);
				
			}
		});
		
		SearchButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String search = SearchText.getText().toString();
				TradeGames = new ArrayList<Game>();
				if (search.length() != 0) {
					//TradeGames = new Network(ctx).getTrades(search);
				}
				TradeGames = new Network(ctx).getGames("halo");
				listViewTrades.setAdapter(new SearchListAdapter(ctx, R.layout.result_item,
						TradeGames));
				
			}
		});

		listViewTrades.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
				Intent i = new Intent(getApplicationContext(), TradeInfo.class);
				i.putExtra("GameKey", TradeGames.get(position)
						.getKey());
				i.putExtra("UserName", Username);
				i.putExtra("UKey", Userkey);
				startActivity(i);
			}
		});
	}

}
