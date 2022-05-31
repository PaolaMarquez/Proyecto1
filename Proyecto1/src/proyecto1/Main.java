
package proyecto1;

public class Main {

    public static void main(String[] args) {
      txt t = new txt();
        Grafo grafo = t.readTxt();
        grafo.readRoutes();
        grafo.printMatrix();
        txt.writeTxt(grafo);
    }
}
