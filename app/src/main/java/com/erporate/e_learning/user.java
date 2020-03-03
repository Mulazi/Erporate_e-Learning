package com.erporate.e_learning;

import android.os.Parcel;
import android.os.Parcelable;

public class user implements Parcelable {
    public  String Fname, Lname, Email, Pwd, School, Gender, City, Birth;

    public user (){

    }

    public user(String fname, String lname, String email, String pwd, String school, String city) {
        this.Fname = fname;
        this.Lname = lname;
        this.Email = email;
        this.Pwd = pwd;
        this.School = school;
        this.City = city;
    }


    protected user(Parcel in) {
        Fname = in.readString();
        Lname = in.readString();
        Email = in.readString();
        Pwd = in.readString();
        School = in.readString();
        Gender = in.readString();
        City = in.readString();
        Birth = in.readString();
    }

    public static final Creator<user> CREATOR = new Creator<user>() {
        @Override
        public user createFromParcel(Parcel in) {
            return new user(in);
        }

        @Override
        public user[] newArray(int size) {
            return new user[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Fname);
        dest.writeString(Lname);
        dest.writeString(Email);
        dest.writeString(Pwd);
        dest.writeString(School);
        dest.writeString(Gender);
        dest.writeString(City);
        dest.writeString(Birth);
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }
}



