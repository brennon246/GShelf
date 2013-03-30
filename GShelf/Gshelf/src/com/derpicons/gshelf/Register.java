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

public class Register extends Activity {

	private Network Net = new Network();
	private String Question = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

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
				final CheckBox Login = (CheckBox) findViewById(R.id.logMeIn);
				boolean complete = true;

				// Check that all fields are filled.
				if (desiredUsername.getText().toString().length() == 0) {
					desiredUsernameTextView.setTextColor(Color.RED);
					complete = false;
				} else
					desiredUsername.setTextColor(Color.WHITE);
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
						String RegisterResult = Net.register(desiredUsername
								.getText().toString(), password.getText()
								.toString(), Question, answer.getText()
								.toString());
						if (RegisterResult == "null") {
								//Intent i = new Intent(getApplicationContext(),
								//		MainMenu.class);
								//i.putExtra("UserName", desiredUsername
								//		.getText().toString());
								//startActivity(i);
						} else {
							errorDis.setText(RegisterResult);
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
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_register, menu);
		return true;
	}
*/

}
