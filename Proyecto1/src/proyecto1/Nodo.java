
package proyecto1;

/**
    * Esta clase los Nodos 
    * @author paola
    */

public class Nodo <T>{
    private T data;
    private Nodo next;
    
      
    /**
    * Constructor del Nodo
    * @param data representa la iformacion que se desea que el nodo Almacenes, ya sea un producto o Almacen, etc
    */
    public Nodo(T data){
        this.data = data;
        this.next = null;
    }
    /**
    * Obtener el atributo data del Nodo
    * @return retorna la informacion almacenada en el nodo
    */
    public T getData(){
        return data;         
    }
    
     /**
    * Metodo que permite modificar el atributo data del Nodo
    * @param data Representa la Informacion a la que se le queire cambiar al nodo
    */
    public void setData(T data){
        this.data = data;
    }
    
    /**
    * Obtener el atributo next del Nodo
    * @return retorna el siguiente Nodo
    */
    public Nodo getNext(){
        return next;
    }
    
    /**
    * Metodo que permite modificar el atributo next del Nodo
    * @param next Representa el nodo al que se le quiere apuntar
    */
    public void setNext(Nodo next){
        this.next = next;
    }
}
