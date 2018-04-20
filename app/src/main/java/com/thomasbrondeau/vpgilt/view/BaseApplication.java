package com.thomasbrondeau.vpgilt.view;

import android.app.Application;
import android.content.Context;

import com.thomasbrondeau.vpgilt.model.Environment;
import com.thomasbrondeau.vpgilt.model.network.Network;
import com.thomasbrondeau.vpgilt.model.network.NetworkImpl;
import com.thomasbrondeau.vpgilt.model.sale.SaleClient;
import com.thomasbrondeau.vpgilt.model.sale.SaleRepository;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class BaseApplication extends Application {

    private SaleRepository mSaleRepository;
    private SaleClient mSaleClient;
    private Network mNetwork;

    public static BaseApplication from(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    public SaleRepository getRepository() {
        if (mSaleRepository == null) {
            mSaleRepository = new SaleRepository(getSaleClient());
        }
        return mSaleRepository;
    }

    public SaleClient getSaleClient() {
        if (mSaleClient == null) {
            mSaleClient = new SaleClient(getNetwork());
        }
        return mSaleClient;
    }

    public Network getNetwork() {
        if (mNetwork == null) {
            mNetwork = new NetworkImpl(this, Environment.ENDPOINT);
        }
        return mNetwork;
    }
}
