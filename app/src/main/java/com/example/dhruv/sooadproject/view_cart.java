package com.example.dhruv.sooadproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhruv.sooadproject.Data.OrderContract.OrderEntry;
import com.example.dhruv.sooadproject.Data.OrderDbHelper;

import java.util.ArrayList;

import static com.example.dhruv.sooadproject.R.string.login;


public class view_cart extends AppCompatActivity {

    private OrderDbHelper myOrderDb;
    final ArrayList<Cart> cart = new ArrayList<Cart>();
    private float total =0;
    private TextView total_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);


        total_textView= (TextView)findViewById(R.id.total_text_view);
        myOrderDb = new OrderDbHelper(this);
        displayCart();
        CartAdapter adapter = new CartAdapter(this, cart);
        ListView listView = (ListView) findViewById(R.id.cart_list_view);
        listView.setAdapter(adapter);

        Button confirm_order = (Button) findViewById(R.id.confirm_order_button);
        confirm_order.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                delete();

                // Create a new intent to open the
                Intent loginIntent = new Intent(view_cart.this, Menu_category.class);

                // Start the new activity
                startActivity(loginIntent);
            }
        });

    }




    public void displayCart() {

        SQLiteDatabase db = myOrderDb.getReadableDatabase();

        String[] projection = {
                OrderEntry._ID,
        OrderEntry.COLUMN_item_name,
        OrderEntry.COLUMN_item_qty,
        OrderEntry.COLUMN_item_price
    };

        Cursor c = db.query(
                OrderEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);
        //TextView displayCart = (TextView)findViewById(R.id.display_cart_items);

        try{
            /*displayCart.setText(         OrderEntry._ID + "  "
                  +  OrderEntry.COLUMN_item_name + "  "
                   + OrderEntry.COLUMN_item_qty + "  "
                   + OrderEntry.COLUMN_item_price);
                   */

            while(c.moveToNext()){
                int currentId = c.getInt(c.getColumnIndex(OrderEntry._ID));
                String itemName = c.getString(c.getColumnIndex(OrderEntry.COLUMN_item_name));
                String itemPrice = c.getString(c.getColumnIndex(OrderEntry.COLUMN_item_price));
                String itemQty = c.getString(c.getColumnIndex(OrderEntry.COLUMN_item_qty));
                Float price = Float.parseFloat(itemPrice);

                total+= price;

                cart.add(new Cart(currentId,itemName,itemQty,itemPrice));


                /* displayCart.append("\n" + currentId +"    "+
                 itemName +"    "+
                 itemQty +"    "+
                 itemPrice);*/
            }
            total_textView.setText("TOTAL : " + total);

        }
        finally {
            c.close();
        }


    }


    public void delete(){
        SQLiteDatabase database = myOrderDb.getWritableDatabase();

        String delete_table = "DELETE FROM " + OrderEntry.TABLE_NAME + ";";
        //String vacuum = "VACUUM;";

        database.execSQL(delete_table);
        //database.execSQL(vacuum);

        Toast.makeText(view_cart.this, "Order Confirmed!!", Toast.LENGTH_SHORT).show();


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
               // delete();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.logout:
                logout();
                return true;
            case R.id.view_cart:
                //viewCart();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
