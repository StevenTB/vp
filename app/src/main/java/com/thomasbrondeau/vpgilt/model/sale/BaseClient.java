package com.thomasbrondeau.vpgilt.model.sale;

import com.thomasbrondeau.vpgilt.model.network.Network;
import com.thomasbrondeau.vpgilt.model.network.NetworkCallback;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public abstract class BaseClient {

    private Network mNetwork;

    BaseClient(Network network) {
        mNetwork = network;
    }

    public void makeGetRequest(NetworkCallback callback) {
        mNetwork.get(callback);
    }
}
