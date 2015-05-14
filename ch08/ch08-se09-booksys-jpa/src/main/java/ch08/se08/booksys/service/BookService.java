package ch08.se08.booksys.service;

import java.util.List;

import ch08.se08.booksys.domain.Book;

public interface BookService {

	int addBook(Book book);

	List<Book> getAllBooks();

	void deleteBook(int id);
	
}
