package com.example.ptsgenap10rpl220;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {

    private ImageView dIcon;
    private TextView dTitle, dDeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dIcon = findViewById(R.id.dIcon);
        dTitle = findViewById(R.id.dTitle);
        dDeskripsi = findViewById(R.id.dDeskripsi);

//        Intent intent = getIntent();
//        String title = intent.getStringExtra("title");
//        detail_title.setText(title);

        Intent intent = getIntent();
        String detailTitle = intent.getStringExtra("iTitle");
        String detailDeskripsi = intent.getStringExtra("iDeskripsi");

        byte[] detailByte = getIntent().getByteArrayExtra("iIcon");

        Bitmap bitmap = BitmapFactory.decodeByteArray(detailByte, 0, detailByte.length);

        dTitle.setText(detailTitle);
        dDeskripsi.setText(detailDeskripsi);
        dIcon.setImageBitmap(bitmap);
    }
}