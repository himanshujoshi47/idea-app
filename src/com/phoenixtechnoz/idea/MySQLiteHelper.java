package com.phoenixtechnoz.idea;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {


	public static final String TABLE_COMMENTS = "cpvData";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_CASESTATUS="case_status";
	public static final String COLUMN_CASEID = "caseid";
	public static final String COLUMN_CPVDATE = "cpv_date";
	public static final String COLUMN_CPVNUMBER = "cpv_number";
	public static final String COLUMN_MOBILE = "mobile";
	public static final String COLUMN_CUSTOMERNAME = "customer_name";
	public static final String COLUMN_ALTERNATENUMBER = "alternate_number";
	public static final String COLUMN_EMAILID = "email";
	public static final String COLUMN_ADDRESS = "resi_address";
	public static final String COLUMN_PINCODE = "resi_pincode";
	public static final String COLUMN_BILLINGLANDMARK = "resi_billing_landmark";
	public static final String COLUMN_BILLINGLANDLINE = "resi_billing_landline";
	public static final String COLUMN_BILLINGADDRESSCHANGE = "resi_billing_address_change";
	public static final String COLUMN_COMPANYNAME = "company_name";
	public static final String COLUMN_COMPANYADDRESS = "company_address";
	public static final String COLUMN_COMPANYPINCODE = "company_pincode";
	public static final String COLUMN_COMPANYLANDMARK = "company_landmark";
	public static final String COLUMN_COMPANYLANDLINE = "company_landline";
	public static final String COLUMN_COMPANYADDRESSCHANGE = "company_address_change";
	public static final String COLUMN_ADDTYPE = "add_type";
	public static final String COLUMN_ADDRESSVERIFIED = "address_verified";
	public static final String COLUMN_SUBIDENTITYCONFIRM = "sub_identity_confirm";
	public static final String COLUMN_VISITMONTH = "visit_mm";
	public static final String COLUMN_VISITDATE = "visit_dd";
	public static final String COLUMN_VISITYEAR = "visit_yy";
	public static final String COLUMN_VISITTIMEHOUR = "visit_time_hh";
	public static final String COLUMN_VISITTIMEMINUTE = "visit_time_mm";
	public static final String COLUMN_CODE = "code";
	public static final String COLUMN_PERSONCONTACT = "person_contact";
	public static final String COLUMN_RELATIONPERSON = "relation_person";
	public static final String COLUMN_REMARKS = "remarks";
	public static final String COLUMN_SIMRECEIVED = "sim_recd";
	public static final String COLUMN_NEIGHBORCHECK = "neighbor_check";
	public static final String COLUMN_HOUSEAREA = "house_area";
	public static final String COLUMN_HOUSELOCALITY = "house_locality";
	public static final String COLUMN_HOUSEOWNERSHIP = "house_ownership";
	public static final String COLUMN_RESIDENCETYPE = "residence_type";
	public static final String COLUMN_HOUSEAPPROACH = "house_approach";
	public static final String COLUMN_HOUSELOCATION = "house_location";
	public static final String COLUMN_EXTERIORCONDITION = "exterior_condition";
	public static final String COLUMN_INTERIORCONDITION = "interior_condition";
	public static final String COLUMN_THIRDPARTYCONTACT = "third_party_contact";
	public static final String COLUMN_ASSETSTV = "assets_tv";
	public static final String COLUMN_ASSETSAC = "assets_ac";
	public static final String COLUMN_ASSETSFRIDGE = "assets_fridge";
	public static final String COLUMN_ASSETSMUSIC = "assets_music";
	public static final String COLUMN_ASSETSNA = "assets_na";
	public static final String COLUMN_NEGATIVEAREA = "negative_area";
	public static final String COLUMN_FAMILYSTRUCTURE = "family_structure";
	public static final String COLUMN_FAMILYSTATUS = "family_status";
	public static final String COLUMN_ORGANISATION = "organisation";
	public static final String COLUMN_PROFESSION = "profession";
	public static final String COLUMN_SERVICEYEAR = "service_year";
	public static final String COLUMN_VEHICLE = "vehicle";
	public static final String COLUMN_EDUCATION = "education";
	public static final String COLUMN_AGENTRATING = "agent_rating";
	public static final String COLUMN_CPVSTATUS = "cpv_status";
	public static final String COLUMN_STREMARK = "st_remark";
	public static final String COLUMN_LAT = "lattitude";
	public static final String COLUMN_LANG = "longitude";
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_COMMENTS + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_CASESTATUS + " text, "  + COLUMN_CASEID
			+ " text, " + COLUMN_CPVDATE + " text, " + COLUMN_CPVNUMBER
			+ " text, " + COLUMN_MOBILE + " text, " + COLUMN_CUSTOMERNAME
			+ " text, " + COLUMN_ALTERNATENUMBER + " text, " + COLUMN_EMAILID
			+ " text, " + COLUMN_ADDRESS + " text, " + COLUMN_PINCODE
			+ " text, " + COLUMN_BILLINGLANDMARK + " text, "
			+ COLUMN_BILLINGLANDLINE + " text, " + COLUMN_BILLINGADDRESSCHANGE
			+ " text, " + COLUMN_COMPANYNAME + " text, "
			+ COLUMN_COMPANYADDRESS + " text, " + COLUMN_COMPANYPINCODE
			+ " text, " + COLUMN_COMPANYLANDMARK + " text, "
			+ COLUMN_COMPANYLANDLINE + " text, " + COLUMN_COMPANYADDRESSCHANGE
			+ " text, " + COLUMN_ADDTYPE + " text, " + COLUMN_ADDRESSVERIFIED
			+ " text, " + COLUMN_SUBIDENTITYCONFIRM + " text, "
			+ COLUMN_VISITMONTH + " text, " + COLUMN_VISITDATE + " text, "
			+ COLUMN_VISITYEAR + " text, " + COLUMN_VISITTIMEHOUR + " text, "
			+ COLUMN_VISITTIMEMINUTE + " text, " + COLUMN_CODE + " text, "
			+ COLUMN_PERSONCONTACT + " text, " + COLUMN_RELATIONPERSON
			+ " text, " + COLUMN_REMARKS + " text, " + COLUMN_SIMRECEIVED
			+ " text, " + COLUMN_NEIGHBORCHECK + " text, " + COLUMN_HOUSEAREA
			+ " text, " + COLUMN_HOUSELOCALITY + " text, "
			+ COLUMN_HOUSEOWNERSHIP + " text, " + COLUMN_RESIDENCETYPE
			+ " text, " + COLUMN_HOUSEAPPROACH + " text, "
			+ COLUMN_HOUSELOCATION + " text, " + COLUMN_EXTERIORCONDITION
			+ " text, " + COLUMN_INTERIORCONDITION + " text, "
			+ COLUMN_THIRDPARTYCONTACT + " text, " + COLUMN_ASSETSTV
			+ " text, " + COLUMN_ASSETSAC + " text, " + COLUMN_ASSETSFRIDGE
			+ " text, " + COLUMN_ASSETSMUSIC + " text, " + COLUMN_ASSETSNA
			+ " text, " + COLUMN_NEGATIVEAREA + " text, "
			+ COLUMN_FAMILYSTRUCTURE + " text, " + COLUMN_FAMILYSTATUS
			+ " text, " + COLUMN_ORGANISATION + " text, " + COLUMN_PROFESSION
			+ " text, " + COLUMN_SERVICEYEAR + " text, " 
			+ COLUMN_VEHICLE + " text, " 
			+ COLUMN_EDUCATION + " text, " 
			+ COLUMN_AGENTRATING+ " text, " 
			+ COLUMN_CPVSTATUS + " text, " 
			+ COLUMN_STREMARK + " text, " 
			+ COLUMN_LAT + " text, " 
			+ COLUMN_LANG
			+ " text);";
	
	public static final String COLUMN_username="userName";
	public static final String COLUMN_password="passWord";
	public static final String TABLE_LOGIN="loginTable";
	public static final String COLUMN_id="_id";
	private static final String DATABASE_CRE ="create table " + TABLE_LOGIN + 
			"(" + COLUMN_id + " integer primary key autoincrement, " + 
			COLUMN_username + " text, " + COLUMN_password + " text); ";
	
	public static final String TABLE_IMAGE="imageTable";
	public static final String COLUMN_Id="_id";
	public static final String COLUMN_EXECUTIVECODE="executiveCode";
	public static final String COLUMN_SIGNATUREPATH="signaturePath";
	public static final String COLUMN_IMAGE1="imageOne";
	public static final String COLUMN_IMAGE2="imageTwo";
	public static final String COLUMN_IMAGE3="imageThree";
	private static final String DATABASE_IMAGE ="create table " + TABLE_IMAGE + 
			"(" + COLUMN_Id + " integer primary key autoincrement, " + 
			COLUMN_CASEID + " text, "  + 
			COLUMN_EXECUTIVECODE + " text, " + 
			COLUMN_SIGNATUREPATH + " text, " + 
			COLUMN_IMAGE1 + " text, "   + 
			COLUMN_IMAGE2 + " text, " + 
			COLUMN_IMAGE3 + " text); ";
	
	
	private static final String DATABASE_NAME = "cpvDatabse.db";
	private static final int DATABASE_VERSION = 2;



	public MySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
  public void onCreate(SQLiteDatabase database) {
	  database.execSQL(DATABASE_CREATE);
	  database.execSQL(DATABASE_CRE);
	  database.execSQL(DATABASE_IMAGE);
  }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(MySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
		onCreate(db);
	}

}
