package com.codingwithmitch.filteringrecyclerview.view;

import android.content.Context;
import android.widget.Filter;
import android.widget.Filterable;

import com.codingwithmitch.filteringrecyclerview.Name;

import java.util.List;

public class AnimalsAdapter implements Filterable {

    private Context context
    private List<Name> nameList;
    private List<Name> filteredNameList;

    public AnimalsAdapter(Context context, List<Name> nameList) {
        super();
        this.context = context;
        this.nameList = nameList;
        this.filteredNameList = nameList;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
