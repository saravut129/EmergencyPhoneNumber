package com.example.zcjse.emergencyphonenumber;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.zcjse.emergencyphonenumber.DB.PhoneDb;
import com.example.zcjse.emergencyphonenumber.Model.PhoneItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PhoneDb mHelper;
    private SQLiteDatabase mDb;

    private ArrayList<PhoneItem> mphoneItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelper = new PhoneDb(this);
        mDb = mHelper.getReadableDatabase();

        Cursor cursor = mDb.query(
                PhoneDb.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(PhoneDb.COL_ID));
            String title = cursor.getString(cursor.getColumnIndex(PhoneDb.COL_TITLE));
            String number = cursor.getString(cursor.getColumnIndex(PhoneDb.COL_NUMBER));
            String picture = cursor.getString(cursor.getColumnIndex(PhoneDb.COL_PICTURE));

            PhoneItem item = new PhoneItem(id,title,number,picture);
            mphoneItemList.add(item);

        }

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                mphoneItemList
        );

        ListView lv = findViewById(R.id.list_view);
        lv.setAdapter(adapter);


    }

}
