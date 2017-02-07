package com.example.queenabergen.banyc.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.queenabergen.banyc.R;
import com.example.queenabergen.banyc.subjects.business.BusinessInfo;

import java.util.List;

/**
 * Created by Hyun on 2/4/17.
 */

public class BusinessAdapter extends RecyclerView.Adapter<BusinessViewHolder> {

    private List<BusinessInfo> description;

    public BusinessAdapter(List<BusinessInfo> data) {
        description = data;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public BusinessViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.businesslayout, viewGroup, false);
        BusinessViewHolder svh = new BusinessViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(BusinessViewHolder businessViewHolder, int i) {
        businessViewHolder.sendData(description.get(i));
    }

    @Override
    public int getItemCount() {
        return description.size();
    }

}