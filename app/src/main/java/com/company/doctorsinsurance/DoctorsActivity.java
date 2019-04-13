package com.company.doctorsinsurance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dmax.dialog.SpotsDialog;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.company.doctorsinsurance.adapters.DoctorAdapter;
import com.company.doctorsinsurance.adapters.InsuranceAdapter;
import com.company.doctorsinsurance.common.ConnectivityReceiver;
import com.company.doctorsinsurance.common.MyApplication;
import com.company.doctorsinsurance.common.common;
import com.company.doctorsinsurance.model.DoctorResponse;
import com.company.doctorsinsurance.model.InsuranceResponse;
import com.company.doctorsinsurance.model.doctors;
import com.company.doctorsinsurance.model.insurances;
import com.company.doctorsinsurance.viewModels.Doctor_ViewModel;
import com.company.doctorsinsurance.viewModels.InsuranceViewModel;

import java.util.ArrayList;
import java.util.List;

public class DoctorsActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {
    RecyclerView recyclerView_Doctors;
    List<doctors> doctors = new ArrayList<>();
    DoctorAdapter adapter;
    LinearLayoutManager layoutManager;
    ProgressBar doctor_ProgressBar;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Font Setup
        common.fontInit();
        setContentView(R.layout.activity_doctors);
        init_Views();
        View view = findViewById(android.R.id.content);
        common.navigationMenu(view, getBaseContext());
        common.changeToolbarSettings(view, R.mipmap.ic_ask_doctors, this.getResources().getString(R.string.ask_doctors));
        checkConnection();

    }

    private void init_Views() {
        recyclerView_Doctors = findViewById(R.id.doctor_Rec);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView_Doctors.setLayoutManager(layoutManager);
        recyclerView_Doctors.setHasFixedSize(true);
        doctor_ProgressBar = findViewById(R.id.doctor_ProgressBar);
    }

    private void getDoctors() {
        Doctor_ViewModel doctor_viewModel = ViewModelProviders.of(DoctorsActivity.this).get(Doctor_ViewModel.class);
        doctor_viewModel.getDoctorsDate().observe(DoctorsActivity.this, new Observer<DoctorResponse>() {
            @Override
            public void onChanged(DoctorResponse doctor_response) {
                doctor_ProgressBar.setVisibility(View.GONE);
                doctors = doctor_response.getDoctors();
                adapter = new DoctorAdapter(doctors, getBaseContext());
                recyclerView_Doctors.setAdapter(adapter);
            }
        });
    }

    // Method to manually check connection status
    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showConnectionMessage(isConnected);
    }

    // Showing the status in Snackbar
    private void showConnectionMessage(boolean isConnected) {
        if (isConnected) {
            getDoctors();
        } else {
            Toast.makeText(this, getBaseContext().getResources().getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showConnectionMessage(isConnected);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.getInstance().setConnectivityListener(this);
    }
}
