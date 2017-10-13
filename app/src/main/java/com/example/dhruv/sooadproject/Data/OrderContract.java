package com.example.dhruv.sooadproject.Data;

import android.provider.BaseColumns;

/**
 * Created by DHRUV on 29-09-2017.
 */

public final class OrderContract {
    private OrderContract(){}

    public static final class OrderEntry implements BaseColumns{
        public final static String TABLE_NAME = "cart";

        /**
         * Unique ID number for the pet (only for use in the database table).
         *
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the pet.
         *
         * Type: TEXT
         */
        public final static String COLUMN_item_name ="name";

        /**
         * Breed of the pet.
         *
         * Type: TEXT
         */
        public final static String COLUMN_item_price = "price";

        /**
         * Gender of the pet.
         *
         * The only possible values are {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE},
         * or {@link #GENDER_FEMALE}.
         *
         * Type: INTEGER
         */
        public final static String COLUMN_item_qty = "quantity";

        /**
         * Weight of the pet.
         *
         * Type: INTEGER
         */
    }
}

