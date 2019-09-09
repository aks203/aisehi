package com.aks.Service;

import com.aks.DAO.BookDAO;
import com.aks.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    BookDAO bookDAO;

    @Override
    public List<Book> getBooks(){
        return bookDAO.getBooks();
    }

    @Override
    public Book addBook(Book book){
        int id=bookDAO.addBook(book);
        return bookDAO.getBookById(id);
    }

    @Override
    public Book getBookById(int id){
        return bookDAO.getBookById(id);
    }

    @Override
    public String deleteBook(Integer id){
        int i=bookDAO.deleteBook(id);
        if(i>0){
            return "Successfully deleted.";
        }
        else {
            return "Delete unsuccessful!";
        }
    }
}
