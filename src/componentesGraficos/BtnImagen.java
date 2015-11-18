
package componentesGraficos;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;


public class BtnImagen extends javax.swing.JPanel {

  
  public BtnImagen() {
    initComponents();
    
  }
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();

    setBackground(new java.awt.Color(70, 120, 200));
    setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    setMaximumSize(new java.awt.Dimension(100, 62));
    setMinimumSize(new java.awt.Dimension(62, 62));
    setPreferredSize(new java.awt.Dimension(62, 62));
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        formMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        formMouseExited(evt);
      }
    });

    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/photo.png"))); // NOI18N
    jLabel1.setPreferredSize(new java.awt.Dimension(48, 32));
    jLabel1.setRequestFocusEnabled(false);
    add(jLabel1);

    jLabel2.setForeground(new java.awt.Color(255, 255, 255));
    jLabel2.setText("icoName");
    add(jLabel2);
  }// </editor-fold>//GEN-END:initComponents

  private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
    this.setBackground(new Color(103,160,212));
  }//GEN-LAST:event_formMouseEntered

  private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
    this.setBackground(this.getParent().getBackground());
  }//GEN-LAST:event_formMouseExited

  public void lblIcon(ImageIcon i) {
    this.jLabel1.setIcon(i);
  }
  
  public void lblText(String t) {
    this.jLabel2.setText(t);
  }
  
  public void pnlColor(Color c) {
    this.setBackground(c);
  }
  

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  // End of variables declaration//GEN-END:variables

    
   

  
   
}
