package com.codingwithmitch.filteringrecyclerview.view;

import android.widget.Filter;
import android.widget.Filterable;

import com.codingwithmitch.filteringrecyclerview.Name;

import java.util.List;

public class AnimalsAdapter implements Filterable {

    private List<Name> nameList;
    private List<Name> filteredNameList;

    @Override
    public Filter getFilter() {
        return null;
    }
}
