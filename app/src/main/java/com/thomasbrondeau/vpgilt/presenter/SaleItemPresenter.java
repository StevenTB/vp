package com.thomasbrondeau.vpgilt.presenter;

import com.thomasbrondeau.vpgilt.model.entity.Sale;
import com.thomasbrondeau.vpgilt.view.SaleItemListView;


/**
 * Created by THOMASBRONDEAU_Steven on 20/04/2018.
 */

public class SaleItemPresenter implements Presenter {

    private SaleItemListView mView;
    private Sale mSale;


    public SaleItemPresenter(SaleItemListView view, Sale sale) {
        mView = view;
        mSale = sale;
    }

    // Presenter
    @Override
    public void init() {
        mView.renderSaleItem(mSale);
    }

    @Override
    public void destroy() {
        mView = null;
    }
}
