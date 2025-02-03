import book.service.InMemoryBookService;
import book.api.BookService;

module jpms.book.core {
	exports book.api;
	requires org.apache.commons.lang3;
	opens book.api;
	provides BookService with InMemoryBookService;
}