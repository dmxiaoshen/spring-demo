package com.dmxiaoshen.service;

import com.dmxiaoshen.entity.Book;

/**
 * Created by hzhsg on 2017/11/16.
 */
public interface BookService {

    void addBook(Book book);

    Book getBookById(String id);
}
