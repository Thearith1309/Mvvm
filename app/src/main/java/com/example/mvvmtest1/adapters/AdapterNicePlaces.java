package com.example.mvvmtest1.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvvmtest1.R;
import com.example.mvvmtest1.models.NicePlace;

import java.util.List;
import java.util.Random;

public class AdapterNicePlaces extends RecyclerView.Adapter<AdapterNicePlaces.MyViewHolder> {

    private List<NicePlace> list;
    private Context context;
    private int []imgInt = new int[] {R.drawable.img1, R.drawable.img2, R.drawable.img3};

    public AdapterNicePlaces(Context context, List<NicePlace> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_nice_place, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        NicePlace item = list.get(i);
        myViewHolder.title.setText(item.name);
        myViewHolder.des.setText(item.description);
        Random random = new Random();
        int index = random.nextInt(imgInt.length);
        myViewHolder.img.setImageResource(imgInt[index]);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        ImageView img;
        TextView title, des;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            des = itemView.findViewById(R.id.des);

        }
    }
}
