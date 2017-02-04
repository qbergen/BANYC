package com.example.queenabergen.banyc.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.queenabergen.banyc.R;
import com.example.queenabergen.banyc.subjects.youthemploy.YouthEmployment;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ResourceVH> {

    public static class ResourceVH extends RecyclerView.ViewHolder {

        CardView cv;
        TextView siteName,
                programType,
                location_1,
                agency,
                boroughCommunity,
                program,
                gradeLevelAgeGroup,
                contactNumber;


        ResourceVH(final View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv2);
            siteName = (TextView) itemView.findViewById(R.id.site_name);
            programType = (TextView) itemView.findViewById(R.id.program_type);
            location_1 = (TextView) itemView.findViewById(R.id.location);
            agency = (TextView) itemView.findViewById(R.id.agency);
            boroughCommunity = (TextView) itemView.findViewById(R.id.borough_community);
            program = (TextView) itemView.findViewById(R.id.program);
            gradeLevelAgeGroup = (TextView) itemView.findViewById(R.id.grade_level);
            contactNumber = (TextView) itemView.findViewById(R.id.contact_number);

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

    List<YouthEmployment> data;

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
        resourceVH.location_1.setText(data.get(i).getYouthEmploymentLocation1().getLatitude() + "," + data.get(i).getYouthEmploymentLocation1().getLongitude());
        resourceVH.agency.setText(data.get(i).getAgency());
        resourceVH.boroughCommunity.setText(data.get(i).getBoroughCommunity());
        resourceVH.program.setText(data.get(i).getProgram());
        resourceVH.gradeLevelAgeGroup.setText(data.get(i).getGradeLevelAgeGroup());
        resourceVH.contactNumber.setText(data.get(i).getContactNumber());

    }

    @Override
    public int getItemCount() {
        return data.size();
//        return 25;
    }
}
