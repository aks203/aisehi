package com.aks.Service;

import com.aks.POJO.BookPojo;

import java.util.List;

public interface CartService {
    List<BookPojo> getCart(int user_id, int type);

    String addBook(int user_id, int book_id);

    String deleteBook(Integer user_id, Integer book_id);

    String checkoutBooks(Integer user_id);

    String returnBook(Integer user_id, Integer book_id);
}
