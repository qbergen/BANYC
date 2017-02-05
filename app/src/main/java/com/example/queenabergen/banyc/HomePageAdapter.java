package com.example.queenabergen.banyc;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by queenabergen on 2/5/17.
 */

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.HomePageHolder> {
    public CardView cardView;
    public ImageView imageView;


    private int[] mHomePagePhotos = {R.drawable.infanthome,
            R.drawable.kidshome, R.drawable.teenshome, R.drawable.collegehome};
    private Context mContext;

    public class HomePageHolder extends RecyclerView.ViewHolder {

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public HomePageHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.home_ViewHolder);
            cardView.setElevation(30);
            imageView = (ImageView) itemView.findViewById(R.id.homeImage);
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public HomePageAdapter.HomePageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homepageviewholder, parent, false);
        return new HomePageAdapter.HomePageHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomePageHolder holder, int position) {
        Picasso.with(mContext).load(mHomePagePhotos[position]).resize(300, 300).into(imageView);
    }


    @Override
    public int getItemCount() {
        return mHomePagePhotos.length;
    }


}
