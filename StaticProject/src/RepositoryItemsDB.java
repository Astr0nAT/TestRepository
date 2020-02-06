import java.util.List;

public class RepositoryItemsDB implements RepositoryItems {

    // implementiert eine Klasse ein Interface, so verpflichtet sie sich dazu, dass sie alle Methoden ausprogrammiert
    // WICHTIG: es können beliebig viele weitere Members (Felder, Methoden) vorhanden sein

    @Override
    public boolean Insert(Item item) {
        System.out.println("Artikel wurde in DB abgespeichert.");
        return false;
    }

    @Override
    public boolean Remove(int primaryKey) {
        System.out.println("Artikel wurde aus DB gelöscht.");
        return false;
    }

    @Override
    public boolean Update(int primaryKey, Item newItemData) {
        System.out.println("Artikel wurde in DB geändert.");
        return false;
    }

    @Override
    public List<Item> SearchByName(String name) {
        System.out.println("Artikelliste aus DB - NAME.");
        return null;
    }

    @Override
    public List<Item> SearchByCategory(String category) {
        System.out.println("Artikelliste aus DB - Kategorie.");
        return null;
    }

    @Override
    public Item SearchByPrimaryKey(int primaryKey) {
        System.out.println("Artikelliste aus DB - ID");
        return null;
    }
}
