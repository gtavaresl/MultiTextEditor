/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.awt.Component;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.undo.UndoManager;

/**
 *
 * @author lucas
 */
abstract class UndoRedoAction extends AbstractAction {
  UndoManager undoManager = new UndoManager();

  String errorMessage = "Não é possível desfazer";

  String errorTitle = "Erro ao desfazer";

  protected UndoRedoAction(UndoManager manager, String name) {
    super(name);
    undoManager = manager;
  }

  public void setErrorMessage(String newValue) {
    errorMessage = newValue;
  }

  public void setErrorTitle(String newValue) {
    errorTitle = newValue;
  }

  protected void showMessage(Object source) {
    if (source instanceof Component) {
      JOptionPane.showMessageDialog((Component) source, errorMessage, errorTitle,
          JOptionPane.WARNING_MESSAGE);
    } else {
      System.err.println(errorMessage);
    }
  }
}
