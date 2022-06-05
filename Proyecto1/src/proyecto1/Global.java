
package proyecto1;

/**
 * Esta clase maneja algunos atributos que son necesarios acceder múltiples veces a lo largo del proyecto
 * @author paola
 */
public class Global {
    private static Grafo grafo;
    private static int path = 0;
    private static List<Storage> storages = new List<Storage>();
    private static String[] routes = new String[0];
    
    /**
     *  @return Grafo
     */
    public static Grafo getGrafo() {
        return grafo;
    }
    
    /**
     *  @param grafo
     */
    public static void setGrafo(Grafo grafo) {
        Global.grafo = grafo;
    }
    
    /**
     *  @return path que representa que información se desplegará en la ventana 2
     */
    public static int getPath() {
        return path;
    }
    
    /**
     *  @param path
     */
    public static void setPath(int path) {
        Global.path = path;
    }
    
    /**
     *  @return storages que es la lista de almacenes en el grafo
     */
    public static List<Storage> getStorages() {
        return storages;
    }
    
    /**
     *  @return storages que es la lista de almacenes en el grafo
     */
    public static void setStorages(List<Storage> storages) {
        Global.storages = storages;
    }

    /**
     *  @return routes que es el array de las rutas del grafo
     */
    public static String[] getRoutes() {
        return routes;
    }

    /**
     *  @return routes que es el array de las rutas del grafo
     */
    public static void setRoutes(String[] routes) {
        Global.routes = routes;
    }
    
}
