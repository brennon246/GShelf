package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		Button register = (Button) findViewById(R.id.register);
		final TextView password = (TextView) findViewById(R.id.passwordField);
		final TextView passwordTextView = (TextView) findViewById(R.id.password);
		final TextView confirmPasswordTextView = (TextView) findViewById(R.id.confirmPassword);
		final TextView desiredUsername = (TextView) findViewById(R.id.desiredUsernameField);
		final TextView desiredUsernameTextView = (TextView) findViewById(R.id.desiredUsername);
		final TextView ConPassword = (TextView) findViewById(R.id.confirmPasswordField);
		final TextView answer = (TextView) findViewById(R.id.answerField);
		final CheckBox Login = (CheckBox) findViewById(R.id.logMeIn);
		TextView loginScreen = (TextView) findViewById(R.id.login);
		final int QUESTION = 1;// ***********************

		// Checks for valid user input and attempts to authenticate the new
		// user.
		register.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// test passwords
				if (!password.getText().toString()
						.equals(ConPassword.getText().toString())) {
					confirmPasswordTextView.setTextColor(Color.RED);
				} else {
					//User NewUser = LoginUtilities.Register(desiredUsername
					//		.getText().toString(), password.getText()
					//		.toString(), answer.getText().toString(), QUESTION);
					//if (NewUser != null) {
						// Intent i = new Intent(getApplicationContext(),
						// MainActivity.class);
						// startActivity(i);
					//} else {
					//	Context context = getApplicationContext();
					//	CharSequence userInUse = "Username in use!";
					//	int duration = Toast.LENGTH_SHORT;

					//	Toast toast = Toast.makeText(context, userInUse,
					//			duration);
					//	toast.show();
					//}
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_register, menu);
		return true;
	}

}

