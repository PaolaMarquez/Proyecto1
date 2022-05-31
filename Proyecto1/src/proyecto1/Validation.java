
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
        String[] storageName = new String[Global.getGrafo().getMaxVertices()];  /// revisar si es con max o con num
        for(int i = 0; i < (Global.getGrafo().getMaxVertices()); i++){
            storageName[i] = Global.getGrafo().getVertices().getElement(i).getName();
        }
        
        if(r[0].toUpperCase().equals(name)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        
        System.out.println("=====");
          if(r[1].toUpperCase().equals(name)){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
        
        if((r[0].toUpperCase().equals(name)) || (r[1].toUpperCase().equals(name))){
            System.out.println("Entre a la funcion");
            int a = Global.getGrafo().getIndex(storageName,r[0].toUpperCase());
            int b = Global.getGrafo().getIndex(storageName,r[1].toUpperCase());
            System.out.println(a + " --- " + b);
            if(a != -1 || b != -1){
                return true;
            }
        }
        System.out.println("Sali y no funciono");    
        return false;
    } 
     
}
