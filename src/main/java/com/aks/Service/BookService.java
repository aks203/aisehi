package com.aks.Service;

import com.aks.Entity.Book;
import com.aks.POJO.BookPojo;

import java.util.List;

public interface BookService {
    /**
     *
     * @return
     */
    List<BookPojo> getBooks();

    BookPojo addBook(BookPojo bookPojo);

    BookPojo getBookById(int id);

    String deleteBook(Integer id);
}
