import java.util.ArrayList;

public class Catalog {
    private ArrayList<CatalogItem> items;
    private int idCounter; // To generate unique IDs

    // No-argument constructor
    public Catalog() {
        items = new ArrayList<>();
        idCounter = 0;
    }

    public String add(Book book) {
        String id = String.valueOf(idCounter++);
        CatalogItem item = new CatalogItem(book, id, true);
        items.add(item);
        return id;
    }

    public boolean checkout(String id) {
        for (CatalogItem item : items) {
            if (item.getId().equals(id) && item.isAvailable()) {
                item.setUnavailable();
                return true;
            }
        }
        return false;
    }

    public boolean checkin(String id) {
        for (CatalogItem item : items) {
            if (item.getId().equals(id) && !item.isAvailable()) {
                item.setAvailable();
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> search(String searchTerm) {
        ArrayList<String> foundBooks = new ArrayList<>();
        for (CatalogItem item : items) {
            Book book = item.getBook();
            if (book.getTitle().equalsIgnoreCase(searchTerm) ||
                book.getAuthorFirstName().equalsIgnoreCase(searchTerm) ||
                book.getAuthorLastName().equalsIgnoreCase(searchTerm)) {
                foundBooks.add(item.getId());
            }
        }
        return foundBooks;
    }

    public Book getBook(String id) {
        for (CatalogItem item : items) {
            if (item.getId().equals(id)) {
                return item.getBook();
            }
        }
        return null;
    }

    public boolean remove(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id) && items.get(i).isAvailable()) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }
}
