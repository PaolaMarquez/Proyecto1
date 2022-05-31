
package proyecto1;

import javax.swing.JOptionPane;

    
public class Grafo {
    private List<Storage> vertices;
    private int[][] matriz;
    private int nVertices;
    private int maxVertices;
    private String[] routes;
    
    public Grafo(int max, List<Storage> storage, String[] routes){
        this.vertices =  storage;
        this.nVertices = storage.getLength();
        this.maxVertices = max;
        this.routes = routes;
        this.matriz = new int[max][max];
        for (int i = 0; i< max; i++){
            for (int j = 0; j< max; j++){
                this.matriz[i][j] = 0;
            }
        }
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
    
    public void addRout(String r){
        String[] names = new String[nVertices];  /// revisar si es con max o con num
        for(int i = 0; i < (vertices.getLength()); i++){
            names[i] = vertices.getElement(i).getName();
        }
        String[] temp = r.split(",");
        int a = getIndex(names,temp[0]);
        int b = getIndex(names,temp[1]);
        if (a != -1 && b != -1){
            matriz[a][b] = Integer.valueOf(temp[temp.length - 1]);
        }
    }
    
    
    public void readRoutes(){
        for(int i=1; i< routes.length; i++){
            addRout(routes[i]);           
        }
    }

    public int getIndex(String[] name, String word){
        for(int i = 0; i < name.length; i++){
            if(name[i].equals(word)){
                return i;
            }
        }
        return -1;
    }

    public void printMatrix(){
        for (int i = 0; i < nVertices; i++){
            for (int j = 0; j < nVertices; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }
    
    //Recorido de Anchura
    public void bfs(int start){ //Le paso la posicion del vertice
        System.out.println(start < vertices.getLength() && start > -1);
        if (start < vertices.getLength() && start > -1){
            Queue<Integer> queue = new Queue();
            boolean[] visited = createListVisited();
            queue.enqueue(start);
            visited[start] = true;
            
            int aux;
            while(!queue.isEmpty()){
                // retorna el elemnto del nodo que esta de primero, que es el indice del nodo
                aux = (int) queue.despachar(); //idice del nodo 
                System.out.println(vertices.getElement(aux).getName());
                for(int i = 0; i < nVertices; i++){
                    if (matriz[aux][i] != 0 && (!visited[i])){
                        queue.enqueue(i);
                        visited[i] = true;
                    }
            }
        }
        }else{
           JOptionPane.showMessageDialog(null,"Error en el idex!"); 
        }
    }
    
    public boolean[] createListVisited(){
        boolean[] visited = new boolean[nVertices];
        for (int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        return visited;
    }
    
    public void dfs(int start, boolean[] visited){
        if (start < vertices.getLength() && start > -1){
        visited[start] = true;
        System.out.println(vertices.getElement(start).getName());
        for (int i = 0; i < matriz[start].length; i++) {
            if (matriz[start][i] != 0 && (!visited[i])) {
                dfs(i, visited);
                    }
                }
        }else{
            JOptionPane.showMessageDialog(null,"Error en el idex!"); 
        }
    }
}