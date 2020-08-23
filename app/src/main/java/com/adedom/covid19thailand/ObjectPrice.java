package com.adedom.covid19thailand;

import com.google.gson.annotations.SerializedName;

public class ObjectPrice {
    @SerializedName("gold")
    private ObjectGold objectGold;
    @SerializedName("gold_bar")
    private ObjectGoldBar objectGoldBar;

    public ObjectGold getObjectGold() {
        return objectGold;
    }

    public void setObjectGold(ObjectGold objectGold) {
        this.objectGold = objectGold;
    }

    public ObjectGoldBar getObjectGoldBar() {
        return objectGoldBar;
    }

    public void setObjectGoldBar(ObjectGoldBar objectGoldBar) {
        this.objectGoldBar = objectGoldBar;
    }
}
