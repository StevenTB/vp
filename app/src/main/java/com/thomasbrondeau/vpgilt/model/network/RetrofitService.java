package com.thomasbrondeau.vpgilt.model.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public interface RetrofitService {
    @GET("sales/women/active.json")
    Call<ResponseBody> getActiveWomenSales();
}
