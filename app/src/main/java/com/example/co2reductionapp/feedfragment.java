package com.example.co2reductionapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.co2reductionapp.backend.feedscrolldown;

public class feedfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String s1 [], s2[];
    private RecyclerView recyclerView;
    int images[]={R.drawable.running,R.drawable.plantatree, R.drawable.fridayforfuture,R.drawable.electricitybill};


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public feedfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static feedfragment newInstance(String param1, String param2) {
        feedfragment fragment = new feedfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        s1 = getResources().getStringArray(R.array.Leaderboardnames);
        s2 = getResources().getStringArray(R.array.description);
        View view = inflater.inflate(R.layout.scrolldownleaderboard, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerviews);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new feedscrolldown(getContext() ,s1,s2,images));
        return view;
    }

}