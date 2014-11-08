package com.phoenixtechnoz.idea;

import java.io.FileNotFoundException;
import java.util.Date;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Form extends Activity {
	public static Bitmap signaurebitmap;
	public static String signature;
	public String image1;
	public String image2;
	public String image3;
	private static int RESULT_LOAD_IMAGE = 1;
	int imagef = 0;
	int images = 0;
	int imaget = 0;
	int locationCheck=0;
	private LocationManager locationManager;
	private String provider;
	Location location;
	double lat,lang;
	final CommentsDataSource imagesource = new CommentsDataSource(this);
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen);
		
		Button signautreButton = (Button) findViewById(R.id.signatureButton);
		signautreButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent uploadScreen = new Intent(Form.this,
						SignatureRecorderActivity.class);
				startActivity(uploadScreen);
			}
		});
		ImageView buttonLoadImage = (ImageView) findViewById(R.id.imageView1);
		buttonLoadImage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				imagef = 1;
				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});
		ImageView buttonLoadImage2 = (ImageView) findViewById(R.id.imageView2);
		buttonLoadImage2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				images = 1;
				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});

		ImageView buttonLoadImage3 = (ImageView) findViewById(R.id.imageView3);
		buttonLoadImage3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				imaget = 1;
				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});
		
		Button locationListener =(Button) findViewById(R.id.locationButton);
		locationListener.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				GPSTracker gpsTracker = new GPSTracker(Form.this);
				if (gpsTracker.canGetLocation) {
					lat = gpsTracker.getLatitude();
					lang = gpsTracker.getLongitude();
					Toast.makeText(getApplicationContext(), "Location Retrieved", Toast.LENGTH_SHORT).show();
				} else {
					gpsTracker.showSettingsAlert();

				}
				
			}
		});
		final String CPVID = getIntent().getStringExtra("CPVID");
		final String CPVNUMBER = getIntent().getStringExtra("CPVNUMBER");
		final String CPVDATE = getIntent().getStringExtra("CPVDATE");
		final String CUSTOMERNAME = getIntent().getStringExtra("CUSTOMERNAME");
		final String MOBILE = getIntent().getStringExtra("MOBILE");
		final String ALTERNATENUMBER = getIntent().getStringExtra(
				"ALTERNATENUMBER");
		final String RESIADDRESS = getIntent().getStringExtra("RESIADDRESS");
		final String RESIPINCODE = getIntent().getStringExtra("RESIPINCODE");
		final String COMPANYNAME = getIntent().getStringExtra("COMPANYNAME");
		final String COMPANYADDRESS = getIntent().getStringExtra(
				"COMPANYADDRESS");
		final String COMPANYPINCODE = getIntent().getStringExtra(
				"COMPANYPINCODE");

		Button loginButton = (Button) findViewById(R.id.button1);
		final EditText customername = (EditText) findViewById(R.id.customerName);
		customername.setText(CUSTOMERNAME);
		final TextView cpvdate = (TextView) findViewById(R.id.cpvdate);
		cpvdate.setText(CPVDATE);
		final TextView cpvnumber = (TextView) findViewById(R.id.cpvNumber);
		cpvnumber.setText(CPVNUMBER);
		final TextView user = (TextView) findViewById(R.id.textView3);
		final EditText mobilenumber = (EditText) findViewById(R.id.mobileNumber);
		mobilenumber.setText(MOBILE);
		final TextView mobile = (TextView) findViewById(R.id.textView2);
		final EditText alternate = (EditText) findViewById(R.id.alternateNumber);
		alternate.setText(ALTERNATENUMBER);
		final TextView alternatenumber = (TextView) findViewById(R.id.textView4);
		final EditText address = (EditText) findViewById(R.id.address);
		address.setText(RESIADDRESS);
		final TextView add = (TextView) findViewById(R.id.textView5);
		final EditText pincode = (EditText) findViewById(R.id.pincode);
		pincode.setText(RESIPINCODE);
		final TextView pin = (TextView) findViewById(R.id.textView6);
		final EditText billinglandmark = (EditText) findViewById(R.id.billingLandmark);
		final EditText billinglandlinenumber = (EditText) findViewById(R.id.billingLandlineNumber);
		final EditText emailaddress = (EditText) findViewById(R.id.emailAddress);
		final EditText companyname = (EditText) findViewById(R.id.companyName);
		companyname.setText(COMPANYNAME);
		final TextView comadd = (TextView) findViewById(R.id.textView13);
		final EditText companyaddress = (EditText) findViewById(R.id.companyAddress);
		companyaddress.setText(COMPANYADDRESS);
		final TextView comname = (TextView) findViewById(R.id.textView12);
		final EditText companypincode = (EditText) findViewById(R.id.companyPincode);
		companypincode.setText(COMPANYPINCODE);
		final EditText companylandmark = (EditText) findViewById(R.id.companyLandmark);
		final EditText companylandlinenumber = (EditText) findViewById(R.id.companyLandlineNumber);
		final EditText contactperson = (EditText) findViewById(R.id.contactPerson);
		final TextView conper = (TextView) findViewById(R.id.textView18);
		final EditText relationship = (EditText) findViewById(R.id.personRelationship);
		final TextView relation = (TextView) findViewById(R.id.textView19);
		final EditText remarks = (EditText) findViewById(R.id.remarks);
		final TextView marks = (TextView) findViewById(R.id.textView20);
		MySQLiteHelper dbHelper = new MySQLiteHelper(this);
		final SQLiteDatabase data = dbHelper.getWritableDatabase();

		loginButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String EXEC_CODE = CommentsDataSource.getUser();

				imagesource.createImage(CPVID, EXEC_CODE, signature, image1,
						image2, image3);

				Date date = new Date();
				final EditText billaddchange = (EditText) findViewById(R.id.changeAddress);
				final EditText compaddchange = (EditText) findViewById(R.id.companyChangeAddress);
				String billingaddresschange;
				String companyaddresschange;
				String compi;
				String comland;
				String comline;
				String landm;
				String landl;
				String mail;
				String comname;

				if ((billaddchange).getText().toString().length() <= 0) {
					billingaddresschange = "Not Applicable";
				} else {
					billingaddresschange = billaddchange.getText().toString();
				}

				if ((compaddchange).getText().toString().length() <= 0) {
					companyaddresschange = "Not Applicable";
				} else {
					companyaddresschange = compaddchange.getText().toString();
				}

				int flag = 1;
				if ((customername).getText().toString().length() <= 0) {
					user.setTextColor(Color.RED);
					flag = 0;
				}
				if ((mobilenumber).getText().toString().length() <= 0) {
					mobile.setTextColor(Color.RED);
					flag = 0;
				}
				if ((alternate).getText().toString().length() <= 0) {
					alternatenumber.setTextColor(Color.RED);
					flag = 0;
				}
				if ((address).getText().toString().length() <= 0) {
					add.setTextColor(Color.RED);
					flag = 0;
				}
				if ((pincode).getText().toString().length() <= 0) {
					pin.setTextColor(Color.RED);
					flag = 0;
				}

				if ((billinglandmark).getText().toString().length() <= 0) {
					landm="-";
				}
				else{
					landm = billinglandmark.getText().toString();
				}
				if ((billinglandlinenumber).getText().toString().length() <= 0) {
					 landl="-";
				}
				else{
					landl = billinglandlinenumber.getText().toString();
				}
				if ((emailaddress).getText().toString().length() <= 0) {
					mail="-";
				}
				else{
					mail = emailaddress.getText().toString();
				}
				if ((companyaddress).getText().toString().length() <= 0) {
					comadd.setTextColor(Color.RED);
					flag = 0;
				}
				if ((companyname).getText().toString().length() <= 0) {
					comname="-";
				}
				else{
					comname=companyname.getText().toString();
				}
				if ((companypincode).getText().toString().length() <= 0) {
					compi="-";
				}else{
					compi = companypincode.getText().toString();
				}
				if ((companylandmark).getText().toString().length() <= 0) {
					comland="-";
				}
				else{
					comland = companylandmark.getText().toString();
				}
				if ((companylandlinenumber).getText().toString().length() <= 0) {
					comline="-";
				}
				else{
					comline = companylandlinenumber.getText().toString();
				}
				if ((contactperson).getText().toString().length() <= 0) {
					conper.setTextColor(Color.RED);
					flag = 0;
				}
				if ((relationship).getText().toString().length() <= 0) {
					relation.setTextColor(Color.RED);
					flag = 0;
				}
				if ((remarks).getText().toString().length() <= 0) {
					marks.setTextColor(Color.RED);
					flag = 0;
				}
				if (image1 == null) {
					flag = 0;
				}
				if (image2 == null) {
					flag = 0;
				}
				if (image3 == null) {
					flag = 0;
				}
				if (signature == null) {
					flag = 0;
				}
				if (flag == 1) {

					String status = "complete";
					int visit_date;
					int visit_month;
					int visit_year;
					int visit_hour;
					int visit_minute;

					visit_date = date.getDate();
					visit_month = date.getMonth();
					visit_year = date.getYear();
					visit_hour = date.getHours();
					visit_minute = date.getMinutes();

					Spinner mySpinner1 = (Spinner) findViewById(R.id.spinner1);
					String addtype = mySpinner1.getSelectedItem().toString();

					Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);
					String addverified = mySpinner2.getSelectedItem()
							.toString();

					Spinner mySpinner3 = (Spinner) findViewById(R.id.spinner3);
					String subidentity = mySpinner3.getSelectedItem()
							.toString();

					Spinner mySpinner4 = (Spinner) findViewById(R.id.spinner4);
					String simrece = mySpinner4.getSelectedItem().toString();

					Spinner mySpinner5 = (Spinner) findViewById(R.id.spinner5);
					String neighborcheck = mySpinner5.getSelectedItem()
							.toString();

					Spinner mySpinner6 = (Spinner) findViewById(R.id.spinner6);
					String areahouse = mySpinner6.getSelectedItem().toString();

					Spinner mySpinner7 = (Spinner) findViewById(R.id.spinner7);
					String localityhouse = mySpinner7.getSelectedItem()
							.toString();

					Spinner mySpinner8 = (Spinner) findViewById(R.id.spinner8);
					String resitype = mySpinner8.getSelectedItem().toString();

					Spinner mySpinner9 = (Spinner) findViewById(R.id.spinner9);
					String ownership = mySpinner9.getSelectedItem().toString();

					Spinner mySpinner10 = (Spinner) findViewById(R.id.spinner10);
					String aphouse = mySpinner10.getSelectedItem().toString();

					Spinner mySpinner11 = (Spinner) findViewById(R.id.spinner11);
					String lochouse = mySpinner11.getSelectedItem().toString();

					Spinner mySpinner12 = (Spinner) findViewById(R.id.spinner12);
					String excon = mySpinner12.getSelectedItem().toString();

					Spinner mySpinner13 = (Spinner) findViewById(R.id.spinner13);
					String intcon = mySpinner13.getSelectedItem().toString();

					Spinner mySpinner14 = (Spinner) findViewById(R.id.spinner14);
					String party = mySpinner14.getSelectedItem().toString();

					Spinner mySpinner15 = (Spinner) findViewById(R.id.spinner15);
					String tv = mySpinner15.getSelectedItem().toString();

					Spinner mySpinner16 = (Spinner) findViewById(R.id.spinner16);
					String ac = mySpinner16.getSelectedItem().toString();

					Spinner mySpinner17 = (Spinner) findViewById(R.id.spinner17);
					String fridge = mySpinner17.getSelectedItem().toString();

					Spinner mySpinner18 = (Spinner) findViewById(R.id.spinner18);
					String musicsystem = mySpinner18.getSelectedItem()
							.toString();

					Spinner mySpinner19 = (Spinner) findViewById(R.id.spinner19);
					String na = mySpinner19.getSelectedItem().toString();

					Spinner mySpinner20 = (Spinner) findViewById(R.id.spinner20);
					String negativearea = mySpinner20.getSelectedItem()
							.toString();

					Spinner mySpinner21 = (Spinner) findViewById(R.id.spinner21);
					String famstruct = mySpinner21.getSelectedItem().toString();

					Spinner mySpinner22 = (Spinner) findViewById(R.id.spinner22);
					String famstatus = mySpinner22.getSelectedItem().toString();

					Spinner mySpinner23 = (Spinner) findViewById(R.id.spinner23);
					String organization = mySpinner23.getSelectedItem()
							.toString();

					Spinner mySpinner24 = (Spinner) findViewById(R.id.spinner24);
					String prof = mySpinner24.getSelectedItem().toString();

					Spinner mySpinner25 = (Spinner) findViewById(R.id.spinner25);
					String year = mySpinner25.getSelectedItem().toString();

					Spinner mySpinner26 = (Spinner) findViewById(R.id.spinner26);
					String vehicle = mySpinner26.getSelectedItem().toString();

					Spinner mySpinner27 = (Spinner) findViewById(R.id.spinner27);
					String qual = mySpinner27.getSelectedItem().toString();

					Spinner mySpinner28 = (Spinner) findViewById(R.id.spinner28);
					String rating = mySpinner28.getSelectedItem().toString();

					Spinner mySpinner29 = (Spinner) findViewById(R.id.spinner29);
					String cpvstatus = mySpinner29.getSelectedItem().toString();

					Spinner mySpinner30 = (Spinner) findViewById(R.id.spinner30);
					String cpvremarks = mySpinner30.getSelectedItem()
							.toString();

					String customerName = customername.getText().toString();
					String mobile = mobilenumber.getText().toString();
					String alternatenumber = alternate.getText().toString();
					String residenceaddress = address.getText().toString();
					String pinco = pincode.getText().toString();
					String execode = CommentsDataSource.getUser();
					String comnam = companyname.getText().toString();
					String comad = companyaddress.getText().toString();
					String conper = contactperson.getText().toString();
					String conrel = relationship.getText().toString();
					String rema = remarks.getText().toString();
					String latitude=Double.toString(lat);
					String longitude=Double.toString(lang);
					
					data.execSQL("UPDATE " + MySQLiteHelper.TABLE_COMMENTS
							+ " SET " + MySQLiteHelper.COLUMN_CASEID + "= '"
							+ CPVID + "'," + MySQLiteHelper.COLUMN_CASESTATUS
							+ "= '" + status + "',"
							+ MySQLiteHelper.COLUMN_CPVDATE + "= '" + CPVDATE
							+ "'," + MySQLiteHelper.COLUMN_MOBILE + "= '"
							+ mobile + "',"
							+ MySQLiteHelper.COLUMN_CUSTOMERNAME + "= '"
							+ customerName + "',"
							+ MySQLiteHelper.COLUMN_ALTERNATENUMBER + "= '"
							+ alternatenumber + "',"
							+ MySQLiteHelper.COLUMN_EMAILID + "= '" + mail
							+ "'," + MySQLiteHelper.COLUMN_ADDRESS + "= '"
							+ residenceaddress + "',"
							+ MySQLiteHelper.COLUMN_PINCODE + "= '" + pinco
							+ "'," + MySQLiteHelper.COLUMN_BILLINGLANDMARK
							+ "= '" + landm + "',"
							+ MySQLiteHelper.COLUMN_BILLINGLANDLINE + "= '"
							+ landl + "',"
							+ MySQLiteHelper.COLUMN_BILLINGADDRESSCHANGE
							+ "= '" + billingaddresschange + "',"
							+ MySQLiteHelper.COLUMN_COMPANYNAME + "= '"
							+ comname + "',"
							+ MySQLiteHelper.COLUMN_COMPANYADDRESS + "= '"
							+ comad + "',"
							+ MySQLiteHelper.COLUMN_COMPANYPINCODE + "= '"
							+ compi + "',"
							+ MySQLiteHelper.COLUMN_COMPANYLANDMARK + "= '"
							+ comland + "',"
							+ MySQLiteHelper.COLUMN_COMPANYLANDLINE + "= '"
							+ comline + "',"
							+ MySQLiteHelper.COLUMN_COMPANYADDRESSCHANGE
							+ "= '" + companyaddresschange + "',"
							+ MySQLiteHelper.COLUMN_ADDTYPE + "= '" + addtype
							+ "'," + MySQLiteHelper.COLUMN_ADDRESSVERIFIED
							+ "= '" + addverified + "',"
							+ MySQLiteHelper.COLUMN_SUBIDENTITYCONFIRM + "= '"
							+ subidentity + "',"
							+ MySQLiteHelper.COLUMN_VISITMONTH + "= '"
							+ visit_month + "',"
							+ MySQLiteHelper.COLUMN_VISITDATE + "= '"
							+ visit_date + "',"
							+ MySQLiteHelper.COLUMN_VISITYEAR + "= '"
							+ visit_year + "',"
							+ MySQLiteHelper.COLUMN_VISITTIMEHOUR + "= '"
							+ visit_hour + "',"
							+ MySQLiteHelper.COLUMN_VISITTIMEMINUTE + "= '"
							+ visit_minute + "'," + MySQLiteHelper.COLUMN_CODE
							+ "= '" + execode + "',"
							+ MySQLiteHelper.COLUMN_PERSONCONTACT + "= '"
							+ conper + "',"
							+ MySQLiteHelper.COLUMN_RELATIONPERSON + "= '"
							+ conrel + "'," + MySQLiteHelper.COLUMN_REMARKS
							+ "= '" + rema + "',"
							+ MySQLiteHelper.COLUMN_SIMRECEIVED + "= '"
							+ simrece + "',"
							+ MySQLiteHelper.COLUMN_NEIGHBORCHECK + "= '"
							+ neighborcheck + "',"
							+ MySQLiteHelper.COLUMN_HOUSEAREA + "= '"
							+ areahouse + "',"
							+ MySQLiteHelper.COLUMN_HOUSELOCALITY + "= '"
							+ localityhouse + "',"
							+ MySQLiteHelper.COLUMN_HOUSEOWNERSHIP + "= '"
							+ ownership + "',"
							+ MySQLiteHelper.COLUMN_RESIDENCETYPE + "= '"
							+ resitype + "',"
							+ MySQLiteHelper.COLUMN_HOUSEAPPROACH + "= '"
							+ aphouse + "',"
							+ MySQLiteHelper.COLUMN_HOUSELOCATION + "= '"
							+ lochouse + "',"
							+ MySQLiteHelper.COLUMN_EXTERIORCONDITION + "= '"
							+ excon + "',"
							+ MySQLiteHelper.COLUMN_INTERIORCONDITION + "= '"
							+ intcon + "',"
							+ MySQLiteHelper.COLUMN_THIRDPARTYCONTACT + "= '"
							+ party + "'," + MySQLiteHelper.COLUMN_ASSETSTV
							+ "= '" + tv + "',"
							+ MySQLiteHelper.COLUMN_ASSETSAC + "= '" + ac
							+ "'," + MySQLiteHelper.COLUMN_ASSETSFRIDGE + "= '"
							+ fridge + "'," + MySQLiteHelper.COLUMN_ASSETSMUSIC
							+ "= '" + musicsystem + "',"
							+ MySQLiteHelper.COLUMN_ASSETSNA + "= '" + na
							+ "'," + MySQLiteHelper.COLUMN_NEGATIVEAREA + "= '"
							+ negativearea + "',"
							+ MySQLiteHelper.COLUMN_FAMILYSTRUCTURE + "= '"
							+ famstruct + "',"
							+ MySQLiteHelper.COLUMN_FAMILYSTATUS + "= '"
							+ famstatus + "',"
							+ MySQLiteHelper.COLUMN_ORGANISATION + "= '"
							+ organization + "',"
							+ MySQLiteHelper.COLUMN_LAT + "= '"
							+ latitude + "',"
							+ MySQLiteHelper.COLUMN_LANG + "= '"
							+ longitude + "',"
							+ MySQLiteHelper.COLUMN_PROFESSION + "= '" + prof
							+ "'," + MySQLiteHelper.COLUMN_SERVICEYEAR + "= '"
							+ year + "'," + MySQLiteHelper.COLUMN_VEHICLE
							+ "= '" + vehicle + "',"
							+ MySQLiteHelper.COLUMN_EDUCATION + "= '" + qual
							+ "'," + MySQLiteHelper.COLUMN_AGENTRATING + "= '"
							+ rating + "'," + MySQLiteHelper.COLUMN_CPVSTATUS
							+ "= '" + cpvstatus + "',"
							+ MySQLiteHelper.COLUMN_STREMARK + "= '"
							+ cpvremarks + "'" + " WHERE "
							+ MySQLiteHelper.COLUMN_CPVNUMBER + " = "
							+ CPVNUMBER);
					imagesource.createImage(CPVID, execode, signature, image1,
							image2, image3);
					Toast.makeText(getApplicationContext(),
							"Case saved offline",
							Toast.LENGTH_LONG).show();
					Intent workoffline = new Intent(Form.this,
							WorkofflineActivity.class);
					startActivity(workoffline);

				} else {
					Toast.makeText(getApplicationContext(),
							"Please upload all Images, Fields and Signature",
							Toast.LENGTH_LONG).show();
				}

			}

		}

		);
		

	}
	@Override
	protected void onPause() {

		super.onPause();
		imagesource.close();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub

		super.onResume();
		imagesource.open();
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };
			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();
			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();
			Bitmap imagea=null;
			Bitmap imageb=null;
			Bitmap imagec=null;
			if (imagef == 1) {
				ImageView imageView = (ImageView) findViewById(R.id.imageView1);
				try {
					imagea=decodeUri(getApplicationContext(), selectedImage, 60);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				imageView.setImageBitmap(imagea);
				image1 = picturePath;
				imagef--;
			}
			if (images == 1) {
				ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
				try {
					imageb=decodeUri(getApplicationContext(), selectedImage, 60);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				imageView2.setImageBitmap(imageb);
				image2 = picturePath;
				images--;
			}
			if (imaget == 1) {
				ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
				try {
					imagec=decodeUri(getApplicationContext(), selectedImage, 60);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				imageView3.setImageBitmap(imagec);
				image3 = picturePath;
				imaget--;
			}
			if (signature != null) {
				ImageView signautureimage = (ImageView) findViewById(R.id.imageView4);
				signautureimage.setImageBitmap(BitmapFactory.decodeFile(signature));

			}

		}
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public static Bitmap decodeUri(Context c, Uri uri, final int requiredSize) 
            throws FileNotFoundException {
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(c.getContentResolver().openInputStream(uri), null, o);

        int width_tmp = o.outWidth
                , height_tmp = o.outHeight;
        int scale = 1;

        while(true) {
            if(width_tmp / 2 < requiredSize || height_tmp / 2 < requiredSize)
                break;
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(c.getContentResolver().openInputStream(uri), null, o2);
    }  
	public void onLocationChanged(Location arg0) {
		
		lat = location.getLatitude();
		lang = location.getLongitude();
		Toast.makeText(getApplicationContext(),
				lat +" "+lang,
				Toast.LENGTH_LONG).show();
		
		
	}
	public void onProviderDisabled(String provider) {
		
	}
	public void onProviderEnabled(String provider) {
		
	}
	public void onStatusChanged(String provider, int status, Bundle extras) {
		
	} 
}

