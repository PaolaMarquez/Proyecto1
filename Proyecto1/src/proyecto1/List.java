
package proyecto1;

/**
    * Esta clase maneja todo lo relacionado al grafo, su creacion, el agregar rutas, vertices, y crear la matriz de adyacencia
    * @author abril
    * @author paola
    */
public class List <T>{
    private Nodo head;
    private int length;
    
    /**
    * Constructor de a lista
    */
    public List(){
        this.head = null;
        this.length = 0;
        
    }

    /**
    * Obtener el atributo head de la lista
    * @return retorna la cabeza de la lista
    */
    public Nodo getHead(){
        return head;
    }
    
    /**
    * Metodo que permite modificar el atributo head del grafo
    * @param head Representa el nodo que se le agregara en la cabeza de la lista
    */
    public void setHead(Nodo head){
        this.head = head;
    }
    
    /**
    * Obtener el atributo length de la lista
    * @return retorna la cantidad de elementos que tiene la lista
    */
    public int getLength(){
        return length;
    }
    
    /**
    * Lista vacia
    * Metodo que determinar si la cavbeza de la lista esta vacia
    * @return retorna Verdadero si la lista esta vacia
    */
    public boolean isEmpty(){
        return getHead() == null;
    }
    
     /**
    * Insertar Principio
    * Metodo que permite Incertar Al principio de una lista
    * @param data representa la informacion de que se le quiere agregar al nodo
    */
    public void insertFirst(T data){
        Nodo nodo = new Nodo(data);
        if (isEmpty()){
            setHead(nodo);
        } else {
            nodo.setNext(getHead());
            setHead(nodo);
        }
        length++;  
    }
    
     /**
    * Insertar Final
    * Metodo que permite Incertar Al final de una lista
    * @param data representa la informacion de que se le quiere agregar al nodo
    */
    public void insertLast(T data){
        Nodo nodo = new Nodo(data);
        if (isEmpty()){
            setHead(nodo);
        } else {
            Nodo pointer = getHead();
            while (pointer.getNext() != null){
                pointer = pointer.getNext();
            }
            pointer.setNext(nodo);
        } length ++;
    }
    
    /**
    * Insertar Indice
    * Metodo que permite Incertar en un nodo en un indice de la lista
    * @param data representa la informacion de que se le quiere agregar al nodo
    * @param position representa el indice en donde se desea agregar el nodo
    */

    public void insertIndex(int position, T data){
        Nodo nodo = new Nodo(data);
        if (isEmpty()){
            setHead(nodo);
        } else{
            Nodo pointer = getHead();
            int count = 0;
            while (count < (position -1) && pointer.getNext() != null){
                pointer = pointer.getNext();
                count++;
            }
        nodo.setNext(pointer.getNext());
        pointer.setNext(nodo);
        }length ++;
    }
    
    /**
    * Eliminar Inicio
    * Metodo que permite eliminar el primer nodo de la lista
    * @param data representa la informacion de que se le quiere agregar al nodo
    * @param position representa el indice en donde se desea agregar el nodo
    */

    public void deleteFirst(){
        if (!isEmpty()){
            Nodo pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            length --;
        } else {
            System.out.println("La lista está vacía.");
        }
    }
    
    /**
    * Eliminar final 
    * Metodo que permite Eliminar el elemento final de una lista
    * @param data representa la informacion de que se le quiere agregar al nodo
    * @param position representa el indice en donde se desea agregar el nodo
    */

    public void deleteLast(){
        if (!isEmpty()){
            Nodo pointer = getHead();
            while (pointer.getNext().getNext() != null){
               pointer = pointer.getNext();
            }
            pointer.setNext(null);
            length--;
        } else {
            System.out.println("La lista está vacía.");
        }
    }
    
    /**
    * Eliminar Indice 
    * Metodo que permite Eliminar un elemento de la lista, en una posicion determinada
    * @param position representa el indice en donde se desea eliminar el nodo
    */
    public void deleteIndex(int position){
        if (!isEmpty()){
            Nodo pointer = getHead();
            int count = 0;
            while (count < (position -1) && pointer.getNext() != null){
                pointer = pointer.getNext();
                count++;
            }
            Nodo aux = pointer.getNext();
            pointer.setNext(aux.getNext());
            aux.setNext(null);
            length--;
        }
    }
    
    /**
    * Obtener Elemento
    * Metodo que recorre la lista para obterner el elemnto de un nodo determinado
    * @param position representa el indice en donde se encuentra el nodo, del cual se queire obtener la informacion
    * @return retorna la informacion del nodo
    */
    public T getElement(int position){
        if (isEmpty()){
            return null;
        } else {
            Nodo pointer = getHead();
            int count = 0;
            while (count < position && pointer.getNext()!= null){
                pointer = pointer.getNext();
                count++;
            }
            if (count == position){
                return (T) pointer.getData();
            } else {
                return null;
            }
        }
    }
    
      /**
    * Obtener Indice
    * Metodo que permite obtener el indice de uno de los almacenes
    * @param data representa el nombre del almacen
    * @return retorna el indice del almacen
    */
    public int getIndex(T data){
        if(!isEmpty()){
            for(int i = 0;i < length; i++){
                if(getElement(i).equals(data)){
                    return i;
                }
            }
        }
        return -1;
    }
    
    /**
    * Imprimir lista
    * Metodo que permite Imprimir la lista
    */
    public void printList(){
        for(int i =0; i < length; i++){
            System.out.println(this.getElement(i));
        }
    }    
}
