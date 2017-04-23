package com.android.demo.sampletest;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by bhara on 16/04/17.
 */

public class UserData implements Parcelable {

    String name;
    String address;
    boolean isMarried;
    int age;
    String[] courses;
    List<String> subjs;

    public UserData(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        name=parcel.readString();
        address=parcel.readString();
        isMarried=parcel.readInt()!=0;
        age=parcel.readInt();
        parcel.readStringArray(courses);
        parcel.readArrayList(subjs.getClass().getClassLoader());
    }

    protected UserData(Parcel in) {
        in.writeString(name);
        in.writeString(address);
        in.writeInt(isMarried ? 1 : 0);
        in.writeInt(age);
        in.writeStringArray(courses);
        in.writeStringList(subjs);
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {

        @Override
        public UserData createFromParcel(Parcel parcel) {
            return new UserData(parcel);
        }

        @Override
        public UserData[] newArray(int i) {
            return new UserData[0];
        }
    };
}
