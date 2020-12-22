public class Store {
    private String brandName;
    private Product product;
    public Store (String brandName) {
        this.brandName = brandName;
    }
    public String getBrandName () {
        return this.brandName;
    }
    public Product getProduct () {
        return this.product;
    }
    public void setProduct (Product product) {
        this.product = product;
    }
}
