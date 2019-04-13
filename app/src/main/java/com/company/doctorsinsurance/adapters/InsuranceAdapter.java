package com.company.doctorsinsurance.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.company.doctorsinsurance.DoctorsActivity;
import com.company.doctorsinsurance.R;
import com.company.doctorsinsurance.model.insurances;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InsuranceAdapter extends RecyclerView.Adapter<InsuranceAdapter.ViewHolder> {
    List<insurances> insurancesList;
    Context context;

    public InsuranceAdapter(List<insurances> insurancesList, Context context) {
        this.insurancesList = insurancesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.insurance_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        insurances insurances = insurancesList.get(position);
        String url = insurances.getInsuranceImg();
        holder.get_Image(url);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, DoctorsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return insurancesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView insure_Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void get_Image(String url) {
            insure_Image = view.findViewById(R.id.insure_Image);
            Picasso.get().load(url).into(insure_Image);
        }
    }
}
