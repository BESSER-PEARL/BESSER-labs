using System.Collections.Generic;
using System;

public class Author {
    public string Name { get; set; }
    public string Email { get; set; }
    public List<Book> Books { get; set; }

    public Author(string name, string email)
    {
        this.Name = name;
        this.Email = email;
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
        return "Author{Name=" + Name + ", Email=" + Email + ", Books=" + Books.Count + "}";
    }
}
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
    public int Pages { get; set; }
    public string Title { get; set; }
    public DateTime Release { get; set; }
    public List<Author> Authors { get; set; }
    public Library Library { get; set; }

    public Book(int pages, string title, DateTime release)
    {
        this.Pages = pages;
        this.Title = title;
        this.Release = release;
        this.Authors = new List<Author>();
        this.Library = null;
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
        return "Book{Pages=" + Pages + ", Title=" + Title + ", Release=" + Release + ", Authors=" + Authors.Count +  ", Library=" + (Library != null ? Library.Name : "None") + "}";
    }
}
