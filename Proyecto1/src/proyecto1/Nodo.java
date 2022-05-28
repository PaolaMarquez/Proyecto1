
package proyecto1;

public class Nodo <T>{
    private T data;
    private Nodo next;
    
    public Nodo(T data){
        this.data = data;
        this.next = null;
    }
    
    public T getData(){
        return data;         
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public Nodo getNext(){
        return next;
    }
    
    public void setNext(Nodo next){
        this.next = next;
    }
}
