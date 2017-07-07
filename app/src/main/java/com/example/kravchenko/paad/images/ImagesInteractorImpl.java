package com.example.kravchenko.paad.images;

/**
 * Created by katerynakravchenko on 27.06.17.
 */

public class ImagesInteractorImpl implements ImagesInteractor {
    private ImagesRepository repository;

    public ImagesInteractorImpl(ImagesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getImages();
    }
}