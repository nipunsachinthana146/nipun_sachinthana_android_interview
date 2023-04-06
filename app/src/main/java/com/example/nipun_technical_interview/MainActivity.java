package com.example.nipun_technical_interview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nipun_technical_interview.utils.SpacingItemDecorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageView bottombtn_1, bottombtn_2, bottombtn_3, bottombtn_4, homepage_main_image;
    private Button  button_1, button_2, button_3, button_4, button_5, button_6 ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottombtn_1 = findViewById(R.id.bottombtn_1);
        bottombtn_2 = findViewById(R.id.bottombtn_2);
        bottombtn_3 = findViewById(R.id.bottombtn_3);
        bottombtn_4 = findViewById(R.id.bottombtn_4);

        button_1 = findViewById(R.id.button1);
        button_2 = findViewById(R.id.button2);
        button_3 = findViewById(R.id.button3);
        button_4 = findViewById(R.id.button4);
        button_5 = findViewById(R.id.button5);
        button_6 = findViewById(R.id.button6);


        recyclerView = findViewById(R.id.recyclerView);
        homepage_main_image = findViewById(R.id.homepage_main_image);


        resetButtonShape();
        button_1.setBackgroundResource(R.drawable.rectangle_btn);
        button_1.setTextColor(Color.parseColor("#ffffff"));

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SpacingItemDecorator itemDecorator = new SpacingItemDecorator(30);
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://59b8726e92ccc3eb44b0c193eeef96f6.m.pipedream.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONPlaceholder jsonPlaceholder = retrofit.create(JSONPlaceholder.class);
        Call<List<Post>> call = jsonPlaceholder.getPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Post> postList = response.body();
                PostAdapter postAdapter = new PostAdapter(MainActivity.this, postList);
                recyclerView.setAdapter(postAdapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        bottombtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonImage();
                bottombtn_1.setImageResource(R.drawable.bottom_btn_1_2);
            }
        });

        bottombtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonImage();
                bottombtn_2.setImageResource(R.drawable.bottom_btn_2_2);
            }
        });

        bottombtn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonImage();
                bottombtn_3.setImageResource(R.drawable.bottom_btn_3_2);
            }
        });

        bottombtn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonImage();
                bottombtn_4.setImageResource(R.drawable.bottom_btn_4_2);
            }
        });


        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonShape();
                button_1.setBackgroundResource(R.drawable.rectangle_btn);
                button_1.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonShape();
                button_2.setBackgroundResource(R.drawable.rectangle_btn);
                button_2.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonShape();
                button_3.setBackgroundResource(R.drawable.rectangle_btn);
                button_3.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonShape();
                button_4.setBackgroundResource(R.drawable.rectangle_btn);
                button_4.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonShape();
                button_5.setBackgroundResource(R.drawable.rectangle_btn);
                button_5.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonShape();
                button_6.setBackgroundResource(R.drawable.rectangle_btn);
                button_6.setTextColor(Color.parseColor("#ffffff"));
            }
        });

        homepage_main_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductDetails.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });

    }

    public  void resetButtonImage(){
        bottombtn_1.setImageResource(R.drawable.bottom_btn_1_1);
        bottombtn_2.setImageResource(R.drawable.bottom_btn_2_1);
        bottombtn_3.setImageResource(R.drawable.bottom_btn_3_1);
        bottombtn_4.setImageResource(R.drawable.bottom_btn_4_1);
    }

    public void  resetButtonShape(){
        button_1.setBackgroundResource(R.drawable.rectangle_btn_white);
        button_2.setBackgroundResource(R.drawable.rectangle_btn_white);
        button_3.setBackgroundResource(R.drawable.rectangle_btn_white);
        button_4.setBackgroundResource(R.drawable.rectangle_btn_white);
        button_5.setBackgroundResource(R.drawable.rectangle_btn_white);
        button_6.setBackgroundResource(R.drawable.rectangle_btn_white);

        button_1.setTextColor(Color.parseColor("#000000"));
        button_2.setTextColor(Color.parseColor("#000000"));
        button_3.setTextColor(Color.parseColor("#000000"));
        button_4.setTextColor(Color.parseColor("#000000"));
        button_5.setTextColor(Color.parseColor("#000000"));
        button_6.setTextColor(Color.parseColor("#000000"));
    }
}