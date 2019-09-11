package com.aks.Controller;

import com.aks.Entity.Book;
import com.aks.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public @ResponseBody List<Book> getBooks(){
        try {
            return bookService.getBooks();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ArrayList<Book>();
        }
    }

    @PostMapping()
    public @ResponseBody Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody String deleteBook(@PathVariable("id") Integer id){
        return bookService.deleteBook(id);
    }
}
