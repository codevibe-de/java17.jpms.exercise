package book.api;

import book.service.InMemoryBookService;

import java.util.List;

public interface BookService {

    BookService INSTANCE = new InMemoryBookService();


    String generateIsbn();

    void addBook(String title, String author, Integer year, String isbn);

    void addBook(Book book);

    List<Book> findAllBooks();

}
