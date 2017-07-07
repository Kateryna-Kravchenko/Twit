package com.example.kravchenko.paad.images.di;

import com.example.kravchenko.paad.images.ImagesPresenter;
import com.example.kravchenko.paad.images.ui.ImagesFragment;
import com.example.kravchenko.paad.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by katerynakravchenko on 28.06.17.
 */

@Singleton
@Component(modules = {LibsModule.class, ImagesModule.class})
public interface ImagesComponent {

    void inject(ImagesFragment imagesFragment);
    ImagesPresenter getPresenter();
}
