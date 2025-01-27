package book.report;

import book.api.Book;

import java.util.Collection;
import java.util.stream.Collectors;

public interface BookReportWriter<T> {

    T generateReport(Collection<Book> books);

    static BookReportWriter<String> getStringInstance() {
        return new BookReportWriter<>() {
            private static final String PATTERN = "%-17.17s | %-27.27s | %4.4s | %-26.26s%n";
            private static final String SEPARATOR_SEGMENT = "----------------------------------------------------------";

            @Override
            public String generateReport(Collection<Book> books) {
                return PATTERN.formatted("ISBN", "Title", "Year", "Author")
                        +
                        PATTERN.formatted(SEPARATOR_SEGMENT, SEPARATOR_SEGMENT, SEPARATOR_SEGMENT, SEPARATOR_SEGMENT)
                        +
                        books.stream()
                                .map(b -> PATTERN.formatted(b.isbn(), b.title(), b.year(), b.author()))
                                .collect(Collectors.joining());
            }
        };
    }
}
