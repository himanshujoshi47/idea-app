package com.phoenixtechnoz.idea;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MainActivity extends Activity {
	// private SQLiteDatabase data;
	private CommentsDataSource datasource;
	ProgressDialog loader;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		datasource = new CommentsDataSource(this);
		datasource.open();
		String user = datasource.getUser();
		if (user == null) {
			setContentView(R.layout.login_screen);

			Button loginButton = (Button) findViewById(R.id.loginButton);
			final EditText username = (EditText) findViewById(R.id.usernameTextBox);
			final EditText password = (EditText) findViewById(R.id.passwordTextBox);

			datasource = new CommentsDataSource(this);
			loginButton.setOnClickListener(new View.OnClickListener() {
				public void onClick(final View view) {

					Log.v("UserName value=", username.getText().toString());
					Log.v("Password value=", password.getText().toString());
					RequestParams params = new RequestParams();
					params.put("username", username.getText().toString());
					params.put("password", password.getText().toString());
					if (username.getText().toString().equalsIgnoreCase("")
							|| password.getText().toString()
									.equalsIgnoreCase("")) {
						Toast.makeText(getApplicationContext(),
								"All Fields Required.", Toast.LENGTH_SHORT)
								.show();
					} else {
						AsyncHttpClient client = new AsyncHttpClient();
						client.post(
								"http://aaplus.co.in/Check_User.aspx",
								params, new AsyncHttpResponseHandler() {

									@Override
									public void onFinish() {
										loader.dismiss();

										super.onFinish();
									}

									@Override
									public void onStart() {

										new ProgressDialog(
												getApplicationContext());
										loader = ProgressDialog.show(view
												.getRootView().getContext(),
												"", "Please Wait");
										super.onStart();
									}

									@Override
									public void onFailure(Throwable arg0,
											String arg1) {
										loader.dismiss();
										Toast.makeText(getApplicationContext(),
												"Unable to connect to the server please check internet connection", Toast.LENGTH_SHORT).show();
										super.onFailure(arg0, arg1);
									}

									@Override
									public void onSuccess(String response) {
										
										response = response.replace("<![CDATA[", "");
								           
										response = response.replace("]]>", "");
										
										String ResValid = ParseXmlResponse
												.XMLfromString(response,
														"valid");
										if (ResValid.equals("true")) {

											datasource.open();
											String userName = username
													.getText().toString();
											String Password = password
													.getText().toString();
											datasource.createUser(userName,
													Password);

											Log.i("hey", "executed");
											Intent workoffline = new Intent(
													MainActivity.this,
													WorkofflineActivity.class);
											startActivity(workoffline);
											//
											MainActivity.this.finish();
										} else {
											String resMessage = ParseXmlResponse
													.XMLfromString(response,
															"msg");
											Toast.makeText(
													getApplicationContext(),
													resMessage,
													Toast.LENGTH_LONG).show();

										}

									}

								});
					}
				}
			});

		} else {
			Intent workoffline = new Intent(MainActivity.this,
					WorkofflineActivity.class);
			startActivity(workoffline);
			this.finish();

		}

	}

	@Override
	protected void onPause() {

		super.onPause();
		datasource.close();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

		super.onResume();
		datasource.open();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
