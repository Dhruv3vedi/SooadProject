package com.example.dhruv.sooadproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.example.dhruv.sooadproject.R.id.logout;

public class Menu_category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_category);

        TextView soupTextView = (TextView) findViewById(R.id.soups);
        soupTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(Menu_category.this, ItemsListActivity.class);
                intent.putExtra("id", 1);

                // Start the new activity
                startActivity(intent);
            }
        });

        TextView startersTextView = (TextView) findViewById(R.id.starters);
        startersTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(Menu_category.this, ItemsListActivity.class);
                intent.putExtra("id", 2);

                // Start the new activity
                startActivity(intent);
            }
        });

        TextView mainCourseTextView = (TextView) findViewById(R.id.main_course);
        mainCourseTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(Menu_category.this, ItemsListActivity.class);
                intent.putExtra("id", 3);

                // Start the new activity
                startActivity(intent);
            }
        });

        TextView breadsTextView = (TextView) findViewById(R.id.breads);
        breadsTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(Menu_category.this, ItemsListActivity.class);
                intent.putExtra("id", 4);

                // Start the new activity
                startActivity(intent);
            }
        });

        TextView riceTextView = (TextView) findViewById(R.id.rice_biryani);
        riceTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(Menu_category.this, ItemsListActivity.class);
                intent.putExtra("id", 5);

                // Start the new activity
                startActivity(intent);
            }
        });

        TextView noodlesTextView = (TextView) findViewById(R.id.fried_rice_noodles);
        noodlesTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(Menu_category.this, ItemsListActivity.class);
                intent.putExtra("id", 6);

                // Start the new activity
                startActivity(intent);
            }
        });

        TextView pizzaTextView = (TextView) findViewById(R.id.pizza_pasta);
        pizzaTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(Menu_category.this, ItemsListActivity.class);
                intent.putExtra("id", 7);

                // Start the new activity
                startActivity(intent);
            }
        });


        TextView burgerTetView = (TextView) findViewById(R.id.burgers);
        burgerTetView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(Menu_category.this, ItemsListActivity.class);
                intent.putExtra("id", 8);

                // Start the new activity
                startActivity(intent);
            }
        });

        TextView desertsTextView = (TextView) findViewById(R.id.deserts);
        desertsTextView.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                Intent intent = new Intent(Menu_category.this, ItemsListActivity.class);
                intent.putExtra("id", 9);

                // Start the new activity
                startActivity(intent);
            }
        });


    }

    public void viewCart(){
        Intent i = new Intent(Menu_category.this,view_cart.class);
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
            case logout:
               // logout();
                return true;
            case R.id.view_cart:
                viewCart();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
