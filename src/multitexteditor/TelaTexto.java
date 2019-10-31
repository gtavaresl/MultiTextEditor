/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Gabriell
 */
public class TelaTexto extends javax.swing.JFrame {

    /**
     * Creates new form TelaTexto
     * @param logado
     */
    
    private final Server servidor;
    private final User logado;
    private final Arquivo file;
    private final UndoManager manager = new UndoManager();
    private Thread twf;
    //Thread trf;
    private final InputStream imgStream;
    private final BufferedImage myImg;
    
    /** Método construtor da classe TelaTexto
     * @param servidor
     * @param logado
     * @param LL
     * @throws java.io.IOException */
    public TelaTexto(Server servidor, User logado, String LL) throws IOException {
        super("Editor de texto colaborativo"); //altera o titulo do frame
        this.imgStream = TelaServidor.class.getResourceAsStream("file_txt-512.png");
        initComponents();
        this.myImg = ImageIO.read(imgStream);
        this.setIconImage(this.myImg);
        this.servidor = servidor;
        this.logado = logado;
        this.setName(this.getName() + "-" + logado.getNome()); //altera o nome do frame de acordo com o cliente
        this.file = new Arquivo(jTextArea);
        jTextArea.getDocument().addUndoableEditListener(manager);        
        
        jLabelNome.setText("User: " + logado.getNome());
        if(LL != null)
            jLabelLastLogin.setText("Last login had been: " + LL);
        else
            jLabelLastLogin.setText("Last login: " + logado.getLastLogin());
        
        jTextArea.setVisible(false);
        jLabelFileName.setVisible(false);
        jButtonClose.setVisible(false);
        jButtonSave.setVisible(false);
        jButtonSave.setMnemonic(KeyEvent.VK_S);
        jMenuItemDelete.setVisible(false);
        jMenuItemRename.setVisible(false);
        jLabelFileSaved.setVisible(false);
        jMenuItemRedo.setEnabled(false);
        jMenuItemUndo.setEnabled(false);
        jMenuItemFind.setEnabled(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jButtonClose = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jLabelFileSaved = new javax.swing.JLabel();
        jLabelFileName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelLastLogin = new javax.swing.JLabel();
        jButtonDisconnect = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemNovo = new javax.swing.JMenuItem();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jMenuItemDelete = new javax.swing.JMenuItem();
        jMenuItemRename = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuItemUndo = new javax.swing.JMenuItem();
        jMenuItemRedo = new javax.swing.JMenuItem();
        jMenuItemFind = new javax.swing.JMenuItem();
        jMenuUsers = new javax.swing.JMenu();
        jMenuItemUsers = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("frameTexto"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextAreaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea);

        jButtonClose.setText("Close");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabelFileSaved.setText("File saved!");

        jLabelFileName.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelFileName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelFileSaved)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelFileSaved)
                        .addComponent(jLabelFileName))
                    .addComponent(jButtonClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabelNome.setText("jLabel1");

        jLabelLastLogin.setText("jLabel2");

        jButtonDisconnect.setText("Disconnect");
        jButtonDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisconnectActionPerformed(evt);
            }
        });
        jButtonDisconnect.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonDisconnectKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addComponent(jLabelLastLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDisconnect)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLastLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jButtonDisconnect)))
                .addContainerGap())
        );

        jMenuFile.setText("File");

        jMenuItemNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multitexteditor/new-file-icon-19-jpg.png"))); // NOI18N
        jMenuItemNovo.setText("Novo");
        jMenuItemNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNovoActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemNovo);

        jMenuItemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multitexteditor/open-icon-files-12-jpg.png"))); // NOI18N
        jMenuItemAbrir.setText("Abrir");
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemAbrir);

        jMenuItemDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItemDelete.setText("Deletar");
        jMenuItemDelete.setName(""); // NOI18N
        jMenuItemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDeleteActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemDelete);

        jMenuItemRename.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItemRename.setText("Renomear");
        jMenuItemRename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRenameActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItemRename);

        jMenuBar1.add(jMenuFile);

        jMenuEdit.setText("Edit");

        jMenuItemUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multitexteditor/undo-icon.png"))); // NOI18N
        jMenuItemUndo.setText("Desfazer");
        jMenuItemUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUndoActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemUndo);

        jMenuItemRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multitexteditor/redo-icon.png"))); // NOI18N
        jMenuItemRedo.setText("Refazer");
        jMenuItemRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRedoActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemRedo);

        jMenuItemFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multitexteditor/search.png"))); // NOI18N
        jMenuItemFind.setText("Encontrar");
        jMenuItemFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFindActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuItemFind);

        jMenuBar1.add(jMenuEdit);

        jMenuUsers.setText("Users");

        jMenuItemUsers.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/multitexteditor/group-2-512.png"))); // NOI18N
        jMenuItemUsers.setText("Gerenciar");
        jMenuItemUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUsersActionPerformed(evt);
            }
        });
        jMenuUsers.add(jMenuItemUsers);

        jMenuBar1.add(jMenuUsers);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Método que chama o frame TextBox ao apertar o menuItem jMenuItemNovo */
    private void jMenuItemNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNovoActionPerformed
        // TODO add your handling code here:
        manager.discardAllEdits(); //descarta todos as edições da textArea
        TextBox TB;
        try {
            TB = new TextBox(servidor, logado, manager, this.jTextArea, this.jButtonClose, this.jButtonSave, this.jLabelFileName, this.jMenuItemNovo, this.jMenuItemAbrir, this.jMenuItemUndo, this.jMenuItemRedo, this.jMenuItemFind, this.jMenuItemDelete, this.jMenuItemRename, this.file, "Criar arquivo");
            TB.setVisible(true);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jMenuItemNovoActionPerformed

    /** Método que chama o frame TextBox ao apertar o menuItem jMenuItemAbrir */
    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
        // TODO add your handling code here:
        manager.discardAllEdits(); //descarta todos as edições da textArea
        TextBox TB;
        try {
            TB = new TextBox(servidor, logado, manager, this.jTextArea, this.jButtonClose, this.jButtonSave, this.jLabelFileName, this.jMenuItemNovo, this.jMenuItemAbrir, this.jMenuItemUndo, this.jMenuItemRedo, this.jMenuItemFind, this.jMenuItemDelete, this.jMenuItemRename, this.file, "Abrir arquivo");
            TB.setVisible(true);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jMenuItemAbrirActionPerformed

    /** Método que chama o frame TelaUsers ao apertar o menuItem jMenuItemUsers */
    private void jMenuItemUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUsersActionPerformed
        // TODO add your handling code here:
        TelaUsers LU;
        try {
            LU = new TelaUsers(servidor, logado, jLabelNome);
            LU.setVisible(true);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jMenuItemUsersActionPerformed

    /** Método que fecha o arquivo que está sendo editado */
    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        // TODO add your handling code here:
        servidor.stopThread(file.getThread()); // para a thread de escrever o arquivo
        
        jTextArea.setText(""); //limpa o texto da textArea
        manager.discardAllEdits(); //descarta todos as edições da textArea
        file.setNome(null);
        file.setTexto("");
        file.nullFile();
        jTextArea.setVisible(false);
        jButtonClose.setVisible(false);
        jButtonSave.setVisible(false);
        jLabelFileSaved.setVisible(false);
        jLabelFileName.setVisible(false);
        jMenuItemAbrir.setEnabled(true);
        jMenuItemNovo.setEnabled(true);
        jMenuItemDelete.setVisible(false);
        jMenuItemRename.setVisible(false);
        jMenuItemUndo.setEnabled(false);
        jMenuItemRedo.setEnabled(false);
    }//GEN-LAST:event_jButtonCloseActionPerformed

    /** Método que força o texto a ser salvo no arquivo */
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        file.writeFile(); //escreve no arquivo
//        aparecer mensagem de "file saved" por 5 segundos
        Timer timer = new Timer(5000, (ActionEvent evt1) -> {
            jLabelFileSaved.setVisible(false);
        });
        timer.setRepeats(false);
        timer.start();
        jLabelFileSaved.setVisible(true);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    /** Método que realiza a função desfazer modificações ao apertar o menuItem jMenuItemUndo */
    private void jMenuItemUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUndoActionPerformed
        // TODO add your handling code here:
        UndoAction undo = new UndoAction(manager, "Undo");
        undo.actionPerformed(evt);
    }//GEN-LAST:event_jMenuItemUndoActionPerformed

    /** Método que realiza a função refazer modificações ao apertar o menuItem jMenuItemRedo */
    private void jMenuItemRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRedoActionPerformed
        // TODO add your handling code here:
        RedoAction redo = new RedoAction(manager, "Redo");
        redo.actionPerformed(evt);
    }//GEN-LAST:event_jMenuItemRedoActionPerformed

    /** Método que realiza a função procurar próximo ao apertar o menuItem jMenuItemFind */
    private void jMenuItemFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFindActionPerformed
        // TODO add your handling code here:
        TextBox TB;
        try {
            TB = new TextBox(servidor, logado, manager, this.jTextArea, this.jButtonClose, this.jButtonSave, this.jLabelFileName, this.jMenuItemNovo, this.jMenuItemAbrir, this.jMenuItemUndo, this.jMenuItemRedo, this.jMenuItemFind, this.jMenuItemDelete, this.jMenuItemRename, this.file, "Encontre uma palavra");
            TB.setVisible(true);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jMenuItemFindActionPerformed

    /** Método que salva e fecha os arquivos, dependendo os atalhos pressionados enquanto no jTextArea */
    private void jTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaKeyPressed
        // TODO add your handling code here:
        if((evt.getKeyCode() == KeyEvent.VK_S) && (evt.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0) //CTRL+S
            jButtonSave.doClick();
        if((evt.getKeyCode() == KeyEvent.VK_W) && (evt.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0) //CTRL+W
            jButtonClose.doClick();
    }//GEN-LAST:event_jTextAreaKeyPressed

    private void jTextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextAreaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAreaKeyReleased

    /** Método que desconecta o usuário atual e fecha todos os seus frames derivados */
    private void jButtonDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisconnectActionPerformed
        // TODO add your handling code here:
        if(!file.isNull()) // se tem arquivo, parar a thread de write
            servidor.stopThread(file.getThread());
        servidor.disconnectClient(logado);
    }//GEN-LAST:event_jButtonDisconnectActionPerformed

    /** Método que desconecta o usuário atual e fecha todos os seus frames derivados ao pressionar o jButtonDisconnect */
    private void jButtonDisconnectKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonDisconnectKeyPressed
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if(key == '\n'){
            jButtonDisconnect.doClick();
        }
    }//GEN-LAST:event_jButtonDisconnectKeyPressed

    /** Método que, ao fechar o frame atual, também desconecta o usuário atual */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        jButtonDisconnect.doClick();
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDeleteActionPerformed
        // TODO add your handling code here:
        file.deleteOpenFile();
        jButtonClose.doClick();
    }//GEN-LAST:event_jMenuItemDeleteActionPerformed

    private void jMenuItemRenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRenameActionPerformed
        // TODO add your handling code here:
        TextBox TB;
        try {
            TB = new TextBox(servidor, logado, manager, this.jTextArea, this.jButtonClose, this.jButtonSave, this.jLabelFileName, this.jMenuItemNovo, this.jMenuItemAbrir, this.jMenuItemUndo, this.jMenuItemRedo, this.jMenuItemFind, this.jMenuItemDelete, this.jMenuItemRename, this.file, "Digite o novo nome do arquivo");
            TB.setVisible(true);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_jMenuItemRenameActionPerformed

    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaTexto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaTexto().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonDisconnect;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabelFileName;
    private javax.swing.JLabel jLabelFileSaved;
    private javax.swing.JLabel jLabelLastLogin;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenuItem jMenuItemDelete;
    private javax.swing.JMenuItem jMenuItemFind;
    private javax.swing.JMenuItem jMenuItemNovo;
    private javax.swing.JMenuItem jMenuItemRedo;
    private javax.swing.JMenuItem jMenuItemRename;
    private javax.swing.JMenuItem jMenuItemUndo;
    private javax.swing.JMenuItem jMenuItemUsers;
    private javax.swing.JMenu jMenuUsers;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}
