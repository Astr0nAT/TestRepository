import java.util.List;

public class RepositoryItemDB implements RepositoryItems {

    // implementiert eine Klasse ein Interface, so verpflichtet sie sich dazu, dass sie alle Methoden ausprogrammiert
    // WICHTIG: es können beliebig viele weitere Members (Felder, Methoden) vorhanden sein

    @Override
    public boolean Save() {
        return false;
    }

    @Override
    public boolean Insert(Item item) {
        return false;
    }

    @Override
    public boolean Remove(int primaryKey) {
        return false;
    }

    @Override
    public boolean Update(int primaryKey, Item newItemData) {
        return false;
    }

    @Override
    public List<Item> SearchByName(String name) {
        return null;
    }

    @Override
    public List<Item> SearchByCategory(String category) {
        return null;
    }

    @Override
    public Item SearchByPrimaryKey(int primaryKey) {
        return null;
    }
}
