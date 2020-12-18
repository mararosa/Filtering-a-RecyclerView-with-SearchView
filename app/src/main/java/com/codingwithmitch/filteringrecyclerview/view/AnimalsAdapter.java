package com.codingwithmitch.filteringrecyclerview.view;

import android.content.Context;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.recyclerview.widget.RecyclerView;

import com.codingwithmitch.filteringrecyclerview.Name;

import java.util.ArrayList;
import java.util.List;

public class AnimalsAdapter extends RecyclerView.Adapter implements Filterable {

    private Context context;
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
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charSequenceString = constraint.toString();
                if (charSequenceString.isEmpty()) {
                    filteredNameList = nameList;
                } else {
                    List<Name> filteredList = new ArrayList<>();
                    for (Name name : nameList) {
                        if (name.getName().toLowerCase().contains(charSequenceString.toLowerCase())) {
                            filteredList.add(name);
                        }
                        filteredNameList = filteredList;
                    }
                }
                FilterResults results = new FilterResults();
                results.values = filteredNameList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredNameList = (List<Name>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
