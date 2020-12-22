import java.lang.String;

public class Product {
    private int partNumber;
    private String name;
    public String publicName;

    public Product (int partNumber, String name) {
        this.partNumber = partNumber;
        this.name = name;
        this.publicName = "#" + partNumber + "\t" + name + "!";
    }
    public int getPartNumber () {
        return this.partNumber;
    }
    public String getName () {
        return this.name;
    }
}
