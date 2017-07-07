package com.example.kravchenko.paad.hashtags.ui;

import com.example.kravchenko.paad.entities.Hashtag;

import java.util.List;

/**
 * Created by katerynakravchenko on 29.06.17.
 */

public interface HashtagsView {

    void showHashtags();
    void hideHashtags();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Hashtag> items);
}
