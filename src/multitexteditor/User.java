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
    private String nome;
    private String lastLogin;


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
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setLastLogin(String lastLogin){
        this.lastLogin = lastLogin;
    }
    
    @Override
    public String toString(){
        return "Usuário: " + this.nome + "\n"+"Último login: " + this.lastLogin;
    }
    
}
