package com.example.co2reductionapp.backend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.co2reductionapp.R;

public class activityscrolldown extends RecyclerView.Adapter<activityscrolldown.MyViewHolder2> {
    String data1[], data2[];
    int images[];
    Context context;

    public activityscrolldown(Context ct, String[] s1, String[] s2, int[] im){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = im ;

    }
    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.activitiyrow, parent, false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.Profileimage.setImageResource(images[position]);
        holder.nametext.setText(data1[position]);
        holder.descriptontext.setText(data2[position]);



    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public  class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView nametext, descriptontext,bluecoinnumber,greencoinnumber;

        ImageView Profileimage,greencoinimage,bluecoinimage;
        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            nametext = itemView.findViewById(R.id.Activitytitel);
            descriptontext = itemView.findViewById(R.id.activityscore);
            Profileimage = itemView.findViewById(R.id.imageactivity);

        }
    }
}

