/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        ArrayList<User> users = new ArrayList<>();
        loadUsers(users);
        TelaLogin TL;
        TL = new TelaLogin(users);
        TL.setVisible(true);
//        System.out.println(users.size());
        /*users.forEach((u) -> {
        System.out.println(u.toString());
        });*/
    }
    
    public static void loadUsers(ArrayList<User> users){
        File file = new File( "Usuarios.txt");
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
    }
}
