package com.thomasbrondeau.vpgilt.presenter;

import com.thomasbrondeau.vpgilt.model.entity.Sale;
import com.thomasbrondeau.vpgilt.model.sale.SaleRepository;
import com.thomasbrondeau.vpgilt.view.SaleListView;

import java.util.List;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class SaleListPresenter implements Presenter, SaleRepository.SaleListListener {

    private SaleListView mView;
    private SaleRepository mSaleRepository;

    public SaleListPresenter(SaleListView view, SaleRepository saleRepository){
        mView = view;
        mSaleRepository = saleRepository;

    }

    // Presenter
    @Override
    public void init() {
        mView.showProgressBar();
        mView.hideRetryLayout();
        mSaleRepository.getList(this);
    }

    @Override
    public void destroy() {
        mView = null;
        mSaleRepository = null;
    }

    // Model callbacks
    @Override
    public void onSaleListReceived(List<Sale> saleList) {
        mView.hideProgressBar();
        mView.hideRetryLayout();
        mView.renderSaleList(saleList);
    }

    @Override
    public void onSuccess(String msg) {

    }

    @Override
    public void onFailure(String msg) {
        mView.hideProgressBar();
        mView.showRetryLayout();
    }
}
