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

/**
 *
 * @author Gabriell
 */
public class User {
    private String nome;
    private String lastLogin;
    private int index;


    public User(String nome, String lastLogin){
        this.nome = nome;
        this.lastLogin = lastLogin;
        this.index = -1;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getLastLogin(){
        return this.lastLogin;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setLastLogin(String lastLogin){
        this.lastLogin = lastLogin;
    }
    
    public String updateUsers() {
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
                    if(line1.equals(this.nome)){
                        LL = line2;
                        line2 = this.lastLogin;
                        this.index = i;
                    }
                    inputBuffer.append(line2);
                    inputBuffer.append('\n');
                }
                if(this.index ==  -1){ // preciso adcionar o novo
                    this.index = i+1;
                    inputBuffer.append(this.nome);
                    inputBuffer.append('\n');
                    inputBuffer.append(this.lastLogin);
                    inputBuffer.append('\n');
                }
                br.close();
            } catch(IOException e) {
                System.out.println(e);
            }
        } else {
            this.index = 0;
            inputBuffer.append(this.nome);
            inputBuffer.append('\n');
            inputBuffer.append(this.lastLogin);
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
    
    public void editNome(String newNome){
        StringBuilder inputBuffer = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"))) {
            String line1;
            String line2;
            for(int i = 0; i < this.index; i++){
                line1 = br.readLine();
                inputBuffer.append(line1);
                inputBuffer.append('\n');
                line2 = br.readLine();
                inputBuffer.append(line2);
                inputBuffer.append('\n');
            }
            line1 = br.readLine();
            if(line1.equals(this.nome)){
                this.nome = newNome;
                line1 = this.nome;
            }
            inputBuffer.append(line1);
            inputBuffer.append('\n');
            line2 = br.readLine();
            inputBuffer.append(line2);
            inputBuffer.append('\n');
            br.close();
        } catch(IOException e) {
            System.out.println(e);
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
    }
    
    @Override
    public String toString(){
        return "Nome: " + this.nome + "  LL: " + this.lastLogin + "  Index: " + this.index;
    }
    
}
