package com.seoul.myai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GeminiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<DataItem> list;

    public void setList(ArrayList<DataItem> items){
        list = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gemini_item, parent, false);
        return new GeminiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((GeminiViewHolder) holder).bind(position, list);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private static class GeminiViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public GeminiViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
            imageView = itemView.findViewById(R.id.imageview);
        }

        void bind(int position, ArrayList<DataItem> items) {

            DataItem getItem = items.get(position);

            textView.setText(getItem.name);
            imageView.setImageResource(getItem.src);
        }

    }

}
