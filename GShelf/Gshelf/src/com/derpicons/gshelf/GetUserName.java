package com.derpicons.gshelf;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GetUserName extends Base_Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_user_name);

		final Network Net = new Network(this);
		Button submit = (Button) findViewById(R.id.submission);
		TextView loginScreen = (TextView) findViewById(R.id.login);
		final TextView errorDis = (TextView) findViewById(R.id.errorDisplay);

		submit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final EditText username = (EditText) findViewById(R.id.desiredUsernameField);
				final TextView usernameTextView = (TextView) findViewById(R.id.username);
				boolean complete = true;

				// Check that all fields are filled.
				if (username.getText().toString().length() == 0) {
					usernameTextView.setTextColor(Color.RED);
					complete = false;
				}

				if (complete) {
					String GetQuestionResult = Net.getQuestion(username
							.getText().toString());
					if (GetQuestionResult == "null") {

						Intent i = new Intent(getApplicationContext(),
								ChangePassword.class);
						i.putExtra("Question", GetQuestionResult);
						i.putExtra("UserName", username.getText().toString());
						startActivity(i);
					} else {
						errorDis.setText("Not a valid username.");
					}
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

}
