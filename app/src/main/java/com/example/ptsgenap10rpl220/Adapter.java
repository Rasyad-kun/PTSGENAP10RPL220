package com.example.ptsgenap10rpl220;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    //referensi -> after declare arraylist in adapter -> alt+ins -> constructor
    private ArrayList<part> itemList;

    public Adapter(ArrayList<part> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Referensi
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.row, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,  parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imgIcon.setImageResource(itemList.get(position).getIcon());
        holder.txtTitle.setText(itemList.get(position).getTitle());
        holder.txtDeskripsi.setText(itemList.get(position).getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // View Holder bisa beda class tapi lebih mudah di dalam class adapter
    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgIcon;
        private TextView txtTitle, txtDeskripsi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon = itemView.findViewById(R.id.tv_Icon);
            txtTitle =  itemView.findViewById(R.id.tv_Title);
            txtDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
        }

    }

}
