
package proyecto1;

import javax.swing.JOptionPane;

public class Validation {
    
    //Verificar routes cuando se agregan
    public static boolean route(String r){
        String[] route = r.split(",");
        if (route.length == 3){
            try{
                int i = Integer.parseInt(route[2]);
                return true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Informacion de rutas invalida"); 
            }
        }
        return false;
    }
    
    //Verificar routes cuando se agrega un almacen
    public static Boolean VerifyRoutes(String route,String name){
        String[] r = route.split(",");                
        if((r[0].toUpperCase().equals(name)) || (r[1].toUpperCase().equals(name))){
            int a = Global.getGrafo().getIndex(r[0].toUpperCase());
            int b = Global.getGrafo().getIndex(r[1].toUpperCase());
            System.out.println(a + " --- " + b);
            if(a != -1 || b != -1){
                return true;
            }
        }   
        return false;
    } 
     
    public static Product products(int index, String nameProduct){
        List<Product> products = Global.getGrafo().getVertices().getElement(index).getProducts();
        for(int i = 0; i < products.getLength(); i++){
            if(products.getElement(i).getName().equals(nameProduct)){
               return products.getElement(i);
            }
        }
       
       return null;
   }
}
