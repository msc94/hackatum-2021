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

public class activityscrolldown extends RecyclerView.Adapter<scrolldownfragment.MyViewHolder> {
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
    public scrolldownfragment.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.feedrow, parent, false);
        return new scrolldownfragment.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull scrolldownfragment.MyViewHolder holder, int position) {
        holder.Profileimage.setImageResource(R.drawable.ads1);
        holder.nametext.setText(data1[position]);
        holder.descriptontext.setText(data2[position]);



    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nametext, descriptontext,bluecoinnumber,greencoinnumber;

        ImageView Profileimage,greencoinimage,bluecoinimage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nametext = itemView.findViewById(R.id.title1);
            descriptontext = itemView.findViewById(R.id.descripton1);
            Profileimage = itemView.findViewById(R.id.myimageView);
            greencoinimage =itemView.findViewById(R.id.greencoinimage);
            bluecoinimage= itemView.findViewById(R.id.bluecoinimage);
            bluecoinnumber = itemView.findViewById(R.id.bluecoinnumber);
            greencoinnumber = itemView.findViewById(R.id.greencoinnumber);
        }
    }
}

