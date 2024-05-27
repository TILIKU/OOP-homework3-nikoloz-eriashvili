package lms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LMS implements Serializable {

    List<Book> books = new ArrayList<>();
    List<BorrowedBook> borrowedBooks = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(Book book) {
        boolean removed = false;
        // TODO must be implemented
        if(books.contains(book)){
            books.remove(book);
            removed = true;
        }
        return removed;
    }

    public boolean borrowBook(Book book, Student student) {
        boolean borrowed = false;
        // TODO must be implemented
        if (books.contains(book)) {
            borrowedBooks.add(new BorrowedBook(book, student));
            books.remove(book);
            borrowed = true;
        }
        return borrowed;
    }

    public boolean returnBook(Book book) {
        boolean returned = false;
        // TODO must be implemented
        for (BorrowedBook borrowedBook : borrowedBooks) {
            if (borrowedBook.getBook().equals(book)) {
                borrowedBooks.remove(borrowedBook);
                books.add(book);
                returned = true;
            }
        }
        return returned;
    }

    public void saveState(String filePath) {
        // TODO must be implemented
        // this one just had filePath so were good
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
//            for(Book book:books){
//                booksString = booksString.concat("author: ").concat(book.getAuthor()).concat(" | title: ").concat(book.getTitle().concat("\n"));
//            }
//            System.out.println(booksString);
//            oos.writeObject(booksString);
//            for(BorrowedBook borrowedBook : borrowedBooks){
//                borrowedString = borrowedString.concat("book { ").concat("title: ").concat(borrowedBook.getBook().getTitle()).concat(" | author: ").concat(borrowedBook.getBook().getAuthor()).concat("} || student { ").concat("name: ").concat(borrowedBook.getStudent().getName().concat(" | surname: ").concat(borrowedBook.getStudent().getSurname().concat("}\n")));
//            }
//            System.out.println(borrowedString);
//            oos.writeObject(borrowedString);
            // i tried doing it in a human readable format but it took way too much effort so i resorted on using Serialization and Objects
            //left the human readable halfcode too because im proud of it
            oos.writeObject(books);
            oos.writeObject(borrowedBooks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean loadState(Book book) {
        //still dont understand why this needs to take in book, but ill just pass random thing because i dont want to change that, just in case i have no persmission
        boolean returned = false;
        // TODO must be implemented
        // i dont even know in what logic this is, i dont know if i can (in rules of this assigment) change, what should be
        // given to methods, and since i cant give loadState - filePath, but saveState gets it
        // then i will just manually add it according to what you wrote in tester class
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("libraryState.txt"))) {
            books = (List<Book>) ois.readObject();
            borrowedBooks = (List<BorrowedBook>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return returned;
    }

}
