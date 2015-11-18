/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSQUEDA;

import PaqueteLogica.Clase_Conexion;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.JPanel;

/**
 *
 * @author LUPITHAG
 */
public class SearchTextBox extends javax.swing.JPanel implements KeyListener,ActionListener{
    /**
     * Creates new form SearchTextBox
     */
    public String text;
    public Clase_Conexion c;
    public SearchTable p;
    
    public SearchTextBox() {
        initComponents();
        setListeners();
        c=new Clase_Conexion("localhost", "odontoffice", "postgres","POSTGRES");      
    }
    
    public SearchTextBox(SearchTable p) {
        initComponents();
        setListeners();
        this.p=p;
        c=new Clase_Conexion("localhost", "odontoffice", "postgres","POSTGRES");      
    }
    
    public void setListeners(){
        jTextField1.addKeyListener(this);
     
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setName("SearchBox"); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Search");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText(" *Pacientes, Telefonos , Fechas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(184, 184, 184))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
           
    }
        
    @Override
    public void keyReleased(KeyEvent e) {
       text=jTextField1.getText();
       String condicion;
       ResultSet r;
      
                condicion="WHERE person.nombre ILIKE '%"+text+"%' "
                   + "OR person.apellido ILIKE '%"+text+"%' "
                  // + "OR person.fechaNacimiento ILIKE '%"+text+"%' "
                   + "OR person.telefono ILIKE '%"+text+"%'";
                  // + "OR px.fechaInsert ILIKE '%"+text+"%'";
      
               
           
        r=new events().filterSearch(condicion);
        p.addToPanel(r);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        
    }
}
