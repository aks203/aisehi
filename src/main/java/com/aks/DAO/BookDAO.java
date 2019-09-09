package com.aks.DAO;

import com.aks.Entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();

    int addBook(Book book);

    Book getBookById(int id);

    int deleteBook(Integer id);
}
