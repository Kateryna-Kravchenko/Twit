package com.example.kravchenko.paad.images.ui;

import com.example.kravchenko.paad.entities.Image;

import java.util.List;

/**
 * Created by katerynakravchenko on 25.06.17.
 */

public interface ImagesView {
    void showImages();
    void hideImages();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> items);
}