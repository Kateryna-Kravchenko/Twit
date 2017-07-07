package com.example.kravchenko.paad.lib;

import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.kravchenko.paad.lib.base.ImageLoader;

/**
 * Created by katerynakravchenko on 13.06.17.
 */

public class GlideImageLoader implements ImageLoader {
    private RequestManager glideRequestManager;

    public GlideImageLoader(RequestManager glideRequestManager) {
        this.glideRequestManager = glideRequestManager;
    }

    @Override
    public void load(ImageView imageView, String URL) {
        glideRequestManager
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .override(600, 400)
                .into(imageView);
//
//        glideRequestManager
//                .load(URL)
////                .diskCacheStrategy(DiskCacheStrategy.ALL)
////                .centerCrop()
////                .override(600, 400)
//                .into(imageView);


        ;
    }
}