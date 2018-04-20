package com.thomasbrondeau.vpgilt.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class SaleBase implements Serializable {
    @SerializedName("sales")
    public List<Sale> saleList;

    public List<Sale> getSaleList() {
        return saleList;
    }
}
