
package proyecto1;

    /**
    * Esta clase representa los Almacenes
    * @author paola
    */
public class Storage {
    private String name;
    private List<Product> products;
    
    /**
    * Constructor del Almacen
    * @param name representa el nombre del Almacen
    * @param products representa una de los productos, con los que cuenta el almacen
    */
    public Storage(String name, List<Product> products){
        this.name = name;
        this.products = products;
    }

    /**
    * Obtener el atributo name del Almacen
    * @return retorna el nombre del almacen
    */
    public String getName() {
        return name;
    }

    
     /**
    * Metodo que permite modificar el atributo name del Almacen
    * @param name Representa el nuevo nombre del almacen
    */
    public void setName(String name) {
        this.name = name;
    }

     /**
    * Obtener el atributo products del Almacen
    * @return retorna la lista del productos del almacen
    */
    public List<Product> getProducts() {
        return products;
    }
    
     /**
    * Metodo que permite modificar el atributo products del Producto
    * @param products representa una nueva lsita de productos
    */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    
}
