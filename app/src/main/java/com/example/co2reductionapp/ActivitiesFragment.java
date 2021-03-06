package com.example.co2reductionapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.co2reductionapp.backend.Backend;
import com.example.co2reductionapp.backend.User;

import com.example.co2reductionapp.backend.activityscrolldown;
import com.example.co2reductionapp.backend.scrolldownfragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivitiesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivitiesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String s1 [], s2[];
    private RecyclerView recyclerView;
    int images[]={R.drawable.bicycle,R.drawable.bus,R.drawable.ecobag,R.drawable.fertilizer,R.drawable.seeding,R.drawable.water,R.drawable.subway,R.drawable.pedestrian,R.drawable.placard,R.drawable.flash};

    public ActivitiesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivitiesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivitiesFragment newInstance(String param1, String param2) {
        ActivitiesFragment fragment = new ActivitiesFragment();
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
        s1 = getResources().getStringArray(R.array.activity_names);
        s2 = getResources().getStringArray(R.array.activity_numbers);
        View view = inflater.inflate(R.layout.scrolldownactivities, container, false);
        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recycleractivitys);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new activityscrolldown(getContext() ,s1,s2,images));
        return view;
    }
}