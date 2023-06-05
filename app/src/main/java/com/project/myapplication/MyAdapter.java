package com.project.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    public MyAdapter(Context context, ArrayList<NewsContainer> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    ArrayList<NewsContainer> newsArrayList;


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        NewsContainer newsContainer = newsArrayList.get(position);

        holder.Title.setText(newsContainer.Title);
        holder.Description.setText(newsContainer.Description);

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView Title,Description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.titleNews);
            Description = itemView.findViewById(R.id.descriptionNews);
        }
    }
}
