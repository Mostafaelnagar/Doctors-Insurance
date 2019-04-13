package com.company.doctorsinsurance.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class insurances {
    @SerializedName("insure_Id")
    @Expose
    private Integer insureId;
    @SerializedName("insurance_img")
    @Expose
    private String insuranceImg;

    public Integer getInsureId() {
        return insureId;
    }

    public void setInsureId(Integer insureId) {
        this.insureId = insureId;
    }

    public String getInsuranceImg() {
        return insuranceImg;
    }

    public void setInsuranceImg(String insuranceImg) {
        this.insuranceImg = insuranceImg;
    }
}
