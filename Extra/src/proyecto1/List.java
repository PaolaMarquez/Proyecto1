
package proyecto1;

public class List <T>{
    private Nodo head;
    private int length;
    
    public List(){
        this.head = null;
        this.length = 0;
        
    }    
    public Nodo getHead(){
        return head;
    }
    
    public void setHead(Nodo head){
        this.head = head;
    }
    
    public int getLength(){
        return length;
    }
    
    public boolean isEmpty(){
        return getHead() == null;
    }
    
//    Insertar principio
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
    
//   Insertar al final
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
    
// Insertar en un índice
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
    
//    Eliminar al principio
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
    
//    Eliminar al final
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
    
//    Eliminar en posición
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
    
//    RETORNAR NODO Y EN EL MAIN SE OBTIENE EL ELEMENTO
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
}
