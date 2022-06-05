
package proyecto1;

public class Dijkstra {
    
    public static int[] dijkstra(int[][] matiz, int vOrigin) {
        int numVertices = matiz.length;
        boolean[] visited = Global.getGrafo().createListVisited();
        int[] distance = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
          distance[i] = Integer.MAX_VALUE;
        }

    // Distance of self loop is zero
        distance[vOrigin] = 0;
        for (int i = 0; i < numVertices; i++) {

          // Update the distance between neighbouring vertex and source vertex
          int u = findShortestPath(distance, visited);
          visited[u] = true;

          // Update all the neighbouring vertex distances
          for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && matiz[u][v] != 0 && (distance[u] + matiz[u][v] < distance[v])) {
              distance[v] = distance[u] + matiz[u][v];
            }
          }
        }
        return distance;

    }

  // Finding the minimum distance
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
