package com.adedom.covid19thailand;

import com.google.gson.annotations.SerializedName;

public class ObjectResponse {

    @SerializedName("date")
    private String date;
    @SerializedName("update_time")
    private String update_time;
    @SerializedName("price")
    private ObjectPrice objectPrice;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public ObjectPrice getObjectPrice() {
        return objectPrice;
    }

    public void setObjectPrice(ObjectPrice objectPrice) {
        this.objectPrice = objectPrice;
    }
}
