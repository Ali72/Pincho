package com.raheshtek.pincho.model;

import com.google.gson.annotations.Expose;

public class Photo {
    @Expose public long albumId;
    @Expose public long id;
    @Expose public String title;
    @Expose public String url;
    @Expose public String thumbnailUrl;
}
