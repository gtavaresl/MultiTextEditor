/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

//import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Gabriell
 */
public class User {
    private final String nome;
    private final Calendar lastLogin;
//    private SimpleDateFormat;
    
    public User(String nome, Calendar lastLogin){
        this.nome = nome;
        this.lastLogin = lastLogin;
        
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
}
