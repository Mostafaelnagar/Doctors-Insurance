package com.company.doctorsinsurance.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DoctorResponse {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("doctors")
    @Expose
    private List<doctors> doctors = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<doctors> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<doctors> doctors) {
        this.doctors = doctors;
    }
}
