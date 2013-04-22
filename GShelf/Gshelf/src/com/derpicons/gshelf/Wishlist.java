package com.derpicons.gshelf;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class Wishlist extends Base_Activity {

	private ListView listViewGames;
	private Context ctx;
	private ArrayList<Game> WishListGames;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_games_library);
		ctx = this;

		Intent intent = getIntent();
		String Username = intent.getStringExtra("UserName");
		int Userkey = intent.getIntExtra("UKey", 0);

		// Get list of wishlist games

		WishListGames = new ArrayList<Game>();
		LocalDatabase LD = new LocalDatabase(ctx);
		WishListGames = LD.getGamesFromWishlist();
		LD.close();

		// Display list of wishlist games
		listViewGames = (ListView) findViewById(R.id.wish_list);
		listViewGames.setAdapter(new GameListAdapter(ctx,
				R.layout.wishlist_item, WishListGames));

		listViewGames.setClickable(true);

		listViewGames.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

				Toast.makeText(getApplicationContext(),
						"Click GameItemNumber " + position, Toast.LENGTH_LONG)
						.show();
				// Takes user to WishListInfo page with required data.

				Intent i = new Intent(getApplicationContext(), WishlistInfo.class);
				i.putExtra("GameKey", WishListGames.get(position)
						.getKey());
				startActivity(i);

			}
		});
	}

}
