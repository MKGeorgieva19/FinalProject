package models;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private int categoryId;

    public Book() {
    }

    public Book(int bookId, String title, String autor, int year, int categoryId) {
        this.id = bookId;
        this.title = title;
        this.author = autor;
        this.year = year;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", categoryId=" + categoryId +
                '}';
    }
}
