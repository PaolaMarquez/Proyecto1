
package proyecto1;

import javax.swing.JOptionPane;

public class Basket {
    List<Product> products;
    String input;

    public Basket() {
        this.products = new List<Product>();
        this.input = "";
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
    
    public void readInput(String input){
        try{
            String[] info = input.split(";");
            for (int i =0; i < (info.length) ; i++){
                String[] tempProduct = info[i].split(",");
                if (tempProduct.length == 2){
//                    Esto verifica que sea String y numero?
                    Product p = new Product(tempProduct[0], Integer.valueOf(tempProduct[1]));
                    this.products.insertLast(p);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al ingresar los datos");
                    break;
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos");
        }
    }   
    
    
    public List<Product> checkInput(String input, String name){
        try{
            Grafo grafo = Global.getGrafo();
            if (grafo != null){
                int pos = grafo.getIndex(name);
                if (pos != -1){
                    readInput(input);
                    for (int i = 0; i < this.getProducts().getLength(); i++) {
//                      temp es del stock y p es el pedido
                        Product p = this.getProducts().getElement(i);
                        Product temp = Validation.isInStorages(p.getName()); 
                        if (temp == null){
                            JOptionPane.showMessageDialog(null, "Error, no existe en ningún almacén el producto: "+ p.getName());
                            break;
                        }else {
//                            aux es para evaluar en el almacen seleccionado
                            Product aux = Validation.products(pos, p.getName());
                            if (aux != null){
                                if (p.getStock() <= aux.getStock()){
                                    int auxIndex = Validation.indProduct(pos, aux);
                                    grafo.getVertices().getElement(pos).getProducts().getElement(auxIndex).setStock(aux.getStock() - p.getStock());
                                }else if (p.getStock() > aux.getStock()){
                                    int auxIndex = Validation.indProduct(pos, aux);
                                    int qty = p.getStock() - aux.getStock();
                                    Storage ask = askOtherStorage(qty, aux.getName());
                                    grafo.getVertices().getElement(pos).getProducts().getElement(auxIndex).setStock(0);
                                    int indAsk = grafo.getIndex(ask.getName());
                                    Product aux2 = grafo.getVertices().getElement(indAsk).getProducts().getElement(auxIndex);
                                    grafo.getVertices().getElement(indAsk).getProducts().getElement(auxIndex).setStock(aux2.getStock() - qty);
                                }
                            } else {
                                askOtherStorage(p.getStock(), aux.getName());
                            }
                    }

                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error, el almacén no existe");
            }
            } 
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error!");
        }
        return null;
    }
          
    public List<Storage> possibleStorages(int qty, String nameProduct){
        List<Storage> list = new List<Storage>();
        for (int i = 0; i < Global.getGrafo().getVertices().getLength(); i++) {
            Product temp = Validation.products(i, nameProduct);
            if (temp != null && qty <= temp.getStock()){
                list.insertLast(Global.getGrafo().getVertices().getElement(temp.getStock()));
            }
        }
        return list;
    }
    
    public Storage askOtherStorage(int qty, String nameProduct){
        List<Storage> possibleStorages = this.possibleStorages(qty, nameProduct);
//        Storage storage = abril();
        return null;
    }
}
