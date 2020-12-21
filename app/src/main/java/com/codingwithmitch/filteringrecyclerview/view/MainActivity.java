package com.codingwithmitch.filteringrecyclerview.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.codingwithmitch.filteringrecyclerview.Name;
import com.codingwithmitch.filteringrecyclerview.R;
import com.codingwithmitch.filteringrecyclerview.common.DummyData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private androidx.appcompat.widget.SearchView searchView;
    private RecyclerView recyclerView;
    private AnimalsAdapter animalsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        searchView = findViewById(R.id.search_view);
        recyclerView = findViewById(R.id.recycler_view);
        initRecyclerView(DummyData.getDummyName());

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                animalsAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                animalsAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void initRecyclerView(List<Name> nameList) {
        animalsAdapter = new AnimalsAdapter(this, nameList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(animalsAdapter);
    }
}
