package com.derpicons.gshelf;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetUserName extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_user_name);

		Button submit = (Button) findViewById(R.id.submission);
		final TextView username = (TextView) findViewById(R.id.desiredUsernameField);
		TextView loginScreen = (TextView) findViewById(R.id.login);

		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//String Question = LoginUtilities.GetQuestion(username.getText()
				//		.toString());
				String Question = "dsa";
				if (Question != null) {
					// pass question to next screen.
					Intent i = new Intent(getApplicationContext(),
							ChangePassword.class);
					startActivity(i);
				} else {
					// not a valid username.
				}
			}
		});
		loginScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_get_user_name, menu);
		return true;
	}

}

