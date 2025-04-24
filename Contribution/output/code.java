import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Author {
    private String name; 
    private String email; 
    private List<Book> books;

    public Author(String name, String email){
        this.name = name;
        this.email = email;
        this.books = new ArrayList<>();
    }    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Book> getBooks() {
        return books;
    }
    
    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
            book.addAuthor(this);
        }
    }

    @Override
    public String toString() {
        return "Author{name=" + name + ", email=" + email + ", books=" + books.size() + "}";
    }
}

public class Library {
    private String name; 
    private String address; 
    private List<Book> books;

    public Library(String name, String address){
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
    }    

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
            book.setLibrary(this);
        }
    }

    @Override
    public String toString() {
        return "Library{name=" + name + ", address=" + address + ", books=" + books.size() + "}";
    }
}

public class Book {
    private int pages; 
    private String title; 
    private LocalDateTime release; 
    private List<Author> authors;
    private Library library;

    public Book(int pages, String title, LocalDateTime release){
        this.pages = pages;
        this.title = title;
        this.release = release;
        this.authors = new ArrayList<>();
        this.library = null; 
    }    

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getRelease() {
        return release;
    }
    public void setRelease(LocalDateTime release) {
        this.release = release;
    }
    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
            author.addBook(this);
        }
    }
    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        if (this.library != library) {
            this.library = library;
            library.addBook(this);
        }
    }

    @Override
    public String toString() {
        return "Book{pages=" + pages + ", title=" + title + ", release=" + release + ", authors=" + authors.size() +  ", library=" + (library != null ? library.getName() : "None") + "}";
    }
}

