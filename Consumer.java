import java.lang.String;

public class Consumer extends Thread {
    String name;
    Store enteredStore;

    public Consumer (String name) {
        this.name = name;
    }
    public void enterStore (Store store) {
        this.enteredStore = store;
        System.out.println(this.name.charAt(0) + ": Hello! I\'d like to buy your product!");
    }
    public void consume () {
        try {
            if (this.enteredStore.getProduct() == null) throw new EmptyStoreException();
            System.out.println(this.name.charAt(0) + ": Just consumed\t" + this.enteredStore.getProduct().publicName);
            this.enteredStore.setProduct(null);
        } catch (EmptyStoreException e) {
            System.out.println(this.enteredStore.getBrandName().charAt(0) + ": Oops, the store is empty...");
            System.out.println(this.name.charAt(0) + ": Never mind, I\'ll wait.");
        }
    }
    public void exitStore () {
        System.out.println(this.name.charAt(0) + ": Goodbye!");
        this.enteredStore = null;
    }
    public void run () {
        try {
            for (int i=1; i<=10; i++) {
                consume ();
                sleep(100);
            }
        } catch (InterruptedException e) {
            return;
        }
        exitStore();
    }
}