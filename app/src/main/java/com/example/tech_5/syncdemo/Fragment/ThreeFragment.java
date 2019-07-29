package com.example.tech_5.syncdemo.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tech_5.syncdemo.R;


public class ThreeFragment extends Fragment{

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_three, container, false);

        TextView title = (TextView) viewRoot.findViewById(R.id.ghost);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "font/DK Face Your Fears.ttf");
        title.setTypeface(font);

        return viewRoot;
    }

}