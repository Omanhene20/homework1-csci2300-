import java.util.ArrayList;

public class Driver {
    public static int testAdd() {
        Catalog catalog = new Catalog();
        int numErrors = 0;

        Book book = new Book("Introduction to Java", "Kate", "Holdener");
        String bookId = catalog.add(book);
        ArrayList<String> foundBooks = catalog.search("Kate");

        if (foundBooks.size() != 1) {
            System.out.println("Error: search method should have found one book");
            numErrors++;
        }
        return numErrors;
    }

    public static void main(String[] args) {
        int numErrors = 0;
        numErrors += testAdd();

        // Additional tests can be added here

        if (numErrors > 0) {
            System.out.println("Fix your errors");
        } else {
            System.out.println("No errors were found");
        }
    }
}
