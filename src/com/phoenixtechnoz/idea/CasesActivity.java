package com.phoenixtechnoz.idea;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class CasesActivity extends Activity {
	private SQLiteDatabase data;
	private MySQLiteHelper dbHelper = new MySQLiteHelper(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cases_list);

		ArrayList<SearchResults> searchResults = GetSearchResults();

		final ListView lv1 = (ListView) findViewById(R.id.list);
		lv1.setAdapter(new MyCustomBaseAdapter(this, searchResults));

		lv1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Form.signature=null;
				Form.signaurebitmap=null;
				
				Object o = lv1.getItemAtPosition(position);
				SearchResults fullObject = (SearchResults) o;
				String CPVID = fullObject.getid();
				String CPVNUMBER = fullObject.getCpvnumber();
				String CPVDATE = fullObject.getCpvdate();
				String CUSTOMERNAME = fullObject.getName();
				String MOBILE = fullObject.getMobile();
				String ALTERNATENUMBER = fullObject.getAlternatenumber();
				String RESIADDRESS = fullObject.getResiaddress();
				String RESIPINCODE = fullObject.getResipincode();
				String COMPANYNAME = fullObject.getCompanyname();
				String COMPANYADDRESS = fullObject.getCompanyaddress();
				String COMPANYPINCODE = fullObject.getCompanypincode();

				Intent Form = new Intent(CasesActivity.this, Form.class);
				Form.putExtra("CPVID", CPVID);
				Form.putExtra("CPVNUMBER", CPVNUMBER);
				Form.putExtra("CPVDATE", CPVDATE);
				Form.putExtra("CUSTOMERNAME", CUSTOMERNAME);
				Form.putExtra("MOBILE", MOBILE);
				Form.putExtra("ALTERNATENUMBER", ALTERNATENUMBER);
				Form.putExtra("RESIADDRESS", RESIADDRESS);
				Form.putExtra("RESIPINCODE", RESIPINCODE);
				Form.putExtra("COMPANYNAME", COMPANYNAME);
				Form.putExtra("COMPANYADDRESS", COMPANYADDRESS);
				Form.putExtra("COMPANYPINCODE", COMPANYPINCODE);
				startActivity(Form);

			};

		});

	}

	private ArrayList<SearchResults> GetSearchResults() {
		data = dbHelper.getWritableDatabase();
		ArrayList<SearchResults> results = new ArrayList<SearchResults>();
		Cursor cursor = data.rawQuery("SELECT * FROM "
				+ MySQLiteHelper.TABLE_COMMENTS, null);
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			String check;
			SearchResults sr1;
			while (!cursor.isAfterLast()) {

				sr1 = new SearchResults();
				check = cursor.getString(1);
				Log.i("check", check);
				sr1.setid(cursor.getString(2));
				sr1.setCpvdate(cursor.getString(3));
				sr1.setCpvnumber(cursor.getString(4));
				sr1.setMobile(cursor.getString(5));
				sr1.setName(cursor.getString(6));
				sr1.setAlternatenumber(cursor.getString(7));
				sr1.setResiaddress(cursor.getString(9));
				sr1.setResipincode(cursor.getString(10));
				sr1.setCompanyname(cursor.getString(14));
				sr1.setCompanyaddress(cursor.getString(15));
				sr1.setComanypincode(cursor.getString(16));
				if (!check.equals("complete")) {
					results.add(sr1);
				}
				cursor.moveToNext();
			}

			cursor.close();
			return results;
		} else {
			Toast.makeText(getApplicationContext(), "Please download cases",
					Toast.LENGTH_LONG).show();
		}
		cursor.close();
		return results;
	}

}
