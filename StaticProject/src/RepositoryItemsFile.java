import java.util.List;

public class RepositoryItemsFile implements RepositoryItems{

    @Override
    public boolean Insert(Item item) {
        System.out.println("Artikel hinzugefügt - FILE");
        return false;
    }

    @Override
    public boolean Remove(int primaryKey) {
        System.out.println("Artikel gelöscht - FILE");
        return false;
    }

    @Override
    public boolean Update(int primaryKey, Item newItemData) {
        System.out.println("Artikel geändert - FILE");
        return false;
    }

    @Override
    public List<Item> SearchByName(String name) {
        System.out.println("Artikelliste - Name - FILE");
        return null;
    }

    @Override
    public List<Item> SearchByCategory(String category) {
        System.out.println("Artikelliste - Kategorie - FILE");
        return null;
    }

    @Override
    public Item SearchByPrimaryKey(int primaryKey) {
        System.out.println("Artikel ID - FILE");
        return null;
    }
}
