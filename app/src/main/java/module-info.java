import book.api.BookService;

module jpms.app {
	requires jpms.book.starter;
	requires org.apache.commons.lang3;
	uses BookService;
}