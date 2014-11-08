package com.phoenixtechnoz.idea;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class UploadDownloadActivity extends Activity {
	ProgressDialog loader;
	ProgressDialog uploadLoader;
	private MySQLiteHelper dbhelper;
	private CommentsDataSource datasource;
	private SQLiteDatabase data;
	private MySQLiteHelper dbHelper = new MySQLiteHelper(this);
	private static SQLiteDatabase imagedata;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload_download);
		datasource = new CommentsDataSource(this);
		datasource.open();

	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.upload_button:
			uploadData(view);
			break;
		case R.id.download_button:
			RequestParams params = new RequestParams();
			String user = datasource.getUser();
			Log.i("download get user from database", user);
			params.put("id", user);
			downloadData(params, view);
			break;
		}

	}

	private void uploadData(final View view) {
		

		
		uploadLoader = new ProgressDialog(this);
		uploadLoader.setTitle("Please wait");
		uploadLoader.setMessage("Please wait while we are uploading the cases.");
		uploadLoader.setCancelable(false);
		uploadLoader.setIndeterminate(true);
		
		uploadLoader.show();
 
		data = dbHelper.getWritableDatabase();
		Cursor cursor = datasource.getUploadDataCursor(MySQLiteHelper.COLUMN_CASESTATUS);
		int count = cursor.getCount();
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {

				String CASESTATUS = cursor.getString(1);
				final String CASEID = cursor.getString(2);
				String CPVDATE = cursor.getString(3);
				final String CPVNUMBER = cursor.getString(4);
				String MOBILE = cursor.getString(5);
				String CUSTOMERNAME = cursor.getString(6);
				String ALTERNATENUMBER = cursor.getString(7);
				String EMAILID = cursor.getString(8);
				String ADDRESS = cursor.getString(9);
				String PINCODE = cursor.getString(10);
				String BILLINGLANDMARK = cursor.getString(11);
				String BILLINGLANDLINE = cursor.getString(12);
				String BILLINGADDRESSCHANGE = cursor.getString(13);
				String COMPANYNAME = cursor.getString(14);
				String COMPANYADDRESS = cursor.getString(15);
				String COMPANYPINCODE = cursor.getString(16);
				String COMPANYLANDMARK = cursor.getString(17);
				String COMPANYLANDLINE = cursor.getString(18);
				String COMPANYADDRESSCHANGE = cursor.getString(19);
				String ADDTYPE = cursor.getString(20);
				String ADDRESSVERIFIED = cursor.getString(21);
				String SUBIDENTITYCONFIRM = cursor.getString(22);
				String VISITMONTH = cursor.getString(23);
				String VISITDATE = cursor.getString(24);
				String VISITYEAR = cursor.getString(25);
				String VISITTIMEHOUR = cursor.getString(26);
				String VISITTIMEMINUTE = cursor.getString(27);
				String CODE = cursor.getString(28);
				String PERSONCONTACT = cursor.getString(29);
				String RELATIONPERSON = cursor.getString(30);
				String REMARKS = cursor.getString(31);
				String SIMRECEIVED = cursor.getString(32);
				String NEIGHBORCHECK = cursor.getString(33);
				String HOUSEAREA = cursor.getString(34);
				String HOUSELOCALITY = cursor.getString(35);
				String HOUSEOWNERSHIP = cursor.getString(36);
				String RESIDENCETYPE = cursor.getString(37);
				String HOUSEAPPROACH = cursor.getString(38);
				String HOUSELOCATION = cursor.getString(39);
				String EXTERIORCONDITION = cursor.getString(40);
				String INTERIORCONDITION = cursor.getString(41);
				String THIRDPARTYCONTACT = cursor.getString(42);
				String ASSETSTV = cursor.getString(43);
				String ASSETSAC = cursor.getString(44);
				String ASSETSFRIDGE = cursor.getString(45);
				String ASSETSMUSIC = cursor.getString(46);
				String ASSETSNA = cursor.getString(47);
				String NEGATIVEAREA = cursor.getString(48);
				String FAMILYSTRUCTURE = cursor.getString(49);
				String FAMILYSTATUS = cursor.getString(50);
				String ORGANISATION = cursor.getString(51);
				String PROFESSION = cursor.getString(52);
				String SERVICEYEAR = cursor.getString(53);
				String VEHICLE = cursor.getString(54);
				String EDUCATION = cursor.getString(55);
				String AGENTRATING = cursor.getString(56);
				String CPVSTATUS = cursor.getString(57);
				String STREMARK = cursor.getString(58);
				String Lat = cursor.getString(59);
				String Lang = cursor.getString(60);


				DownloadFilesTask df = new DownloadFilesTask(this);
				df.execute(CASEID,CPVNUMBER,CUSTOMERNAME,BILLINGLANDMARK,BILLINGLANDLINE,EMAILID,BILLINGADDRESSCHANGE,COMPANYLANDMARK,COMPANYLANDLINE,COMPANYADDRESSCHANGE,ADDTYPE,ADDRESSVERIFIED,SUBIDENTITYCONFIRM,VISITMONTH,VISITDATE,VISITYEAR,VISITTIMEHOUR,VISITTIMEMINUTE,PERSONCONTACT,RELATIONPERSON,REMARKS,SIMRECEIVED,NEIGHBORCHECK,HOUSEAREA,HOUSELOCALITY,HOUSEOWNERSHIP,RESIDENCETYPE,HOUSEAPPROACH,HOUSELOCATION,	EXTERIORCONDITION,INTERIORCONDITION,THIRDPARTYCONTACT,ASSETSTV,ASSETSAC,ASSETSFRIDGE,ASSETSMUSIC,ASSETSNA,NEGATIVEAREA,	FAMILYSTRUCTURE,FAMILYSTATUS,ORGANISATION,PROFESSION,SERVICEYEAR,VEHICLE,EDUCATION,AGENTRATING,CPVSTATUS,STREMARK,Lat, Lang);

					
				cursor.moveToNext();

			}
		} else {
			Toast.makeText(getApplicationContext(),
					"PLEASE COMPLETE SOME CASES FIRST", Toast.LENGTH_LONG)
					.show();

		}

	}

	public void downloadData(RequestParams params, final View view) {

		AsyncHttpClient client = new AsyncHttpClient();
		client.post(
				"http://aaplus.co.in/download.aspx",
				params, new AsyncHttpResponseHandler() {
					@Override
					public void onFinish() {
						loader.dismiss();
						super.onFinish();
					}

					@Override
					public void onStart() {
						new ProgressDialog(getApplicationContext());
						loader = ProgressDialog.show(
								UploadDownloadActivity.this, "",
								"Please Wait..");
						super.onStart();
					}

					@Override
					public void onFailure(Throwable arg0, String arg1) {
						super.onFailure(arg0, arg1);
						loader.dismiss();

						Log.d("stringIs", arg1);

						Toast.makeText(getApplicationContext(),
								"Failed to download Data "+arg1, Toast.LENGTH_LONG)
								.show();
					}

					@Override
					public void onSuccess(String response) {
						datasource.deleteData();
						
						Toast.makeText(getApplicationContext(),
								"Cases Downloaded Successfully",
								Toast.LENGTH_LONG).show();
						Document doc = XmlHelper.XMLfromString(response);
						NodeList nodes = doc
								.getElementsByTagName("opencpvlist");
						Element XMLPayload = (Element) nodes.item(0);
						NodeList nl = XMLPayload
								.getElementsByTagName("cpvlist");
						for (int i = 0; i < nl.getLength(); i++) {
							String ID = "ID";
							String CPVDate = "CPVDate";
							String CPVNumber = "CPVNumber";
							String Mobile = "Mobile";
							String CustomerName = "CustomerName";
							String AlternateNumber = "AlternateNumber";
							String Address = "Address";
							String Pincode = "PINCODE";
							String CompanyName = "ComapnyName";
							String CompanyAddress = "Address";
							String CompanyPincode = "Pincode";
							Map<String, String> comment = new HashMap<String, String>();
							Element e = (Element) nl.item(i);
							Node child;
							if (e.hasChildNodes()) {
								for (child = e.getFirstChild(); child != null; child = child
										.getNextSibling()) {
									if (child.getNodeName().equals("#text")
											&& child.getNextSibling() != null)
										continue;
									if (child.getNodeName().equals("#text") == false)
										comment.put(child.getNodeName()
												.toString(), child
												.getTextContent().toString());

								}
							}

							
							datasource.createComment("downloaded",
									comment.get(ID), comment.get(CPVDate),
									comment.get(CPVNumber),
									comment.get(Mobile),
									comment.get(CustomerName),
									comment.get(AlternateNumber),
									comment.get(Address), comment.get(Pincode),
									comment.get(CompanyName),
									comment.get(CompanyAddress),
									comment.get(CompanyPincode), null, null,
									null, null, null, null, null, null, null,
									null, null, null, null, null, null, null,
									null, null, null, null, null, null, null,
									null, null, null, null, null, null, null,
									null, null, null, null, null, null, null,
									null, null, null, null, null, null, null,
									null, null,null,null);

						}
						loader.dismiss();

					}

				});

	}

	public byte[] pathToByteArray(String imagePath) {

		Bitmap	image = resizeBitMapImage(imagePath, 320, 480);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
		return baos.toByteArray();
	}

	public static Bitmap resizeBitMapImage(String filePath, int targetWidth,
			int targetHeight) {
		Bitmap bitMapImage = null;
		
		if (filePath != null) {
			bitMapImage = BitmapFactory.decodeFile(filePath);
			
			int bitmapImageWidth = bitMapImage.getWidth();
			int bitmapImageHeight = bitMapImage.getHeight();
			
			if(bitmapImageWidth > targetWidth) {
				float scaleFactor = bitmapImageWidth / targetWidth;
				
				bitmapImageWidth = (int) (bitmapImageWidth / scaleFactor);
				bitmapImageHeight = (int) (bitmapImageHeight / scaleFactor);
				
			}
			
			bitMapImage = Bitmap.createScaledBitmap(bitMapImage, bitmapImageWidth, bitmapImageHeight, false);
		}

		return bitMapImage;
	}
	
	
	public class DownloadFilesTask extends AsyncTask<String, Integer, String> {
		
		Context mContext;
		
		public DownloadFilesTask(Context ctx) {
			mContext = ctx;
		}
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			
		}
		
		@Override
		protected String doInBackground(String... strings) {

			String CASEID = strings[0];
			String EXEC_CODE = strings[2];
			String CPVNUMBER = strings[1];
			String BILLINGLANDMARK = strings[3];
			String BILLINGLANDLINE = strings[4];
			String EMAILID = strings[5];
			String BILLINGADDRESSCHANGE = strings[6];
			String COMPANYLANDMARK = strings[7];
			String COMPANYLANDLINE = strings[8];
			String COMPANYADDRESSCHANGE = strings[9];
			String ADDTYPE = strings[10];
			String ADDRESSVERIFIED = strings[11];
			String SUBIDENTITYCONFIRM = strings[12];
			String VISITMONTH = strings[13];
			String VISITDATE = strings[14];
			String VISITYEAR = strings[15];
			String VISITTIMEHOUR = strings[16];
			String VISITTIMEMINUTE = strings[17];
			String PERSONCONTACT = strings[18];
			String RELATIONPERSON = strings[19];
			String REMARKS = strings[20];
			String SIMRECEIVED = strings[21];
			String NEIGHBORCHECK = strings[22];
			String HOUSEAREA = strings[23];
			String HOUSELOCALITY = strings[24];
			String HOUSEOWNERSHIP = strings[25];
			String RESIDENCETYPE = strings[26];
			String HOUSEAPPROACH = strings[27];
			String HOUSELOCATION = strings[28];
			String EXTERIORCONDITION = strings[29];
			String INTERIORCONDITION = strings[30];
			String THIRDPARTYCONTACT = strings[31];
			String ASSETSTV = strings[32];
			String ASSETSAC = strings[33];
			String ASSETSFRIDGE = strings[34];
			String ASSETSMUSIC = strings[35];
			String ASSETSNA = strings[36];
			String NEGATIVEAREA = strings[37];
			String FAMILYSTRUCTURE = strings[38];
			String FAMILYSTATUS = strings[39];
			String ORGANISATION = strings[40];
			String PROFESSION = strings[41];
			String SERVICEYEAR = strings[42];
			String VEHICLE = strings[43];
			String EDUCATION = strings[44];
			String AGENTRATING = strings[45];
			String CPVSTATUS = strings[46];
			String STREMARK = strings[47];
			String Lat= strings[48];
			String Lang= strings[49];
			Cursor imageCursor = CommentsDataSource.getImageCursor(CASEID);
			imageCursor.moveToFirst();
			String success = "Image Success";
			String failure ="Failure";



			List<NameValuePair> pairs = new ArrayList<NameValuePair>();

			pairs.add(new BasicNameValuePair("ID", CASEID));
			pairs.add(new BasicNameValuePair("cpv_number", CPVNUMBER));
			pairs.add(new BasicNameValuePair("EXEC_CODE", EXEC_CODE));
			pairs.add(new BasicNameValuePair("code", EXEC_CODE));
			pairs.add(new BasicNameValuePair("BILLING_LANDMARK", BILLINGLANDMARK));
			pairs.add(new BasicNameValuePair("BILLING_LANDLINE", BILLINGLANDLINE));
			pairs.add(new BasicNameValuePair("EMAIL", EMAILID));
			pairs.add(new BasicNameValuePair("BILLING_ADDRESS_CHANGE", BILLINGADDRESSCHANGE));
			pairs.add(new BasicNameValuePair("COMPANY_LANDMARK", COMPANYLANDMARK));
			pairs.add(new BasicNameValuePair("COMPANY_LANDLINE", COMPANYLANDLINE));
			pairs.add(new BasicNameValuePair("COMPANY_ADDRESS_CHANGE", COMPANYADDRESSCHANGE));
			pairs.add(new BasicNameValuePair("ADD_TYPE", ADDTYPE));
			pairs.add(new BasicNameValuePair("ADDRESS_VERIFIED", ADDRESSVERIFIED));


			pairs.add(new BasicNameValuePair("SUB_IDENTITY_CONFIRM", SUBIDENTITYCONFIRM));
			pairs.add(new BasicNameValuePair("visit_mm", VISITMONTH));
			pairs.add(new BasicNameValuePair("visit_dd", VISITDATE));
			pairs.add(new BasicNameValuePair("visit_yy", VISITYEAR));
			pairs.add(new BasicNameValuePair("visit_time_hh", VISITTIMEHOUR));
			pairs.add(new BasicNameValuePair("visit_time_mm", VISITTIMEMINUTE));


			pairs.add(new BasicNameValuePair("PERSON_CONTACT", PERSONCONTACT));
			pairs.add(new BasicNameValuePair("RELATION_PERSON", RELATIONPERSON));
			pairs.add(new BasicNameValuePair("REMARKS", REMARKS));
			pairs.add(new BasicNameValuePair("SIM_RECD", SIMRECEIVED));
			pairs.add(new BasicNameValuePair("NEIGHBOR_CHECK", NEIGHBORCHECK));
			pairs.add(new BasicNameValuePair("HOUSE_AREA", HOUSEAREA));


			pairs.add(new BasicNameValuePair("HOUSE_LOCALITY", HOUSELOCALITY));
			pairs.add(new BasicNameValuePair("HOUSE_OWNERSHIP", HOUSEOWNERSHIP));
			pairs.add(new BasicNameValuePair("RESIDENCE_TYPE", RESIDENCETYPE));
			pairs.add(new BasicNameValuePair("HOUSE_APPROACH", HOUSEAPPROACH));
			pairs.add(new BasicNameValuePair("HOUSE_LOCATION", HOUSELOCATION));
			pairs.add(new BasicNameValuePair("EXTERIOR_CONDITION", EXTERIORCONDITION));


			pairs.add(new BasicNameValuePair("INTERIOR_CONDITION", INTERIORCONDITION));
			pairs.add(new BasicNameValuePair("THIRD_PARTY_CONTACT", THIRDPARTYCONTACT));
			pairs.add(new BasicNameValuePair("ASSETS_TV", ASSETSTV));
			pairs.add(new BasicNameValuePair("ASSETS_AC", ASSETSAC));
			pairs.add(new BasicNameValuePair("ASSETS_FRIDGE", ASSETSFRIDGE));
			pairs.add(new BasicNameValuePair("ASSETS_MUSIC", ASSETSMUSIC));


			pairs.add(new BasicNameValuePair("ASSETS_NA", ASSETSNA));
			pairs.add(new BasicNameValuePair("NEGATIVE_AREA", NEGATIVEAREA));
			pairs.add(new BasicNameValuePair("FAMILY_STRUCTURE", FAMILYSTRUCTURE));
			pairs.add(new BasicNameValuePair("FAMILY_STATUS", FAMILYSTATUS));
			pairs.add(new BasicNameValuePair("ORGANISATION", ORGANISATION));
			pairs.add(new BasicNameValuePair("PROFESSION", PROFESSION));


			pairs.add(new BasicNameValuePair("SERVICE_YEAR", SERVICEYEAR));
			pairs.add(new BasicNameValuePair("VEHICLE", VEHICLE));
			pairs.add(new BasicNameValuePair("EDUCATION", EDUCATION));
			pairs.add(new BasicNameValuePair("AGENT_RATING", AGENTRATING));
			pairs.add(new BasicNameValuePair("CPV_STATUS", CPVSTATUS));
			pairs.add(new BasicNameValuePair("ST_REMARK", STREMARK));


			pairs.add(new BasicNameValuePair("cpv_lat", Lat));
			pairs.add(new BasicNameValuePair("cpv_long", Lang));


			

			byte[] signatureImage = pathToByteArray(imageCursor.getString(3));	 	
			byte[] jpegOne = pathToByteArray(imageCursor.getString(4));
			byte[] jpegTwo = pathToByteArray(imageCursor.getString(5));
			byte[] jpegThree = pathToByteArray(imageCursor.getString(6));

			


			String signatureImageString = Base64.encodeToString(signatureImage, Base64.DEFAULT);
			String jpegOneString = Base64.encodeToString(jpegOne, Base64.DEFAULT);
			String jpegTwoString = Base64.encodeToString(jpegTwo, Base64.DEFAULT);
			String jpegThreeString = Base64.encodeToString(jpegThree, Base64.DEFAULT);

			
			
			pairs.add(new BasicNameValuePair("jpgfile2", jpegOneString));
			pairs.add(new BasicNameValuePair("jpgfile3", jpegTwoString));
			pairs.add(new BasicNameValuePair("jpgfile4", jpegThreeString));
			pairs.add(new BasicNameValuePair("signature", signatureImageString));


			HttpParams params = new BasicHttpParams();
			params.setParameter(CoreProtocolPNames.PROTOCOL_VERSION,
					HttpVersion.HTTP_1_1);
			HttpClient mHttpClient = new DefaultHttpClient(params);
			HttpPost localHttpPost = new HttpPost("http://aaplus.co.in/UpdateData.aspx");
			localHttpPost.setHeader("Content-Type",
                    "application/x-www-form-urlencoded;charset=UTF-8");


			try {
				localHttpPost.setEntity(new UrlEncodedFormEntity(pairs));
				ResponseHandler<String> responseHandler = new BasicResponseHandler();				
				
				String response = mHttpClient.execute(localHttpPost, responseHandler);
				
				Log.d("response", response);
				
				try {
				
					data.delete(MySQLiteHelper.TABLE_COMMENTS, MySQLiteHelper.COLUMN_CPVNUMBER + " = '"+ CPVNUMBER+"'", null);
				}
				
				catch (Exception e) {}
				
				
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					if(uploadLoader.isShowing()) {
						uploadLoader.dismiss();
						Toast.makeText(UploadDownloadActivity.this, "Upload Complete", Toast.LENGTH_SHORT).show();
					}
				}
			});
			
			return success;

		}

		@Override
		protected void onPostExecute(String result) {
			
			
			if(uploadLoader.isShowing()) {
				uploadLoader.dismiss();
				Toast.makeText(UploadDownloadActivity.this, "Upload Complete", Toast.LENGTH_SHORT).show();
			}
		}
	}

	public String getPath(Uri uri) {
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = managedQuery(uri, projection, null, null, null);
		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}





	@Override
	protected void onResume() {
		datasource.open();
		super.onResume();
	}

	@Override
	protected void onPause() {
		datasource.close();
		super.onPause();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
