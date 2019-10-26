/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Gabriell
 */
public class Arquivo extends TimerTask{
    private String nome;
    private String texto;
    private final Timer timer;
    
    public Arquivo(){
        this.timer = new Timer();
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
        timer.scheduleAtFixedRate(this,0,1);
    }

    @Override
    public void run() {
//        System.out.println(this.nome);
        if(this.nome != null){
            System.out.println("Thread funcionando!");
        }
    }
    
}
