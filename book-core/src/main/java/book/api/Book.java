package book.api;

import org.apache.commons.lang3.StringUtils;

public record Book(
        String isbn,
        String title,
        Integer year,
        String author
) implements Comparable<Book> {

    public Book {
        checkIsbn(isbn);
    }

    private void checkIsbn(String isbn) throws IllegalArgumentException {
        // noop
    }

    @Override
    public int compareTo(Book that) {
        if (that == null) {
            return -1;
        } else {
            return StringUtils.compare(this.isbn, that.isbn);
        }
    }
}
