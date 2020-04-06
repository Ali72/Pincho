package com.raheshtek.pincho.repository.remote.services;

import com.raheshtek.pincho.model.Api;
import com.raheshtek.pincho.model.Photo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ServiceApi {

    @GET("albums/2/photos")
    Call<List<Photo>> getPhotos();

    @GET()
    @Streaming
    Call<ResponseBody> downloadImage(@Url String fileUrl);
}
