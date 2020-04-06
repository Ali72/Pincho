package com.raheshtek.pincho.view;

import android.content.Context;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.raheshtek.pincho.R;
import com.raheshtek.pincho.model.Photo;
import com.raheshtek.pincho.utils.ImageLoader;
import com.raheshtek.pincho.utils.PinchImageView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainPagerAdapter extends PagerAdapter {
    private List<Photo> photos = new ArrayList<>();
    private final LinkedList<PinchImageView> viewCache = new LinkedList<>();
    private Context context;

    void setData(Context context, List<Photo> photos) {
        this.photos = photos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        PinchImageView piv;
        if (viewCache.size() > 0) {
            piv = viewCache.remove();
            piv.reset();
        } else {
            piv = new PinchImageView(context);
        }
        ImageLoader.getImage(photos.get(position).url, piv, android.R.color.white);
        container.addView(piv);
        return piv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
        PinchImageView piv = (PinchImageView) object;
        container.removeView(piv);
        viewCache.add(piv);
    }
//
//    @Override
//    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        PinchImageView piv = (PinchImageView) object;
////        ImageLoader.getImage(photos.get(position).url, piv, android.R.color.white);
//    }
}
