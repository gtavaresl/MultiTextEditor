/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.awt.event.ActionEvent;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author lucas
 */
class UndoAction extends UndoRedoAction {
    
    /** Método construtor da classe UndoAction */
    public UndoAction(UndoManager manager, String name) {
        super(manager, name);
        this.setAlert();
    }
    
    /** Método chamado para realizar a função de desfazer modificações */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            undoManager.undo();
        } catch (CannotUndoException cannotUndoException) {
            showMessage(actionEvent.getSource());
        }
    }
    
    /** Método que define as mensagens de erro */
    public final void setAlert(){
        setErrorMessage("Não é possível desfazer");
        setErrorTitle("Erro ao desfazer");
    }
}