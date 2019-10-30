/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.awt.Frame;
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
    
    /** Atributo que representa o JList com os nomes dos clientes */
    public JList jListClients;
    
    /** Método construtor da classe Server
     * @param jListClients */
    public Server(JList jListClients) {
        this.status = false;
        this.clients = new ArrayList<>();
        this.jListClients = jListClients;
    }

    /** Getter do atributo status
     * @return  */
    public boolean getStatus() {
        return this.status;
    }
    
    /** Getter do texto associado ao atributo status
     * @return  */
    public String getStatusText() {
        return this.status ? "ON" : "OFF" ;
    }

    /** Setter do atributo status
     * @param status */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /** Método que altera o valor do atributo status */
    public void changeStatus() {
        this.status = !status;
    }
    
    /** Método que adiciona um novo cliente
     * @param client
     * @return  */
    public String addClient(User client){
        this.clients.add(client);
        //this.listClients();
        this.updateJList();
        return this.updateUsers(client);
    }
    
    /** Método que lista todos os clientes */
    public void listClients(){
        this.clients.forEach((c) -> {
            System.out.println(c.getNome());
        });
    }
    
    /** Método que inicia a thread
     * @param t */
    public void startThread(Thread t){
        t.start();
    }
    
    /** Método que para a thread
     * @param t */
    public void stopThread(Thread t){
        t.interrupt();
    }
    
    /** Método que desconecta apenas um cliente
     * @param client */
    public void disconnectClient(User client){
        this.clients.remove(client); //remove cliente
        this.updateJList(); //atualiza lista
        Frame[] frames = Frame.getFrames(); //vetor com todos os frames abertos
        for (Frame frame : frames) {
            if (frame.getName().contains("-"+client.getNome()) == true && frame.getName().equals("frameServidor") == false) {
                frame.dispose(); //fecha o frame
            }
        }
    }
    
    /** Método que desconecta todos os clientes */
    public void disconnectAll(){
        this.clients.removeAll(clients); //remove todos os clientes
        this.updateJList(); //atualiza lista
        Frame[] frames = Frame.getFrames();
        for (Frame frame : frames) {
            if (frame.getName().equals("frameServidor") || frame.getName().equals("frameListUsers")) {
                continue;
            }
            frame.dispose(); //fecha o frame
        }
    }
    
    /** Método que atualiza a lista de clientes */
    public void updateJList(){
        DefaultListModel<String> model = (DefaultListModel<String>) jListClients.getModel();
        model.removeAllElements();
        this.clients.forEach((c) -> {
            model.addElement(c.getNome());
        });
    }
    
    /** Método que atualiza os clientes
     * @param client
     * @return  */
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
                    inputBuffer.append(line1); //linha com nomes é concatenada na string
                    inputBuffer.append('\n'); //quebra de linha é concatenada na string
                    line2 = br.readLine(); //linha com ultimo login
                    if(line1.equals(client.getNome())){
                        LL = line2;
                        line2 = client.getLastLogin();
                        client.setIndex(i);
                    }
                    inputBuffer.append(line2); //linha com ultimo login é concatenada na string
                    inputBuffer.append('\n'); //quebra de linha é concatenada na string
                }
                if(client.getIndex() ==  -1){ // preciso adcionar o novo
                    client.setIndex(i+1);
                    inputBuffer.append(client.getNome()); //novo nome é concatenado na string
                    inputBuffer.append('\n'); //quebra de linha é concatenada na string
                    inputBuffer.append(client.getLastLogin()); //novo ultimo login é concatenado na string
                    inputBuffer.append('\n'); //quebra de linha é concatenada na string
                }
                br.close();
            } catch(IOException e) {
                System.out.println(e);
            }
        } else {
            client.setIndex(0); //adiciona novo cliente
            inputBuffer.append(client.getNome()); //novo nome é concatenado na string
            inputBuffer.append('\n'); //quebra de linha é concatenada na string
            inputBuffer.append(client.getLastLogin()); //novo ultimo login é concatenado na string
            inputBuffer.append('\n'); //quebra de linha é concatenada na string
        }
        
        String inputStr = inputBuffer.toString();
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("Usuarios.txt");
            fileOut.write(inputStr.getBytes()); //escreve no arquivo
            fileOut.close(); //fecha o strem do arquivo
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
