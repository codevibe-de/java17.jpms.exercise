package book.io;

import book.api.Book;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class BookReader {

    public List<Book> readBooksFromCsv(InputStream in, boolean hasHeaderRow, String separator) throws IOException {
        // check args
        Objects.requireNonNull(in, "Input stream must not be null");
        final var finalSeparator = Objects.requireNonNullElse(separator, ",");
        // read content
        var content = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        return content.lines()
                .skip(hasHeaderRow ? 1 : 0)
                .map(l -> l.split(finalSeparator))
                .filter(parts -> parts.length == 4)
                .map(parts -> new Book(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]))
                .toList();
    }

}
