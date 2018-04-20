package com.thomasbrondeau.vpgilt.model.sale;

import com.thomasbrondeau.vpgilt.model.entity.Sale;
import com.thomasbrondeau.vpgilt.model.network.Network;
import com.thomasbrondeau.vpgilt.model.network.NetworkCallback;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by THOMASBRONDEAU_Steven on 20/04/2018.
 */

public class SaleClientTest {

    private Network mNetwork;

    @Test
    public void testError() throws Exception {
        // Given : network will fail
        mNetwork = new Network() {
            @Override
            public void get(NetworkCallback callback) {
                callback.failure("{\"error\":\"lol\"}");
            }
        };
        SaleClient client = new SaleClient(mNetwork);

        // When :
        final boolean[] failureCalled = {false};
        client.getList(new SaleRepository.SaleListListener() {
            @Override
            public void onSaleListReceived(List<Sale> saleList) {

            }

            @Override
            public void onSuccess(String msg) {
            }

            @Override
            public void onFailure(String msg) {
                failureCalled[0] = true;
            }
        });

        // Then :
        Assert.assertTrue(failureCalled[0]);
    }
}
