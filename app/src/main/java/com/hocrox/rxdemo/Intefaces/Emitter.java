package com.hocrox.rxdemo.Intefaces;

/**
 * Created by sahilgoyal on 9/6/17.
 */

public interface Emitter<T> {
    void onNext(T value);
    void onError(Throwable error);
    void onComplete();

}
