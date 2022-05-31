
package proyecto1;

public class Storage {
    private String name;
    private List<Product> products;
    private static int id = 0;
    
    public Storage(String name, List<Product> products){
        this.name = name;
        this.products = products;
        this.id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
}
