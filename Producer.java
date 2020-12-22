import java.lang.String;

public class Producer extends Thread {
    String name;
    Store ProducersStore;

    public Producer (String name) {
        this.name = name;
        String brandName = this.name + "\'s Store";
        ProducersStore = new Store (brandName);
    }
    public void produce (int partNumber, String name) {
        Product product = new Product(partNumber, name);
        ProducersStore.setProduct(product);
        System.out.println(this.name.charAt(0) + ": Just produced\t" + product.publicName);
    }
    public void run () {
        try {
            for (int i=1; i<=15; i++) {
                produce(i, Integer.toString(i));
                sleep(100);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
