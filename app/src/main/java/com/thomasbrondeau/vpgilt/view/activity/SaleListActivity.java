package com.thomasbrondeau.vpgilt.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.thomasbrondeau.vpgilt.R;
import com.thomasbrondeau.vpgilt.model.entity.Sale;
import com.thomasbrondeau.vpgilt.presenter.SaleListPresenter;
import com.thomasbrondeau.vpgilt.view.BaseApplication;
import com.thomasbrondeau.vpgilt.view.SaleListView;
import com.thomasbrondeau.vpgilt.view.adapter.SaleAdapter;
import com.thomasbrondeau.vpgilt.view.holder.OnRecyclerViewClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class SaleListActivity extends BaseActivity implements SaleListView, OnRecyclerViewClickListener {

    @BindView(R.id.act_salelist_cl)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.act_salelist_pb)
    ProgressBar progressBar;
    @BindView(R.id.act_salelist_layout_retry)
    LinearLayout layoutRetry;
    @BindView(R.id.act_salelist_bt_retry)
    Button btRetry;
    @BindView(R.id.act_salelist_rv)
    RecyclerView recyclerView;

    private SaleListPresenter mPresenter;
    private SaleAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salelist);
        ButterKnife.bind(this);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new SaleAdapter(getApplicationContext(), this);
        recyclerView.setAdapter(mAdapter);

        if (mPresenter == null) {
            mPresenter = new SaleListPresenter(this, BaseApplication.from(this).getRepository());
        }

        mPresenter.init();
    }

    @Override
    public void onRecyclerViewClick(Object clickedItem) {
        Sale sale = (Sale) clickedItem;
        mNavigation.navigateToSaleDetails(this, sale);
    }

    @Override
    public void renderSaleList(List<Sale> saleList) {
        if (null != saleList){
            mAdapter.setData(saleList);
        }
    }

    @OnClick(R.id.act_salelist_bt_retry)
    public void onClickRetry() {
        mPresenter.init();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRetryLayout() {
        layoutRetry.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideRetryLayout() {
        layoutRetry.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
}