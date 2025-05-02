public class Book {
    private String title;
    private String authorFirstName;
    private String authorLastName;

    // Constructor
    public Book(String title, String firstName, String lastName) {
        this.title = title;
        this.authorFirstName = firstName;
        this.authorLastName = lastName;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    @Override
    public String toString() {
        return title + ", " + authorLastName + ", " + authorFirstName;
    }
}
