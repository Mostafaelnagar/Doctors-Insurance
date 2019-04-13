package com.company.doctorsinsurance.repository;

import com.company.doctorsinsurance.model.DoctorResponse;
import com.company.doctorsinsurance.services.ServiceGenerator;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctorsRepository {
    private MutableLiveData<DoctorResponse> doctor_response;

    public DoctorsRepository() {
        doctor_response = new MutableLiveData<>();
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
