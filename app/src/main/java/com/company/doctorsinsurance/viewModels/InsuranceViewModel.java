package com.company.doctorsinsurance.viewModels;

import android.app.Application;

import com.company.doctorsinsurance.model.InsuranceResponse;
import com.company.doctorsinsurance.repository.InsuranceRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class InsuranceViewModel extends AndroidViewModel {
    private InsuranceRepository insuranceRepository;
    private MutableLiveData<InsuranceResponse> data;

    public InsuranceViewModel(@NonNull Application application) {
        super(application);
        insuranceRepository = new InsuranceRepository();
        data = insuranceRepository.getInsurance();
    }

    public MutableLiveData<InsuranceResponse> getInsuranceData() {
        return data;
    }
}
