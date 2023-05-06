/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.user_interface.fundacaqueta.Interfaces.Usuario;
import com.logic.fundacaqueta.abstractions.Usuario;

import com.logic.fundacaqueta.Fundacaqueta;
import com.logic.fundacaqueta.Administrador;
import com.logic.fundacaqueta.Auxiliar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author nebel
 */
public class AdministradorUsuarios extends javax.swing.JFrame {

    private Fundacaqueta admin;
    /**
     * Creates new form AdministradorUsuarios
     */
    public AdministradorUsuarios(Fundacaqueta admin) {
        initComponents();
        this.admin = admin;
        mostrarAdministradores();
        mostrarAuxiliares();
        this.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    }
    
    private String[] devolverInformacionAdministradorSeleccionado(){
        String[] datosUsuario = new String[5];
        
        datosUsuario[0] = listAdmins.getSelectedValue();
        
        for(int i = 0; i < admin.obtenerAdministradores().size(); i++){
            if(admin.obtenerAdministradores().get(i).obtenerNombreUsuario().equals(datosUsuario[0])){
                datosUsuario[1] = admin.obtenerAdministradores().get(i).obtenerContraseña();
                datosUsuario[2] = admin.obtenerAdministradores().get(i).obtenerNombre();
                datosUsuario[3] = admin.obtenerAdministradores().get(i).obtenerCorreo();
                datosUsuario[4] = String.valueOf(admin.obtenerAdministradores().get(i).obtenerDocumento());
                break;
            }
        }
        
        return datosUsuario;
    }
    
    private String[] devolverInformacionAuxiliarSeleccionado(){
        String[] datosUsuario = new String[5];
        
        datosUsuario[0] = listAuxs.getSelectedValue();
        
        for(int i = 0; i < admin.obtenerAuxiliares().size(); i++){
            if(admin.obtenerAuxiliares().get(i).obtenerNombreUsuario().equals(datosUsuario[0])){
                datosUsuario[1] = admin.obtenerAuxiliares().get(i).obtenerContraseña();
                datosUsuario[2] = admin.obtenerAuxiliares().get(i).obtenerNombre();
                datosUsuario[3] = admin.obtenerAuxiliares().get(i).obtenerCorreo();
                datosUsuario[4] = String.valueOf(admin.obtenerAuxiliares().get(i).obtenerDocumento());
                break;
            }
        }
        
        return datosUsuario;
    }
    
    private void mostrarAdministradores(){
        DefaultListModel administradores = new DefaultListModel();
        for(int i = 0; i < admin.obtenerAdministradores().size(); i++){
            administradores.addElement(admin.obtenerAdministradores().get(i).obtenerNombreUsuario());
        }
        listAdmins.setModel(administradores);
    }
    
    private void mostrarAuxiliares(){
        DefaultListModel auxiliares = new DefaultListModel();
        for(int i = 0; i < admin.obtenerAuxiliares().size(); i++){
            auxiliares.addElement(admin.obtenerAuxiliares().get(i).obtenerNombreUsuario());
        }
        listAuxs.setModel(auxiliares);
    }
    
    public void agregarUsuarioAdministrador(String nombreUsuario, String contraseña, String correo, String nombre, int documento){
        admin.agregarAdministrador(new Administrador(nombreUsuario, contraseña, nombre, correo, documento));
        mostrarAdministradores();
    }
    
    public void agregarUsuarioAuxiliar(String nombreUsuario, String contraseña, String correo, String nombre, int documento){
        admin.agregarAuxiliares(new Auxiliar(nombreUsuario, contraseña, nombre, correo, documento));
        mostrarAuxiliares();
    }
    
    public void editarUsuarioAdministrador(String nombreUsuario, String contraseña, String nombre, String correo, int documento){
        String[] datosActualesUsuario = devolverInformacionAdministradorSeleccionado();
        listAdmins.setModel(new DefaultListModel());
        admin.modificarAdministrador(
                admin.obtenerAdministrador(datosActualesUsuario[0]),
                new Administrador(nombreUsuario, contraseña, nombre, correo, documento)
                );
        mostrarAdministradores();
    }
    
    public void editarUsuarioAuxiliar(String nombreUsuario, String contraseña, String nombre, String correo, int documento){
        String[] datosActualesUsuario = devolverInformacionAuxiliarSeleccionado();
        listAuxs.setModel(new DefaultListModel());
        admin.modificarAuxiliar(
                admin.obtenerAuxiliar(datosActualesUsuario[0]),
                new Auxiliar(nombreUsuario, contraseña, nombre, correo, documento)
                );
        mostrarAuxiliares();
    }
    
    public void eliminarUsuarioAdministrador(){
        int index = listAdmins.getSelectedIndex();
        listAdmins.setModel(new DefaultListModel());
        admin.eliminarAdministrador(index);
        mostrarAdministradores();
    }
    
    public void eliminarUsuarioAuxiliar(){
        int index = listAuxs.getSelectedIndex();
        listAuxs.setModel(new DefaultListModel());
        admin.eliminarAuxiliares(index);
        mostrarAuxiliares();
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
        listAdmins = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        bttnAgregarAdmin = new javax.swing.JButton();
        bttnEditarAdmin = new javax.swing.JButton();
        bttnEliminarAdmin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        bttnAgregarAux = new javax.swing.JButton();
        bttnEliminarAux = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAuxs = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        bttnEditarAux = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane1.setViewportView(listAdmins);

        jLabel1.setText("Administradores:");

        bttnAgregarAdmin.setText("Agregar");
        bttnAgregarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAgregarAdminActionPerformed(evt);
            }
        });

        bttnEditarAdmin.setText("Editar");
        bttnEditarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEditarAdminActionPerformed(evt);
            }
        });

        bttnEliminarAdmin.setText("Eliminar");
        bttnEliminarAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEliminarAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bttnEditarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bttnAgregarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bttnEliminarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bttnAgregarAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttnEditarAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttnEliminarAdmin)
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bttnAgregarAux.setText("Agregar");
        bttnAgregarAux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAgregarAuxActionPerformed(evt);
            }
        });

        bttnEliminarAux.setText("Eliminar");
        bttnEliminarAux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEliminarAuxActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listAuxs);

        jLabel2.setText("Auxiliares:");

        bttnEditarAux.setText("Editar");
        bttnEditarAux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEditarAuxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bttnAgregarAux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bttnEditarAux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bttnEliminarAux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bttnAgregarAux)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttnEditarAux)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(bttnEliminarAux))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttnAgregarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAgregarAdminActionPerformed
        // TODO add your handling code here:
        AgregarUsuario au = new AgregarUsuario(this, Usuario.ADMINISTRADOR);
        au.setVisible(true);
    }//GEN-LAST:event_bttnAgregarAdminActionPerformed

    private void bttnAgregarAuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAgregarAuxActionPerformed
        // TODO add your handling code here:
        AgregarUsuario au = new AgregarUsuario(this, Usuario.AUXILIAR);
        au.setVisible(true);
    }//GEN-LAST:event_bttnAgregarAuxActionPerformed

    private void bttnEditarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEditarAdminActionPerformed
        // TODO add your handling code here:
        String[] datosAdmin = devolverInformacionAdministradorSeleccionado();
        if(datosAdmin[0] == null){
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar un usuario administrador para poder editarlo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                    );
        }
        else{
            EditarUsuario eu = new EditarUsuario(
                    this,
                    datosAdmin[0],
                    datosAdmin[1],
                    datosAdmin[2],
                    datosAdmin[3],
                    datosAdmin[4],
                    Usuario.ADMINISTRADOR
            );
            
            eu.setVisible(true);
        }
    }//GEN-LAST:event_bttnEditarAdminActionPerformed

    private void bttnEditarAuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEditarAuxActionPerformed
        // TODO add your handling code here:
        String[] datosAux = devolverInformacionAuxiliarSeleccionado();
        if(datosAux[0] == null){
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar un usuario auxiliar para poder editarlo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                    );
        }
        else{
            EditarUsuario eu = new EditarUsuario(
                    this,
                    datosAux[0],
                    datosAux[1],
                    datosAux[2],
                    datosAux[3],
                    datosAux[4],
                    Usuario.AUXILIAR
            );
            
            eu.setVisible(true);
        }
    }//GEN-LAST:event_bttnEditarAuxActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void bttnEliminarAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEliminarAdminActionPerformed
        // TODO add your handling code here:
        String[] datosAdmin = devolverInformacionAdministradorSeleccionado();
        if(listAdmins.getSelectedIndex() < 0)
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar un usuario administrador para poder eliminarlo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        else{
            EliminarUsuario eu = new EliminarUsuario(
                    this,
                    datosAdmin[0],
                    datosAdmin[1],
                    datosAdmin[2],
                    datosAdmin[3],
                    datosAdmin[4],
                    Usuario.ADMINISTRADOR
            );
            eu.setVisible(true);
        }
    }//GEN-LAST:event_bttnEliminarAdminActionPerformed

    private void bttnEliminarAuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEliminarAuxActionPerformed
        // TODO add your handling code here:
        String[] datosAux = devolverInformacionAuxiliarSeleccionado();
        if(listAuxs.getSelectedIndex() < 0)
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar un usuario auxiliar para poder eliminarlo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        else{
            EliminarUsuario eu = new EliminarUsuario(
                    this,
                    datosAux[0],
                    datosAux[1],
                    datosAux[2],
                    datosAux[3],
                    datosAux[4],
                    Usuario.AUXILIAR
            );
            eu.setVisible(true);
        }
    }//GEN-LAST:event_bttnEliminarAuxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnAgregarAdmin;
    private javax.swing.JButton bttnAgregarAux;
    private javax.swing.JButton bttnEditarAdmin;
    private javax.swing.JButton bttnEditarAux;
    private javax.swing.JButton bttnEliminarAdmin;
    private javax.swing.JButton bttnEliminarAux;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listAdmins;
    private javax.swing.JList<String> listAuxs;
    private javax.swing.JMenu menuSalir;
    // End of variables declaration//GEN-END:variables
}
