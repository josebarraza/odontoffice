/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteInterfaz;

import java.awt.Component;

/**
 *
 * @author Jorge Petris
 */
public class PanelDientes extends javax.swing.JPanel {

  /**
   * Creates new form PanelDientes
   */
  public PanelDientes() {
    initComponents();
  }
  
  public void addDiente(Component obj) {
    jPanel15.add(obj);
  }
  
  public void removeDientes() {
    jPanel15.removeAll();
  }

 
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  private void initComponents() {

    jScrollPane12 = new javax.swing.JScrollPane();
    jPanel15 = new javax.swing.JPanel();

    setMinimumSize(new java.awt.Dimension(692, 281));
    setPreferredSize(new java.awt.Dimension(692, 281));

    jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    jScrollPane12.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

    jPanel15.setBackground(new java.awt.Color(255, 255, 255));
    jScrollPane12.setViewportView(jPanel15);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 692, Short.MAX_VALUE)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addContainerGap()
          .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
          .addContainerGap()))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 281, Short.MAX_VALUE)
      .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(15, 15, 15)
          .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
          .addGap(16, 16, 16)))
    );
  }// </editor-fold>                        


  // Variables declaration - do not modify                     
  private javax.swing.JPanel jPanel15;
  private javax.swing.JScrollPane jScrollPane12;
  // End of variables declaration                   
}

