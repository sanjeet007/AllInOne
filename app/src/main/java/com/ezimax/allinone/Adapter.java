package com.ezimax.allinone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private Integer[] imageList;
    private Context context;
    private ArrayList<String> list;
    RecyclerViewActivity activity;

    public Adapter(Integer[] imageList, Context context, ArrayList<String> list, RecyclerViewActivity activity) {
        this.imageList = imageList;
        this.context = context;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
        Holder holder = new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int i) {
        holder.textView.setText(list.get(i));
        Glide.with(context).load(imageList[i]).into(holder.imageView);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeActivity(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {


        private CircleImageView imageView;
        private TextView textView;
        private CardView cardView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.TV);
            imageView = itemView.findViewById(R.id.CIV);
            cardView = itemView.findViewById(R.id.CV);
        }
    }
}
