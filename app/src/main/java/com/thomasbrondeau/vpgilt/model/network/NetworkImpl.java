package com.thomasbrondeau.vpgilt.model.network;

import android.content.Context;

import com.thomasbrondeau.vpgilt.model.Environment;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import timber.log.Timber;

/**
 * Created by THOMASBRONDEAU_Steven on 18/04/2018.
 */

public class NetworkImpl implements Network {

    private RetrofitService mService;
    private final int CACHE_SIZE = 10 * 1024 * 1024; // 10MB

    // Here we set a 10MB cache to keep http response
    // This is the way I chose to avoid a database in order to support data persistence
    // We also remove the Pragma header to avoid the "no-cache" value
    public NetworkImpl(Context ctx, String baseUrl){
        OkHttpClient client = new OkHttpClient.Builder()
                .cache(new Cache(new File(ctx.getCacheDir(), "vpCacheResponse"), CACHE_SIZE))
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response response = chain.proceed(chain.request());
                        return response.newBuilder()
                                .removeHeader("Pragma")
                                .build();
                    }
                })
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder().addHeader("apikey", Environment.API_KEY).build();
                        return chain.proceed(request);
                    }
                })
                .build();
        Retrofit retrofit = new Retrofit.Builder().client(client).baseUrl(baseUrl).build();
        mService = retrofit.create(RetrofitService.class);
    }

    public void get(final NetworkCallback callback) {
        Call<ResponseBody> call = mService.getActiveWomenSales();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                checkResponse(response, callback);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.failure(null);
            }
        });
    }

    private void checkResponse(retrofit2.Response<ResponseBody> response, NetworkCallback callback) {
        String body = getBodyFromResponse(response);
        if (!response.isSuccessful()) {
            callback.failure(body);
        } else {
            callback.success(body);
        }
    }

    private String getBodyFromResponse(retrofit2.Response<ResponseBody> response) {
        String body = "";
        try {
            if (response != null && response.body() != null) {
                body = response.body().string();
            }
        } catch (Exception e) {
            Timber.e("Error while retrieving response body", e);
        }
        return body;
    }
}