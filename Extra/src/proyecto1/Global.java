
package proyecto1;

public class Global {
   private static Grafo grafo;
   private static int path = 0;
   private static List<Storage> storages = new List<Storage>();
   private static String[] routes = new String[0];

    public static Grafo getGrafo() {
        return grafo;
    }

    public static void setGrafo(Grafo grafo) {
        Global.grafo = grafo;
    }
    
    public static int getPath() {
        return path;
    }

    public static void setPath(int path) {
        Global.path = path;
    }

    public static List<Storage> getStorages() {
        return storages;
    }

    public static void setStorages(List<Storage> storages) {
        Global.storages = storages;
    }

    public static String[] getRoutes() {
        return routes;
    }

    public static void setRoutes(String[] routes) {
        Global.routes = routes;
    }
    
}
