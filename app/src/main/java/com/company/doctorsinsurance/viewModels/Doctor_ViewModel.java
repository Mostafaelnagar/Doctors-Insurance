package com.company.doctorsinsurance.viewModels;

import android.app.Application;

import com.company.doctorsinsurance.model.DoctorResponse;
import com.company.doctorsinsurance.repository.DoctorsRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class Doctor_ViewModel extends AndroidViewModel {
    private DoctorsRepository repository;
    private MutableLiveData<DoctorResponse> data;

    public Doctor_ViewModel(@NonNull Application application) {
        super(application);
        repository = new DoctorsRepository();
        data = repository.getDoctor();
    }

    public MutableLiveData<DoctorResponse> getDoctorsDate() {
        return data;
    }
}
