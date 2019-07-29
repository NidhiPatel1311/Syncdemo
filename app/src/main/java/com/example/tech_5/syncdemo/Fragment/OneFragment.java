package com.example.tech_5.syncdemo.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tech_5.syncdemo.R;


public class OneFragment extends Fragment{


    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

//        String fontPath = "font/DK Face Your Fears.ttf";
//
//        // text view label
//        TextView txtGhost = (TextView) getActivity().findViewById(R.id.ghost);
//
//        // Loading Font Face
//        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), fontPath);
//
//        // Applying font
//        txtGhost.setTypeface(tf);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot =  inflater.inflate(R.layout.fragment_one, container, false);

       TextView title = (TextView) viewRoot.findViewById(R.id.ghost);
      Typeface  font = Typeface.createFromAsset(getActivity().getAssets(), "font/DK Face Your Fears.ttf");
        title.setTypeface(font);

        return viewRoot;
    }


}