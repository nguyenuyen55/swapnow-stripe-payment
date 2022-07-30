package com.example.swapnowstripepayment.dto;

import com.google.gson.annotations.SerializedName;

public class CreatePayment {
    //Price
    //name membership

    @SerializedName("items")
    Object[] items;

    public Object[] getItems() {
        return items;
    }
}
