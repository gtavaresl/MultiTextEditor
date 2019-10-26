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
        System.out.println(users.size());
        /*users.forEach((u) -> {
        System.out.println(u.toString());
        });*/
    }
    
    public static void loadUsers(ArrayList<User> users){
//        System.out.printf("\nConteúdo do arquivo texto:\n");
        File file = new File( "Usuarios.txt");
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader("Usuarios.txt"))) {
                String linha = reader.readLine(); // lê a primeira linha
                while (linha != null) {
//                    System.out.printf("%s\n", linha);
                    User u;
                    u = new User(linha,"1");
                    users.add(u);
                    linha = reader.readLine(); // lê da segunda até a última linha
                }
            }catch(IOException e){
                System.out.println(e);
            }
        }
        System.out.println();
    }
}
