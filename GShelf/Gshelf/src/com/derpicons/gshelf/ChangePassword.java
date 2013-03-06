package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePassword extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_password);

		TextView loginScreen = (TextView) findViewById(R.id.login);
		Button submitPass = (Button) findViewById(R.id.submission);

		//GET QUESTION
		// Sends user to login screen.
		loginScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		submitPass.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final TextView answerTextView = (TextView) findViewById(R.id.answer);
				final EditText answer = (EditText) findViewById(R.id.answerField);
				final CheckBox Login = (CheckBox) findViewById(R.id.logMeIn);
				final EditText password = (EditText) findViewById(R.id.newPasswordField);
				final TextView passwordTextView = (TextView) findViewById(R.id.newPassword);
				final EditText ConPassword = (EditText) findViewById(R.id.confirmNewPasswordField);
				final TextView confirmPasswordTextView = (TextView) findViewById(R.id.confirmPassword);
				
				// test password
				if (!password.getText().toString()
						.equals(ConPassword.getText().toString())) {
					confirmPasswordTextView.setTextColor(Color.RED);
				} else {
					//User CurUser = LoginUtilities.ChangePass(username.getText()
					//		.toString(), password.getText().toString(), answer
					//		.getText().toString());
					/*
					 * if (CurUser != null) { Intent i = new
					 * Intent(getApplicationContext(), MainActivity.class);
					 * startActivity(i); } // ORRRRRRRRR if (CurUser != null) {
					 * finish(); }
					 */
					if (1 == 1) 
					{
						
					} 
					else {
						Context context = getApplicationContext();
						CharSequence InvalidAnswer = "Invalid answer!";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, InvalidAnswer,
								duration);
						toast.show();
					}

				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_change_password, menu);
		return true;
	}

}

