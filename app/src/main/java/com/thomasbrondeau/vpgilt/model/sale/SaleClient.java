package com.thomasbrondeau.vpgilt.model.sale;

import com.google.gson.Gson;
import com.thomasbrondeau.vpgilt.model.entity.SaleBase;
import com.thomasbrondeau.vpgilt.model.network.Network;
import com.thomasbrondeau.vpgilt.model.network.NetworkCallback;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class SaleClient extends BaseClient {

    public SaleClient(Network network) {
        super(network);
    }

    public void getList(final SaleRepository.SaleListListener callback){
        NetworkCallback networkCallback = new NetworkCallback() {
            @Override
            public void success(String body) {
                SaleBase saleBase = new Gson().fromJson(body, SaleBase.class);
                callback.onSaleListReceived(saleBase.saleList);
            }

            @Override
            public void failure(String body) {
                // TODO: set default error message
                String message = "";
                if (null != body && !body.isEmpty()) {
                    Error error = new Gson().fromJson(body, Error.class);
                    message = error.getMessage();
                }
                callback.onFailure(message);
            }
        };

        makeGetRequest(networkCallback);
    }
}
