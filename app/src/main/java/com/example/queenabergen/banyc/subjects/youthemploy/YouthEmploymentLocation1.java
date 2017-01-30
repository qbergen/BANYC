package com.example.queenabergen.banyc.subjects.youthemploy;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Hyun on 1/30/17.
 */

public class YouthEmploymentLocation1 implements Serializable {

    @SerializedName("latitude")
    private String latitude;
    @SerializedName("human_address")
    private String humanAddress;
    @SerializedName("needs_recoding")
    private Boolean needsRecoding;
    @SerializedName("longitude")
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getHumanAddress() {
        return humanAddress;
    }

    public void setHumanAddress(String humanAddress) {
        this.humanAddress = humanAddress;
    }

    public Boolean getNeedsRecoding() {
        return needsRecoding;
    }

    public void setNeedsRecoding(Boolean needsRecoding) {
        this.needsRecoding = needsRecoding;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}