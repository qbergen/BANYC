package com.example.queenabergen.banyc;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by queenabergen on 2/4/17.
 */

public class ArtsAdapterr extends RecyclerView.Adapter<ArtsAdapterr.MyViewHolder> {
    @Override
    public ArtsAdapterr.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ArtsAdapterr.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
