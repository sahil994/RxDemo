package com.hocrox.rxdemo.Intefaces;

/**
 * Created by sahilgoyal on 9/6/17.
 */

public interface ObservableOnSubscribe<T> {

   void subscribe(Emitter<T> tEmittere)throws  Exception;

}
