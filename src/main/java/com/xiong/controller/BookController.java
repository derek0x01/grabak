package com.xiong.controller;

import com.xiong.pojo.Books;
import com.xiong.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list=bookService.queryAllBooks();
        model.addAttribute("list",list);
        return "allBook";
    }
    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id,Model model){
        Books books = bookService.queryBookByID(id);
        model.addAttribute("book",books);

        return "updateBook";
    }
    @RequestMapping("/updateBook")
    public String updateBook(Model model,Books book){
        System.out.println(book);
        bookService.updateBook(book);
        Books books=bookService.queryBookByID(book.getBookID());
        model.addAttribute("book",books);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookByID(id);
        return "redirect:/book/allBook";
    }
}
