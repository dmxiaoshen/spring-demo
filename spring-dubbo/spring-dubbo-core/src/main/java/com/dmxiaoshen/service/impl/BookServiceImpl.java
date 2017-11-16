package com.dmxiaoshen.service.impl;

import com.dmxiaoshen.entity.Book;
import com.dmxiaoshen.service.BookService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzhsg on 2017/11/16.
 */
public class BookServiceImpl implements BookService{
    static Map<String,Book> bookcase = Collections.synchronizedMap(new HashMap<>());

    @Override
    public void addBook(Book book) {
        bookcase.put(book.getId(),book);
        System.out.println("add book:"+book.toString());
    }

    @Override
    public Book getBookById(String id) {
        Book book = bookcase.get(id);
        System.out.println("get book: "+book.toString());
        return book;
    }
}
