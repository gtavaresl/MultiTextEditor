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
 *  Classe ainda nao implementada no projeto
 */
public class ReadFile implements Runnable {
    
    public final Arquivo file;
    public JTextArea textArea;
    
    public ReadFile(Arquivo file, JTextArea textArea){
        this.file = file;
        this.textArea = textArea;
    }
    
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

