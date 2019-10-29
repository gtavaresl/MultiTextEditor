/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Gabriell
 */
public class Server {
    
    private boolean status;
    private final ArrayList<User> clients;
    public JList jListClients;
    
    public Server(JList jListClients) {
        this.status = false;
        this.clients = new ArrayList<>();
        this.jListClients = jListClients;
    }

    public boolean getStatus() {
        return this.status;
    }
    
    public String getStatusText() {
        return this.status ? "ON" : "OFF" ;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void changeStatus() {
        this.status = !status;
    }
    
    public String addClient(User client){
        this.clients.add(client);
//        this.listClients();
        this.updateJList();
        return this.updateUsers(client);
    }
    
    public void listClients(){
        this.clients.forEach((c) -> {
            System.out.println(c.getNome());
        });
    }
    
    public void disconnectClient(User client){
        this.clients.remove(client);
//        this.listClients();
        this.updateJList();
    }
    
    public void updateJList(){
        DefaultListModel<String> model = (DefaultListModel<String>) jListClients.getModel();
        model.removeAllElements();
        this.clients.forEach((c) -> {
            model.addElement(c.getNome());
        });
    }
    
    public String updateUsers(User client) {
        File file = new File("Usuarios.txt");
        String LL = null;
        StringBuilder inputBuffer = new StringBuilder();
        if (file.exists()) { // arquivo ja existe, preciso ler e atualizar o ultimo login
            try (BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"))) {
                String line1;
                String line2;
                int i = -1;
                while ((line1 = br.readLine()) != null) {
                    i++;
                    inputBuffer.append(line1);
                    inputBuffer.append('\n');
                    line2 = br.readLine();
                    if(line1.equals(client.getNome())){
                        LL = line2;
                        line2 = client.getLastLogin();
                        client.setIndex(i);
                    }
                    inputBuffer.append(line2);
                    inputBuffer.append('\n');
                }
                if(client.getIndex() ==  -1){ // preciso adcionar o novo
                    client.setIndex(i+1);
                    inputBuffer.append(client.getNome());
                    inputBuffer.append('\n');
                    inputBuffer.append(client.getLastLogin());
                    inputBuffer.append('\n');
                }
                br.close();
            } catch(IOException e) {
                System.out.println(e);
            }
        } else {
            client.setIndex(0);
            inputBuffer.append(client.getNome());
            inputBuffer.append('\n');
            inputBuffer.append(client.getLastLogin());
            inputBuffer.append('\n');
        }
        
        String inputStr = inputBuffer.toString();
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("Usuarios.txt");
            fileOut.write(inputStr.getBytes());
            fileOut.close();
        } catch (IOException e) {
            System.err.println(e);
        }
        return LL;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
