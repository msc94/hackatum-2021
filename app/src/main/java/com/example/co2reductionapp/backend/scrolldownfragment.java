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
    String data1[], data2[];
    int images[];
    Context context;

    public scrolldownfragment(Context ct, String[] s1, String[] s2, int[] im){
        context = ct;
        data1 = s1;
        data2 = s2;
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

        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2;
        ImageView myImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1= itemView.findViewById(R.id.title1);
            myText2 = itemView.findViewById(R.id.descripton1);
            myImage = itemView.findViewById(R.id.myimageView);
        }
    }
}
