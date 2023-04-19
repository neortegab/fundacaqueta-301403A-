/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.user_interface.fundacaqueta.Interfaces.Proyecto;

//Java imports
import javax.swing.JOptionPane;
import javax.swing.JFrame;

//Logic imports
import com.logic.fundacaqueta.Fundacaqueta;
import com.logic.fundacaqueta.Proyecto;

//Interface imports
import com.user_interface.fundacaqueta.*;

/**
 *
 * @author nebel
 */
public class AgregarProyecto extends javax.swing.JFrame {

    private InterfazAdmin parentAdmin;
    
//    private InterfazUsuarioAuxiliar parentAuxiliar;
    
    private Fundacaqueta fundacaqueta;
    /**
     * Creates new form AgregarProyecto
     */
    public AgregarProyecto(Fundacaqueta fundacaqueta, InterfazAdmin parentAdmin) {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.fundacaqueta = fundacaqueta;
        if(parentAdmin != null)
            this.parentAdmin = parentAdmin;
        
//        if(parentAuxiliar != null)
//            this.parentAuxiliar = parentAuxiliar;
    }
    
    /**
     * Metodo que verifica que se hayan añadido los valores especificados
     */
    private boolean revisarValores(){
        boolean valoresValidos = true;
        String nombre = TxtNombre.getText();
        String lugarEjecucion = TxtLugarEjecucion.getText();
        
        if(nombre.equals("") && lugarEjecucion.equals("")){
            JOptionPane.showMessageDialog(this, 
                    "El nombre y el lugar del ejecucion no pueden ser vacíos", 
                    "Nombre faltante", 
                    JOptionPane.ERROR_MESSAGE);
            return !valoresValidos;
        }
        if(lugarEjecucion.equals("")){
            JOptionPane.showMessageDialog(this, 
                    "El lugar de ejecución no puede ser vacío", 
                    "Lugar faltante", 
                    JOptionPane.ERROR_MESSAGE);
            return !valoresValidos;
        }
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(this, 
                    "El nombre del proyecto no puede ser vacío", 
                    "Nombre faltante", 
                    JOptionPane.ERROR_MESSAGE);
            return !valoresValidos;
        }
        return valoresValidos;
    }
    
    /**
     * Comprueba el tipo seleccionado en el combo box
     * Si no hay tipo seleccionado se predetermina al primer tipo (Salud).
     */
    private String devolverTipoSeleccionado(){
        String tipoSeleccionado = CBTipo.getSelectedItem().toString();
        if(tipoSeleccionado.equals("")){
            CBTipo.setSelectedIndex(0);
            tipoSeleccionado = CBTipo.getSelectedItem().toString();
        }
        
        if(tipoSeleccionado.equals("Salud"))
            tipoSeleccionado = Proyecto.SALUD;
        if(tipoSeleccionado.equals("Inversion social"))
            tipoSeleccionado = Proyecto.INVERSION_SOCIAL;
        
        return tipoSeleccionado;
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
        TxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtLugarEjecucion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CBTipo = new javax.swing.JComboBox<>();
        BttnConfirmar = new javax.swing.JButton();
        BttnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Agregar Proyecto");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Lugar Ejecucion:");

        jLabel4.setText("Tipo:");

        CBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salud", "Inversion social" }));

        BttnConfirmar.setText("Confirmar");
        BttnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnConfirmarActionPerformed(evt);
            }
        });

        BttnCancelar.setText("Cancelar");
        BttnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBTipo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtLugarEjecucion, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(BttnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BttnCancelar)
                        .addGap(22, 22, 22))
                    .addComponent(TxtNombre))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtLugarEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BttnConfirmar)
                    .addComponent(BttnCancelar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BttnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnConfirmarActionPerformed
        // TODO add your handling code here:
        if(revisarValores()){
            String tipo = devolverTipoSeleccionado();
            int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Esta seguro de agregar el siguiente Proyecto?"
            +"\nNombre: " + TxtNombre.getText() + "\n" + ""
            +"Lugar ejecucion: "+TxtLugarEjecucion.getText()+"\n"
            +"Tipo: "+tipo,
            "Confirmar",
            JOptionPane.YES_NO_OPTION);
            if(confirmacion == JOptionPane.YES_OPTION){
                Proyecto nuevoProyecto = new Proyecto(TxtNombre.getText(), TxtLugarEjecucion.getText(), tipo);
                fundacaqueta.agregarProyecto(nuevoProyecto);
                JOptionPane.showMessageDialog(this, "Proyecto agregado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                if(this.parentAdmin != null)
                    parentAdmin.updateProjects();
            }
        }
    }//GEN-LAST:event_BttnConfirmarActionPerformed

    private void BttnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BttnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BttnCancelar;
    private javax.swing.JButton BttnConfirmar;
    private javax.swing.JComboBox<String> CBTipo;
    private javax.swing.JTextField TxtLugarEjecucion;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}