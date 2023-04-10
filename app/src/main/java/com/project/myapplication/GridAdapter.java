package com.project.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    LayoutInflater inflater;

    Context context;
    String[] names;
    int[] images;

    String[] videoids;

    public GridAdapter(Context context, String[] names, int[] images, String[] videoids) {
        this.context = context;
        this.images = images;
        this.names = names;
        this.videoids=videoids;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater==null)
            inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if(view==null)
            view=inflater.inflate(R.layout.grid_item,null);

        ImageView imageView=view.findViewById(R.id.grid_image);
        TextView textView=view.findViewById(R.id.grid_text);

        imageView.setImageResource(images[i]);
        textView.setText(names[i]);


        return view;
    }
}
