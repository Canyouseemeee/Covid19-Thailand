package com.adedom.covid19thailand;

import com.google.gson.annotations.SerializedName;

public class ObjectGold {

    @SerializedName("buy")
    private String buy ;
    @SerializedName("sell")
    private String sell ;

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }
}
