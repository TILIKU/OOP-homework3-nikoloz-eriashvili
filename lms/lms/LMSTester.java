package lms;

public class LMSTester {
    public static void main(String[] args) {
        LMS iliauniLibrary = new LMS();
        LMS oldState = new LMS();
        oldState.loadState(new Book("satauri","autori"));// this works too so i think it should be enough if i dont display any info since it wasnt mentioned


        Book lor = new Book("Lord of the rings", "tolkien");
        Book oop = new Book("OOP", "paata gogisvhili");
        Book doug = new Book("how to cure deppresion", "DougDoug");
        Book osaka = new Book("osaka gaming", "nikoloz eriashvili");
        iliauniLibrary.addBook(lor);
        iliauniLibrary.addBook(oop);
        iliauniLibrary.addBook(doug);
        iliauniLibrary.addBook(osaka);
        //added a bit of books to test methods well and i wont take them out because no reason, i think we should be good

        Student gocha = new Student("Gocha", "Gegeshidze", "dfasdf");
        iliauniLibrary.borrowBook(lor, gocha);

        Student maka = new Student("Maka", "Lobjanidze", "3421325");
        iliauniLibrary.borrowBook(oop, maka);


        iliauniLibrary.saveState("libraryState.txt");

    }
}
