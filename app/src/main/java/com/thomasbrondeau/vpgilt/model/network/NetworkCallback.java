package com.thomasbrondeau.vpgilt.model.network;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public interface NetworkCallback {
    void success(String body);
    void failure(String body);
}
