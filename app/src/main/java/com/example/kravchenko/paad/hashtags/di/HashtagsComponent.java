package com.example.kravchenko.paad.hashtags.di;

import com.example.kravchenko.paad.hashtags.HashtagPresenter;
import com.example.kravchenko.paad.hashtags.ui.HashtagsFragment;
import com.example.kravchenko.paad.lib.di.LibsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by katerynakravchenko on 29.06.17.
 */


@Singleton
@Component(modules = {LibsModule.class, HashtagsModule.class})
public interface HashtagsComponent {

    void inject(HashtagsFragment hashtagsFragment);
    HashtagPresenter getPresenter();
}