package com.raheshtek.pincho.utils;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.request.RequestOptions;
import com.raheshtek.pincho.app.G;


/**
 * Created by ali on 31/07/2017.
 */

public class ImageLoader {

    private static final String TAG = ImageLoader.class.getName();

    public static void getImage(final String url, ImageView imageView, int placeHolder) {
        if (url == null || imageView == null) return;
        Log.i(TAG, "-> Server Url Image: " + url);
        Glide.with(G.getInstance()).asBitmap().load(getGlideUrl(url))
                .apply(new RequestOptions()
                        .placeholder(placeHolder).override(250,250))
                .into(imageView);
    }

    private static GlideUrl getGlideUrl(String url) {
        return new GlideUrl(url, new LazyHeaders.Builder()
                .addHeader("User-Agent",
                        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit / 537.36(KHTML, like Gecko) Chrome  47.0.2526.106 Safari / 537.36")
                .build());
    }
}
