package com.thomasbrondeau.vpgilt.model;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public interface RepositoryListener {
    void onSuccess(String msg);
    void onFailure(String msg);
}
