package com.example.queenabergen.banyc.sportsresources;

class Sports {

    String sptsSiteName, sptsProgramType, sptsLocation, sptsAgency, sptsBorough, sptsProgram, sptsGradeLevel, sptsContactNumber;
    int photoId;

    public Sports(String sptsSiteName, int photoId, String sptsProgramType, String sptsLocation, String sptsAgency, String sptsBorough, String sptsProgram, String sptsGradeLevel, String sptsContactNumber) {
        this.sptsSiteName = sptsSiteName;
        this.photoId = photoId;
        this.sptsProgramType = sptsProgramType;
        this.sptsLocation = sptsLocation;
        this.sptsAgency = sptsAgency;
        this.sptsBorough = sptsBorough;
        this.sptsProgram = sptsProgram;
        this.sptsGradeLevel = sptsGradeLevel;
        this.sptsContactNumber = sptsContactNumber;
    }

}
