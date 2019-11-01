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
 * Classe que executa a escrita do arquivo em paralelo.
 * @author Gabriell
 */
public class WriteFile implements Runnable {

    /** Atributo que representa a classe Arquivo */
    public Arquivo file;
    
    /** Atributo que representa o JTextArea */
    public JTextArea textArea;
    
    /** Atributo que representa o temporizador da thread */ 
    private Timer timer;
    
    /** Método construtor da classe WriteFile
     * @param file
     * @param textArea */
    public WriteFile(Arquivo file, JTextArea textArea){
        this.file = file;
        this.textArea = textArea;
    }
    
    /** Método que paraleliza a escrita do arquivo */
    @Override
    public void run() {
        this.timer = new Timer(100, (ActionEvent evt1) -> {
            if(!this.file.isNull()){
                this.file.setTexto(this.textArea.getText());
                this.file.writeFile();
            }else{
                this.timer.stop();
            }
        });
        this.timer.setRepeats(true);
        this.timer.start();
    }
}
