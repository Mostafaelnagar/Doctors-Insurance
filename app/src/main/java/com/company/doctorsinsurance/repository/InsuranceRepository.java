package com.company.doctorsinsurance.repository;

import com.company.doctorsinsurance.model.DoctorResponse;
import com.company.doctorsinsurance.model.InsuranceResponse;
import com.company.doctorsinsurance.services.ServiceGenerator;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsuranceRepository {
    private MutableLiveData<InsuranceResponse> listLiveData;
    private MutableLiveData<DoctorResponse> doctor_response;

    public InsuranceRepository() {
        listLiveData = new MutableLiveData<>();
        doctor_response = new MutableLiveData<>();
    }

    public MutableLiveData<InsuranceResponse> getInsurance() {
        ServiceGenerator.getRequestApi()
                .getInsuranceService().enqueue(new Callback<InsuranceResponse>() {
            @Override
            public void onResponse(Call<InsuranceResponse> call, Response<InsuranceResponse> response) {
                listLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<InsuranceResponse> call, Throwable t) {
            }
        });
        return listLiveData;
    }

    public MutableLiveData<DoctorResponse> getDoctor() {
        ServiceGenerator.getRequestApi().getDoctors().enqueue(new Callback<DoctorResponse>() {
            @Override
            public void onResponse(Call<DoctorResponse> call, Response<DoctorResponse> response) {
                doctor_response.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DoctorResponse> call, Throwable t) {
            }
        });
        return doctor_response;
    }

}
