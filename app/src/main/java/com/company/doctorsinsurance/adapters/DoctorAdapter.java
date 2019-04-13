package com.company.doctorsinsurance.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.doctorsinsurance.R;
import com.company.doctorsinsurance.model.doctors;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {
    List<doctors> doctorsList;
    Context context;

    public DoctorAdapter(List<doctors> doctorsList, Context context) {
        this.doctorsList = doctorsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctors_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        doctors doctors = doctorsList.get(position);
        String imge_Url = doctors.getDoctorImage();
        String doc_Name = doctors.getDoctorName();
        holder.getImage(imge_Url);
        holder.getDoctorName(doc_Name);
    }

    @Override
    public int getItemCount() {
        return doctorsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView doctor_Image;
        TextView doctor_Name;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void getImage(String url) {
            doctor_Image = view.findViewById(R.id.doctor_Image);
            Picasso.get().load(url).placeholder(R.color.overlayBackground).into(doctor_Image);
        }

        public void getDoctorName(String name) {
            doctor_Name = view.findViewById(R.id.doctor_Name);
            doctor_Name.setText("Dr :" + name);
        }
    }
}
