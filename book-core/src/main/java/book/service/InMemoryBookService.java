package book.service;

import book.api.Book;
import book.api.BookService;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InMemoryBookService implements BookService {

    private final Random random = new Random();

    private final List<Book> books = new ArrayList<>();

    @Override
    public String generateIsbn() {
        return String.format("978-3-%05d-%03d-0",
                random.nextInt(100000),
                random.nextInt(1000));
    }


    @Override
    public void addBook(String title, String author, Integer year, String isbn) {
        if (StringUtils.isBlank(isbn)) {
            isbn = generateIsbn();
        }
        addBook(
                new Book(
                        (isbn == null || isbn.isBlank()) ? generateIsbn() : isbn,
                        title,
                        year,
                        author
                ));
    }


    @Override
    public void addBook(Book book) {
        books.add(book);
    }


    @Override
    public List<Book> findAllBooks() {
        return List.copyOf(books);
    }

}
