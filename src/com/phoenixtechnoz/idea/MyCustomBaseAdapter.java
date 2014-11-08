package com.phoenixtechnoz.idea;



import java.util.ArrayList;




import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;



public class MyCustomBaseAdapter extends BaseAdapter {

private static ArrayList<SearchResults> searchArrayList;

 

private LayoutInflater mInflater;



public MyCustomBaseAdapter(Context context, ArrayList<SearchResults> results) {

  searchArrayList = results;

  mInflater = LayoutInflater.from(context);

}



public int getCount() {

  return searchArrayList.size();

}



public Object getItem(int position) {

  return searchArrayList.get(position);

}



public long getItemId(int position) {

  return position;

}



public View getView(int position, View convertView, ViewGroup parent) {

  ViewHolder holder;

  if (convertView == null) {

  convertView = mInflater.inflate(R.layout.custom_row_view, null);

  holder = new ViewHolder();

  holder.caseid = (TextView) convertView.findViewById(R.id.caseid);

  holder.cpvdate = (TextView) convertView.findViewById(R.id.cpvdate);

  holder.cpvnumber = (TextView) convertView.findViewById(R.id.cpvnumber);

  holder.name = (TextView) convertView.findViewById(R.id.name);

  holder.mobile = (TextView) convertView.findViewById(R.id.mobile);

  holder.alternate = (TextView) convertView.findViewById(R.id.alternatenumber);

  holder.resiadd = (TextView) convertView.findViewById(R.id.resiaddress);
  
  holder.pincode = (TextView) convertView.findViewById(R.id.pincode);



  convertView.setTag(holder);

  } else {

  holder = (ViewHolder) convertView.getTag();

  }

 

  holder.caseid.setText(searchArrayList.get(position).getid());

  holder.cpvdate.setText(searchArrayList.get(position).getCpvdate());

  holder.cpvnumber.setText(searchArrayList.get(position).getCpvnumber());

  holder.name.setText(searchArrayList.get(position).getName());

  holder.mobile.setText(searchArrayList.get(position).getMobile());

  holder.alternate.setText(searchArrayList.get(position).getAlternatenumber());

  holder.resiadd.setText(searchArrayList.get(position).getResiaddress());
  
  holder.pincode.setText(searchArrayList.get(position).getResipincode());

 

  return convertView;

}



static class ViewHolder {

  TextView caseid;

  TextView cpvnumber;

  TextView cpvdate;

  TextView name;

  TextView mobile;

  TextView alternate;

  TextView resiadd;
  
  TextView pincode;
}

}