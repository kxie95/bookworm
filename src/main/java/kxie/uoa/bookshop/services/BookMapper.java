package kxie.uoa.bookshop.services;

import kxie.uoa.bookshop.domain.Book;
import kxie.uoa.bookshop.domain.Genre;
import kxie.uoa.bookshop.dto.BookDto;

/**
 * Class for converting between BookDto and domain model class Book.
 * @author Karen Xie kxie094
 *
 */
public class BookMapper {
	public static Book toDomainModel(BookDto bookDto) {
		Book fullBook = new Book(
				bookDto.getTitle(), 
				bookDto.getAuthor(), 
				Genre.fromString(bookDto.getGenre()),
				bookDto.getPrice());
		return fullBook;
	}

	static BookDto toDto(Book book) {
		BookDto bookDto = new BookDto(
				book.getId(), 
				book.getTitle(), 
				book.getAuthor(), 
				book.getGenre().getDescription(), 
				book.getPrice());
		return bookDto;

	}
}
