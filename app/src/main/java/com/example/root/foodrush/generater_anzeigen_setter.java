package com.example.root.foodrush;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;

import java.util.List;

public class generater_anzeigen_setter extends RecyclerView.Adapter<generater_anzeigen_setter.myViewHolder> {
    Context mContext;
    List<generater> mData;

    public generater_anzeigen_setter(Context context, List<generater> data) {
        mContext = context;
        mData = data;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.custom_anzeige, parent , false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder myViewHolder, final int i) {
        myViewHolder.name.setText((mData.get(i).getName_user()));
        myViewHolder.reward.setText(mData.get(i).getReward());
        myViewHolder.order.setText(mData.get(i).getOrder());





    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        MapView locationshown;
        TextView name , reward , order , location;



        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            locationshown = itemView.findViewById(R.id.mapView);
            name = itemView.findViewById(R.id.user_name_order);
            reward = itemView.findViewById(R.id.reward_order);
            order = itemView.findViewById(R.id.order_order);
            location = itemView.findViewById(R.id.order_location);
        }
    }
}