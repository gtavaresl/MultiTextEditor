/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.awt.event.ActionEvent;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author lucas
 */
class RedoAction extends UndoRedoAction {
    
    /** Método construtor da classe RedoAction */
    public RedoAction(UndoManager manager, String name) {
        super(manager, name);
        this.setAlert();
    }
    
    /** Método chamado para realizar a função de refazer modificações */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            undoManager.redo(); //refaz as modificações
        } catch (CannotRedoException cannotRedoException) {
            showMessage(actionEvent.getSource()); //mensagem de erro
        }
    }
    
    /** Método que define as mensagens de erro */
    public final void setAlert(){
        setErrorMessage("Não é possível refazer");
        setErrorTitle("Erro ao refazer");
    }
}
