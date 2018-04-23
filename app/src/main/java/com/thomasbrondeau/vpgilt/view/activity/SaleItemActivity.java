package com.thomasbrondeau.vpgilt.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;

import com.thomasbrondeau.vpgilt.R;
import com.thomasbrondeau.vpgilt.model.entity.Sale;
import com.thomasbrondeau.vpgilt.presenter.SaleItemPresenter;
import com.thomasbrondeau.vpgilt.utils.DateUtils;
import com.thomasbrondeau.vpgilt.view.SaleItemListView;
import com.thomasbrondeau.vpgilt.view.component.ImageComponent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by THOMASBRONDEAU_Steven on 19/04/2018.
 */

public class SaleItemActivity extends BaseActivity implements SaleItemListView {

    @BindView(R.id.item_sale_detail_image)
    ImageView image;
    @BindView(R.id.item_sale_detail_title)
    AppCompatTextView title;

    @BindView(R.id.item_sale_detail_description)
    AppCompatTextView desc_content;
    @BindView(R.id.item_sale_detail_description_label)
    AppCompatTextView desc_label;

    @BindView(R.id.item_sale_detail_begins)
    AppCompatTextView begins_content;
    @BindView(R.id.item_sale_detail_begins_label)
    AppCompatTextView begins_label;

    @BindView(R.id.item_sale_detail_ends)
    AppCompatTextView ends_content;
    @BindView(R.id.item_sale_detail_ends_label)
    AppCompatTextView ends_label;

    @BindView(R.id.item_sale_detail_url)
    AppCompatTextView url_content;
    @BindView(R.id.item_sale_detail_url_label)
    AppCompatTextView url_label;

    private SaleItemPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saleitem);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Sale sale = (Sale) intent.getSerializableExtra("sale");

        if (mPresenter == null){
            mPresenter = new SaleItemPresenter(this, sale);
        }

        mPresenter.init();
    }

    @Override
    public void renderSaleItem(final Sale sale) {
        if (null == sale) return;

        if (null != sale.getImageUrlList() && !sale.getImageUrlByDimens().equals("")) {
            ImageComponent.loadImage(getApplicationContext(), sale.getImageUrlByDimens(), image, false);
        }

        if (null != sale.getSaleName() && !sale.getSaleName().equals("")) {
            title.setText(sale.getSaleName());
        }

        if (null != sale.getDescription() && !sale.getDescription().equals("")) {
            desc_content.setText(sale.getDescription());
            desc_label.setVisibility(View.VISIBLE);
        }

        if (null != sale.getBegins() && !sale.getBegins().equals("")) {
            begins_content.setText(DateUtils.getFormattedDate(getApplicationContext(), sale.getBegins()));
            begins_label.setVisibility(View.VISIBLE);

        }

        if (null != sale.getEnds() && !sale.getEnds().equals("")) {
            ends_content.setText(DateUtils.getFormattedDate(getApplicationContext(), sale.getEnds()));
            ends_label.setVisibility(View.VISIBLE);
        }

        if (null != sale.getSaleUrl() && !sale.getSaleUrl().equals("")) {
            url_content.setText(sale.getSaleUrl());

            View.OnClickListener listener = new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    mNavigation.navigateToUrl(SaleItemActivity.this, sale.getSaleUrl());
                }
            };

            url_content.setOnClickListener(listener);
            url_label.setVisibility(View.VISIBLE);
        }

    }
}
