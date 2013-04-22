package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {

	private Context ctx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ctx = this;
		
		final TextView errorDis = (TextView) findViewById(R.id.errorDisplay);

		// Check Shared Preferences
		SharedPreferences settings = getSharedPreferences("GSHELF_LOGIN",
				Activity.MODE_PRIVATE);
		if (settings.contains("username") && settings.contains("password")) {
			String SPuname = settings.getString("username", null);
			String SPpass = settings.getString("password", null);
			SPpass = new Network(ctx).decrypt(SPpass);
			int SPLoginResult = new Network(ctx).login(SPuname, SPpass);

			// Login is a success take user to default page
			if (SPLoginResult != 0) {
				Intent i = new Intent(getApplicationContext(),
						DealsView.class);
				i.putExtra("UserName", SPuname);
				i.putExtra("UKey", SPLoginResult);
				startActivity(i);
			}

		}

		Button login = (Button) findViewById(R.id.login);
		TextView registerScreen = (TextView) findViewById(R.id.register);
		TextView passwordScreen = (TextView) findViewById(R.id.forgotPassword);

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
				String un = username.getText().toString();
				String pass = password.getText().toString();
				if (un.length() == 0) {
					usernameText.setTextColor(Color.RED);
					complete = false;
				} else
					usernameText.setTextColor(Color.WHITE);
				if (pass.length() == 0) {
					passwordText.setTextColor(Color.RED);
					complete = false;
				} else
					passwordText.setTextColor(Color.WHITE);

				if (complete) {
					int LoginResult = new Network(ctx).login(un, pass);

					// Login is a success take user to default page
					if (LoginResult != 0) {
						if (Remember.isChecked()) {
							// Save to Shared Preferences
							SharedPreferences settings = getSharedPreferences(
									"GSHELF_LOGIN", 0);
							SharedPreferences.Editor editor = settings.edit();
							pass = new Network(ctx).encrypt(pass);
							editor.putString("username", un);
							editor.putString("password", pass);
							editor.commit();
						}
						Intent i = new Intent(getApplicationContext(),
								DealsView.class);
						i.putExtra("UserName", un);
						i.putExtra("UKey", LoginResult);
						startActivity(i);
					} else {
						// Error, display the meaning of the error code
						errorDis.setText("Login failed");
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
				if (new Network(ctx).hasNetwork()) {
					Intent i = new Intent(getApplicationContext(),
							GetUserName.class);
					startActivity(i);
				} else
					errorDis.setText("no network");
			}
		});

	}

}
