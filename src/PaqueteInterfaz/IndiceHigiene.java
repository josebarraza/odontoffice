/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteInterfaz;

import componentesGraficos.boton;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IndiceHigiene extends javax.swing.JPanel implements MouseListener {


  public IndiceHigiene() {
        
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  private void initComponents() {
      b1 = new boton [14];
      b2 = new boton [14];
      b3 = new boton [14];
      b4 = new boton [14];
      for(int i=0;i<14;i++){
          b1[i] = new boton(i+1,1);
          b1[i].addMouseListener(this);
          b1[i].setSize(73, 23);
          b2[i] = new boton(i+1,2);
          b2[i].addMouseListener(this);
          b2[i].setSize(73, 23);
          b3[i] = new boton(i+1,3);
          b3[i].addMouseListener(this);
          b3[i].setSize(73, 23);
          b4[i] = new boton(i+1,4);
          b4[i].addMouseListener(this);
          b4[i].setSize(73, 23);
      }
    jTable1 = new javax.swing.JTable();
    jLabel2 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField("0.00");
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jTextField2 = new javax.swing.JTextField("0.00");
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    jTextField3 = new javax.swing.JTextField("0.00");
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jTextField4 = new javax.swing.JTextField("0.00");
    jLabel9 = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jTextField5 = new javax.swing.JTextField("0.00");
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jDateChooser1 = new com.toedter.calendar.JDateChooser();
    jTextField1.setEditable(false);
    jTextField2.setEditable(false);
    jTextField3.setEditable(false);
    jTextField4.setEditable(false);
    jTextField5.setEditable(false);
    panel.setLayout(new GridLayout(8,15));
    panel.setBackground(new Color(255,255,255));
    panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    
    panel.add(new JLabel(""));
    panel.add(new JLabel(""));
    panel.add(new JLabel(""));
    panel.add(new JLabel("    55"));
    panel.add(new JLabel("    54"));
    panel.add(new JLabel("    53"));
    panel.add(new JLabel("    52"));
    panel.add(new JLabel("    51"));
    panel.add(new JLabel("    61"));
    panel.add(new JLabel("    62"));
    panel.add(new JLabel("    63"));
    panel.add(new JLabel("    64"));
    panel.add(new JLabel("    65"));
    panel.add(new JLabel(""));
    panel.add(new JLabel(""));
    //---
     panel.add(new JLabel(""));
    panel.add(new JLabel("    17"));
    panel.add(new JLabel("    16"));
    panel.add(new JLabel("    15"));
    panel.add(new JLabel("    14"));
    panel.add(new JLabel(   "    13"));
    panel.add(new JLabel("    12"));
    panel.add(new JLabel("    11"));
    panel.add(new JLabel("    21"));
    panel.add(new JLabel("    22"));
    panel.add(new JLabel("    23"));
    panel.add(new JLabel("    24"));
    panel.add(new JLabel("    25"));
    panel.add(new JLabel("    26"));
    panel.add(new JLabel("    27"));
    //
    panel.add(new JLabel("       VS"));
    for(int i=0;i<14;i++)
        panel.add(b1[i]);
     //
    panel.add(new JLabel("       P"));
    for(int i=0;i<14;i++)
        panel.add(b2[i]);
     //
    panel.add(new JLabel("       L"));
    for(int i=0;i<14;i++)
        panel.add(b3[i]);
     //
    panel.add(new JLabel("       VI"));
    for(int i=0;i<14;i++)
        panel.add(b4[i]);
    //---
     panel.add(new JLabel(""));
    panel.add(new JLabel("    47"));
    panel.add(new JLabel("    46"));
    panel.add(new JLabel("    45"));
    panel.add(new JLabel("    44"));
    panel.add(new JLabel("    43"));
    panel.add(new JLabel("    42"));
    panel.add(new JLabel("    41"));
    panel.add(new JLabel("    31"));
    panel.add(new JLabel("    32"));
    panel.add(new JLabel("    33"));
    panel.add(new JLabel("    34"));
    panel.add(new JLabel("    35"));
    panel.add(new JLabel("    36"));
    panel.add(new JLabel( "    37"));
    //
    panel.add(new JLabel(""));
    panel.add(new JLabel(""));
    panel.add(new JLabel(""));
    panel.add(new JLabel("    85"));
    panel.add(new JLabel("    84"));
    panel.add(new JLabel("    83"));
    panel.add(new JLabel("    82"));
    panel.add(new JLabel("    81"));
    panel.add(new JLabel("    71"));
    panel.add(new JLabel("    72"));
    panel.add(new JLabel("    73"));
    panel.add(new JLabel("    74"));
    panel.add(new JLabel("    75"));
    panel.add(new JLabel(""));
    panel.add(new JLabel(""));
    
    
    
    

    setBackground(new java.awt.Color(230, 230, 230));
    setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));

    jLabel2.setText("Vestibular superior");

    jLabel3.setText("%");

    jLabel4.setText("Vestibular inferior");

    jLabel5.setText("%");

    jLabel6.setText("Palatino");

    jLabel7.setText("%");

    jLabel8.setText("Lingual");

    jLabel9.setText("%");

    jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel10.setText("Total");

    jLabel11.setText("%");

    jLabel12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel12.setText("Fecha");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(49, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
              .addComponent(jLabel12)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel6))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)))))
        .addContainerGap(49, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3)
          .addComponent(jLabel6)
          .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel7))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5)
          .addComponent(jLabel8)
          .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel9)
          .addComponent(jLabel10)
          .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel11))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>                        
  public boton [] b1;
  public boton [] b2;
  public boton [] b3;
  public boton [] b4;
  public com.toedter.calendar.JDateChooser jDateChooser1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JTable jTable1;
  public javax.swing.JTextField jTextField1;
  public  javax.swing.JTextField jTextField2;
  public  javax.swing.JTextField jTextField3;
 public  javax.swing.JTextField jTextField4;
  public javax.swing.JTextField jTextField5;
  public JPanel panel = new JPanel();
                   

 
  
    public void mouseClicked(MouseEvent e) {
        double VS=0,P=0,L=0,VI=0,T=0;
        double v1,p,l,v2,t;
        for(int i=0;i<14;i++){
            if(b1[i].b)
                VS++;
            if(b2[i].b)
                P++;
            if(b3[i].b)
                L++;
            if(b4[i].b)
                VI++;
        }
        T = VS+VI+P+L;
        double div = 100.00/14.00;
        double div2 = 100.00/56.00;
        v1 =  (div*VS);
        p = (div*P);
        l =  (div*L);
        v2 = (div*VI);
        t = (div2*T);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField1.setText((v1+"00").substring(0,5));
        jTextField3.setText((p+"00").substring(0,5));
        jTextField4.setText((l+"00").substring(0,5));
        jTextField2.setText((v2+"00").substring(0,5));
        jTextField5.setText((t+"00").substring(0,5));
    }
    public void mousePressed(MouseEvent e) {   
    }
    public void mouseReleased(MouseEvent e) {   
    }
    public void mouseEntered(MouseEvent e) {
         
    }
    public void mouseExited(MouseEvent e) {
    }
}

