package com.derpicons.gshelf;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class OwnedTradeInfo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_owned_trade_info);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.owned_trade_info, menu);
		return true;
	}

}
