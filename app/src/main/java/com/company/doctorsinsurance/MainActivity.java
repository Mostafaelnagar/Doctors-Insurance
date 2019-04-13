package com.company.doctorsinsurance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dmax.dialog.SpotsDialog;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.company.doctorsinsurance.adapters.InsuranceAdapter;
import com.company.doctorsinsurance.common.ConnectivityReceiver;
import com.company.doctorsinsurance.common.MyApplication;
import com.company.doctorsinsurance.common.common;
import com.company.doctorsinsurance.model.InsuranceResponse;
import com.company.doctorsinsurance.model.insurances;
import com.company.doctorsinsurance.viewModels.InsuranceViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {
    RecyclerView recyclerViewInsurance;
    List<insurances> insurances = new ArrayList<>();
    InsuranceAdapter adapter;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setup Font
        common.fontInit();
        setContentView(R.layout.activity_main);
        init_Views();
        View view = findViewById(android.R.id.content);
        common.navigationMenu(view, getBaseContext());
        common.changeToolbarSettings(view, R.mipmap.ic_, this.getResources().getString(R.string.insurance_text));
        checkConnection();
    }

    private void init_Views() {
        recyclerViewInsurance = findViewById(R.id.rec_Insurance);
        GridLayoutManager mGrid = new GridLayoutManager(this, 2);
        recyclerViewInsurance.setLayoutManager(mGrid);
        recyclerViewInsurance.setHasFixedSize(true);
    }

    // Method to manually check connection status
    private void checkConnection() {
        boolean isConnected = ConnectivityReceiver.isConnected();
        showConnectionMessage(isConnected);
    }

    // Showing the status in Snackbar
    private void showConnectionMessage(boolean isConnected) {
        if (isConnected) {
            getInsurance();
        } else {
            Toast.makeText(this, getBaseContext().getResources().getString(R.string.connection_error), Toast.LENGTH_SHORT).show();
        }
    }

    private void getInsurance() {
        final SpotsDialog progressDialog = new SpotsDialog(MainActivity.this);
        progressDialog.show();
        InsuranceViewModel insuranceViewModel = ViewModelProviders.of(this).get(InsuranceViewModel.class);
        insuranceViewModel.getInsuranceData().observe(this, new Observer<InsuranceResponse>() {
            @Override
            public void onChanged(InsuranceResponse insuranceResponse) {
                progressDialog.dismiss();
                insurances = insuranceResponse.getInsurances();
                adapter = new InsuranceAdapter(insurances, getBaseContext());
                recyclerViewInsurance.setAdapter(adapter);
            }
        });
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
