package com.example.root.foodrush;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        myViewHolder.location.setText(mData.get(i).getLocation());
        myViewHolder.Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference myRef = database.getReference("Anzeigen");
                myRef.child(String.valueOf(i)).child("Accept").setValue("true");
            }
        });
        if (mData.get(i).getPicture() == 1){
            Drawable myDrawable = mContext.getResources().getDrawable(R.drawable.alex);
            myViewHolder.picture.setImageDrawable(myDrawable);
        }
        if (mData.get(i).getPicture() == 2){
            Drawable myDrawable = mContext.getResources().getDrawable(R.drawable.alex);
            myViewHolder.picture.setImageDrawable(myDrawable);
        }
        if (mData.get(i).getPicture() == 3){
            Drawable myDrawable = mContext.getResources().getDrawable(R.drawable.alex);
            myViewHolder.picture.setImageDrawable(myDrawable);
        }






    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
ImageView picture;

        TextView name , reward , order , location ;
        Button Accept;




        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.user_name_order);
            reward = itemView.findViewById(R.id.reward_order);
            order = itemView.findViewById(R.id.order_order);
            location = itemView.findViewById(R.id.order_location);
            picture = itemView.findViewById(R.id.picture);
            Accept = itemView.findViewById(R.id.Accept);
        }
    }
}
