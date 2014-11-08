package com.phoenixtechnoz.idea;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CommentsDataSource {

	private static SQLiteDatabase data;
	private MySQLiteHelper dbHelper;

	private String[] all = { MySQLiteHelper.COLUMN_username,
			MySQLiteHelper.COLUMN_password };

	public CommentsDataSource(Context context) {
		dbHelper = new MySQLiteHelper(context);
	}

	public void open() throws SQLException {
		data = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	

	public void deleteData() {
		data.delete(MySQLiteHelper.TABLE_COMMENTS, null, null);
}

	public void createImage(String caseid, String executivecode,
			String signaturepath, String image1, String image2, String image3) {

		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_CASEID, caseid);
		values.put(MySQLiteHelper.COLUMN_EXECUTIVECODE, executivecode);
		values.put(MySQLiteHelper.COLUMN_SIGNATUREPATH, signaturepath);
		values.put(MySQLiteHelper.COLUMN_IMAGE1, image1);
		values.put(MySQLiteHelper.COLUMN_IMAGE2, image2);
		values.put(MySQLiteHelper.COLUMN_IMAGE3, image3);
		data.insert(MySQLiteHelper.TABLE_IMAGE, null, values);
	}

	public void createComment(String CASESTATUS, String CASEID, String CPVDATE,
			String CPVNUMBER, String MOBILE, String CUSTOMERNAME,
			String ALTERNATENUMBER, String ADDRESS, String PINCODE,
			String COMPANYNAME, String COMPANYADDRESS, String COMPANYPINCODE,
			String EMAILID, String BILLINGLANDMARK, String BILLINGLANDLINE,
			String BILLINGADDRESSCHANGE, String COMPANYLANDMARK,
			String COMPANYLANDLINE, String COMPANYADDRESSCHANGE,
			String ADDTYPE, String ADDRESSVERIFIED, String SUBIDENTITYCONFIRM,
			String VISITMONTH, String VISITDATE, String VISITYEAR,
			String VISITTIMEHOUR, String VISITTIMEMINUTE, String CODE,
			String PERSONCONTACT, String RELATIONPERSON, String REMARKS,
			String SIMRECEIVED, String NEIGHBORCHECK, String HOUSEAREA,
			String HOUSELOCALITY, String HOUSEOWNERSHIP, String RESIDENCETYPE,
			String HOUSEAPPROACH, String HOUSELOCATION,
			String EXTERIORCONDITION, String INTERIORCONDITION,
			String THIRDPARTYCONTACT, String ASSETSTV, String ASSETSAC,
			String ASSETSFRIDGE, String ASSETSMUSIC, String ASSETSNA,
			String NEGATIVEAREA, String FAMILYSTRUCTURE, String FAMILYSTATUS,
			String ORGANISATION, String PROFESSION, String SERVICEYEAR,
			String VEHICLE, String EDUCATION, String AGENTRATING,
			String CPVSTATUS, String STREMARK, String Lat, String Lang) {

		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_CASESTATUS, CASESTATUS);
		values.put(MySQLiteHelper.COLUMN_CASEID, CASEID);
		values.put(MySQLiteHelper.COLUMN_CPVDATE, CPVDATE);
		values.put(MySQLiteHelper.COLUMN_CPVNUMBER, CPVNUMBER);
		values.put(MySQLiteHelper.COLUMN_MOBILE, MOBILE);
		values.put(MySQLiteHelper.COLUMN_CUSTOMERNAME, CUSTOMERNAME);
		values.put(MySQLiteHelper.COLUMN_ALTERNATENUMBER, ALTERNATENUMBER);
		values.put(MySQLiteHelper.COLUMN_EMAILID, EMAILID);
		values.put(MySQLiteHelper.COLUMN_ADDRESS, ADDRESS);
		values.put(MySQLiteHelper.COLUMN_PINCODE, PINCODE);
		values.put(MySQLiteHelper.COLUMN_BILLINGLANDMARK, BILLINGLANDMARK);
		values.put(MySQLiteHelper.COLUMN_BILLINGLANDLINE, BILLINGLANDLINE);
		values.put(MySQLiteHelper.COLUMN_BILLINGADDRESSCHANGE,
				BILLINGADDRESSCHANGE);
		values.put(MySQLiteHelper.COLUMN_COMPANYNAME, COMPANYNAME);
		values.put(MySQLiteHelper.COLUMN_COMPANYADDRESS, COMPANYADDRESS);
		values.put(MySQLiteHelper.COLUMN_COMPANYPINCODE, COMPANYPINCODE);
		values.put(MySQLiteHelper.COLUMN_COMPANYLANDMARK, COMPANYLANDMARK);
		values.put(MySQLiteHelper.COLUMN_COMPANYLANDLINE, COMPANYLANDLINE);
		values.put(MySQLiteHelper.COLUMN_COMPANYADDRESSCHANGE,
				COMPANYADDRESSCHANGE);
		values.put(MySQLiteHelper.COLUMN_ADDTYPE, ADDTYPE);
		values.put(MySQLiteHelper.COLUMN_ADDRESSVERIFIED, ADDRESSVERIFIED);
		values.put(MySQLiteHelper.COLUMN_SUBIDENTITYCONFIRM, SUBIDENTITYCONFIRM);
		values.put(MySQLiteHelper.COLUMN_VISITMONTH, VISITMONTH);
		values.put(MySQLiteHelper.COLUMN_VISITDATE, VISITDATE);
		values.put(MySQLiteHelper.COLUMN_VISITYEAR, VISITYEAR);
		values.put(MySQLiteHelper.COLUMN_VISITTIMEHOUR, VISITTIMEHOUR);
		values.put(MySQLiteHelper.COLUMN_VISITTIMEMINUTE, VISITTIMEMINUTE);
		values.put(MySQLiteHelper.COLUMN_CODE, CODE);
		values.put(MySQLiteHelper.COLUMN_PERSONCONTACT, PERSONCONTACT);
		values.put(MySQLiteHelper.COLUMN_RELATIONPERSON, RELATIONPERSON);
		values.put(MySQLiteHelper.COLUMN_REMARKS, REMARKS);
		values.put(MySQLiteHelper.COLUMN_SIMRECEIVED, SIMRECEIVED);
		values.put(MySQLiteHelper.COLUMN_NEIGHBORCHECK, NEIGHBORCHECK);
		values.put(MySQLiteHelper.COLUMN_HOUSEAREA, HOUSEAREA);
		values.put(MySQLiteHelper.COLUMN_HOUSELOCALITY, HOUSELOCALITY);
		values.put(MySQLiteHelper.COLUMN_HOUSEOWNERSHIP, HOUSEOWNERSHIP);
		values.put(MySQLiteHelper.COLUMN_RESIDENCETYPE, RESIDENCETYPE);
		values.put(MySQLiteHelper.COLUMN_HOUSEAPPROACH, HOUSEAPPROACH);
		values.put(MySQLiteHelper.COLUMN_HOUSELOCATION, HOUSELOCATION);
		values.put(MySQLiteHelper.COLUMN_EXTERIORCONDITION, EXTERIORCONDITION);
		values.put(MySQLiteHelper.COLUMN_INTERIORCONDITION, INTERIORCONDITION);
		values.put(MySQLiteHelper.COLUMN_THIRDPARTYCONTACT, THIRDPARTYCONTACT);
		values.put(MySQLiteHelper.COLUMN_ASSETSTV, ASSETSTV);
		values.put(MySQLiteHelper.COLUMN_ASSETSAC, ASSETSAC);
		values.put(MySQLiteHelper.COLUMN_ASSETSFRIDGE, ASSETSFRIDGE);
		values.put(MySQLiteHelper.COLUMN_ASSETSMUSIC, ASSETSMUSIC);
		values.put(MySQLiteHelper.COLUMN_ASSETSNA, ASSETSNA);
		values.put(MySQLiteHelper.COLUMN_NEGATIVEAREA, NEGATIVEAREA);
		values.put(MySQLiteHelper.COLUMN_FAMILYSTRUCTURE, FAMILYSTRUCTURE);
		values.put(MySQLiteHelper.COLUMN_FAMILYSTATUS, FAMILYSTATUS);
		values.put(MySQLiteHelper.COLUMN_ORGANISATION, ORGANISATION);
		values.put(MySQLiteHelper.COLUMN_PROFESSION, PROFESSION);
		values.put(MySQLiteHelper.COLUMN_SERVICEYEAR, SERVICEYEAR);
		values.put(MySQLiteHelper.COLUMN_VEHICLE, VEHICLE);
		values.put(MySQLiteHelper.COLUMN_EDUCATION, EDUCATION);
		values.put(MySQLiteHelper.COLUMN_AGENTRATING, AGENTRATING);
		values.put(MySQLiteHelper.COLUMN_CPVSTATUS, CPVSTATUS);
		values.put(MySQLiteHelper.COLUMN_STREMARK, STREMARK);
		values.put(MySQLiteHelper.COLUMN_LAT, Lat);
		values.put(MySQLiteHelper.COLUMN_LANG, Lang);

		data.insert(MySQLiteHelper.TABLE_COMMENTS, null, values);

	}

	public void end() {
		data.close();
	}


	public void createUser(String userName, String passWord) {
		ContentValues values = new ContentValues();
		values.put(MySQLiteHelper.COLUMN_username, userName);
		values.put(MySQLiteHelper.COLUMN_password, passWord);
		long insertId = data.insert(MySQLiteHelper.TABLE_LOGIN, null, values);
		Log.d("Insert ID", String.valueOf(insertId));
		Cursor cursor = data.query(MySQLiteHelper.TABLE_LOGIN, all,
				MySQLiteHelper.COLUMN_id + " = " + insertId, null, null, null,
				null);
		cursor.moveToFirst();
		cursor.close();
	}

	public static String getUser() {
		Cursor cursor = data.rawQuery("select * from "
				+ MySQLiteHelper.TABLE_LOGIN, null);
		int numRows = cursor.getCount();
		
		
		
		
		if (numRows > 0) {
			cursor.moveToFirst();
			String userName = cursor.getString(1);
			Log.i("get user function retured", userName);
			return userName;
		}
		return null;
	}

	public static Cursor getImageCursor(String CASEID) {
		Cursor imageCursor = data.rawQuery("SELECT * FROM "
				+ MySQLiteHelper.TABLE_IMAGE + " WHERE "
				+ MySQLiteHelper.COLUMN_CASEID + " ='" + CASEID + "'", null);
		return imageCursor;

	}

	public static Cursor getUploadDataCursor(String CaseStatus) {
		Cursor uploadDataCursor = data.rawQuery("SELECT * FROM "
				+ MySQLiteHelper.TABLE_COMMENTS + " WHERE " + CaseStatus
				+ " ='" + "complete" + "'", null);

		return uploadDataCursor;

	}
	


}