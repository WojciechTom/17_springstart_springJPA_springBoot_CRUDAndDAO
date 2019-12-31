package jp.javastart.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import jp.javastart.model.Book;

@Repository
public class BookDaoImp implements BookDao{

	@PersistenceContext
	private EntityManager manago;
	
	BookDaoImp(){}
	
	@Override
	@Transactional
	public void save(Book book) {
		manago.persist(book);
	}

	

	@Override
	@Transactional
	public Book get(Long id) {
		return manago.find(Book.class, id);
		
	}

	@Override
	@Transactional
	public void remove(Long id) {
		Book bookToRemove = manago.find(Book.class, id);
		manago.remove(bookToRemove);
		System.out.println("Usunięto książkę: " + bookToRemove.toString());
	}

	
	@Transactional
	public void updateSecondVersion(Book book) {
		manago.merge(book);
	}

	@Override
	@Transactional
	public void update(Book book) {
		Book bookToChange = manago.find(Book.class, book.getId());
		if(bookToChange != null) {
			bookToChange.setAuthor(book.getAuthor());
			bookToChange.setTitle(book.getTitle());
			bookToChange.setIsbn(book.getIsbn());
		}
	
	}

	

}
