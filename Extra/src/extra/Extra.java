
package extra;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import javax.swing.JOptionPane;

public class Extra {

    public static void main(String[] args) {
//        public static Grafo readTxt(){
//        List<Storage> storages = new List<Storage>();
//        String[] routes = new String[0];
//        String line;
//        String infoTxt = "";
//        String path = "test\\txt.txt";
//        File file = new File(path);
//        
//        try{
//            if(!file.exists()){
//                file.createNewFile();
//            }else{
//                FileReader fr = new FileReader(file);
//                BufferedReader br = new BufferedReader(fr);
//                while((line = br.readLine()) != null){
//                    if(!line.isEmpty()){
//                        infoTxt += line + "\n";
//                    }
//                }
//                if(!"".equals(infoTxt)){
//                    String[] infoSplit = infoTxt.split(";");
//                    if (infoSplit[0].equals("Almacenes")){
//                            for (int i=1; i < (infoSplit.length - 1); i++){
//                                if (!infoSplit[i].equals("\nRutas")){
//                                    Storage tempStorage = readStorage(infoSplit[i]);
//                                    storages.insertLast(tempStorage);
//                                }else{
//                                    routes = infoSplit[i + 1].split("\n");
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                
//                Grafo grafo = new Grafo(storages.getLength(), storages, routes);               
//                br.close();
//                JOptionPane.showMessageDialog(null,"Lectura Exitosa");
//                return grafo;
//                }              
//        }catch(Exception ex){
//             JOptionPane.showMessageDialog(null, ex);
//        }
//        
//        return null;
//   }
    }
    
}
