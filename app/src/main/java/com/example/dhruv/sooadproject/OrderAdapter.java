package com.example.dhruv.sooadproject;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DHRUV on 15-09-2017.
 */

public class OrderAdapter extends ArrayAdapter<Item> {
    public OrderAdapter(Activity context, ArrayList<Item> items) {
        super(context, 0, items);}


        @NonNull
        @Override
        public View getView ( int position, @Nullable View convertView, @NonNull ViewGroup parent){
            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
            }

                //getb the current object in the  array list
                Item currentItem = getItem(position);

                //get the textview to set name
                TextView nameTextView = (TextView) listItemView.findViewById(R.id.item_text_view);

                //set the item name in the listview
                nameTextView.setText(currentItem.getName());

                TextView priceTextView = (TextView) listItemView.findViewById(R.id.price_text_view);
                priceTextView.setText("$"+ currentItem.getPrice());

                return listItemView;

        }
    }