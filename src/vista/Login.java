/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Control.database;
import com.sun.glass.events.KeyEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author yopri
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setSize(319, 422);
        Toolkit tk=Toolkit.getDefaultToolkit();
        Dimension d=tk.getScreenSize();
        setLocation((d.width-getSize().width)/2,(d.height-getSize().height)/2);
        jtfUsuario.requestFocus();
        jtfUsuario.selectAll();
         setIconImage(new ImageIcon(getClass().getResource("/img/candy16.png")).getImage());
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        btnAcceder = new javax.swing.JButton();
        jtfPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("INICIO DE SESIÓN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Usuario:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jtfUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfUsuarioKeyTyped(evt);
            }
        });
        getContentPane().add(jtfUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 223, -1));

        btnAcceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iniciar-sesion.png"))); // NOI18N
        btnAcceder.setText("Acceder");
        btnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederActionPerformed(evt);
            }
        });
        getContentPane().add(btnAcceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        jtfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(jtfPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 220, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/perfil-del-usuario.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
            /* vista.sistema ventana = new vista.sistema();
            ventana.setVisible(true);*/
       
       try {
      int resultado = database.validarUsuario(String.valueOf(jtfPassword.getPassword()),jtfUsuario.getText());
        if (resultado==1) {
            vista.sistema ventana = new vista.sistema();
            ventana.setVisible(true);
            this.dispose();
        }
        else{
        JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos");
                }
    } catch (SQLException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }//GEN-LAST:event_btnAccederActionPerformed

    private void jtfUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
              jtfPassword.requestFocus();
        }
  
    }//GEN-LAST:event_jtfUsuarioKeyPressed

    private void jtfUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfUsuarioKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtfUsuarioKeyTyped

    private void jtfPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPasswordKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
              btnAcceder.doClick();
        }
    }//GEN-LAST:event_jtfPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jtfPassword;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
