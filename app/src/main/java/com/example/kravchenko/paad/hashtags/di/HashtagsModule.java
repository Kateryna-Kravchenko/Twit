package com.example.kravchenko.paad.hashtags.di;

import com.example.kravchenko.paad.api.CustomTwitterApiClient;
import com.example.kravchenko.paad.entities.Hashtag;
import com.example.kravchenko.paad.hashtags.HashtagPresenter;
import com.example.kravchenko.paad.hashtags.HashtagsInteractor;
import com.example.kravchenko.paad.hashtags.HashtagsInteractorImpl;
import com.example.kravchenko.paad.hashtags.HashtagsPresenterImpl;
import com.example.kravchenko.paad.hashtags.HashtagsRepository;
import com.example.kravchenko.paad.hashtags.HashtagsRepositoryImpl;
import com.example.kravchenko.paad.hashtags.ui.HashtagsView;
import com.example.kravchenko.paad.hashtags.ui.adapters.HashtagsAdapter;
import com.example.kravchenko.paad.hashtags.ui.adapters.OnItemClickListener;
import com.example.kravchenko.paad.lib.base.EventBus;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by katerynakravchenko on 29.06.17.
 */
@Module
public class HashtagsModule {

    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    HashtagsAdapter providesAdapter(List<Hashtag> dataset,  OnItemClickListener clickListener){
        return new HashtagsAdapter(dataset, clickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> providesItemsList(){
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    HashtagPresenter providesHashtagsPresenter(HashtagsView view, EventBus eventBus, HashtagsInteractor interactor){
        return new HashtagsPresenterImpl( eventBus,view, interactor);
    }

    @Provides
    @Singleton
    HashtagsView providesHashtagsView(){
        return this.view;
    }

    @Provides
    @Singleton
    HashtagsInteractor providesHashtagsInteractor(HashtagsRepository repository){
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository providesHashtagsRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new HashtagsRepositoryImpl(eventBus, client);
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

