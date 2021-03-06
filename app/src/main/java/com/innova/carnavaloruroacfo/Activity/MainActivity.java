package com.innova.carnavaloruroacfo.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.innova.carnavaloruroacfo.Adapter.CategoryAdapter;
import com.innova.carnavaloruroacfo.Adapter.RecommendedAdapter;
import com.innova.carnavaloruroacfo.Domain.CategoryDomain;
import com.innova.carnavaloruroacfo.Domain.FoodDomain;
import com.innova.carnavaloruroacfo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategotyList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategoty();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza", "mini_autoctonos", "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce", 13.0, 5, 20, 1000));
        foodlist.add(new FoodDomain("Chesse Burger", "burger_large", "beef, Gouda Cheese, Special sauce, Lettuce, tomato ", 15.20, 4, 18, 1500));
        foodlist.add(new FoodDomain("Vagetable pizza", "pizza3", " olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil", 11.0, 3, 16, 800));
        foodlist.add(new FoodDomain("Pizza carlistos", "cat_2", " olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil", 11.0, 3, 16, 800));
        adapter2 = new RecommendedAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategoty() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList = findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
//        categoryList.add(new CategoryDomain("Alejandro", "cat_1"));
        categoryList.add(new CategoryDomain("Autoctonos", "mini_autoctonos"));
        categoryList.add(new CategoryDomain("Caporeles", "mini_caporales"));
        categoryList.add(new CategoryDomain("Cullaguads", "mini_cullaguada"));
        categoryList.add(new CategoryDomain("Diablada", "mini_diablada"));
        categoryList.add(new CategoryDomain("Doctorcitos", "mini_doctorcitos"));
        categoryList.add(new CategoryDomain("Estilizadas", "mini_estilizadas"));
        categoryList.add(new CategoryDomain("Incas", "mini_incas"));
        categoryList.add(new CategoryDomain("Kallawayas", "mini_kallawayas"));
        categoryList.add(new CategoryDomain("Kantus Sarta??ani", "mini_kantus_sarta_ani"));
        categoryList.add(new CategoryDomain("Llamerada", "mini_llamerada"));
        categoryList.add(new CategoryDomain("Morenada", "mini_morenada"));
        categoryList.add(new CategoryDomain("Negritos", "mini_negritos"));
        categoryList.add(new CategoryDomain("Phujllay", "mini_phujllay"));
        categoryList.add(new CategoryDomain("Potolos", "mini_potolos"));
        categoryList.add(new CategoryDomain("Tarqueda", "mini_tarqueada"));
        categoryList.add(new CategoryDomain("Tinku", "mini_tinku"));
        categoryList.add(new CategoryDomain("Tobas", "mini_tobas"));
        categoryList.add(new CategoryDomain("Waca Tokori", "mini_waca_tokori"));
//        categoryList.add(new CategoryDomain("Burger", "cat_2"));
//        categoryList.add(new CategoryDomain("Hotdog", "cat_3"));
//        categoryList.add(new CategoryDomain("Drink", "cat_4"));
//        categoryList.add(new CategoryDomain("Donut", "cat_5"));


        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);

    }
}