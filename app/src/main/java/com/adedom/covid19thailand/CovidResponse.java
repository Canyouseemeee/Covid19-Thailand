package com.adedom.covid19thailand;

import com.google.gson.annotations.SerializedName;

public class CovidResponse {

    @SerializedName("Confirmed")
    private int confirmed;

    @SerializedName("Recovered")
    private int recovered;

    @SerializedName("Hospitalized")
    private int hospitalized;

    @SerializedName("Deaths")
    private int deaths;

    @SerializedName("NewConfirmed")
    private int newConfirmed;

    @SerializedName("NewRecovered")
    private int newRecovered;

    @SerializedName("NewHospitalized")
    private int newHospitalized;

    @SerializedName("NewDeaths")
    private int newDeaths;

    @SerializedName("UpdateDate")
    private String updateDate;

    @SerializedName("Source")
    private String source;

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getHospitalized() {
        return hospitalized;
    }

    public void setHospitalized(int hospitalized) {
        this.hospitalized = hospitalized;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(int newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public int getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(int newRecovered) {
        this.newRecovered = newRecovered;
    }

    public int getNewHospitalized() {
        return newHospitalized;
    }

    public void setNewHospitalized(int newHospitalized) {
        this.newHospitalized = newHospitalized;
    }

    public int getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(int newDeaths) {
        this.newDeaths = newDeaths;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
