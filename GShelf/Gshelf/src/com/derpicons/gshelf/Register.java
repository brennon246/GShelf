package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends Activity {

	private String Question = null;
	private Context ctx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		ctx = this;
		
		Button register = (Button) findViewById(R.id.register);
		TextView loginScreen = (TextView) findViewById(R.id.login);
		final TextView errorDis = (TextView) findViewById(R.id.errorDisplay);

		// Checks for valid user input and attempts to authenticate the new
		// user.
		register.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final EditText password = (EditText) findViewById(R.id.passwordField);
				final TextView passwordTextView = (TextView) findViewById(R.id.password);
				final EditText ConPassword = (EditText) findViewById(R.id.confirmPasswordField);
				final TextView confirmPasswordTextView = (TextView) findViewById(R.id.confirmPassword);
				final EditText desiredUsername = (EditText) findViewById(R.id.desiredUsernameField);
				final TextView desiredUsernameTextView = (TextView) findViewById(R.id.desiredUsername);
				final EditText answer = (EditText) findViewById(R.id.answerField);
				final TextView answerTextView = (TextView) findViewById(R.id.answer);
				boolean complete = true;

				// Check that all fields are filled.
				if (desiredUsername.getText().toString().length() == 0) {
					desiredUsernameTextView.setTextColor(Color.RED);
					complete = false;
				} else
					desiredUsernameTextView.setTextColor(Color.WHITE);
				if (password.getText().toString().length() == 0) {
					passwordTextView.setTextColor(Color.RED);
					complete = false;
				} else
					passwordTextView.setTextColor(Color.WHITE);
				if (ConPassword.getText().toString().length() == 0) {
					confirmPasswordTextView.setTextColor(Color.RED);
					complete = false;
				} else
					confirmPasswordTextView.setTextColor(Color.WHITE);
				if (answer.getText().toString().length() == 0) {
					answerTextView.setTextColor(Color.RED);
					complete = false;
				} else
					answerTextView.setTextColor(Color.WHITE);
				//Check Question

				if (complete) {
					// test passwords
					if (!password.getText().toString()
							.equals(ConPassword.getText().toString())) {
						confirmPasswordTextView.setTextColor(Color.RED);
					} else {
						//String RegisterResult = Net.register(desiredUsername
						//		.getText().toString(), password.getText()
						//		.toString(), Question, answer.getText()
						//		.toString());
						boolean RegisterResult = new Network(ctx).addUser(desiredUsername.getText().toString(), password.getText().toString());
						if (RegisterResult == true) {
								//Intent i = new Intent(getApplicationContext(),
								//		GamesLibrary.class);
								//i.putExtra("UserName", desiredUsername.getText().toString());
								//i.putExtra("UKey", RegisterResult);
								//startActivity(i);
							finish();
						} else {
							errorDis.setText("Failed to register user");
						}
					}
				}
			}
		});

		// Sends user back to login screen.
		loginScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

}
