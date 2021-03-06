package com.example.queenabergen.banyc.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.queenabergen.banyc.R;
import com.example.queenabergen.banyc.subjects.business.BusinessInfo;

/**
 * Created by Hyun on 2/4/17.
 */

public class BusinessViewHolder extends RecyclerView.ViewHolder {
    private CardView cv;
    private TextView interest,
            program_desc,programName;

    public BusinessViewHolder(final View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cv2);
        interest = (TextView) itemView.findViewById(R.id.interest_TV);
        programName = (TextView) itemView.findViewById(R.id.programName_TV);
        program_desc = (TextView) itemView.findViewById(R.id.programdesc_TV);
        cv.setBackgroundResource(R.drawable.backgroundbusiness);
        onClicks();

    }

    private void onClicks() {
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

    public void sendData(BusinessInfo input) {
        interest.setText(input.getInterest());
        programName.setText(input.getProgram());
        program_desc.setText(input.getPrgdesc());
    }
}
