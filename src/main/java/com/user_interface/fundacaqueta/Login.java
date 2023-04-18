/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.user_interface.fundacaqueta;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.Month;
import com.logic.fundacaqueta.Fundacaqueta;
import com.logic.fundacaqueta.Administrador;
import com.logic.fundacaqueta.Auxiliar;
import com.logic.fundacaqueta.Profesional;
import com.logic.fundacaqueta.Proyecto;
import com.logic.fundacaqueta.Actividad;
import com.logic.fundacaqueta.ContratoColaboracion;
import com.logic.fundacaqueta.ContratoLaboral;
import javax.swing.JOptionPane;

/**
 *
 * @author nebel
 */
public class Login extends javax.swing.JFrame {

    private Fundacaqueta fundacaqueta;

    /**
     * Creates new form NewJFrame
     */
    public Login() {
        initComponents();
        fundacaqueta = new Fundacaqueta();
        
        // Test instances in order to test application
        Administrador adminTest = new Administrador("test", "123456", "John Doe", "john@doe.com", 123456);
        fundacaqueta.agregarAdministrador(adminTest);
        
        Auxiliar auxTest = new Auxiliar("test1", "123456", "John Doe", "john@doe.com", 123456);
        fundacaqueta.agregarAuxiliares(auxTest);
        
        LocalDate someBirthday = LocalDate.of(1995, Month.MARCH, 12);
        Profesional profTest = new Profesional("test2", "123456", "John Doe", "john@doe.com", 123456, someBirthday, "ingeniero", "programador");
        
        Actividad activityTest = new Actividad("Test", "Test", "Test");
        profTest.agregarActividad(activityTest);
        
        ContratoLaboral contratoLabTest = new ContratoLaboral("Test", "Test", 10000);
        profTest.modificarContrato(contratoLabTest);
        
        ContratoColaboracion contratoColTest = new ContratoColaboracion("Test", "Test", 100000);
        
        Proyecto proyTest = new Proyecto("Prueba", "Florencia", Proyecto.INVERSION_SOCIAL);
        proyTest.agregarContrato(contratoColTest);
        proyTest.agregarProfesional(profTest);
        fundacaqueta.agregarProyecto(proyTest);
        //End of adding test data
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TxtPassword = new javax.swing.JTextField();
        TxtUsername1 = new javax.swing.JTextField();
        BttnCancel = new javax.swing.JButton();
        BttnLogin1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TxtPassword.setText("123456");

        TxtUsername1.setText("test");

        BttnCancel.setText("Cancelar");
        BttnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnCancelActionPerformed(evt);
            }
        });

        BttnLogin1.setText("Iniciar sesion");
        BttnLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnLogin1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Usuario:");
        jLabel1.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");
        jLabel2.setEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("FUNDACAQUETA");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(BttnLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BttnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtUsername1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BttnLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BttnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BttnLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnLogin1ActionPerformed
        // TODO add your handling code here:
        String username = TxtUsername1.getText();
        String password = TxtPassword.getText();

        if (username.equals("") || password.equals("")) {
            TxtUsername1.setFocusable(true);
            TxtPassword.setFocusable(true);
            JOptionPane.showMessageDialog(this, "Debe ingresar un usuario y una contraseña", "Informacion invalida", JOptionPane.ERROR_MESSAGE);
        }

        if (!checkIfOnList(username, password))
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Informacion incorrecta", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_BttnLogin1ActionPerformed

    private void BttnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BttnCancelActionPerformed

    private boolean checkIfOnList(String user, String password) {
        ArrayList<Administrador> admins = fundacaqueta.obtenerAdministradores();
        ArrayList<Auxiliar> auxs = fundacaqueta.obtenerAuxiliares();
        ArrayList<Profesional> profs = fundacaqueta.obtenerProfesionales();
        for (int i = 0; i < admins.size(); i++) {
            String usuarioAdministrador = admins.get(i).obtenerNombreUsuario();
            String contraseña = admins.get(i).obtenerContraseña();

            if (user.equals(usuarioAdministrador) && password.equals(contraseña)) {
                InterfazAdmin adminView = new InterfazAdmin(fundacaqueta);
                adminView.setVisible(true);
                return true;
            }
        }

        for (int i = 0; i < auxs.size(); i++) {
            String usuarioAux = auxs.get(i).obtenerNombreUsuario();
            String contraseña = auxs.get(i).obtenerContraseña();

            if (user.equals(usuarioAux) && password.equals(contraseña)) {
                InterfazUsuarioAuxiliar aux = new InterfazUsuarioAuxiliar(fundacaqueta);
                aux.setVisible(true);
                return true;
            }
        }

        for (int i = 0; i < auxs.size(); i++) {
            String usuarioProf = profs.get(i).obtenerNombreUsuario();
            String contraseña = profs.get(i).obtenerContraseña();

            if (user.equals(usuarioProf) && password.equals(contraseña)) {
                InterfazProfesional profesional = new InterfazProfesional(fundacaqueta);
                profesional.setVisible(true);
                return true;
            }
        }

        return false;
    }

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
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login login = new Login();
                login.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BttnCancel;
    private javax.swing.JButton BttnLogin1;
    private javax.swing.JTextField TxtPassword;
    private javax.swing.JTextField TxtUsername1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
