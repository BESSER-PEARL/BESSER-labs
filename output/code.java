import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

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
    private LocalDateTime release; 
    private String title; 
    private int pages; 
    private Library library;
    private List<Author> authors;

    public Book(LocalDateTime release, String title, int pages){
        this.release = release;
        this.title = title;
        this.pages = pages;
        this.library = null; 
        this.authors = new ArrayList<>();
    }    

    public LocalDateTime getRelease() {
        return release;
    }
    public void setRelease(LocalDateTime release) {
        this.release = release;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
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
    public List<Author> getAuthors() {
        return authors;
    }
    
    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
            author.addBook(this);
        }
    }

    @Override
    public String toString() {
        return "Book{release=" + release + ", title=" + title + ", pages=" + pages + ", library=" + (library != null ? library.getName() : "None") +  ", authors=" + authors.size() + "}";
    }
}

public class Author {
    private String email; 
    private String name; 
    private List<Book> books;

    public Author(String email, String name){
        this.email = email;
        this.name = name;
        this.books = new ArrayList<>();
    }    

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
        return "Author{email=" + email + ", name=" + name + ", books=" + books.size() + "}";
    }
}

