package com.example.kravchenko.paad.hashtags;

import com.example.kravchenko.paad.entities.Hashtag;

import java.util.List;

/**
 * Created by katerynakravchenko on 29.06.17.
 */

public class HashtagsEvent {



        private String error;
        private List<Hashtag> hashtags;

        public List<Hashtag>  getHashtags() {
            return hashtags;
        }

        public void setHashtags(List<Hashtag> hashtags) {
            this.hashtags = hashtags;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

}
