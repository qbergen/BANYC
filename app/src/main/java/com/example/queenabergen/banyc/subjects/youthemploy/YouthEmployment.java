package com.example.queenabergen.banyc.subjects.youthemploy;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hyun on 1/30/17.
 */

public class YouthEmployment {

    @SerializedName("site_name")
    private String siteName;
    @SerializedName("program_type")
    private String programType;
    @SerializedName("location_1")
    private YouthEmploymentLocation1 location_1;
    @SerializedName("agency")
    private String agency;
    @SerializedName("borough_community")
    private String boroughCommunity;
    @SerializedName("program")
    private String program;
    @SerializedName("grade_level_age_group")
    private String gradeLevelAgeGroup;
    @SerializedName("contact_number")
    private String contactNumber;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getBoroughCommunity() {
        return boroughCommunity;
    }

    public void setBoroughCommunity(String boroughCommunity) {
        this.boroughCommunity = boroughCommunity;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getGradeLevelAgeGroup() {
        return gradeLevelAgeGroup;
    }

    public void setGradeLevelAgeGroup(String gradeLevelAgeGroup) {
        this.gradeLevelAgeGroup = gradeLevelAgeGroup;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public YouthEmploymentLocation1 getYouthEmploymentLocation1() {
        return location_1;
    }

    public void setYouthEmploymentLocation1(YouthEmploymentLocation1 location_1) {
        this.location_1 = location_1;
    }

}
