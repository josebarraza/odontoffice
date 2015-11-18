/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentesGraficos;

import PaqueteInterfaz.HojaEvolucion;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


public class panelActividades extends JPanel implements MouseListener{
    
    boolean b = false;
    Color c = new Color(255,255,255);
    public String t;
    HojaEvolucion h;
    public int n;
    
    public panelActividades(int n,HojaEvolucion h,String a,String b,String c,String t){
        jLabel1 = new javax.swing.JLabel(a);
        jLabel2 = new javax.swing.JLabel(b);
        jLabel3 = new javax.swing.JLabel(c);
        this.t = t;
        this.h = h;
        this.n=n;
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12));
        initComponents();
        addMouseListener(this);
        
    }
     private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
         jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        
        this.setBackground(new Color (255,255,255));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0,0), 1, true));
        setFont(new java.awt.Font("sansserif", 1, 12));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;

   
    public void mouseClicked(MouseEvent e) {
        h.b = false;
       
        try {
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            Date fe = f.parse(jLabel1.getText());
            h.jTextField1.setText(jLabel2.getText());
            h.jTextArea1.setText(t);
            h.jDateChooser1.setDate(fe);
            
            for (int i=0;i<h.comboCD.getItemCount();i++)
                if(h.comboCD.getItemAt(i).equals(jLabel3.getText())){
                    h.comboCD.setSelectedIndex(i);
                    break;
                }
            h.jFrame1.setVisible(true);
            h.actual = n;
        } catch (ParseException ex) {
            System.out.println(ex);
        }
    }

   
    public void mousePressed(MouseEvent e) {
      
    }
    public void mouseReleased(MouseEvent e) {
    
    }
    public void mouseEntered(MouseEvent e) {
       this.setBackground(new Color(190,190,255));
    }

    public void mouseExited(MouseEvent e) {
       this.setBackground(c);
    }
}
