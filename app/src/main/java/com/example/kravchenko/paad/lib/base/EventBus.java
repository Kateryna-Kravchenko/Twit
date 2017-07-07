package com.example.kravchenko.paad.lib.base;

/**
 * Created by katerynakravchenko on 13.06.17.
 */

public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}