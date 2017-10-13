package com.example.dhruv.sooadproject;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DHRUV on 02-10-2017.
 */

public class CartAdapter extends ArrayAdapter<Cart> {

    public CartAdapter(Activity context, ArrayList<Cart> cart){
        super(context,0,cart);
    }

    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent){
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.cart_list_item, parent, false);
        }

        //getb the current object in the  array list
        Cart currentCart = getItem(position);

        //get the textview to set name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_carttext_view);

        //set the item name in the listview
        nameTextView.setText(currentCart.getName());

        TextView priceTextView = (TextView) listItemView.findViewById(R.id.price_carttext_view);
        priceTextView.setText( currentCart.getPrice());

        TextView qtyTextView = (TextView) listItemView.findViewById(R.id.qty_carttext_view);
        qtyTextView.setText(currentCart.getQty());

        //TextView srNoTextView = (TextView)listItemView.findViewById(R.id.sr_no_carttext_view);
        //srNoTextView.setText("" + currentCart.getId());

        return listItemView;

    }
}
