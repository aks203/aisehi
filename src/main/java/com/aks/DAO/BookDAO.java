package com.aks.DAO;

import com.aks.Entity.Book;
import com.aks.POJO.BookPojo;

import java.util.List;

public interface BookDAO {
    List<Book> getBooks();

    int addBook(Book book);

    Book getBookById(int id);

    int deleteBook(Integer id);

    int getCount(int book_id);

    Book updateBook(BookPojo bookPojo);
}
