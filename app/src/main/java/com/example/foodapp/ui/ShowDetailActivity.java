package com.example.foodapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodapp.Helper.ManagementCart;
import com.example.foodapp.Model.FoodDomain;
import com.example.foodapp.R;


public class ShowDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTxt,feeTxt,descriptionTxt,numberOrderTxt;
    private ImageView plusBtn,minBtn,picFood;
    FoodDomain object;
    int numberOrder = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);
        managementCart = new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object =(FoodDomain) getIntent().getSerializableExtra("object");
        @SuppressLint("DiscouragedApi") int drawableResourceId = this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(picFood);
        titleTxt.setText(object.getTitle());
        feeTxt.setText("$ "+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder+=1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });
        minBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOrder>1){
                 numberOrder-=1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumInCart(numberOrder);
                managementCart.insertFood(object);

            }
        });

    }

    private void initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titletext);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.DescriptionTxt);
        numberOrderTxt = findViewById(R.id.numberOrderTxt);
        plusBtn = findViewById(R.id.plusBtn);
        minBtn = findViewById(R.id.minBtn);
        picFood = findViewById(R.id.pic);
    }
}