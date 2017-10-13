package com.example.dhruv.sooadproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhruv.sooadproject.Data.OrderDbHelper;
import com.example.dhruv.sooadproject.Data.OrderContract.OrderEntry;

import static android.R.attr.button;
import static com.example.dhruv.sooadproject.R.id.add;
import static com.example.dhruv.sooadproject.R.id.plus;

public class FoodItem extends AppCompatActivity {
    float price, temp;
    String name;
    int image_id;
    int noOfItems = 1;
    private OrderDbHelper myOrderDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item);

        price = getIntent().getFloatExtra("Price", 0);
        name = getIntent().getStringExtra("Name");
        image_id = getIntent().getIntExtra("FoodImage", 0);

        //Setting the price and name on the screen
        final TextView priceTextView = (TextView) findViewById(R.id.foodprice_text_view);
        priceTextView.setText("$" + price);

        TextView nameTextView = (TextView) findViewById(R.id.foodname_text_view);
        nameTextView.setText(name);

        ImageView foodImageView = (ImageView) findViewById(R.id.food_image_view);
        foodImageView.setImageResource(image_id);

        //for setting the quantuty
        temp = price;
        Button plus = (Button) findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noOfItems++;
                price = noOfItems * temp;
                TextView qtyTextView = (TextView) findViewById(R.id.quantity_text_view);
                qtyTextView.setText("" + noOfItems);
                priceTextView.setText("$" + price);
            }
        });

        Button minus = (Button) findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noOfItems == 0)
                    noOfItems = 0;
                else
                    noOfItems--;

                price = noOfItems * temp;
                TextView qtyTextView = (TextView) findViewById(R.id.quantity_text_view);
                qtyTextView.setText("" + noOfItems);
                priceTextView.setText("$" + price);

            }
        });

        //myOrderDb = new OrderDbHelper(this);


        Button addToCart = (Button) findViewById(R.id.add_to_cart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertItem();
            }
        });


    }

    public void viewCart(){
        Intent i = new Intent(FoodItem.this,view_cart.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    public void logout(){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_food_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.view_cart_tp:
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.logout:
                // Do nothing for now
                return true;
            case R.id.view_cart:
                viewCart();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void insertItem(){


        myOrderDb = new OrderDbHelper(FoodItem.this);
        SQLiteDatabase db = myOrderDb.getWritableDatabase();
       // myOrderDb.onCreate(db);


        ContentValues values = new ContentValues();
        values.put(OrderEntry.COLUMN_item_name, name);
        values.put(OrderEntry.COLUMN_item_price, price);
        values.put(OrderEntry.COLUMN_item_qty, noOfItems);


        long rowId = db.insert(OrderEntry.TABLE_NAME, null, values);

        if (rowId > 0)
            Toast.makeText(FoodItem.this, "Item Added Successfully", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(FoodItem.this, "Item NOT ADDED", Toast.LENGTH_SHORT).show();

    }


}
