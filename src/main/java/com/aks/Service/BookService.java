package com.aks.Service;

import com.aks.Entity.Book;

import java.util.List;

public interface BookService {
    /**
     *
     * @return
     */
    List<Book> getBooks();

    Book addBook(Book book);

    Book getBookById(int id);

    String deleteBook(Integer id);
}
