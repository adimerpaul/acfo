package com.innova.carnavaloruroacfo.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.innova.carnavaloruroacfo.Domain.CategoryDomain;
import com.innova.carnavaloruroacfo.Helper.ManagementCart;
import com.innova.carnavaloruroacfo.R;

public class ShowCategoryActivity extends AppCompatActivity {
    private static final String TAG = "MYTAG";
    private TextView addToCartBtn;
    private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt, totalPriceTxt, starTxt, caloryTxt, timeTxt;
    private ImageView plusBtn, minusBtn, picFood;
    private CategoryDomain object;
    private int numberOrder = 1;
    private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_category);
        managementCart = new ManagementCart(this);
        iniView();
        getBundle();
    }

    private void getBundle() {
        object = (CategoryDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Log.e(TAG,drawableResourceId+"");
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

    }

    private void iniView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberItemTxt);
        plusBtn = findViewById(R.id.plusCardBtn);
        minusBtn = findViewById(R.id.minusCardBtn);
        picFood = findViewById(R.id.foodPic);
        totalPriceTxt = findViewById(R.id.totalPriceTxt);
        starTxt = findViewById(R.id.starTxt);
        caloryTxt = findViewById(R.id.VicaloriesTxt);
        timeTxt = findViewById(R.id.timeTxt);
    }
}