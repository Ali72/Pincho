package com.raheshtek.pincho.repository.remote.services;

import androidx.multidex.BuildConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.raheshtek.pincho.app.Constants;
import com.raheshtek.pincho.app.G;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiConnection {

    private ServiceApi serviceApi;
    private Retrofit retrofit;


    public ApiConnection() {
        retrofit = create();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public ServiceApi getService() {
        if (serviceApi == null) {
            serviceApi = retrofit.create(ServiceApi.class);
        }
        return serviceApi;
    }

    private Retrofit create() {

        OkHttpClient.Builder client = getOkHttpClient();

//        if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(logging);
//        }

        client.addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder().build();
            return chain.proceed(newRequest);
        });


        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        retrofit = new Retrofit.Builder()
                .client(client.build())
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }

    public void clear() {
        retrofit = null;
        serviceApi = null;
    }

    private OkHttpClient.Builder getOkHttpClient() {
        int cacheSize = 20 * 1024 * 1024;
        Cache cache = new Cache(G.getInstance().getCacheDir(), cacheSize);

        return new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true).cache(cache);
    }
}
