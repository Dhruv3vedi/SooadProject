package com.example.dhruv.sooadproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;
import static com.example.dhruv.sooadproject.R.id.logout;

public class ItemsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_display);

        int id = getIntent().getIntExtra("id", 0);

        final ArrayList<Item> order = new ArrayList<Item>();
        //Soups
        if (id == 1) {

            order.add(new Item(200, "Taco Soup", R.drawable.taco_soup));
            order.add(new Item(250, "Beer cheese soup", R.drawable.beer_cheese_soup));
            order.add(new Item(250, "WIne soup", R.drawable.wine_soup));

        }
        //Starters
        else if (id == 2) {
            order.add(new Item(300, "Cheese Balls", R.drawable.cheese_balls));
            order.add(new Item(350, "Hot basil chicken cups", R.drawable.hot_basil_chicken_cups));
            order.add(new Item(300, "Microwave paneer tikkas", R.drawable.microwave_panee_tikkas));

        }
        //Main Course
        else if (id == 3) {
            order.add(new Item(500, "Sphageti Bolognese", R.drawable.spaghetti_bolognese));
            order.add(new Item(450, "Carbonara pasta", R.drawable.carbonara_pasta));
            order.add(new Item(400, "Lasagna", R.drawable.lasagna));

        }
        //Breads
        else if (id == 4) {
            order.add(new Item(10, "PizzaBreads", R.drawable.pizza));
            order.add(new Item(10, "PizzaSoup", R.drawable.pizza));
            order.add(new Item(10, "PizzaSoup", R.drawable.pizza));

        }
        //Biryani
        else if (id == 5) {
            order.add(new Item(450, "Hydrebadi biryani", R.drawable.hyderabadi_biryani));
            order.add(new Item(500, "Makhni paneer biryani", R.drawable.makhni_paneer_biryani));
            order.add(new Item(500, "Machlli biryani", R.drawable.machchli_biryani));

        }
        //noodles
        else if (id == 6) {
            order.add(new Item(350, "Thai Noodle Soup", R.drawable.thai_noodle_soup));
            order.add(new Item(450, "Chicken Choupsey", R.drawable.chicken_chopsuey));
            order.add(new Item(500, "Rice Noodles with stir fried chicken", R.drawable.rice_noodles_with_stir_fried_chicken));

        }
        //pizza pasta
        else if (id == 7) {
            order.add(new Item(450, "Pepperoni pizza", R.drawable.pepperoni_pizza));
            order.add(new Item(475, "Mexican pizza", R.drawable.mexican_pizza));
            order.add(new Item(450, "Kebab Paneer Pizza", R.drawable.kebab_paneer_pizza));
        }
        //burgers
        else if (id == 8) {
            order.add(new Item(400, "PizzaBurgers", R.drawable.chilli_burger_with_pepper_relish));
            order.add(new Item(450, "Stuffed Bean Burger", R.drawable.stuffed_bean_burger));
            order.add(new Item(420, "Supreme veggie Burger", R.drawable.supreme_veggie_burger));

        }
        //deserts
        else if (id == 9) {
            order.add(new Item(300, "Aam Shrikhand", R.drawable.aam_shrikhand));
            order.add(new Item(250, "Gulab jamun", R.drawable.gulab_jamun));
            order.add(new Item(250, "Kulfi", R.drawable.kulfi));
        }


        OrderAdapter adapter = new OrderAdapter(this, order);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        //Button b = (Button)findViewById(R.id.button_add);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item = order.get(i);
                Intent food = new Intent(ItemsListActivity.this, FoodItem.class);
                food.putExtra("Price", item.getPrice());
                food.putExtra("Name", item.getName());
                food.putExtra("FoodImage", item.getFood_id());
                startActivity(food);
            }
        });

    }

    public void viewCart() {
        Intent i = new Intent(ItemsListActivity.this, view_cart.class);
        startActivity(i);
    }

    public void logout() {
        Intent i = new Intent(this, MainActivity.class);
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
                logout();
                return true;
            case R.id.view_cart:
                viewCart();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
