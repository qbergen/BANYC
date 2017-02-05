package com.example.queenabergen.banyc.sportsresources;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.queenabergen.banyc.R;

import java.util.List;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.SportsVH> {

    public static class SportsVH extends RecyclerView.ViewHolder {

        TextView sptsSiteName, sptsProgramType, sptsLocation, sptsAgency, sptsBoroughCommunity, sptsProgram, sptsGradeAgeGroup, sptsContactNumber;
        ImageView sitePhoto;

        SportsVH(final View itemView) {
            super(itemView);
            sptsSiteName = (TextView) itemView.findViewById(R.id.spts_sitename);
            sitePhoto = (ImageView) itemView.findViewById(R.id.spts_site_image);
            sptsProgramType = (TextView) itemView.findViewById(R.id.spts_program_type);
            sptsLocation = (TextView) itemView.findViewById(R.id.spts_location);
            sptsAgency = (TextView) itemView.findViewById(R.id.spts_agency);
            sptsBoroughCommunity = (TextView) itemView.findViewById(R.id.spts_borough_comm);
            sptsProgram = (TextView) itemView.findViewById(R.id.spts_program);
            sptsGradeAgeGroup = (TextView) itemView.findViewById(R.id.spts_grade_level);
            sptsContactNumber = (TextView) itemView.findViewById(R.id.spts_contact_number);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CharSequence text = "you clicked";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(itemView.getContext(), text, duration);
                    toast.show();
                }
            });

        }
    }

    List<Sports> sport;

    SportsAdapter(List<Sports> sport) {
        this.sport = sport;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public SportsVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sports_item, viewGroup, false);
        SportsVH svh = new SportsVH(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(SportsVH sportsViewHolder, int i) {
        sportsViewHolder.sptsSiteName.setText(sport.get(i).sptsSiteName);
        sportsViewHolder.sptsProgramType.setText(sport.get(i).sptsProgramType);
        sportsViewHolder.sptsLocation.setText(sport.get(i).sptsLocation);
        sportsViewHolder.sptsAgency.setText(sport.get(i).sptsAgency);
        sportsViewHolder.sptsBoroughCommunity.setText(sport.get(i).sptsBorough);
        sportsViewHolder.sptsProgram.setText(sport.get(i).sptsProgram);
        sportsViewHolder.sptsGradeAgeGroup.setText(sport.get(i).sptsGradeLevel);
        sportsViewHolder.sptsContactNumber.setText(sport.get(i).sptsContactNumber);
    }

    @Override
    public int getItemCount() {
        return sport.size();
    }

}