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
  public RedoAction(UndoManager manager, String name) {
    super(manager, name);
    setErrorMessage("Não é possível refazer");
    setErrorTitle("Erro ao refazer");
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    try {
      undoManager.redo();
    } catch (CannotRedoException cannotRedoException) {
      showMessage(actionEvent.getSource());
    }
  }
}
