
package proyecto1;
    /**
    * Esta clase maneja lo relacionado al algotitmo Dijkstra, para poder enncontrar el camino mas corto entre los vertices
    * @author abril
    * @author  paola
    */
public class Dijkstra {
    /**
    * Algoritmo Dijkstra
    * Metodo que permite recorrer cada almacen y encontrar el camino mas corto del origen a los otros
    * @param matriz representa la matri de adyacencia
    * @param vOrigin representa el vertice (Almacen) de orige, del cual se parte
    * @return un int con las distacias de los almacenes al amacen requerido 
    */
    public static int[] dijkstra(int[][] matiz, int vOrigin) {
        int numVertices = matiz.length;
        boolean[] visited = Global.getGrafo().createListVisited();
        int[] distance = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
          distance[i] = Integer.MAX_VALUE;
        }
        distance[vOrigin] = 0;
        for (int i = 0; i < numVertices; i++) {
            int u = findShortestPath(distance, visited);
            visited[u] = true;
            for (int v = 0; v < numVertices; v++) {
              if (!visited[v] && matiz[u][v] != 0 && (distance[u] + matiz[u][v] < distance[v])) {
                distance[v] = distance[u] + matiz[u][v];
            }
          }
        }
        return distance;

    }

    /**
    * Camino mas corto
    * Metodo que encontrar el camino mas corto de a un vertice 
    * @param distance representa un array con las distancas desde un almacen a los demas
    * @param visited representa un array de Booleans que indican si un almacen ya fue visitado o no
    * @return retorna la distancia minia al vertice
    */
    private static int findShortestPath(int[] distance, boolean[] visited) {
    int minDistance = Integer.MAX_VALUE;
    int minDistanceVertice = -1;
    for (int i = 0; i < distance.length; i++) {
      if (!visited[i] && distance[i] < minDistance) {
        minDistance = distance[i];
        minDistanceVertice = i;
      }
    }
    return minDistanceVertice;
  }
}
