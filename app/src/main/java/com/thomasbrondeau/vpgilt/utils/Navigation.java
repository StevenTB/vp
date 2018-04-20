package com.thomasbrondeau.vpgilt.utils;

import android.content.Intent;
import android.net.Uri;

import com.thomasbrondeau.vpgilt.model.entity.Sale;
import com.thomasbrondeau.vpgilt.view.activity.BaseActivity;
import com.thomasbrondeau.vpgilt.view.activity.SaleItemActivity;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class Navigation {
    public Navigation(){

    }

    public void navigateToSaleDetails(BaseActivity sourceActivity, Sale sale){
        Intent intent = new Intent(sourceActivity, SaleItemActivity.class);
        intent.putExtra("sale", sale);
        sourceActivity.startActivity(intent);
    }

    public void navigateToUrl(BaseActivity sourceActivity, String url){
        if (null != url && !url.equals("")){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            sourceActivity.startActivity(i);
        }
    }
}
