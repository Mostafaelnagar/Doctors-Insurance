package com.company.doctorsinsurance.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InsuranceResponse {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("insurances")
    @Expose
    private List<insurances> insurances;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<insurances> getInsurances() {
        return insurances;
    }

    public void setInsurances(List<insurances> insurances) {
        this.insurances = insurances;
    }
}
