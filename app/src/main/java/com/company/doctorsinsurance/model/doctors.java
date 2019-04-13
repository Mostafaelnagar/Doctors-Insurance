package com.company.doctorsinsurance.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class doctors {
    @SerializedName("doc_Id")
    @Expose
    private Integer docId;
    @SerializedName("doctor_name")
    @Expose
    private String doctorName;
    @SerializedName("doctor_image")
    @Expose
    private String doctorImage;

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorImage() {
        return doctorImage;
    }

    public void setDoctorImage(String doctorImage) {
        this.doctorImage = doctorImage;
    }
}
