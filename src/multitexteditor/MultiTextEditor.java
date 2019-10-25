/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.util.ArrayList;

/**
 *
 * @author Gabriell
 */
public class MultiTextEditor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        User logado = null;
        TelaLogin TL;
        TL = new TelaLogin(logado);
        TL.setVisible(true);
    }
}
