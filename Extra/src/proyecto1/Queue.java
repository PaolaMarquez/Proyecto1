
package proyecto1;

public class Queue<T>{
    private Nodo head,end;
    private int length;
    
    public Queue(){
        this.head = null;
        this.end = null;
        this.length = 0;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public Nodo getEnd() {
        return end;
    }

    public void setEnd(Nodo end) {
        this.end = end;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public boolean isEmpty(){
        return getHead() == null;
    }
    
    //Insertar al final
    public void enqueue(T data){
        Nodo nodo = new Nodo(data);
        if(isEmpty()) {
            setHead(nodo);
            setEnd(nodo);
        } else {
            getEnd().setNext(nodo);
            setEnd(nodo);
        }
        length++;
    }
    
    public void dequeue(){
        if(!isEmpty()) {
            if (length == 1){
                setHead(null);
                setEnd(null);
            } else {
                Nodo temp = getHead();
                setHead(temp.getNext());
                temp.setNext(null);
            }
            length--;
        }
    }
    
    public T consult() { /////Noso porque lo tengo que castear
        return (T) getHead().getData();
    }
    
    public T despachar() {
        T temp = consult();
        dequeue();
        return temp;
    }
}
