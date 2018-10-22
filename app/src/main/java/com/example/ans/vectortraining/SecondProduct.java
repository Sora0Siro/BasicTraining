package com.example.ans.vectortraining;

import android.os.Parcel;
import android.os.Parcelable;

public class SecondProduct implements Parcelable
{
    private String name;
    private String company;
    private int price;

    public static final Creator<SecondProduct> CREATOR = new Creator<SecondProduct>()
    {
        @Override
        public SecondProduct createFromParcel(Parcel source)
        {
            String name = source.readString();
            String company = source.readString();
            int price = source.readInt();
            return new SecondProduct(name,company,price);
        }

        @Override
        public SecondProduct[] newArray(int size)
        {
            return new SecondProduct[size];
        }
    };

    public SecondProduct(String name,String company,int price)
    {
        this.name = name;
        this.company = company;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel,int flags)
    {
        parcel.writeString(name);
        parcel.writeString(company);
        parcel.writeInt(price);
    }
}
