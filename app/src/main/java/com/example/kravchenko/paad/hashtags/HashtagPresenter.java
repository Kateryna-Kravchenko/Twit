package com.example.kravchenko.paad.hashtags;

/**
 * Created by katerynakravchenko on 29.06.17.
 */


public interface HashtagPresenter {
    void onResume();
    void onPause();
    void onDestroy();
    void getImageTweets();
    void onEventMainThread(HashtagsEvent event);
}