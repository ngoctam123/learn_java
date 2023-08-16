package fa.training.services;

import java.util.*;

import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.entities.Book;

public class Library {
    private List<Book> books;
    private List<Magazine> magazines;

    public Library() {
        books = new ArrayList<>();
        magazines = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMagazine(Magazine magazine) {
        magazines.add(magazine);
    }

    public void displayPublicationsByYearAndPublisher(int year, String publisher) {
        System.out.println("Publications with publication year " + year + " and publisher " + publisher + ":");
        for (Publication publication : getAllPublications()) {
            if (publication.getPublicationYear() == year && publication.getPublisher().equals(publisher)) {
                publication.display();
            }
        }
    }

    public void addAuthorToBook(String isbn, String author) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.getAuthors().contains(author)) {
                    System.out.println("Author already exists for this book.");
                } else {
                    book.getAuthors().add(author);
                    System.out.println("Author added successfully.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayTopMagazinesByVolume() {
        List<Magazine> sortedMagazines = new ArrayList<>(magazines);
        sortedMagazines.sort(Comparator.comparingInt(Magazine::getVolume).reversed());
        System.out.println("Top 10 magazines by volume:");
        for (int i = 0; i < Math.min(sortedMagazines.size(), 10); i++) {
            sortedMagazines.get(i).display();
        }
    }

    public Book searchBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthors().contains(author)) {
                result.add(book);
            }
        }
        result.sort(Comparator.comparing(Book::getIsbn).thenComparing(Book::getPublicationDate));
        return result;
    }

    public List<Book> searchBookByPublisher(String publisher) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublisher().equals(publisher) ) {
                result.add(book);
            }
            else if (book.getIsbn().equals(publisher)) {
            	result.add(book);
			}
        }
        result.sort(Comparator.comparing(Book::getIsbn).thenComparing(Book::getPublicationDate));
        return result;
    }

    private List<Publication> getAllPublications() {
        List<Publication> publications = new ArrayList<>();
        publications.addAll(books);
        publications.addAll(magazines);
        return publications;
    }

	public List<Magazine> getMagazines() {
		return magazines;
	}
}
