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
 *
 * @author Gabriell
 */
public class WriteFile implements Runnable {

    /** Atributo que representa a classe Arquivo */
    public Arquivo file;
    
    /** Atributo que representa o JTextArea */
    public JTextArea textArea;
    
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
        Timer timer = new Timer(10, (ActionEvent evt1) -> {
            System.out.println(this.file.getNome());
            if(!this.file.isNull()){
                this.file.setTexto(this.textArea.getText());
                this.file.writeFile();
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
}
