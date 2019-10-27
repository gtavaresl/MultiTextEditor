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
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextArea;

/**
 *
 * @author Gabriell
 */
public class Arquivo extends TimerTask{
    private String nome;
    private String texto;
    private final Timer timer;
    private File arq;
    public JTextArea TA;
    
    public Arquivo(JTextArea TA){
        this.texto = "";
        this.timer = new Timer();
        this.TA = TA;
    }

    public String getNome() {
        return this.nome;
    }
    
    
    public String getTexto() {
        return texto;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public void setTimer(){
        timer.scheduleAtFixedRate(this,0,100);
    }
    
    public void setFile(){
        this.arq = new File(this.nome + ".txt");
    }
    
    public void writeFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.arq))) {
            bw.write(this.texto);
            bw.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
               System.out.println(e);
        }
    }
    
    public void readFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(this.arq))) {
            String linha = br.readLine();
            while(linha != null){
                this.texto += linha + System.lineSeparator();
                linha = br.readLine();
            }
            this.TA.setText(this.texto);
        } catch (IOException e){
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        if(this.nome != null){
            this.texto = TA.getText();
//            System.out.println(this.texto);
            this.writeFile();
        }
    }
    
}
