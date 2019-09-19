package com.aks.Service;

import com.aks.DAO.BookDAO;
import com.aks.Entity.Book;
import com.aks.Exceptions.CustomException;
import com.aks.POJO.BookPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
//    classes annotated with @Component, @Service, @Repository are considered as beans
//    so their objects are injected
    @Autowired
    BookDAO bookDAO;

    @Override
    public List<BookPojo> getBooks(){
        List<BookPojo> bookPojoList = new ArrayList<>();
        try {
            List<Book> bookList = bookDAO.getBooks();
            for (Book newBook : bookList) {
                bookPojoList.add(new BookPojo(newBook.getBook_id(),
                        newBook.getTitle(),
                        newBook.getAuthor(),
                        newBook.getCategory(),
                        newBook.getPublisher(),
                        newBook.getContent()));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return bookPojoList;
    }

    @Override
    public BookPojo addBook(BookPojo bookPojo){
        Book book=new Book(bookPojo.getTitle(),
                bookPojo.getAuthor(),
                bookPojo.getCategory(),
                bookPojo.getContent(),
                bookPojo.getPublisher());
        int id = bookDAO.addBook(book);
        return this.getBookById(id);
    }

    @Override
    public BookPojo getBookById(int id){
            Book returnedBook = bookDAO.getBookById(id);
            if(returnedBook==null) {
                throw new CustomException("Book not found.");
            }
        return new BookPojo(returnedBook.getBook_id(),
                returnedBook.getTitle(),
                returnedBook.getAuthor(),
                returnedBook.getCategory(),
                returnedBook.getPublisher(),
                returnedBook.getContent());
    }

    @Override
    public int deleteBook(Integer id){
           return bookDAO.deleteBook(id);
    }
}
