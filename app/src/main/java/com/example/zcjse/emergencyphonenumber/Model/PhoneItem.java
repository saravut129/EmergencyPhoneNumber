package com.example.zcjse.emergencyphonenumber.Model;

/**
 * Created by zcjse on 11/26/2017.
 */

public class PhoneItem {

    public final int id;
    public final String title;
    public final String number;
    public final String picture;

    public PhoneItem(int id, String title, String number, String picture) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return title;

    }
}
