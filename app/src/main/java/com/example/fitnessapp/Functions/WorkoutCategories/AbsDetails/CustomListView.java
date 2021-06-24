package com.example.fitnessapp.Functions.WorkoutCategories.AbsDetails;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.fitnessapp.R;


public class CustomListView extends ArrayAdapter<String> {

    private String [] abslist;
    private int [] images;
    private Activity context;

    public CustomListView(Activity context, String[] abslist, int [] images) {
        super(context, R.layout.item_layout, abslist);

        this.context =context;
        this.abslist = abslist;
        this.images = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r = convertView;
        ViewHolder viewHolder;
        if(r == null)
        {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.item_layout,null,true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        }else
        {
            viewHolder = (ViewHolder) r.getTag();
        }
         viewHolder.imageView.setImageResource(images[position]);
        viewHolder.textView.setText(abslist[position]);
        return r;

    }

    class ViewHolder
    {

        TextView textView;
        ImageView imageView;

        ViewHolder(View v)
        {

           textView = v.findViewById(R.id.title_abs);
           imageView = v.findViewById(R.id.first_abs);

        }


    }
}
