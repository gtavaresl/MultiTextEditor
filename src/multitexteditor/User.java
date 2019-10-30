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

    /** Método construtor da classe User
     * @param nome
     * @param lastLogin */
    public User(String nome, String lastLogin){
        this.nome = nome;
        this.lastLogin = lastLogin;
        this.index = -1;
    }
    
    /** Getter do atributo nome
     * @return  */
    public String getNome(){
        return this.nome;
    }
    
    /** Getter do atributo lastLogin
     * @return  */
    public String getLastLogin(){
        return this.lastLogin;
    }

    /** Getter do atributo index
     * @return  */
    public int getIndex() {
        return index;
    }

    /** Setter do atributo index
     * @param index */
    public void setIndex(int index) {
        this.index = index;
    }
    
    /** Setter do atributo nome
     * @param nome */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /** Setter do atributo lastLogin
     * @param lastLogin */
    public void setLastLogin(String lastLogin){
        this.lastLogin = lastLogin;
    }
    
    /** Método que atualiza informações de usuários
     * @return  */
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
                    inputBuffer.append(line1); //concatena a linha com nome com a string
                    inputBuffer.append('\n'); //concatena a quebra de linha com a string
                    line2 = br.readLine();
                    if(line1.equals(this.nome)){
                        LL = line2;
                        line2 = this.lastLogin;
                        this.index = i;
                    }
                    inputBuffer.append(line2); //concatena a linha com data e horario com a string
                    inputBuffer.append('\n'); //concatena a quebra de linha com a string
                }
                if(this.index ==  -1){ // preciso adcionar o novo
                    this.index = i+1;
                    inputBuffer.append(this.nome); //concatena o nome com a string
                    inputBuffer.append('\n'); //concatena a quebra de linha com a string
                    inputBuffer.append(this.lastLogin); //concatena a data e horario com a string
                    inputBuffer.append('\n'); //concatena a quebra de linha com a string
                }
                br.close(); //fecha o BufferedReader
            } catch(IOException e) {
                System.out.println(e);
            }
        } else {
            this.index = 0;
            inputBuffer.append(this.nome); //concatena o nome com a string
            inputBuffer.append('\n'); //concatena a quebra de linha com a string
            inputBuffer.append(this.lastLogin); //concatena a data e horario com a string
            inputBuffer.append('\n'); //concatena a quebra de linha com a string
        }
        
        String inputStr = inputBuffer.toString();
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("Usuarios.txt");
            fileOut.write(inputStr.getBytes()); //escreve no arquivo
            fileOut.close(); //fecha o stream do arquivo
        } catch (IOException e) {
            System.err.println(e);
        }
        return LL;
    }
    
    /** Método que edita o nome do cliente
     * @param newNome */
    public void editNome(String newNome){
        this.nome = newNome;
        StringBuilder inputBuffer = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("Usuarios.txt"))) {
            String line1;
            String line2;
            int i = -1;
            while ((line1 = br.readLine()) != null) {
                i++;
                if(i == this.index)
                    line1 = this.nome;
                inputBuffer.append(line1); //concatena a linha com nome com a string
                inputBuffer.append('\n'); //concatena a quebra de linha com a string
                line2 = br.readLine();
                inputBuffer.append(line2); //concatena a linha com data e horario com a string
                inputBuffer.append('\n'); //concatena a quebra de linha com a string
            }
            br.close(); //fecha o BufferedReader
        } catch(IOException e) {
            System.out.println(e);
        }
        String inputStr = inputBuffer.toString();
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream("Usuarios.txt");
            fileOut.write(inputStr.getBytes()); //escreve no arquivo
            fileOut.close(); //fecha o stream do arquivo
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    /** Método que sobrescreve o toString
     * @return  */
    @Override
    public String toString(){
        return "Nome: " + this.nome + "  LL: " + this.lastLogin + "  Index: " + this.index;
    }
    
}
