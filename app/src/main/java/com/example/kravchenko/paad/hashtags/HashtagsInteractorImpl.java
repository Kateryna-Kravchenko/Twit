package com.example.kravchenko.paad.hashtags;

/**
 * Created by katerynakravchenko on 03.07.17.
 */
public class HashtagsInteractorImpl implements HashtagsInteractor {
    private HashtagsRepository repository;

    public HashtagsInteractorImpl(HashtagsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute() {
        repository.getHashtags();
    }
}

