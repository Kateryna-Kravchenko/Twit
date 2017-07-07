package com.example.kravchenko.paad.images.di;


import com.example.kravchenko.paad.api.CustomTwitterApiClient;
import com.example.kravchenko.paad.entities.Image;
import com.example.kravchenko.paad.images.ImagesInteractor;
import com.example.kravchenko.paad.images.ImagesInteractorImpl;
import com.example.kravchenko.paad.images.ImagesPresenteImpl;
import com.example.kravchenko.paad.images.ImagesPresenter;
import com.example.kravchenko.paad.images.ImagesRepository;
import com.example.kravchenko.paad.images.ImagesRepositoryImpl;
import com.example.kravchenko.paad.images.ui.ImagesView;
import com.example.kravchenko.paad.images.ui.adapters.ImagesAdapter;
import com.example.kravchenko.paad.images.ui.adapters.OnItemClickListener;
import com.example.kravchenko.paad.lib.base.EventBus;
import com.example.kravchenko.paad.lib.base.ImageLoader;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by katerynakravchenko on 28.06.17.
 */
@Module
public class ImagesModule {
    private ImagesView view;
    private OnItemClickListener clickListener;

    public ImagesModule(ImagesView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    ImagesAdapter providesAdapter(List<Image> dataset, ImageLoader imageLoader, OnItemClickListener clickListener){
        return new ImagesAdapter(dataset, imageLoader, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Image> providesItemsList(){
        return new ArrayList<Image>();
    }

    @Provides
    @Singleton
    ImagesPresenter providesImagesPresenter(ImagesView view, EventBus eventBus, ImagesInteractor interactor){
        return new ImagesPresenteImpl( eventBus,view, interactor);
    }

    @Provides
    @Singleton
    ImagesView providesImagesView(){
        return this.view;
    }

    @Provides
    @Singleton
    ImagesInteractor providesImagesInteractor(ImagesRepository repository){
        return new ImagesInteractorImpl(repository);
    }

    @Provides
    @Singleton
    ImagesRepository providesImagesRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new ImagesRepositoryImpl(eventBus, client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(Session session) {
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    Session providesTwitter() {
        return Twitter.getSessionManager().getActiveSession();
    }
}