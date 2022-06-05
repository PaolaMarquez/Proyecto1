
package proyecto1;

import javax.swing.JOptionPane;

/**
 * Esta clase maneja todas las funcionalidades de registrar pedido (leer el input, buscar el producto, revisar stock)
 * @author paola
 */
public class Basket {
    List<Product> products;
    String input;
    
    /**
     * Constructor para la clase Basket, se crea una lista nueva que servirá como cesta para almacenar los productos del pedido
     */
    public Basket() {
        this.products = new List<Product>();
        this.input = "";
    }
    
    /**
     *  @return Lista de productos
     */
    public List<Product> getProducts() {
        return products;
    }
    
    /**
     *  @param products es la lista de productos, es decir, la cesta del carrito
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    /**
     *  @return String de input
     */
    public String getInput() {
        return input;
    }
    
    /**
     *  @param String de input
     */
    public void setInput(String input) {
        this.input = input;
    }
    
    /**
     * Toma los inputs del usuario y los separa para poder revisarlos en la función checkInput
     * @param input es el string del input tomado de la ventana de la interfaz gráfica que contiene la información del pedido
     */
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

    /**
     * Este método revisa que el input cumpla con las condiciones necesarias, y llama a diferentes funciones para poder registrar el pedido del usuario.
     * Por ejemplo si en el almacén seleccionado no hay cantidad suficiente, se llama la función para pedirlo de otro almacén
     * @param input es el string del input tomado de la ventana de la interfaz gráfica que contiene la información del pedido
     * @param name es el string del nombre del almacen desde donde se realizará la compra 
     * @return Lista de productos registrados en la compra
     */
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
                                    Storage ask = askOtherStorage(qty, aux.getName(), pos);                                           
                                    grafo.getVertices().getElement(pos).getProducts().getElement(auxIndex).setStock(0);
                                    int indAsk = grafo.getIndex(ask.getName());
                                    Product aux2 = grafo.getVertices().getElement(indAsk).getProducts().getElement(auxIndex);
                                    grafo.getVertices().getElement(indAsk).getProducts().getElement(auxIndex).setStock(aux2.getStock() - qty);
                                }
                            } else {
                                Storage ask = askOtherStorage(p.getStock(), p.getName(), pos);
                                int indexAsk = grafo.getIndex(ask.getName());
                                for (int j = 0; j < ask.getProducts().getLength(); j++) {
                                    if (ask.getProducts().getElement(j).getName().equals(p.getName())){
                                        Product temp2 = grafo.getVertices().getElement(indexAsk).getProducts().getElement(j);
                                        grafo.getVertices().getElement(indexAsk).getProducts().getElement(j).setStock(temp2.getStock()-p.getStock());
                                        Basket.newProduct(p.getName(), name, String.valueOf(0));
                                        break;
                                    }
                                }
                            }
                    }JOptionPane.showMessageDialog(null,"Felicidades! Tu pedido ha sido registrado.");
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
    
    /**
     * Genera una lista con los alamacenes que cumplen con los requerimientos del producto pedido
     * @param nameProduct es el string del nombre del producto que se está buscando
     * @param qty es la cantidad del producto que se necesita
     * @return Lista de almacenes que contienen la cantidad adecuada del producto seleccionado;
     */
    public List<Storage> possibleStorages(int qty, String nameProduct){
        List<Storage> list = new List<Storage>();
        for (int i = 0; i < Global.getGrafo().getVertices().getLength(); i++) {
            Product temp = Validation.products(i, nameProduct);
            if (temp != null && qty <= temp.getStock()){
                list.insertLast(Global.getGrafo().getVertices().getElement(i));
            }
        }
        return list;
    }
    
    /**
     * El método evalúa la menor ruta para llegar al almacén que tiene cantidad suficiente del producto
     * @param qty es la cantidad del producto que se necesita
     * @param nameProduct es el string del nombre del producto que se está buscando
     * @param pos indice del almacén desde donde se realizará la compra
     * @return Evalúa el camino más corto para llegar al siguiente almacen que contiene el producto
     */
    public Storage askOtherStorage(int qty, String nameProduct, int pos){
        List<Storage> possibleStorages = this.possibleStorages(qty, nameProduct);
        int [] distance = Dijkstra.dijkstra(Global.getGrafo().getMatriz(), pos);
        int count = Integer.MAX_VALUE;
        int indexStorage = 0;
        for (int i = 0; i < possibleStorages.getLength(); i++) {
            int aux = Global.getGrafo().getIndex(possibleStorages.getElement(i).getName());
            if(distance[aux] < count && distance[aux]!=0){
                count = distance[aux];
                indexStorage = aux;
            }
        }
        Storage s =  Global.getGrafo().getVertices().getElement(indexStorage);
        return s;
    }
    
    /**
     * El método crea un nuevo producto
     * @param productName es el string del nombre del producto
     * @param storage es el string del nombre del storage en donde se agregará el producto
     * @param stockProduct es el string de la cantidad del stock del producto
     */
    public static void newProduct(String productName, String storage, String stockProduct){
        try{
            storage = storage.toUpperCase();
            int stock = Integer.parseInt(stockProduct);
            int indexStorage = Global.getGrafo().getIndex(storage);
            if (indexStorage !=-1){
                for(int i = 0; i < Global.getGrafo().getVertices().getLength() ; i++){
                    if(i == indexStorage){
                        Product p = new Product(productName, stock);
                        Global.getGrafo().getVertices().getElement(i).getProducts().insertLast(p);
                        break;
                    }
                }
                JOptionPane.showMessageDialog(null,productName + " ha sido añadid@ al almacén exitosamente!");
            } else {
                JOptionPane.showMessageDialog(null,"Error, el almacén no existe");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error en los datos ingresados"); 
        }
    }
}
