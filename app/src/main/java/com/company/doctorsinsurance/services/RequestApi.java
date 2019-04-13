package com.company.doctorsinsurance.services;


import com.company.doctorsinsurance.model.DoctorResponse;
import com.company.doctorsinsurance.model.InsuranceResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestApi {
    @GET("allInsurances")
    Call<InsuranceResponse> getInsuranceService();

    @GET("alldoctors")
    Call<DoctorResponse> getDoctors();
}
