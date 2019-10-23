package com.aks.Service;

import com.aks.DAO.BookDAO;
import com.aks.Entity.Book;
import com.aks.Exceptions.BadRequestException;
import com.aks.Exceptions.CustomGenericException;
import com.aks.Exceptions.CustomNotFoundException;
import com.aks.POJO.BookPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
//    Classes annotated with @Component, @Service, @Repository are considered as beans
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
                        newBook.getCountBooks()));
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
                bookPojo.getPublisher(),
                bookPojo.getCountBooks());
        int id = bookDAO.addBook(book);
        return this.getBookById(id);
    }

    @Override
    public BookPojo getBookById(int id){
            Book returnedBook = bookDAO.getBookById(id);
            if(returnedBook==null) {
                throw new CustomNotFoundException("Book not found.");
            }
        return new BookPojo(returnedBook.getBook_id(),
                returnedBook.getTitle(),
                returnedBook.getAuthor(),
                returnedBook.getCategory(),
                returnedBook.getPublisher(),
                returnedBook.getCountBooks());
    }

    @Override
    public int deleteBook(Integer id){
           return bookDAO.deleteBook(id);
    }

    @Override
    public BookPojo updateBook(BookPojo bookPojo) {
        Book book=bookDAO.updateBook(bookPojo);
        BookPojo updatedBook=new BookPojo(
                book.getBook_id(),
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getPublisher(),
                book.getCountBooks()
        );
        if(updatedBook!=null)
            return updatedBook;
        else throw new BadRequestException("Unable to update book now. Please try again later.");
    }
}
