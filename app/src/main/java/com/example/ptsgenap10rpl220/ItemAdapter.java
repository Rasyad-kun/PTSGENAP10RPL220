package com.example.ptsgenap10rpl220;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
    //referensi -> after declare arraylist in adapter -> alt+ins -> constructor
    Context c;
    private Callback callback;
    private ArrayList<Item> itemList;
    int myPost;
    View myview;

    interface Callback {
        void onClick(int position);
    }

    public ItemAdapter(ArrayList<Item> itemList, Callback callback) {
        this.itemList = itemList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        Referensi
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.row, parent, false);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview,  parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imgIcon.setImageResource(itemList.get(position).getIcon());
        holder.txtTitle.setText(itemList.get(position).getTitle());
        holder.txtDeskripsi.setText(itemList.get(position).getDeskripsi());

//        holder.setItemClickListener(new Callback() {
//            @Override
//            public void onItemClickListener(View v, int position) {
//                String gTitle = itemList.get(position).getTitle();
//                String gDeskripsi = itemList.get(position).getDeskripsi();
//                BitmapDrawable bitmapDrawable = (BitmapDrawable)holder.imgIcon.getDrawable();
//
//                Bitmap bitmap = bitmapDrawable.getBitmap();
//
//                ByteArrayOutputStream stream = new ByteArrayOutputStream();
//
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//
//                byte[] bytes = stream.toByteArray();
//
//                Intent intent = new Intent(c , Detail.class);
//                intent.putExtra("iTitle",gTitle);
//                intent.putExtra("iDeskripsi",gDeskripsi);
//                intent.putExtra("iIcon",bytes);
//                c.startActivity(intent);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return  (itemList != null) ? itemList.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private ImageView imgIcon;
        private TextView txtTitle, txtDeskripsi;
        CardView myCard;

        public MyViewHolder(View itemView) {
            super(itemView);
            myview=itemView;
            itemView.setOnCreateContextMenuListener(this);
            imgIcon = itemView.findViewById(R.id.tv_icon);
            txtTitle =  itemView.findViewById(R.id.tv_title);
            txtDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
            myCard = itemView.findViewById(R.id.cd_myCard);
            myCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });

//            itemView.setOnClickListener(this);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), Detail.class);
//                    intent.putExtra("title", itemList.get(getAdapterPosition()));
//                    v.getContext().startActivity(intent);
//                }
//            });
        }

//        @Override
//        public void onClick(View v) {
//            this.Callback.onItemClickListener(v, getLayoutPosition());
//        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "Delete");
            myPost=getAdapterPosition();
            Edit.setOnMenuItemClickListener(onlickcontextmenu);
            Delete.setOnMenuItemClickListener(onlickcontextmenu);
        }
    }

    private final MenuItem.OnMenuItemClickListener onlickcontextmenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case 1:
                    //Do stuff
                    Toast.makeText(myview.getContext(), "Edit data di posisi "+myview, Toast.LENGTH_SHORT).show();
                    break;

                case 2:
                    //Delete data, butuh konfirmasi dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(myview.getContext());
                    builder.setMessage("Are you sure you want to delete data?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    itemList.remove(myview);
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            //Set your icon here
                            .setTitle("Delete data")
                            .setIcon(R.mipmap.ic_launcher);
                    AlertDialog alert = builder.create();
                    alert.show();//showing the dialog

                    break;
            }
            return true;
        }
    };
}
