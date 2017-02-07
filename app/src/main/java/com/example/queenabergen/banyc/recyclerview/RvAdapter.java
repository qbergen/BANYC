package com.example.queenabergen.banyc.recyclerview;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.queenabergen.banyc.R;
import com.example.queenabergen.banyc.maps.MapsActivity;
import com.example.queenabergen.banyc.subjects.youthemploy.YouthEmployment;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ResourceVH> {

    public static class ResourceVH extends RecyclerView.ViewHolder {
        private String latitude,longitude, programName, programSite, programTypeName;
        private CardView cv;
        private TextView siteName,
                programType,
                agency,
                boroughCommunity,
                program,
                gradeLevelAgeGroup,
                contactNumber;

        private Button exitBtn;

        ResourceVH(final View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv2);
            siteName = (TextView) itemView.findViewById(R.id.site_name);
            programType = (TextView) itemView.findViewById(R.id.program_type);
            agency = (TextView) itemView.findViewById(R.id.agency);
            boroughCommunity = (TextView) itemView.findViewById(R.id.borough_community);
            program = (TextView) itemView.findViewById(R.id.program);
            gradeLevelAgeGroup = (TextView) itemView.findViewById(R.id.grade_level);
            contactNumber = (TextView) itemView.findViewById(R.id.contact_number);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (latitude == null && longitude == null) {
                        Toast.makeText(itemView.getContext(), "Cannot find the location on map", Toast.LENGTH_LONG).show();
                    }
                    else if (latitude != null && longitude != null) {
                        Intent intent = new Intent(itemView.getContext(), MapsActivity.class);
                        intent.putExtra("Latitude",latitude);
                        intent.putExtra("Longitude", longitude);
                        intent.putExtra("Name", programName);
                        intent.putExtra("Type", programTypeName);
                        intent.putExtra("Site", programSite);
                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }


        public void sendMapInfo(YouthEmployment youthEmployment) {
            latitude = youthEmployment.getYouthEmploymentLocation1().getLatitude();
            longitude = youthEmployment.getYouthEmploymentLocation1().getLongitude();
            programName = youthEmployment.getProgram();
            programSite = youthEmployment.getSiteName();
            programTypeName = youthEmployment.getProgramType();
        }

    }

    private List<YouthEmployment> data;

    public RvAdapter(List<YouthEmployment> data) {
        this.data = data;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ResourceVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ResourceVH svh = new ResourceVH(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(ResourceVH resourceVH, int i) {
        resourceVH.siteName.setText(data.get(i).getSiteName());
        resourceVH.programType.setText(data.get(i).getProgramType());
        resourceVH.agency.setText(data.get(i).getAgency());
        resourceVH.boroughCommunity.setText(data.get(i).getBoroughCommunity());
        resourceVH.program.setText(data.get(i).getProgram());
        resourceVH.gradeLevelAgeGroup.setText(data.get(i).getGradeLevelAgeGroup());
        resourceVH.contactNumber.setText(data.get(i).getContactNumber());
        resourceVH.sendMapInfo(data.get(i));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
