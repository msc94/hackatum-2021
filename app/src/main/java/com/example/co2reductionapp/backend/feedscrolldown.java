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

public class feedscrolldown extends RecyclerView.Adapter<feedscrolldown.MyViewHolder> {
    String data1[], data2[];
    int images[],imagesfeed[];
    Context context;

    public feedscrolldown(Context ct, String[] s1, String[] s2, int[] im){
        context = ct;
        data1 = s1;
        data2 = s2;
        images = im ;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.feedrow, parent, false);
        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.Profileimage.setImageResource(R.drawable.man1);
        holder.nametext.setText(data1[position]);
        holder.descriptontext.setText(data2[position]);
        holder.feedimage.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public  class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nametext, descriptontext;

        ImageView Profileimage,feedimage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nametext = itemView.findViewById(R.id.feedprofilename);
            descriptontext = itemView.findViewById(R.id.feeddescription);
            Profileimage = itemView.findViewById(R.id.feedprofilepic);
            feedimage =itemView.findViewById((R.id.feedimage));



        }
    }
}
