package com.example.co2reductionapp.backend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import androidx.annotation.NonNull;

import com.example.co2reductionapp.R;

public class scrolldownfragment extends RecyclerView.Adapter<scrolldownfragment.MyViewHolder> {
    String data1[], data2[],data3[],data4[];
    int images[];
    Context context;

    public scrolldownfragment(Context ct, String[] s1, String[] s2,String[] s3,String[] s4, int[] im){
        context = ct;
        data1 = s1;
        data2 = s2;
        data3=s3;
        data4=s4;
        images = im ;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_row, parent, false);
        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Profileimage.setImageResource(R.drawable.man1);
        holder.nametext.setText(data1[position]);
        holder.descriptontext.setText("  ");
        holder.greencoinimage.setImageResource(R.drawable.ecology);
        holder.bluecoinimage.setImageResource(R.drawable.gem);
        holder.bluecoinnumber.setText(data3[position]);
        holder.greencoinnumber.setText(data4[position]);

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {
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
