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
public class Arquivo {
    private String nome;
    private String texto;
    private File arq;
    
    /** TextArea onde serão inseridos os textos */
    public JTextArea textArea; 
    
    private final Lock semaforo;
    private final Condition cond;
    
    /** Thread para escrita do arquivo */
    public Thread twf;

    /** Método construtor da classe arquivo
     * @param textArea */
    public Arquivo(JTextArea textArea){
        this.texto = "";
        this.textArea = textArea;
        semaforo = new ReentrantLock();
        cond = semaforo.newCondition();
    }

    /** Getter do atributo nome
     * @return  */
    public String getNome() {
        return this.nome;
    }

    /** Getter do atributo texto
     * @return  */    
    public String getTexto() {
        return texto;
    }

    /** Setter do atributo nome
     * @param nome */    
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Setter do atributo texto
     * @param texto */    
    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    /** Setter do atributo arq */
    public void setFile(){
        this.arq = new File(this.nome + ".txt");
    }
    
    /** Método que atribui o valor null ao atributo arq */
    public void nullFile(){
        this.arq = null;
    }
    
    /** Método que retorna true se o valor null estiver no atributo arq
     * @return  */
    public boolean isNull(){
        return this.arq == null;
    }
    
    /** Getter do atributo twf
     * @return  */    
    public Thread getThread(){
        return this.twf;
    }

    /** Método que utiliza threads para escrever no arquivo */    
    public void writeFile(){
        semaforo.lock(); //bloqueia
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.arq))) {
            bw.write(this.texto); //escreve no arquivo
            bw.flush(); //obriga a escrever os dados no arquivo
            bw.close(); //fecha o BufferedWriter
            cond.signalAll(); //acorda todas as threads
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            semaforo.unlock(); //desbloqueia
        }
    }
    
    /** Método que utiliza threads para ler o arquivo */
    public void readFile(){
        semaforo.lock(); //bloqueia
        try {
            if(this.arq != null){
//                int cursor = this.textArea.getCaretPosition();
                try(BufferedReader br = new BufferedReader(new FileReader(this.arq))) {
                    StringBuilder inputBuffer = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        inputBuffer.append(line); //concatena a linha atual com a string
                        inputBuffer.append('\n'); //concatena a string com uma quebra de linha
                    }
                    this.texto = inputBuffer.toString();
                    this.textArea.setText(this.texto); //novo texto do TextArea
//                    if(cursor >= this.texto.length())
//                        cursor = this.texto.length()-1;
//                    this.textArea.setCaretPosition(cursor);
                    br.close(); //fecha o BufferedReader
                } catch (IOException e){
                    System.out.println(e);
                }
            }
        } finally {
            semaforo.unlock(); //desbloqueia
        }
    }
    
    /** Método que cria uma nova thread */
    public void createThread(){
        WriteFile wf = new WriteFile(this, textArea);
        this.twf = new Thread(wf);
    }

}