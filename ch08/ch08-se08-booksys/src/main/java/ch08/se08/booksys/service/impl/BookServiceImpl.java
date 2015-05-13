package ch08.se08.booksys.service.impl;

import java.util.List;

import ch08.se08.booksys.dao.BookDao;
import ch08.se08.booksys.domain.Book;
import ch08.se08.booksys.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;

	@Override
	public int addBook(Book book) {
		return (Integer)bookDao.save(book);
	}

	public BookDao getBookDao() {
		return bookDao;
	}
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.findAll(Book.class);
	}

	@Override
	public void deleteBook(int id) {
		bookDao.delete(Book.class, id);
	}

}
