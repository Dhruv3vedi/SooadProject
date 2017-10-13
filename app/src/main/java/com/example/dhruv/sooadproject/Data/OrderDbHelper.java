package com.example.dhruv.sooadproject.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.dhruv.sooadproject.Data.OrderContract.OrderEntry;

/**
 * Created by DHRUV on 29-09-2017.
 */

public class OrderDbHelper extends SQLiteOpenHelper {
    public static final String LOG_TAG = OrderDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "order.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link OrderDbHelper}.
     *
     * @param context of the app
     */
    public OrderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_ORDER_TABLE =  "CREATE TABLE " + OrderEntry.TABLE_NAME + " ("
                + OrderEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + OrderEntry.COLUMN_item_name + " TEXT , "
                + OrderEntry.COLUMN_item_price + " TEXT, "
                + OrderEntry.COLUMN_item_qty + " INTEGER NOT NULL " + ");";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_ORDER_TABLE);
    }

    /**zzzzzz
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }

}
