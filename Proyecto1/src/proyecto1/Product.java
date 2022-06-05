
package proyecto1;

/**
    * Esta clase representa los productos
    * @author abril
    */

public class Product {
    private String name;
    private int stock;
    
    /**
    * Constructor del Producto
    * @param name representa el nombre del producto
    * @param stock representa la cantidad de el producto disponible
    */
    public Product(String name, int stock){
        this.name = name;
        this.stock = stock;
    }
    
     /**
    * Obtener el atributo name del Producto
    * @return retorna el nombre del producto
    */
    public String getName() {
        return name;
    }

     /**
    * Metodo que permite modificar el atributo name del Producto
    * @param name Representa el nuevo nombre del poducto
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * Obtener el atributo stock del Producto
    * @return retorna la cantidad de producto disponible
    */
    public int getStock() {
        return stock;
    }
    
     /**
    * Metodo que permite modificar el atributo stock del Producto
    * @param stock representa la cantidad nueva del producto disponible
    */
    public void setStock(int stock) {
        this.stock = stock;
    }    
}
