
package PaqueteInterfaz;

import java.util.ArrayList;


public class ExamenRadiologico extends javax.swing.JPanel {

    
  public ExamenRadiologico() {
    initComponents();
  }

  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  private void initComponents() {

    jButton1 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jPanel1 = new javax.swing.JPanel();

    setBackground(new java.awt.Color(245, 245, 245));
    setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(60, 60, 60), 1, true), "Examen radiológico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 18))); // NOI18N
    setMaximumSize(new java.awt.Dimension(754, 598));
    setMinimumSize(new java.awt.Dimension(754, 598));
    setPreferredSize(new java.awt.Dimension(754, 598));

    jButton1.setBackground(new java.awt.Color(51, 51, 255));
    jButton1.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setText("Agregar nueva radiografía");
    jButton1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
    jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
    jScrollPane1.setViewportView(jPanel1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(294, 294, 294)
        .addComponent(jButton1)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jButton1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1)
        .addContainerGap())
    );
  }// </editor-fold>                        

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    nuevoExamen();
   
  }     
  
  public void nuevoExamen(){
    radiografias.add(new PanelRadiografia());
    jPanel1.add(radiografias.get(cntRadiografia));
    cntRadiografia++;
    this.repaint();
    this.revalidate();
  }


  public int cntRadiografia = 0;
  public int cNuevos = 0;
  public ArrayList<PanelRadiografia> radiografias = new ArrayList<>();  
  public ArrayList<PanelRadiografia> nuevos = new ArrayList();
  private javax.swing.JButton jButton1;
  public javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration                   
}

