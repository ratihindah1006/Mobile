package com.example.drakorproject.ui.drama;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.drakorproject.data.DramaItem;
import com.example.drakorproject.databinding.ItemDramaImageBinding;
import com.example.drakorproject.databinding.ItemDramaTextBinding;

abstract class BaseViewHolder extends RecyclerView.ViewHolder {


    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindData(DramaItem item);

    //method for share view animation
    public abstract ItemDramaTextBinding getItemDramaTextBinding();
    public abstract ItemDramaImageBinding getItemDramaImageBinding();
}
