package com.phoenixtechnoz.idea;

public class SearchResults {
	 private String id="";
	 private String cpvdate="";
	 private String cpvnumber="";
	 private String mobile="";
	 private String name = "";
	 private String alternatenumber="";
	 private String resiaddress="";
	 private String resipincode="";
	 private String companyname="";
	 private String compaddress="";
	 private String compincode="";

	 public void setComanypincode(String compincode){
			this.compincode=compincode; 
		 }

		 public String getCompanypincode(){
			 return compincode;
		 }
	 
	 public void setCompanyname(String companyname){
			this.companyname=companyname; 
		 }

		 public String getCompanyname(){
			 return companyname;
		 }
		 
		 public void setCompanyaddress(String compaddress){
				this.compaddress=compaddress; 
			 }

			 public String getCompanyaddress(){
				 return compaddress;
			 }
	 
	 public void setResiaddress(String resiaddress){
			this.resiaddress=resiaddress; 
		 }

		 public String getResiaddress(){
			 return resiaddress;
		 }
		 
	 
	 public void setResipincode(String pin){
			this.resipincode=pin; 
		 }

		 public String getResipincode(){
			 return resipincode;
		 }
	 
	 public void setName(String name) {
	  this.name = name;
	 }

	 public String getName() {
	  return name;
	 }
	 
	 public void setAlternatenumber(String number){
			this.alternatenumber=number; 
		 }

		 public String getAlternatenumber(){
			 return alternatenumber;
		 }
		 

	 public void setid(String id) {
	  this.id = id;
	 }

	 public String getid() {
	  return id;
	 }

	 public void setMobile(String mobile) {
	  this.mobile = mobile;
	 }

	 public String getMobile() {
	  return mobile;
	 }
	 
	 public void setCpvdate(String cpvdate){
		this.cpvdate=cpvdate; 
	 }

	 public String getCpvdate(){
		 return cpvdate;
	 }
	 
	 public void setCpvnumber(String cpvnumber){
			this.cpvnumber=cpvnumber; 
		 }

		 public String getCpvnumber(){
			 return cpvnumber;
		 }
	 
	}
