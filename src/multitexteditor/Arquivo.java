/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.awt.event.ActionEvent;
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
    public JTextArea textArea;
    private boolean editable;
    
    public Arquivo(JTextArea textArea){
        this.texto = "";
        this.timer = new Timer();
        this.textArea = textArea;
        this.editable = true;
    }

    public String getNome() {
        return this.nome;
    }
    
    
    public String getTexto() {
        return texto;
    }


    public boolean isEditable() {
        return editable;
    }
    
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public void setTimer(){
        timer.scheduleAtFixedRate(this,0,1000);
    }
    
    public void setFile(){
        this.arq = new File(this.nome + ".txt");
    }
    
    public void nullFile(){
        this.arq = null;
    }
    
    public void writeFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.arq))) {
            bw.write(this.texto);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
        }
    }
    
    public void readFile(){
        if(this.arq != null){
            try(BufferedReader br = new BufferedReader(new FileReader(this.arq))) {
                StringBuilder inputBuffer = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    inputBuffer.append(line);
                    inputBuffer.append('\n');
                }
                this.texto = inputBuffer.toString();
                this.textArea.setText(this.texto);
                br.close();
            } catch (IOException e){
                System.out.println(e);
            }
        }
    }

    @Override
    public void run() {
        if(this.arq != null){
            this.texto = textArea.getText();
            this.writeFile();
//            javax.swing.Timer rf = new javax.swing.Timer(500, (ActionEvent evt1) -> {
//                if(this.editable){
//                    int cursor = this.textArea.getCaretPosition();
//                    this.readFile();
//                    if(cursor >= this.textArea.getDocument().getLength())
//                        cursor = this.textArea.getDocument().getLength()-1;
//                    this.textArea.setCaretPosition(cursor);
//                }
//            });
//            rf.setRepeats(false);
//            rf.start();
        }
    }

//    @Override
//    public void run() {
//        if(this.arq != null && this.editable){
//            int cursor = this.textArea.getCaretPosition();
//            this.readFile();
//            if(cursor >= this.textArea.getDocument().getLength())
//                cursor = this.textArea.getDocument().getLength()-1;
//            this.textArea.setCaretPosition(cursor);
//        }
//    }

    
}
