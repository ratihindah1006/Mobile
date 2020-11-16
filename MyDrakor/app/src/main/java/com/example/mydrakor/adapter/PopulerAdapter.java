package com.example.listdrama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.listdrama.model.Populer;

import java.util.List;

public class PopulerAdapter extends RecyclerView.Adapter<PopulerAdapter.PopulerViewHolder> {

    private Context context;
    private List<Populer> populerList;

    public PopulerAdapter(Context context, List<Populer> populerList) {
        this.context = context;
        this.populerList = populerList;
    }

    @NonNull
    @Override
    public PopulerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.populer_recycler_items, parent, false);


        return new PopulerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopulerViewHolder holder, int position) {

        holder.namaPopuler.setText(populerList.get(position).getName());
        Glide.with(context).load(populerList.get(position).getImageUrl()).into(holder.gambarPopuler);

    }

    @Override
    public int getItemCount() {
        return populerList.size();
    }

    public static class PopulerViewHolder extends RecyclerView.ViewHolder{

        ImageView gambarPopuler;
        TextView namaPopuler;

        public PopulerViewHolder(@NonNull View itemView){
            super((itemView));

            namaPopuler = itemView.findViewById(R.id.nama_populer);
            gambarPopuler = itemView.findViewById(R.id.gambar_populer);
        }
    }
}
