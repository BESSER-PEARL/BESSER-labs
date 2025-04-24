using System.Collections.Generic;
using System;

public class Library {
    public string Name { get; set; }
    public string Address { get; set; }
    public List<Book> Books { get; set; }

    public Library(string name, string address)
    {
        this.Name = name;
        this.Address = address;
        this.Books = new List<Book>();
    }

    public void AddBook(Book book)
    {
        if (!Books.Contains(book))
        {
            Books.Add(book);
            book.Library = this;
        }
    }

    public override string ToString()
    {
        return "Library{Name=" + Name + ", Address=" + Address + ", Books=" + Books.Count + "}";
    }
}
public class Book {
    public DateTime Release { get; set; }
    public string Title { get; set; }
    public int Pages { get; set; }
    public Library Library { get; set; }
    public List<Author> Authors { get; set; }

    public Book(DateTime release, string title, int pages)
    {
        this.Release = release;
        this.Title = title;
        this.Pages = pages;
        this.Library = null;
        this.Authors = new List<Author>();
    }

    public void AddAuthor(Author author)
    {
        if (!Authors.Contains(author))
        {
            Authors.Add(author);
            author.AddBook(this);
        }
    }

    public override string ToString()
    {
        return "Book{Release=" + Release + ", Title=" + Title + ", Pages=" + Pages + ", Library=" + (Library != null ? Library.Name : "None") +  ", Authors=" + Authors.Count + "}";
    }
}
public class Author {
    public string Email { get; set; }
    public string Name { get; set; }
    public List<Book> Books { get; set; }

    public Author(string email, string name)
    {
        this.Email = email;
        this.Name = name;
        this.Books = new List<Book>();
    }

    public void AddBook(Book book)
    {
        if (!Books.Contains(book))
        {
            Books.Add(book);
            book.AddAuthor(this);
        }
    }

    public override string ToString()
    {
        return "Author{Email=" + Email + ", Name=" + Name + ", Books=" + Books.Count + "}";
    }
}
