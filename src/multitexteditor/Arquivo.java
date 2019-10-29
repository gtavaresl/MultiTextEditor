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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JTextArea;

/**
 *
 * @author Gabriell
 */
public class Arquivo { //extends TimerTask{
    private String nome;
    private String texto;
//    private final Timer timer;
    private File arq;
    public JTextArea textArea;
    private final Lock semaforo;
    private final Condition cond;

    
    public Arquivo(JTextArea textArea){
        this.texto = "";
//        this.timer = new Timer();
        this.textArea = textArea;
        semaforo = new ReentrantLock();
        cond = semaforo.newCondition();
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
    
//    public void setTimer(){
//        timer.scheduleAtFixedRate(this,0,1000);
//    }
    
    public void setFile(){
        this.arq = new File(this.nome + ".txt");
    }
    
    public void nullFile(){
        this.arq = null;
    }
    
    public boolean isNull(){
        return this.arq == null;
    }
    
    public void writeFile(){
        semaforo.lock();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.arq))) {
            bw.write(this.texto);
            bw.flush();
            bw.close();
            cond.signalAll();
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            semaforo.unlock();
        }
    }
    
    public void readFile(){
        semaforo.lock();
        try {
            if(this.arq != null){
//                int cusrsor = this.textArea.getCaretPosition();
                try(BufferedReader br = new BufferedReader(new FileReader(this.arq))) {
                    StringBuilder inputBuffer = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        inputBuffer.append(line);
                        inputBuffer.append('\n');
                    }
                    this.texto = inputBuffer.toString();
                    this.textArea.setText(this.texto);
//                    if(cursor >= this.texto.length())
//                        cursor = this.texto.length()-1;
//                    this.textArea.setCaretPosition(cursor);
                    br.close();
                } catch (IOException e){
                    System.out.println(e);
                }
            }
        } finally {
            semaforo.unlock();
        }
    }

//    @Override
//    public void run() {
//        if(this.arq != null){
//            this.texto = textArea.getText();
//            this.writeFile();
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
//        }
//    }
}
