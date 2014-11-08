package com.phoenixtechnoz.idea;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class WorkofflineActivity extends Activity {
	private SQLiteDatabase data;
	private SQLiteDatabase imagedatabase;
	private SQLiteDatabase database;
	private MySQLiteHelper helper;
    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.workoffline);

	}

	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.Logout:					
			helper= new MySQLiteHelper(this);
			database=helper.getWritableDatabase();
			database.delete(MySQLiteHelper.TABLE_COMMENTS, null, null);
			database.delete(MySQLiteHelper.TABLE_IMAGE, null, null);
			database.delete(MySQLiteHelper.TABLE_LOGIN, null, null);
			database.close();
			Intent loginscreen = new Intent(WorkofflineActivity.this,
					MainActivity.class);
			startActivity(loginscreen);
			WorkofflineActivity.this.finish();

			break;
		case R.id.goto_download_button:
			Intent uploadScreen = new Intent(WorkofflineActivity.this,
					UploadDownloadActivity.class);
			startActivity(uploadScreen);

			break;
		case R.id.goto_cpv_list_button:
				Intent casesScreen = new Intent(WorkofflineActivity.this,
						CasesActivity.class);
				startActivity(casesScreen);
			break;
		}
	}

}