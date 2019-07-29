package com.example.tech_5.syncdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tech_5.syncdemo.Adapter.SolventRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActivityStaggered extends AppCompatActivity {

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_view);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        //for vertical
        //gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, 1);


//for horizontal
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        List<ItemObjects> gaggeredList = getListItemData();

        SolventRecyclerViewAdapter rcAdapter = new SolventRecyclerViewAdapter(ActivityStaggered.this, gaggeredList);
        recyclerView.setAdapter(rcAdapter);
    }

    private List<ItemObjects> getListItemData(){
        List<ItemObjects> listViewItems = new ArrayList<ItemObjects>();
        listViewItems.add(new ItemObjects("Person 1", R.drawable.album1));
        listViewItems.add(new ItemObjects("Person 2", R.drawable.dog));
        listViewItems.add(new ItemObjects("Person 3", R.drawable.ic_stub));
        listViewItems.add(new ItemObjects("Person 4", R.drawable.album4));
        listViewItems.add(new ItemObjects("Person 5", R.drawable.download));
        listViewItems.add(new ItemObjects("Person 6", R.drawable.album6));
        listViewItems.add(new ItemObjects("Person 7", R.drawable.rihanna));
        listViewItems.add(new ItemObjects("Person 8", R.drawable.album8));
        listViewItems.add(new ItemObjects("Person 9", R.drawable.album9));
        listViewItems.add(new ItemObjects("Person 10", R.drawable.ic_empty));
        listViewItems.add(new ItemObjects("Person 11", R.drawable.album11));
        listViewItems.add(new ItemObjects("Person 12", R.drawable.ic_error));

        return listViewItems;
    }
}
