/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * Classe que executa a leitura do arquivo em paralelo.
 * @author Gabriell
 *
 */
public class ReadFile implements Runnable {
    
    /** Atributo que representa a classe Arquivo */
    public final Arquivo file;
    /** Atributo que representa o JTextArea */
    public JTextArea textArea;
    
    /** Método construtor da classe ReadFile
     * @param file
     * @param textArea */
    public ReadFile(Arquivo file, JTextArea textArea){
        this.file = file;
        this.textArea = textArea;
    }
    
    /** Método que funciona em paralelo ao programa, com a função de ler o arquivo */
    @Override
    public void run() {
        Timer timer = new Timer(100, (ActionEvent evt1) -> {
            if(!this.file.isNull()){
                this.file.readFile();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }    
}

