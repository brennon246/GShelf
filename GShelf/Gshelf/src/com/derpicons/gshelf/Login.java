package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		Button login = (Button) findViewById(R.id.login);
		TextView registerScreen = (TextView) findViewById(R.id.register);
		TextView passwordScreen = (TextView) findViewById(R.id.forgotPassword);
		final TextView errorDis = (TextView) findViewById(R.id.errorDisplay);
		final Network Net = new Network();// ***************************

		// Attempts to authenticate the user.
		login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final EditText username = (EditText) findViewById(R.id.usernameField);
				final EditText password = (EditText) findViewById(R.id.passwordField);
				final CheckBox Remember = (CheckBox) findViewById(R.id.rememberMe);
				final TextView usernameText = (TextView) findViewById(R.id.username);
				final TextView passwordText = (TextView) findViewById(R.id.password);
				boolean complete = true;

				// Check that all fields are filled.
				if (username.getText().toString() == "") {
					usernameText.setTextColor(Color.RED);
					complete = false;
				} else
					usernameText.setTextColor(Color.BLACK);
				if (password.getText().toString() == "") {
					passwordText.setTextColor(Color.RED);
					complete = false;
				} else
					passwordText.setTextColor(Color.BLACK);
				if (complete) {
					String LoginResult = Net.authenticate(username.getText()
							.toString(), password.getText().toString());
					if (LoginResult == "null") {
						// remember me stuff
						//Intent i = new Intent(getApplicationContext(),
						//		MainMenu.class);
						//i.putExtra("UserName", username.getText().toString());
						//startActivity(i);
					} else {
						errorDis.setText(LoginResult);
					}
				}
			}
		});

		// Sends the user to the register screen.
		registerScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(getApplicationContext(), Register.class);
				startActivity(i);
			}
		});

		// Sends the user to the password screen.
		passwordScreen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (Net.hasNetwork()) {
					Intent i = new Intent(getApplicationContext(),
							GetUserName.class);
					startActivity(i);
				} else
					errorDis.setText("no network");
			}
		});
	}
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}
*/
}
