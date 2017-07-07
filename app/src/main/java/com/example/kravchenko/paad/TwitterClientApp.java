package com.example.kravchenko.paad;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.example.kravchenko.paad.images.di.DaggerImagesComponent;
import com.example.kravchenko.paad.images.di.ImagesComponent;
import com.example.kravchenko.paad.images.di.ImagesModule;
import com.example.kravchenko.paad.images.ui.ImagesView;
import com.example.kravchenko.paad.images.ui.adapters.OnItemClickListener;
import com.example.kravchenko.paad.lib.di.LibsModule;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by katerynakravchenko on 13.06.17.
 */

public class TwitterClientApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY, BuildConfig.TWITTER_SECRET);
                Fabric.with(this, new Twitter(authConfig));
    }


    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view, clickListener))
                .build();
    }


}
