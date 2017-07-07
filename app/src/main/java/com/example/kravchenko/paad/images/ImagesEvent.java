package com.example.kravchenko.paad.images;

import com.example.kravchenko.paad.entities.Image;

import java.util.List;

/**
 * Created by katerynakravchenko on 25.06.17.
 */

public class ImagesEvent {
    private String error;
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}