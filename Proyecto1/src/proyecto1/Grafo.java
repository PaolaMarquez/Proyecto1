
package proyecto1;

import javax.swing.JOptionPane;

    
public class Grafo {
    private List<Storage> vertices;
    private int[][] matriz;
    private int nVertices;
    private int maxVertices;
    private String[] routes;
    private int numRoutes;
    
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

    public int getNumRoutes() {
        return numRoutes;
    }

    public void setNumRoutes(int numRoutes) {
        this.numRoutes = numRoutes;
    } 
    
    public List<Storage> getVertices() {
        return vertices;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public int getnVertices() {
        return nVertices;
    }

    public int getMaxVertices() {
        return maxVertices;
    }
       

    public String[] getRoutes() {
        return routes;
    }

    public void setVertices(List<Storage> vertices) {
        this.vertices = vertices;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }

    public void setMaxVertices(int maxVertices) {
        this.maxVertices = maxVertices;
    }

    public void setRoutes(String[] routes) {
        this.routes = routes;
    }
    
    //Metodo para anadir un almacen
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
    
    //Metodo para obtener una lista on los nombres de los almacenes
    public String[] nameStorage(){
        String[] names = new String[nVertices];
        for(int i = 0; i < (vertices.getLength()); i++){
            names[i] = vertices.getElement(i).getName();
        }
        return names;
    }
    
    
    //Medtodo para leer las rutas del txt
    public void readRoutes(){
        for(int i=1; i< routes.length; i++){
            addRout(routes[i]);           
        }
    }

    //Metodo para obtener los indices de cada vertice
    public int getIndex(String word){
        String[] name = nameStorage();
        for(int i = 0; i < name.length; i++){
            if(name[i].equals(word)){
                return i;
            }
        }
        return -1;
    }
    
    //metodo para obtener el nombre del almacen
     public String getNameStorage(int index){
        for(int i = 0; i < vertices.getLength(); i++){
            if(index == i){
                return vertices.getElement(i).getName();
            }
        }
        return "";
    }
    
    //Imprimir matriz de adyacencia
    public void printMatrix(){
        for (int i = 0; i < nVertices; i++){
            for (int j = 0; j < nVertices; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
    
    //Recorido de Anchura
    public List<Storage> bfs(int start){ //Le paso la posicion del vertice
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
    
    //Crear una lista de Almacenes visitados, inicializada en false
    public boolean[] createListVisited(){
        boolean[] visited = new boolean[nVertices];
        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        return visited;
    }
    
    
    //recorrido Profundo
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
    
    
    //Metodo para anadir un Almacen nuevo
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