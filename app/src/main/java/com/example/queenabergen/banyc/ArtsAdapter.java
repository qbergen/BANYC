package com.example.queenabergen.banyc;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by queenabergen on 2/4/17.
 */

public class ArtsAdapter extends RecyclerView.Adapter<ArtsAdapter.MyViewHolder> {
    private Context mContext;
    private int[] artsProgramPhotos = {R.drawable.themetarts, R.drawable.apollotheater, R.drawable.bcapteen,
            R.drawable.cunytheater};
    private String[] organizationNames = {"The Met After School Arts Program", "The Apollo Theater Internship Program",
            "BCAPTEEN Creative Leadership Project", "CUNY After-School Theater"};
    private String[] organizationAgeTarget = {"18m to 12 years old", "Rising High School Seniors", " 13 to 17 years old",
            "High School Students ", " "};

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public ImageView orgImage;
        public TextView orgTitle;
        public TextView orgLocation;


        public MyViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            cardView = (CardView) itemView.findViewById(R.id.arts_viewHolder);
            orgImage = (ImageView) itemView.findViewById(R.id.imageOfOrganization);
            orgTitle = (TextView) itemView.findViewById(R.id.orgTitle);
            orgLocation = (TextView) itemView.findViewById(R.id.addressLine);

        }
    }


    @Override
    public ArtsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.artsviewholder, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArtsAdapter.MyViewHolder holder, int position) {
        Picasso.with(mContext).load(artsProgramPhotos[position]).resize(550, 550).into(holder.orgImage);
        holder.orgTitle.setText(organizationNames[position]);
        holder.orgLocation.setText(organizationAgeTarget[position]);
    }

    @Override
    public int getItemCount() {
        return artsProgramPhotos.length;
    }

}
