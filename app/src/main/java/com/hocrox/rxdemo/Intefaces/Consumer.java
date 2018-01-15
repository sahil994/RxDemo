package com.hocrox.rxdemo.Intefaces;

public interface Consumer<T> {
  void accept(T t) throws Exception;
}