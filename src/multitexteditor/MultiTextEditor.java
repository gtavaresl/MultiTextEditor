/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Gabriell
 */
public class MultiTextEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<User> users = loadUsers();
        TelaLogin TL;
        TL = new TelaLogin(users);
        TL.setVisible(true);
    }
    
    public static ArrayList<User> loadUsers(){
        File file = new File( "Usuarios.txt");
        ArrayList<User> users  = new ArrayList<>();
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Usuarios.txt"))) {
                String linha1 = reader.readLine(); // lê a primeira linha
                String linha2 = reader.readLine();
                while (linha1 != null) {
                    User u;
                    u = new User(linha1,linha2);
                    users.add(u);
                    linha1 = reader.readLine(); // lê da terceira até a última linha
                    linha2 = reader.readLine();
                }
            }catch(IOException e){
                System.out.println(e);
            }
        }
        return users;
    }
    
    public static void updateUsers(ArrayList<User> users){
        try {
            File arquivo = new File("Usuarios.txt");
            FileWriter fw = new FileWriter(arquivo);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                for(int i = 0; i < users.size(); i++){
                    if(i > 0)
                        bw.newLine();
                    bw.write(users.get(i).getNome());
                    bw.newLine();
                    bw.write(users.get(i).getLastLogin());
                }
                bw.flush();
                bw.close();
                fw.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
               System.out.println(e);
        }
    }
}
