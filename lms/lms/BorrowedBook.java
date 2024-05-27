package lms;

import java.io.Serializable;

public class BorrowedBook implements Serializable {
    // we didnt have anything to implement the function of borrowing books, like, it was basically impossible so i had to add this
    private Book book;
    private Student student;

    public BorrowedBook(Book book, Student student) {
        this.book = book;
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }
}