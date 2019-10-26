/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

/**
 *
 * @author Gabriell
 */
public class User {
    private final String nome;
    private final String lastLogin;
//Date data = fmt.parse("17/12/2007 19:30:20"); 
//String str = fmt.format(data);

    public User(String nome, String lastLogin){
        this.nome = nome;
        this.lastLogin = lastLogin;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getLastLogin(){
        return this.lastLogin;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
}
