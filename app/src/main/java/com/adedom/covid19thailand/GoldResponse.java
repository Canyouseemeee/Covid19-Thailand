package com.adedom.covid19thailand;

import com.google.gson.annotations.SerializedName;

public class GoldResponse {

    private String status;
    @SerializedName("response")
    private ObjectResponse objectResponse;

    public ObjectResponse getObjectResponse() {
        return objectResponse;
    }

    public void setObjectResponse(ObjectResponse objectResponse) {
        this.objectResponse = objectResponse;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
