package com.raheshtek.pincho.utils;

import android.os.Environment;

import com.raheshtek.pincho.app.G;

import java.io.File;

public class FileManager {

    private final String DIR_SDCARD = Environment.getExternalStorageState();
    private final String PUBLIC_APP_DIR = DIR_SDCARD + "/Pincho/";

    private String APPDIR;
    private String APPDIR_DOWNLOADS;
    private String APPDIR_MEDIA;
    private static FileManager mInstance;

    private FileManager() {
        makePrivateAppDir();
    }

    public static FileManager getInstance() {
        if (mInstance == null) {
            mInstance = new FileManager();
        }
        return mInstance;
    }


    private void makePrivateAppDir() {
        APPDIR = G.getInstance().getFilesDir().getPath();
        APPDIR_DOWNLOADS = APPDIR + "/Downloads/";
        APPDIR_MEDIA = APPDIR + "/Media/";
    }

    public String getAppDir() {
        return APPDIR;
    }


    public String getAppDirMedia() {
        File file = new File(APPDIR_MEDIA);
        if (!file.exists()) {
            file.mkdirs();
        }
        return APPDIR_MEDIA;
    }

    public String getAppDirDownloads() {
        File file = new File(APPDIR_DOWNLOADS);
        if (!file.exists()) {
            file.mkdirs();
        }
        return APPDIR_DOWNLOADS;
    }
}
