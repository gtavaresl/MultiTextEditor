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
  public UndoAction(UndoManager manager, String name) {
    super(manager, name);
    setErrorMessage("Não é possível desfazer");
    setErrorTitle("Erro ao desfazer");
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    try {
      undoManager.undo();
    } catch (CannotUndoException cannotUndoException) {
      showMessage(actionEvent.getSource());
    }
  }
}