package com.derpicons.gshelf;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DealsView extends Base_Activity {

	private ListView listViewDeals;
	private Context ctx;
	private String Username;
	private int Userkey;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deals_view);
		ctx = this;

		Intent intent = getIntent();
		Username = intent.getStringExtra("UserName");
		Userkey = intent.getIntExtra("UKey", 0);

		// Get list of Deals
				
		ArrayList<Deal> AllDeals = new ArrayList<Deal>();
		//AllDeals = new Network(this).getDeals();
		
		Button AddDeals = (Button) findViewById(R.id.buttonAddDeal);
		
		// Display list of Deals
		listViewDeals = (ListView) findViewById(R.id.deal_item);
		listViewDeals.setAdapter(new DealListAdapter(ctx, R.layout.deal_item,
				AllDeals));

		listViewDeals.setClickable(true);

		listViewDeals.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {

				Toast.makeText(getApplicationContext(),
						"Click GameItemNumber " + position, Toast.LENGTH_LONG)
						.show();
				// Takes user to DealInfo page with required data.
				
			//	Intent i = new Intent(getApplicationContext(), DealInfo.class);
			//	i.putExtra("GameKey", AllDeals.get(position).getKey());
			//	startActivity(i);
				
			}
		});
		
		AddDeals.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(getApplicationContext(), AddDeal.class);
				startActivity(i);
			}
		});
	}

}
