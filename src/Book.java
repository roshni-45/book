import java.util.ArrayList;
import java.util.Scanner;

// Book class representing a book in the library
class Book {
    private String title;
    private String author;
    private boolean isIssued;

    // Constructor to initialize a new book
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false; // Initially, the book is not issued
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book '" + title + "' has been issued.");
        } else {
            System.out.println("Sorry, the book '" + title + "' is already issued.");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book '" + title + "' has been returned.");
        } else {
            System.out.println("This book wasn't issued.");
        }
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isIssued ? "Issued" : "Available"));
        System.out.println();
    }
}

// Library class that manages books in the library
class Library {
    private ArrayList<Book> books;

    // Constructor to initialize the library with an empty list of books
    public Library() {
        books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' has been added to the library.");
    }

    // Search for a book by title
    public void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayBookDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book with title '" + title + "' not found in the library.");
        }
    }

    // Issue a book
    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.issueBook();
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found in the library.");
    }

    // Return a book
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found in the library.");
    }

    // Display all books in the library
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books available in the library:");
            for (Book book : books) {
                book.displayBookDetails();
            }
        }
    }
}

// Main class to run the library management system
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Adding some books to the library
        library.addBook(new Book("Java Programming", "John Doe"));
        library.addBook(new Book("Data Structures and Algorithms", "Jane Smith"));
        library.addBook(new Book("Database Systems", "Michael Johnson"));

        while (true) {
            // Menu for user
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. Search for a Book");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. View All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // Add a book
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter book author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    // Search for a book
                    System.out.print("Enter book title to search: ");
                    title = sc.nextLine();
                    library.searchBook(title);
                    break;

                case 3:
                    // Issue a book
                    System.out.print("Enter book title to issue: ");
                    title = sc.nextLine();
                    library.issueBook(title);
                    break;

                case 4:
                    // Return a book
                    System.out.print("Enter book title to return: ");
                    title = sc.nextLine();
                    library.returnBook(title);
                    break;

                case 5:
                    // View all books
                    library.displayAllBooks();
                    break;

                case 6:
                    // Exit the program
                    System.out.println("Exiting the Library Management System...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
