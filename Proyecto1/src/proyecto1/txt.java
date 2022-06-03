
package proyecto1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class txt {

    public static void writeTxt(Grafo grafo){
       List<Storage> info = grafo.getVertices();
       int[][] matriz = grafo.getMatriz();
       String storageTxt = "Almacenes;\n";
        if(!info.isEmpty()){
            for (int i = 0; i < info.getLength(); i++){
                storageTxt += "Almacen " +info.getElement(i).getName() + ":\n";
                for(int j = 0; j < info.getElement(i).getProducts().getLength(); j++){
                    if(j == (info.getElement(i).getProducts().getLength() -1)){
                         storageTxt += info.getElement(i).getProducts().getElement(j).getName() + "," + info.getElement(i).getProducts().getElement(j).getStock() + ";\n";
                    }else{
                        storageTxt += info.getElement(i).getProducts().getElement(j).getName() + "," + info.getElement(i).getProducts().getElement(j).getStock() + "\n";
                    }
                }
            }
            String routes = "Rutas;\n";
            for (int i = 0; i < info.getLength(); i++){
                for(int j = 0; j < info.getLength(); j++){
                    if(matriz[i][j] != 0){
                        String a = grafo.getNameStorage(i);
                        String b = grafo.getNameStorage(j);
                        if(!"".equals(a)&& !"".equals(b) ){
                            routes += a + "," + b + "," + matriz[i][j] + "\n";
                        }
                    }
                }
            }
            
            storageTxt += routes;
        }
        
        try{
            PrintWriter pw = new PrintWriter("test\\txt.txt");
            pw.print(storageTxt); // escribe
            pw.close();
             JOptionPane.showMessageDialog(null,"Guardador realizado Exitosamente");
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Error");
        }
        
    } 
    
    public static Grafo readTxt(){
        String line;
        String infoTxt = "";
        String path = "test\\txt.txt";
        File file = new File(path);
        
        try{
            if(!file.exists()){
                file.createNewFile();
            }else{
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((line = br.readLine()) != null){
                    if(!line.isEmpty()){
                        infoTxt += line + "\n";
                    }
                }
                br.close();
                JOptionPane.showMessageDialog(null,"Lectura Exitosa");
                Grafo grafo = txt.checkFile(infoTxt);
                return grafo;
                }              
        }catch(Exception ex){
             JOptionPane.showMessageDialog(null, ex);
        }
        
        return null;
   }
   
    public static Storage readStorage(String info){
        String[] data = info.split("\n");        
        String[] tempn = data[1].split(" ");
        String[] name = tempn[tempn.length - 1].split(":");
        Storage storage = new Storage(name[name.length - 1].toUpperCase(), readProducts(data));
        return storage;
    }
    
    public static List<Product> readProducts(String[] info){
        List<Product> products = new List<Product>(); 
        for (int i = 2; i < (info.length) ; i++){
            String[] tempProduct = info[i].split(",");
            Product p = new Product(tempProduct[0], Integer.valueOf(tempProduct[1]));
            products.insertLast(p);
        }
        
        return products;
    }
    
    public static Grafo checkFile(String infoTxt){
        List<Storage> storages = new List<Storage>();
        String[] routes = new String[0];
        Global.setRoutes(routes);
        Global.setStorages(storages);
        Grafo grafo = null;
        try {
            if(!"".equals(infoTxt)){
                String[] infoSplit = infoTxt.split(";");
                if (infoSplit[0].equals("Almacenes")){
                    for (int i=1; i < (infoSplit.length - 1); i++){
                        if (!infoSplit[i].equals("\nRutas")){
                            Storage tempStorage = readStorage(infoSplit[i]);
                            storages.insertLast(tempStorage);
                        }else{
                            routes = infoSplit[i + 1].split("\n");
                            break;
                        }
                    }
                    Global.setRoutes(routes);
                    Global.setStorages(storages);
                    grafo = new Grafo(storages.getLength(), storages, routes); 
                }
            }
            if (Global.getRoutes().length != 0 && !Global.getStorages().isEmpty()){
                JOptionPane.showMessageDialog(null,"El archivo cumple con la estructura necesaria!");
                return grafo;
            } else {
                JOptionPane.showMessageDialog(null, "\nEl archivo no cumple con la estructura necesaria, intenta otro archivo o usa el archivo default");
                return grafo;
            }
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex + "\nEl archivo no cumple con la estructura necesaria, intenta otro archivo o usa el archivo default");
        }
        return grafo;
    }
}
