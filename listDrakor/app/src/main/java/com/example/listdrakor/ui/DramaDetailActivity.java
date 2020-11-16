package com.example.listdrakor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class DramaDetailActivity extends AppCompatActivity {

    private ImageView DramaThumbnailImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drama_detail);

        String dramaTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        DramaThumbnailImg = findViewById(R.id.detail_drama_img);
        DramaThumbnailImg.setImageResource(imageResourceId);

    }
}