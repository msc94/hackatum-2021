package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
 String s1 [], s2[];
 RecyclerView recyclerView;
 int images[]={R.drawable.ads1,R.drawable.ads2,R.drawable.ads3,R.drawable.ads4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerviews);
        s1 = getResources().getStringArray(R.array.sadasd);
        s2 = getResources().getStringArray(R.array.description);
        MyAdapter myadapter = new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
    }
}