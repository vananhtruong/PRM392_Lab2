package com.example.lab_sed01;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;


import java.util.List;
import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    RecyclerView recyclerViewProducts;
    ProductAdapter productAdapter;
    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));

        productList = new ArrayList<>();
        productList.add(new Product("Apple", R.drawable.ic_launcher_foreground));
        productList.add(new Product("Banana", R.drawable.ic_launcher_foreground));
        productList.add(new Product("Orange", R.drawable.ic_launcher_foreground));

        productAdapter = new ProductAdapter(this, productList);
        recyclerViewProducts.setAdapter(productAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            // TODO: handle search
            return true;
        } else if (id == R.id.action_cart) {
            // TODO: handle cart
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


}