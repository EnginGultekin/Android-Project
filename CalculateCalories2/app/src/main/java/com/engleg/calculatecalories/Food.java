package com.engleg.calculatecalories;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Food implements Parcelable {

    int id;
    String name;
    int cal;
    int protein;
    int carbon;
    int yag;
    boolean isChecked;

    public Food() {}

    public Food(int id, String name, int cal, int protein, int carbon, int yag) {
        this.id = id;
        this.name = name;
        this.cal = cal;
        this.protein = protein;
        this.carbon = carbon;
        this.yag = yag;
        this.isChecked = false;
    }


    protected Food(Parcel in) {
        id = in.readInt();
        name = in.readString();
        cal = in.readInt();
        protein = in.readInt();
        carbon = in.readInt();
        yag = in.readInt();

    }

    public static final Creator<Food> CREATOR = new Creator<Food>() {
        @Override
        public Food createFromParcel(Parcel in) {
            return new Food(in);
        }

        @Override
        public Food[] newArray(int size) {
            return new Food[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(cal);
        dest.writeInt(protein);
        dest.writeInt(carbon);
        dest.writeInt(yag);
    }
}
