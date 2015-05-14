package ch08.se08.booksys.action;

import java.util.List;

import ch08.se08.booksys.domain.Book;
import ch08.se08.booksys.service.BookService;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	private static final long serialVersionUID = 1131129148231996461L;

	private BookService bookService;
	
	private Book book;
	private List<Book> books;
	private int id;

	public String add() {
		int result = bookService.addBook(book);
		if(result > 0) {
			addActionMessage("恭喜你，图书添加成功！");
			return SUCCESS;
		}
		
		addActionMessage("图书添加失败，请重新执行添加操作，抱歉！");
		return ERROR;
	}

	public String list() {
		setBooks(bookService.getAllBooks());
		return SUCCESS;
	}

	public String delete() {
		bookService.deleteBook(id);
		return SUCCESS;
	}
		
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
