package fa.training.main;
import java.util.*;
import fa.training.entities.*;
import fa.training.services.*;

import java.util.Date;
//import routines.TalendDate;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.HashSet;


public class App {
	private static Scanner scanner = new Scanner(System.in);
	private static Library library = new Library();

	public static void main(String[] args) {
		boolean quit = false;
		while (!quit) {
			System.out.println("Library Management System");
			System.out.println("1. Add a book");
			System.out.println("2. Add a magazine");
			System.out.println("3. Display publications by year and publisher");
			System.out.println("4. Add an author to a book");
			System.out.println("5. Display top magazines by volume");
			System.out.println("6. Search books by ISBN");
			System.out.println("7. Search books by author");
			System.out.println("8. Search books by publisher");
			System.out.println("9. Quit");

			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addBook();
				break;
			case 2:
				addMagazine();
				break;
			case 3:
				displayPublicationsByYearAndPublisher();
				break;
			case 4:
				addAuthorToBook();
				break;
			case 5:
				displayTopMagazinesByVolume();
				break;
			case 6:
				searchBookByIsbn();
				break;
			case 7:
				searchBookByAuthor();
				break;
			case 8:
				searchBookByPublisher();
				break;
			case 9:
				quit = true;
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	private static void addBook() {
		System.out.print("Enter publication year: ");
		int publicationYear = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter publisher: ");
		String publisher = scanner.nextLine();

		System.out.print("Enter publication date (dd-MM-yyyy): ");
		String publicationDateStr = scanner.nextLine();
		SimpleDateFormat formatter2=new SimpleDateFormat("dd-MM-yyyy");  
		Date publicationDate = null;
        try {
            publicationDate = formatter2.parse(publicationDateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in dd-MM-yyyy format.");
            return;
        }

		System.out.print("Enter ISBN: ");
		String isbn = scanner.nextLine();

		System.out.print("Enter author names (comma-separated): ");
		String authorNamesStr = scanner.nextLine();
		Set<String> authorNames = new HashSet<>(Arrays.asList(authorNamesStr.split(",")));

		System.out.print("Enter publication place: ");
		String publicationPlace = scanner.nextLine();

		Book book = new Book(publicationYear, publisher, publicationDate, isbn, authorNames, publicationPlace);
		library.addBook(book);
		System.out.println("Book added successfully.");
	}

	private static void addMagazine() {
		System.out.print("Enter publication year: ");
		int publicationYear = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter publisher: ");
		String publisher = scanner.nextLine();

		System.out.print("Enter publication date (dd-MM-yyyy): ");
		String publicationDateStr = scanner.nextLine();
		SimpleDateFormat formatter2=new SimpleDateFormat("dd-MM-yyyy"); 
		Date publicationDate = null;
        try {
            publicationDate = formatter2.parse(publicationDateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in dd-MM-yyyy format.");
            return;
        }

		System.out.print("Enter author name: ");
		String authorName = scanner.nextLine();

		System.out.print("Enter volume: ");
		int volume = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter edition: ");
		int edition = scanner.nextInt();
		scanner.nextLine();

		Magazine magazine = new Magazine(publicationYear, publisher, publicationDate, authorName, volume, edition);
		library.addMagazine(magazine);
		System.out.println("Magazine added successfully.");
	}

	private static void displayPublicationsByYearAndPublisher() {
		System.out.print("Enter publication year: ");
		int publicationYear = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Enter publisher: ");
		String publisher = scanner.nextLine();

		library.displayPublicationsByYearAndPublisher(publicationYear, publisher);
	}
    private static void addAuthorToBook() {
    	System.out.println("Enter the ISBN of the book:");
        String isbn = scanner.nextLine();
        System.out.println("Enter the author name:");
        String author = scanner.nextLine();
        library.addAuthorToBook(isbn, author);
    }

    private static void displayTopMagazinesByVolume() {
    	library.displayTopMagazinesByVolume();
//        List<Magazine> magazines = library.getMagazines();
//        Collections.sort(magazines, new Comparator<Magazine>() {
//            @Override
//            public int compare(Magazine m1, Magazine m2) {
//                return m2.getVolume() - m1.getVolume();
//            }
//        });
//
//        System.out.println("Top 10 magazines by volume:");
//        for (int i = 0; i < 10 && i < magazines.size(); i++) {
//            Magazine magazine = magazines.get(i);
//            System.out.println((i + 1) + ". " + magazine.getAuthor() + " - Volume " + magazine.getVolume());
//        }
    }
    private static void searchBookByIsbn() {
        System.out.println("Enter the ISBN:");
        String isbn = scanner.nextLine();
        Book book = library.searchBookByIsbn(isbn);
        if (book != null) {
            book.display();
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void searchBookByAuthor() {
        System.out.println("Enter the author name:");
        String author = scanner.nextLine();
        List<Book> books = library.searchBookByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Search results:");
            for (Book book : books) {
                book.display();
            }
        }
    }

    private static void searchBookByPublisher() {
        System.out.println("Enter the publisher:");
        String publisher = scanner.nextLine();
        List<Book> books = library.searchBookByPublisher(publisher);
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("Search results:");
            for (Book book : books) {
                book.display();
            }
        }
    }
}