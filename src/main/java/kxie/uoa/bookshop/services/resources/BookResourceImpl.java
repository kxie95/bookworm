package kxie.uoa.bookshop.services.resources;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.ws.rs.core.Response;

import kxie.uoa.bookshop.domain.Book;
import kxie.uoa.bookshop.dto.BookDto;
import kxie.uoa.bookshop.services.mappers.BookMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An implementation of BookResource. 
 * @author Karen Xie kxie094
 *
 */
public class BookResourceImpl implements BookResource {
	
	private static final Logger _logger = LoggerFactory.getLogger(BookResourceImpl.class);

	private EntityManager em;
	
	public BookResourceImpl() {
		em = Persistence.createEntityManagerFactory("bookShopPU").createEntityManager();
	}
	
	/**
	 * Create a book given a BookDto.
	 */
	@Override
	public Response createBook(BookDto bookDto) {
		_logger.debug("Read book: " + bookDto);
		
		// Get the full book
		Book book = BookMapper.toDomainModel(bookDto);
		
		// Persist in DB
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();

		_logger.debug("Created book: " + book);
		return Response.created(URI.create("/books/" + book.getId())).build();
	}

	/**
	 * Retrieve a book using an id.
	 */
	@Override
	public BookDto retrieveBook(long id) {
		// Get the full Book object from the database.
		Book book = em.find(Book.class, id);

		// Convert the full Book a short Book.
		BookDto bookDto = BookMapper.toDto(book);

		return bookDto;
	}

	@Override
	public void updateBook(long id, BookDto bookDto) {
		// TODO Auto-generated method stub
		
	}

}
