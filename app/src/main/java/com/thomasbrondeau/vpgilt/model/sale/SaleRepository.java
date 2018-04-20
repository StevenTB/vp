package com.thomasbrondeau.vpgilt.model.sale;

import com.thomasbrondeau.vpgilt.model.RepositoryListener;
import com.thomasbrondeau.vpgilt.model.entity.Sale;

import java.util.List;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class SaleRepository {
    private final static int MAX_ITEM_INDEX = 9; // 10 items to display only
    private SaleClient mClient;

    public SaleRepository(SaleClient client) {
        mClient = client;
    }

    public void getList(final SaleListListener callback){
        SaleListListener listener = new SaleListListener() {
            @Override
            public void onSaleListReceived(List<Sale> sales) {
                // Return response to callback
                callback.onSaleListReceived(sales.subList(0, MAX_ITEM_INDEX));
            }

            @Override
            public void onFailure(String msg) {
                callback.onFailure(msg);
            }

            @Override
            public void onSuccess(String msg) {
                callback.onSuccess(msg);
            }
        };

        mClient.getList(listener);
    }

    public interface SaleListListener extends RepositoryListener {
        void onSaleListReceived(List<Sale> saleList);
    }
}