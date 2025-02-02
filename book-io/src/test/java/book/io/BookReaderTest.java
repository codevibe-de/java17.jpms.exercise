package book.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

class BookReaderTest {

    @Test
    void readBooksFromCsv() throws IOException {
        // given
        String csvContent = """
                isbn;title;year;author
                978-0451524935;The Adventures of Tom Sawyer;1876;Mark Twain
                """;
        InputStream inputStream = new BufferedInputStream(
                new ByteArrayInputStream(
                        csvContent.getBytes(StandardCharsets.UTF_8)
                )
        );

        // when
        var books = new BookReader().readBooksFromCsv(inputStream, true, ";");

        // then
        Assertions.assertThat(books).isNotNull();
        Assertions.assertThat(books).hasSize(1);
        Assertions.assertThat(books.get(0).isbn()).isEqualTo("978-0451524935");
        Assertions.assertThat(books.get(0).title()).isEqualTo("The Adventures of Tom Sawyer");
        Assertions.assertThat(books.get(0).year()).isEqualTo(1876);
        Assertions.assertThat(books.get(0).author()).isEqualTo("Mark Twain");
    }

}