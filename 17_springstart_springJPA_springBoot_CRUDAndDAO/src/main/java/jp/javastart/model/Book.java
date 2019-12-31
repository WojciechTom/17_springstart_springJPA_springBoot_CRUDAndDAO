package jp.javastart.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PostRemove;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Booksy")
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long id;
	@Column(name = "book_isbn", length = 13, unique = true, nullable = false)
	private String isbn;
	@Column(name = "book_title")
	private String title;
	@Column(name = "book_author")
	private String author;
	@Transient
	private String desc;
	
	public Book() {}

	
	public Book(String isbn, String title, String author, String desc) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.desc = desc;
	}

	
	@PrePersist
	public void prePersist() {
		System.out.println("Zapis obiektu ===>>>>" + this);
	}
	
	@PostPersist
	public void postPersist() {
		System.out.println("Zapisano obiekt ===>>>>" + this);
	}
	
	@PreRemove
	public void preRemove() {
		System.out.println("Przed usunięciem obiektu ===>>>>" + this);
	}

	@PostRemove
	public void PostRemove() {
		System.out.println("Po usunięciu obiektu ===>>>" + this);
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}

	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", desc=" + desc + "]";
	}
	
	
	
}
