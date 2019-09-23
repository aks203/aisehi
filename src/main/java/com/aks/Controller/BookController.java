package com.aks.Controller;

import com.aks.Exceptions.CustomNotFoundException;
import com.aks.Exceptions.CustomGenericException;
import com.aks.Exceptions.DatabaseDownException;
import com.aks.POJO.BookPojo;
import com.aks.Service.BookService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest controller api for books related requests
 * User id must be passed in header under "user_id" field for api requests
 *
 * url             HTTP Method  Operation
 * /api/books      GET          Get a list of all books
 * /api/books      POST         Add a new book and return the book with an id attribute added
 * /api/books/:id  DELETE       Delete the book with id of :id
 */
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * @return List of all books
     */
    @GetMapping()
    public @ResponseBody List<BookPojo> getBooks(){
        try {
            return bookService.getBooks();
        }
        catch (HibernateException | CannotCreateTransactionException dbException) {
            throw new DatabaseDownException("Database error. Could not connect at this time.");
        }
        catch (Exception ex){
            throw new CustomGenericException("Unable to retrive books at this time. Please try again later.");
        }
    }

    /**
     * Add book to DB
     * @param bookPojo
     * @return book with id attribute
     */
    @PostMapping()
    public @ResponseBody BookPojo addBook(@RequestBody BookPojo bookPojo){
        try {
//            BookPojo bookPojo=new BookPojo("fjkda", "dsfa", "afda", "fadf");
            return bookService.addBook(bookPojo);
        }
        catch (HibernateException | CannotCreateTransactionException dbException) {
            throw new DatabaseDownException("Database error. Could not connect at this time.");
        }
        catch (Exception ex){
            throw new CustomGenericException("Book can't be saved at this time. Please try again later.");
        }
    }

    /**
     * Delete book by id
     * @param id
     * @return Message
     */
    @DeleteMapping(value = "/{id}")
    public @ResponseBody String deleteBook(@PathVariable("id") Integer id){
        if(!(bookService.deleteBook(id) >0)){
            throw new CustomNotFoundException("Unable to delete book.");
        }
        return "Book deleted successfully.";
    }
}
