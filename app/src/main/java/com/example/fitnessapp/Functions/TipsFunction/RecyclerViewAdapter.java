package com.example.fitnessapp.Functions.TipsFunction;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.RequestOptions;
import com.example.fitnessapp.R;

import java.util.List;


public class  RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Tipss> mData ;



    public RecyclerViewAdapter(Context mContext, List<Tipss> mData) {
        this.mContext = mContext;
        this.mData = mData;



    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(mContext).inflate(R.layout.tipsrecycleview,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getTitle());

        holder.view_container.setOnClickListener(v -> {

            Intent i = new Intent(mContext, TipsActivity.class);
            i.putExtra("title",mData.get(holder.getAdapterPosition()).getTitle());
            i.putExtra("img",mData.get(holder.getAdapterPosition()).getImgg());
            i.putExtra("description",mData.get(holder.getAdapterPosition()).getDescription());
            mContext.startActivity(i);

        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView tv_name ;
        CardView view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.tittles);


        }
    }

}
