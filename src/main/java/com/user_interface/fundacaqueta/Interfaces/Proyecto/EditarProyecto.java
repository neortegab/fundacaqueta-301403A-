/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.user_interface.fundacaqueta.Interfaces.Proyecto;

//Imports logic
import com.logic.fundacaqueta.Fundacaqueta;

//Imports java
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

//Imports interface
import com.user_interface.fundacaqueta.InterfazAdmin;
/**
 *
 * @author nebel
 */
public class EditarProyecto extends javax.swing.JFrame {
    
    private Fundacaqueta fundacaqueta;
    
    private InterfazAdmin parentAdmin;

    /**
     * Creates new form EditarProyecto
     */
    public EditarProyecto(Fundacaqueta fundacaqueta, InterfazAdmin parent) {
        initComponents();
        this.fundacaqueta = fundacaqueta;
        this.parentAdmin = parent;
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
        txtLugarEjecucion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        bttnConfirmar = new javax.swing.JButton();
        BttnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        ftxtId = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        ftxtFechaFin = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Editar Proyecto");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Lugar Ejecucion:");

        jLabel4.setText("Tipo:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salud", "Inversion social" }));

        bttnConfirmar.setText("Confirmar");
        bttnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnConfirmarActionPerformed(evt);
            }
        });

        BttnCancelar.setText("Cancelar");
        BttnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Id:");

        ftxtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        ftxtId.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ftxtIdPropertyChange(evt);
            }
        });

        jLabel7.setText("Fecha fin:");

        ftxtFechaFin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Para modificar la fecha de inicio, debe modificar la fecha de inicio del primer contrato del proyecto.");
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLugarEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ftxtFechaFin)
                            .addComponent(ftxtId, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bttnConfirmar)
                                .addGap(62, 62, 62)
                                .addComponent(BttnCancelar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLugarEjecucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftxtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bttnConfirmar)
                    .addComponent(BttnCancelar))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BttnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BttnCancelarActionPerformed

    private void ftxtIdPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ftxtIdPropertyChange
        // TODO add your handling code here:
        revisarValorId();
        
    }//GEN-LAST:event_ftxtIdPropertyChange

    private void bttnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnConfirmarActionPerformed
        // TODO add your handling code here:
        int id = Math.toIntExact((Long) ftxtId.getValue());
        id--;
        String nombre = txtNombre.getText();
        String lugarEjecucion = txtLugarEjecucion.getText();
        String tipo = cmbTipo.getSelectedItem().toString();
        String fechaFin = ftxtFechaFin.getText();
        
        if(!ftxtFechaFin.getText().equals(null))
            fechaFin = ftxtFechaFin.getText();
        
        String dialogo = "¿Está seguro que desea editar este proyecto?\n" 
                +"Nombre: " + nombre + "\n" 
                +"Lugar ejecucion: " + lugarEjecucion + "\n"
                +"Tipo: " + tipo + "\n"
                +"Fecha fin: " + fechaFin + "\n";
        
        int respuesta = JOptionPane.showConfirmDialog(this, dialogo, "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if(respuesta == JOptionPane.YES_OPTION){
            fundacaqueta.obtenerProyectos().get(id).modificarNombre(nombre);
            fundacaqueta.obtenerProyectos().get(id).modificarLugarEjecucion(lugarEjecucion);
            fundacaqueta.obtenerProyectos().get(id).modificarTipo(tipo);
                   
            if(!fechaFin.equals("")){
                String[] detallesFechaFin = fechaFin.split("/");
                int diasFechaFin = Integer.parseInt(detallesFechaFin[0]);
                int mesFechaFin = Integer.parseInt(detallesFechaFin[1]);
                int añoFechaFin = Integer.parseInt(detallesFechaFin[2]);
                fundacaqueta.obtenerProyectos().get(id).modificarFechaFin(LocalDate.of(añoFechaFin, mesFechaFin, diasFechaFin));
            }
            parentAdmin.updateProjects();
            JOptionPane.showMessageDialog(this, "Proyecto modificado con éxito", "Exito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_bttnConfirmarActionPerformed

    private void revisarValorId(){
        if(ftxtId.getValue() != null){
            int id = Math.toIntExact((Long)ftxtId.getValue());
            id-=1;
            if(id < 0)
                JOptionPane.showMessageDialog(this, "El id no puede ser negativo o cero", "Id invalido", JOptionPane.ERROR_MESSAGE);
            else{
                if(id > fundacaqueta.obtenerProyectos().size()-1)
                    JOptionPane.showMessageDialog(this, "No existe esta cantidad de proyectos", "Id invalido", JOptionPane.ERROR_MESSAGE);
                if(fundacaqueta.obtenerProyectos().get(id) != null)
                    mostrarDetallesProyectoBuscado(id);
                else
                    JOptionPane.showMessageDialog(this, "El proyecto indicado no existe", "Proyecto no existe", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void mostrarDetallesProyectoBuscado(int id){
        txtNombre.setText(fundacaqueta.obtenerProyectos().get(id).obtenerNombre());
        txtLugarEjecucion.setText(fundacaqueta.obtenerProyectos().get(id).obtenerLugarEjecucion());
        if(fundacaqueta.obtenerProyectos().get(id).obtenerTipo().equals("Inversion social"))
            cmbTipo.setSelectedIndex(1);
        else
            cmbTipo.setSelectedIndex(0);
        
        if(fundacaqueta.obtenerProyectos().get(id).obtenerFechaFin()!=null)
            ftxtFechaFin.setText(fundacaqueta.obtenerProyectos().get(id).obtenerFechaFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BttnCancelar;
    private javax.swing.JButton bttnConfirmar;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JFormattedTextField ftxtFechaFin;
    private javax.swing.JFormattedTextField ftxtId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtLugarEjecucion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
