package com.example.ptsgenap10rpl220;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    //referensi -> after declare arraylist in adapter -> alt+ins -> constructor
    Context c;
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

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String gTitle = itemList.get(position).getTitle();
                String gDeskripsi = itemList.get(position).getDeskripsi();
                BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.imgIcon.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(c , Detail.class);
                intent.putExtra("iTitle",gTitle);
                intent.putExtra("iDeskripsi",gDeskripsi);
                intent.putExtra("iIcon",bytes);
                c.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // View Holder bisa beda class tapi lebih mudah di dalam class adapter
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imgIcon;
        private TextView txtTitle, txtDeskripsi;
        ItemClickListener itemClickListener;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), Detail.class);
//                    intent.putExtra("title", itemList.get(getAdapterPosition()));
//                    v.getContext().startActivity(intent);
//                }
//            });

            imgIcon = itemView.findViewById(R.id.tv_icon);
            txtTitle =  itemView.findViewById(R.id.tv_title);
            txtDeskripsi = itemView.findViewById(R.id.tv_deskripsi);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClickListener(v, getLayoutPosition());
        }

        public  void  setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;
        }
    }

}
