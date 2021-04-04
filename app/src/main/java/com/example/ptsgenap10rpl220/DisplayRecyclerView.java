package com.example.ptsgenap10rpl220;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class DisplayRecyclerView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<part> getItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_recycler_view);

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