import java.util.List;

public class DB_App {

    static RepositoryItems dbItems = new RepositoryItemsFile();

    public static void main(String[] args) {
        dbItems.Insert(new Item());
        dbItems.SearchByCategory("Laptop");

        // beliebig viele Methoden im HP verwenden

    }

    // WICHTIG: Interface als Instanzentypm verwenden
    // hinter new wird die benötigte Klasse verwendet

}
