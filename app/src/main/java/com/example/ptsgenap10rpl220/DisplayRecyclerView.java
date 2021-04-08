package com.example.ptsgenap10rpl220;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayRecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<part> getItem;
    private ImageView btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recycler_view);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisplayRecyclerView.this, MainActivity.class));
            }
        });

        recyclerView = findViewById(R.id.rvData);

        addItem();

        adapter = new Adapter(getItem);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DisplayRecyclerView.this);
//        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new LinearLayoutManager(DisplayRecyclerView.this));
        recyclerView.setAdapter(adapter);

    }

    private void addItem() {
        getItem = new ArrayList<>();
        part itemSatu = new part("Absensi", "Absensi kelas!", R.drawable.exel);
        part itemDua = new part("Tugas Bahasa", "Tugas Penentu Nilai!", R.drawable.word);
        part itemTiga = new part("Presentasi", "Nanti di presentasikan!", R.drawable.ppt);
        getItem.add(itemSatu);
        getItem.add(itemDua);
        getItem.add(itemTiga);
    }

}