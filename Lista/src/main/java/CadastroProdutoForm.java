
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author rafae
 */
public class CadastroProdutoForm extends javax.swing.JFrame {

    /**
     * Creates new form CadastroProdutoForm
     */
    public CadastroProdutoForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldQuant = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("Nome");

        jLabel2.setText("Quantidade");

        jTextFieldQuant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldQuantKeyTyped(evt);
            }
        });

        jLabel3.setText("Preco");

        jTextFieldPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrecoKeyTyped(evt);
            }
        });

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });
        jButtonConfirmar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButtonConfirmarKeyTyped(evt);
            }
        });

        jButtonDeletar.setText("Deletar");
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldQuant, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(jTextFieldNome)
                    .addComponent(jTextFieldPreco))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonConfirmar)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonDeletar)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDeletar)
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButtonConfirmar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        int column = 0;
        int row = ListaForm.jTableLista.getSelectedRow();
        String id = ListaForm.jTableLista.getModel().getValueAt(row, column).toString();
        ListaDAO listaDAO = new ListaDAO();
        listaDAO.excluirSQL(id);
        ListaForm.atualizar();
        this.dispose();
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        confirma();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    
    private void confirma()
    {
        if ("Confirmar".equals(jButtonConfirmar.getText())) {
            ListaDAO listaDao = new ListaDAO();

            if (!"".equals(jTextFieldNome.getText())) {
                if (!"".equals(jTextFieldQuant.getText())) {
                    if (!"".equals(jTextFieldPreco.getText())) {
                        listaDao.insertMySQL(jTextFieldNome.getText(), Double.parseDouble(jTextFieldQuant.getText()), Double.parseDouble(jTextFieldPreco.getText()));
                        ListaForm.atualizar();
                        this.hide();
                    } else {
                        JOptionPane.showMessageDialog(null, "Você deve colocar o preco", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                        jTextFieldPreco.requestFocusInWindow();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Você deve colocar a quantidade", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                    jTextFieldQuant.requestFocusInWindow();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você deve colocar um nome", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldNome.requestFocusInWindow();
            }
        } else if ("Atualizar".equals(jButtonConfirmar.getText())) {
            ListaDAO listaDao = new ListaDAO();

            if (!"".equals(jTextFieldNome.getText())) {
                if (!"".equals(jTextFieldQuant.getText())) {
                    if (!"".equals(jTextFieldPreco.getText())) {
                        int column = 0;
                        int row = ListaForm.jTableLista.getSelectedRow();
                        String id = ListaForm.jTableLista.getModel().getValueAt(row, column).toString();
                        listaDao.atualizaMySQL(jTextFieldNome.getText(), Double.parseDouble(jTextFieldQuant.getText()), Double.parseDouble(jTextFieldPreco.getText()), Integer.parseInt(id));
                        ListaForm.atualizar();
                        this.hide();
                    } else {
                        JOptionPane.showMessageDialog(null, "Você deve colocar o preco", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                        jTextFieldPreco.requestFocusInWindow();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Você deve colocar a quantidade", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                    jTextFieldQuant.requestFocusInWindow();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você deve colocar um nome", "Erro!", JOptionPane.INFORMATION_MESSAGE);
                jTextFieldNome.requestFocusInWindow();
            }
        }
    }
    
    
    private void jTextFieldQuantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldQuantKeyTyped
        char ch = evt.getKeyChar();
        if (!Character.isDigit(ch) && ch != '\b' && ch != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldQuantKeyTyped

    private void jTextFieldPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrecoKeyTyped
        char ch = evt.getKeyChar();
        if (!Character.isDigit(ch) && ch != '\b' && ch != '.' && ch != ',') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldPrecoKeyTyped

    private void jButtonConfirmarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonConfirmarKeyTyped
        confirma();
    }//GEN-LAST:event_jButtonConfirmarKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProdutoForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonConfirmar;
    public javax.swing.JButton jButtonDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JTextField jTextFieldNome;
    public javax.swing.JTextField jTextFieldPreco;
    public javax.swing.JTextField jTextFieldQuant;
    // End of variables declaration//GEN-END:variables
}
