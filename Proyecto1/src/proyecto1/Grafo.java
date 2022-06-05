    
package proyecto1;

import javax.swing.JOptionPane;
    /**
    * Esta clase maneja todo lo relacionado al grafo, su creacion, el agregar rutas, vertices, y crear la matriz de adyacencia
    * @author abril
    */
public class Grafo {
    private List<Storage> vertices;
    private int[][] matriz;
    private int nVertices;
    private int maxVertices;
    private String[] routes;
    private int numRoutes;
    
    
      
    /**
    * Constructor del grafo
    * @param max Represeta el numero de vertices maximo
    * @param storages Representa una lista de Almacenes 
    * @param routes Representa las rutas de los almacenes, traidas del txt
    */
    public Grafo(int max, List<Storage> storage, String[] routes){
        this.vertices =  storage;
        this.nVertices = storage.getLength();
        this.maxVertices = max;
        this.routes = routes;
        this.numRoutes = 0;
        this.matriz = new int[max][max];
        for (int i = 0; i< max; i++){
            for (int j = 0; j< max; j++){
                this.matriz[i][j] = 0;
            }
        }
    }

     /**
    * Obtener el atributo NumRoutes del grafo
    * @return retorna el numero de rutas 
    */
    public int getNumRoutes() {
        return numRoutes;
    }

     /**
    * Metodo que permite modificar el atributo setNumRoutes del grafo
    * @param numRoutes Representa el numero arcos (rutas) que hay en el grafo
    */
    public void setNumRoutes(int numRoutes) {
        this.numRoutes = numRoutes;
    } 
    
    /**
    * Obtener el atributo vertices del grafo
    * @return retorna Lista de ALmacenes
    */
    public List<Storage> getVertices() {
        return vertices;
    }
    
    /**
    * Obtener el atributo matriz del grafo
    * @return retorna la matriz de adyacencia
    */
    public int[][] getMatriz() {
        return matriz;
    }

    /**
    * Obtener el atributo nVertices del grafo
    * @return retorna el numero de vertices que hay en el grafo
    */
    public int getnVertices() {
        return nVertices;
    }
    
    /**
    * Obtener el atributo maxVertices del grafo
    * @return retorna el maximo de vertices que puede tener el grafo
    */
    public int getMaxVertices() {
        return maxVertices;
    }
       
    /**
    * Obtener el atributo routes del grafo
    * @return retorna las rutas del txt
    */
    public String[] getRoutes() {
        return routes;
    }
    
    /**
    * Metodo que permite modificar el atributo vertices del grafo
    * @param vertices Representa una lista de Almacenes
    */
    public void setVertices(List<Storage> vertices) {
        this.vertices = vertices;
    }
    
    /**
    * Metodo que permite modificar el atributo matriz del grafo
    * @param matriz Representa una lista de matriz de Adyacencia
    */
    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
    
    /**
    * Metodo que permite modificar el atributo nVertices del grafo
    * @param nVertices Representa el numero de vertices que hay en el grafo
    */
    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }
    
    /**
    * Metodo que permite modificar el atributo maxVertices del grafo
    * @param maxVertices Representa el numero max de vertices que contiene en el grafo
    */
    public void setMaxVertices(int maxVertices) {
        this.maxVertices = maxVertices;
    }
    
     /**
    * Metodo que permite modificar el atributo routes del grafo
    * @param routes Representa las rutas leidas del txt
    */
    public void setRoutes(String[] routes) {
        this.routes = routes;
    }
    
    
    /**
    *Anadir un Ruta 
    * Metodo que pertmite agregar las rutas entre cada almacen
    * @param r Represeta un string que contriene los vertices y el peso de la ruta que se quiere agregar
    */
    public void addRout(String r){
        String[] temp = r.split(",");
        int a = getIndex(temp[0].toUpperCase());
        int b = getIndex(temp[1].toUpperCase());
        if (a != -1 && b != -1){
            matriz[a][b] = Integer.valueOf(temp[temp.length - 1]);
            numRoutes++;
        }else{
            JOptionPane.showMessageDialog(null,"No fueron encontrados los almacenes");  
        }
    }
    
    /**
    * Lista de Nombres
    * Metodo que pertmite tener una lista con los nombres de cafa ALmacen
    * @return Retorna un Array con los nombres de los almacenes
    */
    public String[] nameStorage(){
        String[] names = new String[nVertices];
        for(int i = 0; i < (vertices.getLength()); i++){
            names[i] = vertices.getElement(i).getName();
        }
        return names;
    }
    
    /**
    *Leer un Ruta 
    * Metodo que pertmite Leer u agregar las rutas que viene del txt
    */
    public void readRoutes(){
        for(int i=1; i< routes.length; i++){
            addRout(routes[i]);           
        }
    }
    
    /**
    * Indice Almacen
    * Metodo que permite obtener el indice en el que se encuentra un almacen
    * @param word Represeta el nombre del Almacen del cual se desea obtener indice
    * @return retorna el index del almacen 
    */
    public int getIndex(String word){
        String[] name = nameStorage();
        for(int i = 0; i < name.length; i++){
            if(name[i].equals(word)){
                return i;
            }
        }
        return -1;
    }
    
    
    /**
    * Nombre Almacen
    * Metodo que permite obtener el Nombre de un almacen, Ubicado en una posicion en espicifico
    * @param index Represeta la posicion del almacen del cual se desa obtener el nombre
    * @return retorna el nombre del almacen 
    */
    public String getNameStorage(int index){
        for(int i = 0; i < vertices.getLength(); i++){
            if(index == i){
                return vertices.getElement(i).getName();
            }
        }
        return "";
    }
    
    /**
    * Imprimri Matriz
    * Metodo que permite Imprimir la matriz de adyacencia
    */
    public void printMatrix(){
        for (int i = 0; i < nVertices; i++){
            for (int j = 0; j < nVertices; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
    
    /**
    * Recorrido Anchura
    * Metodo que permite obtener el recorrido en anchura de un grafo
    * @param start Represeta el vertice orige, de donde se iniciara el recorrido
    * @return retorna el index del almacen
    */
    public List<Storage> bfs(int start){
        if(vertices.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay informacion almacenada");  
        }else if (start < vertices.getLength() && start > -1){
            List<Storage> listStorage = new List<>();
            Queue<Integer> queue = new Queue();
            boolean[] visited = createListVisited();
            queue.enqueue(start);
            visited[start] = true;
            
            int aux;
            while(!queue.isEmpty()){
                // retorna el elemnto del nodo que esta de primero, que es el indice del nodo
                aux = (int) queue.despachar(); //idice del nodo 
                listStorage.insertLast(vertices.getElement(aux));
                for(int i = 0; i < nVertices; i++){
                    if (matriz[aux][i] != 0 && (!visited[i])){
                        queue.enqueue(i);
                        visited[i] = true;
                    }
                }
            }
            return listStorage;
        }else{
           JOptionPane.showMessageDialog(null,"Error en el idex!"); 
        }
        return null;
    }
    
     /**
    * Almacenes Visitado
    * Metodo que permite obtener una lista de los almacenes visitado, iniciando todo en falso. Para luego ser usado en otra funciones 
    * @return retorna una array de boolens con todas las posiciones en false
    */
    public boolean[] createListVisited(){
        boolean[] visited = new boolean[nVertices];
        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        return visited;
    }
    
    
    /**
    * Recorrido Profundida
    * Metodo que permite obtener el recorrido en profundida de un grafo
    * @param start Represeta el vertice orige, de donde se iniciara el recorrido
    * @param visited Representa una lista con los almacenes que se han visitado en el grafo
    * @param ListStorages Una lista de Storages vacia
    * @return retorna una lista de Lista de Almacenes, despues de que se recorre el grafo
    */
    public List<Storage> dfs(int start, boolean[] visited, List<Storage> ListStorages){
        if(vertices.isEmpty()){
            JOptionPane.showMessageDialog(null,"No hay informacion almacenada"); 
        }else if (start < vertices.getLength() && start > -1){
        visited[start] = true;
        ListStorages.insertLast(vertices.getElement(start));
        for (int i = 0; i < matriz[start].length; i++) {
            if (matriz[start][i] != 0 && (!visited[i])) {
                dfs(i, visited, ListStorages);
                    }
            }
        return ListStorages;
        }else{
            JOptionPane.showMessageDialog(null,"Error en el idex!"); 
        }
        return null;
    }
    
    /**
    * Agregar uun Almacen
    * Metodo que permite agregar un Almacen y las rutas
    * @param sotrage Represeta el almacen a agregar
    * @param r1 Representa el primer arco del almacen
    * @param r2 Representa el segundo arco del almacen
    */
    public void addVertice(Storage storage, String r1, String r2){//Despues de hacer toda la verificacion es string o Antes
        int[][] matriztemp = new int[maxVertices + 1][maxVertices + 1];
        for (int i = 0; i< maxVertices; i++){
            for (int j = 0; j< maxVertices; j++){
                if(this.matriz[i][j] != 0){
                    matriztemp[i][j] = this.matriz[i][j];
                }else{
                    matriztemp[i][j] = 0;
                    
                }
            }
        }
        this.matriz = matriztemp;
        this.maxVertices++;
        this.nVertices++;
        vertices.insertLast(storage);
        addRout(r1);
        addRout(r2);
    }
}