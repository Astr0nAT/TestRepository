import java.util.List;

public interface RepositoryItems {

    // in einem Interface gibt man alle Methoden an, welche von implementierenden Klassen ausprogrammiert werden müssen
    // WICHTIG: Interfaces geben einen Vertrag vor
    // es werden nur die Methodenköpfe angegeben, es exisitiert noch kein Code. Diesen müssen die implementierenden
    // Klassen bereitstellen
    public boolean Save();
    public boolean Insert(Item item);
    public boolean Remove(int primaryKey);
    public boolean Update(int primaryKey, Item newItemData);
    public List<Item> SearchByName(String name);
    public List<Item> SearchByCategory(String category);
    public Item SearchByPrimaryKey(int primaryKey);
}
