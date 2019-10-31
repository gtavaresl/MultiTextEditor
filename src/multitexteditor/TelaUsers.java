/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitexteditor;

import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriell
 */
public final class TelaUsers extends javax.swing.JFrame {

    /**
     * Creates new form ListUsers
     * @param users
     */
    
    Server servidor;
    User logado;
    JLabel jLN;
    DefaultTableModel model;
    private final InputStream imgStream = TelaServidor.class.getResourceAsStream("file_txt-512.png");
    private final BufferedImage myImg;
            
    /** Método construtor da classe TelaUsers
     * @param servidor
     * @param logado
     * @param jLN
     * @throws java.io.IOException */
    public TelaUsers(Server servidor, User logado, JLabel jLN) throws IOException {
        super("Editar/Visualizar usuários"); //altera titulo do frame 
        initComponents();
        this.myImg = ImageIO.read(imgStream);
        this.setIconImage(this.myImg);
        this.setLocationRelativeTo(null); //centraliza o frame
        this.servidor = servidor;
        this.logado = logado;
        this.jLN = jLN;
        if(this.logado == null){ // tela invocada pelo servidor
            this.jTextField.setVisible(false);
            this.jLabelNome.setVisible(false);
            this.jButtonEdit.setVisible(false);
        }else
            this.setName(this.getName() + "-" + logado.getNome()); //altera o nome do frame
        this.model = (DefaultTableModel) jTable.getModel();
        createUsersTable();
    }
    
    /** Método que cria uma tabela com os clientes */
    public void createUsersTable(){
        try (BufferedReader reader = new BufferedReader(new FileReader("Usuarios.txt"))) {
            String linha1 = reader.readLine(); // lê a primeira linha
            String linha2 = reader.readLine();
            while (linha1 != null) {
                Object[] row = { linha1, linha2 };
                model.addRow(row);
                linha1 = reader.readLine(); // lê da terceira até a última linha
                linha2 = reader.readLine();
            }
            reader.close(); //fecha o BufferedReader
        }catch(IOException e){
//            System.err.println(e);
        }
    }
    
    /** Método que edita informações do usuário */
    public void editUser() {
        if(!jTextField.getText().isEmpty()){
            Frame[] frames = Frame.getFrames(); //vetor com os frames abertos
            for (Frame frame : frames) {
                if (frame.getName().contains("-"+logado.getNome())) { //se o nome do frame contém "-NameUser", altera esse nome
                    frame.setName(frame.getName().replaceFirst("-"+logado.getNome(), "-"+jTextField.getText())); //troca os nomes
                }
            }
            logado.editNome(jTextField.getText()); //altera o nome do usuario logado
            jTextField.setText(""); //esvazia o textField
            model.setValueAt(logado.getNome(), logado.getIndex(), 0);
            jLN.setText("Usuário: " + logado.getNome());
            servidor.updateJList(); //atualiza lista do servidor
        }else
            JOptionPane.showMessageDialog(null, "Insira um nome"); //mensagem de erro
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
        jTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jTextField = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("frameListUsers"); // NOI18N
        setResizable(false);

        jTable.setBackground(new java.awt.Color(240, 240, 240));
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Último Login"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jTable.setGridColor(new java.awt.Color(240, 240, 240));
        jTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable.setShowHorizontalLines(false);
        jTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabelNome.setText("Editar Nome User:");

        jTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldActionPerformed(evt);
            }
        });
        jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldKeyPressed(evt);
            }
        });

        jButtonEdit.setText("Editar");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jButtonEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonEditKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jButtonEdit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jButtonRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonRefresh)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldActionPerformed

    /** Método que edita informações do usuario ao apertar o jButtonEdit */
    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        // TODO add your handling code here:
        editUser();
    }//GEN-LAST:event_jButtonEditActionPerformed

    /** Método que edita informações do usuario ao pressionar ENTER enquanto está no jTextField */
    private void jTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldKeyPressed
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if(key == '\n'){
            editUser();
        }
    }//GEN-LAST:event_jTextFieldKeyPressed

    /** Método que edita informações do usuario ao pressionar ENTER enquanto está no jButtonEdit */
    private void jButtonEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonEditKeyPressed
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if(key == '\n'){
            editUser();
        }
    }//GEN-LAST:event_jButtonEditKeyPressed

    /** Método que atualiza a tabela de usuário ao apertar o jButtonRefresh */
    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        model = (DefaultTableModel) jTable.getModel();
        for(int i = model.getRowCount() - 1; i >= 0 ; i--)
            model.removeRow(i);
        createUsersTable();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

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
//            java.util.logging.Logger.getLogger(TelaUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new TelaUsers().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextField;
    // End of variables declaration//GEN-END:variables
}
