package com.example.kravchenko.paad.images;


import com.example.kravchenko.paad.images.ui.ImagesView;
import com.example.kravchenko.paad.lib.base.EventBus;

import org.greenrobot.eventbus.Subscribe;

/**
 * Created by katerynakravchenko on 27.06.17.
 */

public class ImagesPresenteImpl implements ImagesPresenter {
    private EventBus eventBus;
    private ImagesView view;
    private ImagesInteractor interactor;

    public ImagesPresenteImpl(EventBus eventBus, ImagesView view, ImagesInteractor interactor) {
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
    public void getImageTweets() {
        if (view != null) {
            view.hideImages();
            view.showProgress();
        }
        interactor.execute();
    }

    @Override
    @Subscribe
    public void onEventMainThread(ImagesEvent event) {
        String errorMsg = event.getError();
        if (view != null) {
            view.showImages();
            view.hideProgress();
            if (errorMsg != null) {
                view.onError(errorMsg);
            } else {
                view.setContent(event.getImages());
            }

        }
    }
}