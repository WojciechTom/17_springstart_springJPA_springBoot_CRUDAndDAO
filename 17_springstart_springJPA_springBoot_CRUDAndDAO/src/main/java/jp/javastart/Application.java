package jp.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jp.javastart.dao.BookDao;
import jp.javastart.dao.BookDaoImp;
import jp.javastart.model.Book;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext ctx =  SpringApplication.run(Application.class, args);
		BookDao dao = ctx.getBean(BookDao.class);
		BookDaoImp daoI = ctx.getBean(BookDaoImp.class);
		
		Book book = new Book("1115", "czy te oczy mogą kłamać", "chyba nie ", "książka o niczym");
		Book book1 = new Book("1116", "w ścianie", "wacław sonelski", "wspinaczka dla ambitnych");
		Book book2 = new Book("1117", "java start", "Billy  Great", "nauka javy w weekend");
		Book book3 = new Book("1118", "Statystyka", "John OStat", "bedziesz umiał liczyć na siebie");
		
		dao.save(book);
		dao.save(book1);
		dao.save(book2);
		dao.save(book3);
		
		System.out.println("Książka nr 1: " +  dao.get(1L).toString());
		System.out.println("Książka nr 2: " +  dao.get(2L).toString());
		
		Book bookToUpdate = new Book("1115", "czy te oczy mogą kłamać", "GGGGG", "FFFFFF");
		bookToUpdate.setId(1L);
		daoI.updateSecondVersion(bookToUpdate);
		//dao.update(bookToUpdate);
		
		System.out.println("po updacie:");
		System.out.println("Książka nr 1: " +  dao.get(1L).toString());
		System.out.println("Książka nr 2: " +  dao.get(2L).toString());
		
		
		
		dao.remove(1L);
		
		System.out.println("po usunięciu:");
		Book b1 = dao.get(1L);
		Book b2 = dao.get(2L);
		System.out.println("Książka nr 2: " +  b2);
		System.out.println("Książka nr 1: " +  b1);
		
		
		
		
	}

}
