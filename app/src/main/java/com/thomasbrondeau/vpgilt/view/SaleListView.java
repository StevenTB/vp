package com.thomasbrondeau.vpgilt.view;

import com.thomasbrondeau.vpgilt.model.entity.Sale;

import java.util.List;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public interface SaleListView{
    void renderSaleList(List<Sale> saleList);
    void showRetryLayout();
    void hideRetryLayout();
    void showProgressBar();
    void hideProgressBar();
}
