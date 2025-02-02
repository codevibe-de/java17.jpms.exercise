package application;

import book.api.BookService;
import book.api.Publisher;
import book.io.BookReader;
import book.report.BookReportWriter;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.io.IOException;

public class BookApplication {

    public static void main(String[] args) throws IOException, IllegalAccessException {
        System.out.println("Hello, Book Application!");

        // -- add a single book
        BookService.INSTANCE.addBook("Java 11", "John Doe", 2018, null);

        // -- create a publisher and fix its name using reflection afterwards
        Publisher publisher = new Publisher("D-Punkt Verlag");
        FieldUtils.writeField(publisher, "name", "dpunkt.verlag", true);

        // -- use BookReader to parse a CSV file and add each book
        new BookReader().readBooksFromCsv(
                ClassLoader.getSystemResourceAsStream("books.csv"), true, ";"
        ).forEach(BookService.INSTANCE::addBook);

        // -- print all books -- this code uses the "book-report" module
        String report = BookReportWriter.getStringInstance().generateReport(
                BookService.INSTANCE.findAllBooks()
        );
        System.out.println(report);
    }
}
