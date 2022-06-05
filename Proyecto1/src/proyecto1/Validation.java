
package proyecto1;

import javax.swing.JOptionPane;

/**
 * Esta clase maneja todas las funcionalidades de validar datos
 * @author abril
 * @author paola
 */
public class Validation {

    /**
    * Verificacion de rutas
    * Metodo que permite verificar si las rutas que ingresa el usuario no tienen ningun problema
    * @param r Representa un string de las rutas con su peso agregado
    * @return retorna Verdadero si todos los datos son correctos
    */
    public static boolean route(String r){
        String[] route = r.split(",");
        if (route.length == 3){
            try{
                int i = Integer.parseInt(route[2]);
                return true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Información de rutas inválida"); 
            }
        }
        return false;
    }
    
      /**
    * Verificacion de rutas De un nuevo Almacen
    * Metodo que permite verificar si las rutas que ingresa el usuario cumplen con las condiciones para agregar un almacen
    * @param r Representa un string de las rutas con su peso agregado
    * @return retorna Verdadero si todos los datos son correctos
    */
    
    public static Boolean VerifyRoutes(String route,String name){
        String[] r = route.split(",");                
        if((r[0].toUpperCase().equals(name)) || (r[1].toUpperCase().equals(name))){
            int a = Global.getGrafo().getIndex(r[0].toUpperCase());
            int b = Global.getGrafo().getIndex(r[1].toUpperCase());
            if(a != -1 || b != -1){
                return true;
            }
        }   
        return false;
    } 
    
    /**
     * Verifica que el producto se encuentra en el almacén seleccionado
     * @param nameProduct es el string que contiene el nombre del producto que se va a verificar
     * @param index es el indice del almacen a evaluar
     * @return products que representa el producto que fue encontrado
     */
    public static Product products(int index, String nameProduct){
        List<Product> products = Global.getGrafo().getVertices().getElement(index).getProducts();
        for(int i = 0; i < products.getLength(); i++){
            if(products.getElement(i).getName().equals(nameProduct)){
               return products.getElement(i);
            }
        }
       return null;
   }
    
    /**
     * Verifica que el producto se encuentra en el almacén seleccionado y retorna el indice del producto en esa lista del almacen
     * @param nameProduct es el string que contiene el nombre del producto que se va a verificar
     * @param index es el indice del almacen a evaluar
     * @return indice del producto que fue encontrado
     */
    public static int indProduct(int indStorage, Product product){
        List<Product> products = Global.getGrafo().getVertices().getElement(indStorage).getProducts();
        for(int i = 0; i < products.getLength(); i++){
            if(products.getElement(i).getName().equals(product.getName())){
               return i;
            }
        }
       return -1;
   }
    
    /**
     * Verifica que el nombre del producto se encuentra en algún almacen y retorna el producto pero como objeto
     * @param nameProduct es el string que contiene el nombre del producto que se va a verificar
     * @return producto que fue encontrado
     */
    public static Product isInStorages(String nameProduct){
        Product temp = null;
        for (int i = 0; i < Global.getGrafo().getVertices().getLength(); i++) {
            temp = Validation.products(i, nameProduct);
            if (temp != null){
                return temp;
            }
        }
        return temp;
    }
}
