package com.example.kravchenko.paad.images;

/**
 * Created by katerynakravchenko on 25.06.17.
 */

public interface ImagesPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}