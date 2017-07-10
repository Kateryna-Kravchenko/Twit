package com.example.kravchenko.paad.hashtags;

import com.example.kravchenko.paad.hashtags.ui.HashtagsView;
import com.example.kravchenko.paad.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by katerynakravchenko on 03.07.17.
 */

public class HashtagsPresenterImpl implements HashtagPresenter {

    private EventBus eventBus;
    private HashtagsView view;
    private HashtagsInteractor interactor;

    public HashtagsPresenterImpl(EventBus eventBus, HashtagsView view, HashtagsInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);

    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getHashtagTweets() {
        if (view != null) {
            view.hideHashtags();
            view.showProgress();
        }
        interactor.execute();
    }



    @Override
    @Subscribe
    public void onEventMainThread(HashtagsEvent event) {
        String errorMsg = event.getError();
        if (view != null) {
            view.showHashtags();
            view.hideProgress();
            if (errorMsg != null) {
                view.onError(errorMsg);
            } else {
                view.setContent(event.getHashtags());
            }

        }
    }


}
