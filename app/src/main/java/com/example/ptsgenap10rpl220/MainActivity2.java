package com.example.ptsgenap10rpl220;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private ArrayList<Item> itemArrayList;
    private ImageView btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.rvData);

        addItem();

        itemAdapter = new ItemAdapter(itemArrayList, new ItemAdapter.Callback() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity2.this, "click item "+position, Toast.LENGTH_SHORT).show();
                Intent move = new Intent(getApplicationContext(),Detail.class);
                Item myItem = itemArrayList.get(position);
                move.putExtra("icon", myItem.getIcon());
                move.putExtra("title", myItem.getTitle());
                move.putExtra("deskripsi", myItem.getDeskripsi());
                startActivity(move);
            }
        });

        //selesai ngatur data dari adapter, kemudian di tempel ke Recyclerview nya
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity2.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemAdapter);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DisplayRecyclerView.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this));
//        recyclerView.setAdapter(itemAdapter);

        //Back to Login Page
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });

    }

    private void addItem() {
        itemArrayList = new ArrayList<>();
        itemArrayList.add(new Item("Absensi", "Absensi kelas!", R.drawable.exel));
        itemArrayList.add(new Item("Tugas Bahasa", "Tugas Penentu Nilai!", R.drawable.word));
        itemArrayList.add(new Item("Presentasi", "Nanti di presentasikan!", R.drawable.ppt));
    }

}