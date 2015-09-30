package kxie.uoa.bookshop.services;

import kxie.uoa.bookshop.domain.Book;
import kxie.uoa.bookshop.dto.BookDto;

public class BookMapper {
	public static Book toDomainModel(BookDto bookDto) {
		Book fullBook = new Book(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.get_price());
		return fullBook;
	}

	public static BookDto toDto(Book book) {
		BookDto bookDto = new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
		return bookDto;

	}
}
