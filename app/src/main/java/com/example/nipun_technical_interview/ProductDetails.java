package com.example.nipun_technical_interview;

import static com.example.nipun_technical_interview.R.id.textview_id;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    private TextView id_txtview, title_txtview, price_txtview, rating_txtview, description_txtview;
    private ImageView star_rate_imageview, imageView_line, dot_image, product_image;
    private RecyclerView recyclerViewProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        //recyclerViewProduct = findViewById(R.id.recyclerview_product);

        id_txtview    = (TextView)findViewById(R.id.textview_id);
        title_txtview = (TextView)findViewById(R.id.txtview_title);
        price_txtview = (TextView)findViewById(R.id.textview_price);
        rating_txtview = (TextView)findViewById(R.id.textview_ratting);
        description_txtview = (TextView)findViewById(R.id.description_textview);

        star_rate_imageview = (ImageView) findViewById(R.id.imageview_star);
        imageView_line = (ImageView) findViewById(R.id.imageviewline);
        dot_image = (ImageView) findViewById(R.id.image_dot);
        product_image = (ImageView) findViewById(R.id.product_image);

        star_rate_imageview.setImageResource(R.drawable.star_1);
        title_txtview.setText("DESTEK V5 VR Headset");
        price_txtview.setText("$ 120.00");
        rating_txtview.setText("4 (5 reviews)");
        description_txtview.setText("Comfortable & lightweight – Compare to market 3D VR headset, Our VR headset decreased in weight due to plastic component swaps and improvements in manufacturing.");
        imageView_line.setImageResource(R.drawable.line);
        dot_image.setImageResource(R.drawable.dot1);
        product_image.setImageResource(R.drawable.vr_image);



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ProductDetails.this, MainActivity.class);
        ProductDetails.this.startActivity(intent);
        finish();

    }

}