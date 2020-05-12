package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        // the model is what is getting returned to the view.

        model.addAttribute("books", bookRepository.findAll());
        // at run time when Spring gets request to /books. it will execute getBooks method, and it will provide model

        return "books/list";
    }
}
