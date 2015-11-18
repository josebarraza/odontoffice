package PaqueteInterfaz;

import javax.swing.*;
import java.util.ArrayList;
public class ExamenOral extends JPanel implements DienteListener{
    
    MainFrame m;
     public ExamenOral(MainFrame m) {
    this.m=m;
    initComponents();
    listeners();
  }
 @SuppressWarnings("unchecked")
  private void initComponents() {

    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    odontograma1 = new PaqueteInterfaz.Odontograma(m);
    jLabel1 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    panelDientes1 = new PaqueteInterfaz.PanelDientes();
    jPanel2 = new javax.swing.JPanel();
    jButton1 = new javax.swing.JButton();
    jScrollPane11 = new javax.swing.JScrollPane();
    jPanel3 = new javax.swing.JPanel();
    jTabbedPane2 = new javax.swing.JTabbedPane();
    jPanel4 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextArea2 = new javax.swing.JTextArea();
    jLabel14 = new javax.swing.JLabel();
    jPanel5 = new javax.swing.JPanel();
    jScrollPane3 = new javax.swing.JScrollPane();
    jTextArea3 = new javax.swing.JTextArea();
    jLabel15 = new javax.swing.JLabel();
    jPanel6 = new javax.swing.JPanel();
    jLabel16 = new javax.swing.JLabel();
    jScrollPane4 = new javax.swing.JScrollPane();
    jTextArea4 = new javax.swing.JTextArea();
    jPanel7 = new javax.swing.JPanel();
    jLabel17 = new javax.swing.JLabel();
    jScrollPane5 = new javax.swing.JScrollPane();
    jTextArea5 = new javax.swing.JTextArea();
    jPanel8 = new javax.swing.JPanel();
    jLabel18 = new javax.swing.JLabel();
    jScrollPane6 = new javax.swing.JScrollPane();
    jTextArea6 = new javax.swing.JTextArea();
    jPanel9 = new javax.swing.JPanel();
    jLabel19 = new javax.swing.JLabel();
    jScrollPane7 = new javax.swing.JScrollPane();
    jTextArea7 = new javax.swing.JTextArea();
    jPanel10 = new javax.swing.JPanel();
    jLabel20 = new javax.swing.JLabel();
    jScrollPane8 = new javax.swing.JScrollPane();
    jTextArea8 = new javax.swing.JTextArea();
    jPanel11 = new javax.swing.JPanel();
    jLabel21 = new javax.swing.JLabel();
    jScrollPane9 = new javax.swing.JScrollPane();
    jTextArea9 = new javax.swing.JTextArea();
    jPanel12 = new javax.swing.JPanel();
    jLabel22 = new javax.swing.JLabel();
    jScrollPane10 = new javax.swing.JScrollPane();
    jTextArea10 = new javax.swing.JTextArea();
    jPanel13 = new javax.swing.JPanel();
    jLabel13 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();

    setBackground(new java.awt.Color(255, 255, 255));
    setMaximumSize(new java.awt.Dimension(754, 598));
    setPreferredSize(new java.awt.Dimension(754, 598));

    jTabbedPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(90, 90, 90), 1, true), "Examen oral", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 18))); // NOI18N
    jTabbedPane1.setPreferredSize(new java.awt.Dimension(754, 598));

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setMinimumSize(new java.awt.Dimension(744, 598));
    jPanel1.setPreferredSize(new java.awt.Dimension(744, 598));

    jLabel1.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(66, 66, 66));
    jLabel1.setText("Haga clic derecho sobre una pieza para agregar un nuevo procedimiento");

    panelDientes1.setBackground(new java.awt.Color(255, 255, 255));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1)
        .addGap(190, 190, 190))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(panelDientes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(odontograma1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
          .addComponent(jSeparator1))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addGap(28, 28, 28)
        .addComponent(odontograma1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(panelDientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(17, 17, 17))
    );

    jTabbedPane1.addTab("Odontograma", jPanel1);

    jPanel2.setBackground(new java.awt.Color(240, 240, 240));

    jButton1.setBackground(new java.awt.Color(51, 51, 255));
    jButton1.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setText("+ Agregar nuevo Ã­ndice de higiene");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jPanel3.setBackground(new java.awt.Color(240, 240, 240));
    jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));
    jScrollPane11.setViewportView(jPanel3);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
          .addContainerGap()
          .addComponent(jButton1)
          .addContainerGap(553, Short.MAX_VALUE)))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap(26, Short.MAX_VALUE)
        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
      .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
          .addContainerGap()
          .addComponent(jButton1)
          .addContainerGap(505, Short.MAX_VALUE)))
    );

    jTabbedPane1.addTab("Ã�ndice de higiene", jPanel2);

    jTabbedPane2.setBackground(new java.awt.Color(73, 130, 212));
    jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
    jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
    jTabbedPane2.setOpaque(true);

    jPanel4.setBackground(new java.awt.Color(240, 240, 240));

    jTextArea2.setColumns(20);
    jTextArea2.setRows(5);
    jScrollPane2.setViewportView(jTextArea2);

    jLabel14.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel14.setText("Observaciones:");

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addComponent(jLabel14)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel14)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane2.addTab("TonificaciÃ³n muscular", jPanel4);

    jPanel5.setBackground(new java.awt.Color(240, 240, 240));

    jTextArea3.setColumns(20);
    jTextArea3.setRows(5);
    jScrollPane3.setViewportView(jTextArea3);

    jLabel15.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel15.setText("Observaciones:");

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
          .addGroup(jPanel5Layout.createSequentialGroup()
            .addComponent(jLabel15)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel15)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane2.addTab("Amigdalas", jPanel5);

    jPanel6.setBackground(new java.awt.Color(240, 240, 240));
    jPanel6.setPreferredSize(new java.awt.Dimension(800, 329));

    jLabel16.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel16.setText("Observaciones:");

    jTextArea4.setColumns(20);
    jTextArea4.setRows(5);
    jScrollPane4.setViewportView(jTextArea4);

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel6Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
          .addGroup(jPanel6Layout.createSequentialGroup()
            .addComponent(jLabel16)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel6Layout.setVerticalGroup(
      jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel16)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane2.addTab("Encia", jPanel6);

    jPanel7.setBackground(new java.awt.Color(240, 240, 240));

    jLabel17.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel17.setText("Observaciones:");

    jTextArea5.setColumns(20);
    jTextArea5.setRows(5);
    jScrollPane5.setViewportView(jTextArea5);

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel7Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
          .addGroup(jPanel7Layout.createSequentialGroup()
            .addComponent(jLabel17)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel7Layout.setVerticalGroup(
      jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel17)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane2.addTab("Carrillos", jPanel7);

    jPanel8.setBackground(new java.awt.Color(240, 240, 240));

    jLabel18.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel18.setText("Observaciones:");

    jTextArea6.setColumns(20);
    jTextArea6.setRows(5);
    jScrollPane6.setViewportView(jTextArea6);

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel8Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
          .addGroup(jPanel8Layout.createSequentialGroup()
            .addComponent(jLabel18)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel8Layout.setVerticalGroup(
      jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel18)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane2.addTab("Suelo de la boca", jPanel8);

    jPanel9.setBackground(new java.awt.Color(240, 240, 240));

    jLabel19.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel19.setText("Observaciones:");

    jTextArea7.setColumns(20);
    jTextArea7.setRows(5);
    jScrollPane7.setViewportView(jTextArea7);

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel9Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
          .addGroup(jPanel9Layout.createSequentialGroup()
            .addComponent(jLabel19)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel9Layout.setVerticalGroup(
      jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel19)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane2.addTab("Lengua", jPanel9);

    jPanel10.setBackground(new java.awt.Color(240, 240, 240));

    jLabel20.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel20.setText("Observaciones:");

    jTextArea8.setColumns(20);
    jTextArea8.setRows(5);
    jScrollPane8.setViewportView(jTextArea8);

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel10Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
          .addGroup(jPanel10Layout.createSequentialGroup()
            .addComponent(jLabel20)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel10Layout.setVerticalGroup(
      jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel20)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane2.addTab("Paladar duro y blando", jPanel10);

    jPanel11.setBackground(new java.awt.Color(240, 240, 240));

    jLabel21.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel21.setText("Observaciones:");

    jTextArea9.setColumns(20);
    jTextArea9.setRows(5);
    jScrollPane9.setViewportView(jTextArea9);

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
      jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel11Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
          .addGroup(jPanel11Layout.createSequentialGroup()
            .addComponent(jLabel21)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel11Layout.setVerticalGroup(
      jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel21)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane2.addTab("Frenillos", jPanel11);

    jPanel12.setBackground(new java.awt.Color(240, 240, 240));

    jLabel22.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel22.setText("Observaciones:");

    jTextArea10.setColumns(20);
    jTextArea10.setRows(5);
    jScrollPane10.setViewportView(jTextArea10);

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
      jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel12Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
          .addGroup(jPanel12Layout.createSequentialGroup()
            .addComponent(jLabel22)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel12Layout.setVerticalGroup(
      jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addComponent(jLabel22)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane2.addTab("Otros", jPanel12);

    jTabbedPane1.addTab("Observaciones", jTabbedPane2);

    jPanel13.setBackground(new java.awt.Color(240, 240, 240));

    jLabel13.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
    jLabel13.setText("Traumatismos (tiempo-lugar-diente)");

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane1.setViewportView(jTextArea1);

    javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
    jPanel13.setLayout(jPanel13Layout);
    jPanel13Layout.setHorizontalGroup(
      jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel13Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
          .addGroup(jPanel13Layout.createSequentialGroup()
            .addComponent(jLabel13)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel13Layout.setVerticalGroup(
      jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel13Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel13)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        .addContainerGap())
    );

    jTabbedPane1.addTab("Traumatismos", jPanel13);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
  }// </editor-fold>//GEN-END:initComponents
 
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    nuevoIndice();
  }   
  
  public void nuevoIndice(){
    IndiceHigiene ih = new IndiceHigiene();
    indice.add(cntIndice, ih);
    jPanel3.add(indice.get(cntIndice));
    cntIndice++;
    revalidate();
    repaint();
  }

  public int cntIndice = 0;
  public ArrayList<IndiceHigiene> indice = new ArrayList<>();               
  public javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel18;
  private javax.swing.JLabel jLabel19;
  private javax.swing.JLabel jLabel20;
  private javax.swing.JLabel jLabel21;
  private javax.swing.JLabel jLabel22;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel10;
  private javax.swing.JPanel jPanel11;
  private javax.swing.JPanel jPanel12;
  private javax.swing.JPanel jPanel13;
  private javax.swing.JPanel jPanel2;
  public javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JPanel jPanel6;
  private javax.swing.JPanel jPanel7;
  private javax.swing.JPanel jPanel8;
  private javax.swing.JPanel jPanel9;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane10;
  private javax.swing.JScrollPane jScrollPane11;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  private javax.swing.JScrollPane jScrollPane6;
  private javax.swing.JScrollPane jScrollPane7;
  private javax.swing.JScrollPane jScrollPane8;
  private javax.swing.JScrollPane jScrollPane9;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTabbedPane jTabbedPane2;
  public javax.swing.JTextArea jTextArea1;
  public javax.swing.JTextArea jTextArea10;
  public javax.swing.JTextArea jTextArea2;
  public javax.swing.JTextArea jTextArea3;
  public javax.swing.JTextArea jTextArea4;
  public javax.swing.JTextArea jTextArea5;
  public javax.swing.JTextArea jTextArea6;
  public javax.swing.JTextArea jTextArea7;
  public javax.swing.JTextArea jTextArea8;
  public javax.swing.JTextArea jTextArea9;
  public PaqueteInterfaz.Odontograma odontograma1;
  public PaqueteInterfaz.PanelDientes panelDientes1;
  
 
   public void updatePanelDientes() {
    panelDientes1.removeDientes();
    
    for(int i =0;i<16;i++){
        
        if(!odontograma1.dienteV1[i].isEmpty() || odontograma1.dienteV1[i].ausente )
            panelDientes1.addDiente(odontograma1.dienteV1[i].dg );
        if(!odontograma1.dienteV4[i].isEmpty() || odontograma1.dienteV4[i].ausente )
            panelDientes1.addDiente(odontograma1.dienteV4[i].dg);
       
    }
    for(int i =0;i<10;i++){
        
        if(!odontograma1.dienteV2[i].isEmpty() || odontograma1.dienteV2[i].ausente)
            panelDientes1.addDiente(odontograma1.dienteV2[i].dg);
        if(!odontograma1.dienteV3[i].isEmpty() || odontograma1.dienteV3[i].ausente )
            panelDientes1.addDiente(odontograma1.dienteV3[i].dg);
    }
    

    this.repaint();
    this.revalidate();
  }
  
  private void listeners() {
        for(int i=0;i<16;i++)
      {
           odontograma1.dienteV1[i].addListener(this);
           odontograma1.dienteV4[i].addListener(this);
      }
         for(int i=0;i<10;i++)
      {
           odontograma1.dienteV2[i].addListener((DienteListener) this);
           odontograma1.dienteV3[i].addListener((DienteListener) this);
      }
   }
  
  public void validaDientes(){
      
      for(int i=0;i<10;i++){
          if(!odontograma1.dienteV1[i+3].isEmpty() )
              odontograma1.dienteV2[i].removeListener();
          else{
              odontograma1.dienteV2[i].clear();
              odontograma1.dienteV2[i].llena();
          }
          if(!odontograma1.dienteV2[i].isEmpty() )
              odontograma1.dienteV1[i+3].removeListener();
          else{
              odontograma1.dienteV1[i+3].clear();
              odontograma1.dienteV1[i+3].llena();
          }
          
          //
          if(!odontograma1.dienteV4[i+3].isEmpty() )
              odontograma1.dienteV3[i].removeListener();
          else{
              odontograma1.dienteV3[i].clear();
              odontograma1.dienteV3[i].llena();
          }
          if(!odontograma1.dienteV3[i].isEmpty() )
              odontograma1.dienteV4[i+3].removeListener();
          else{
              odontograma1.dienteV4[i+3].clear();
              odontograma1.dienteV4[i+3].llena();
          }
          
      
      
      }
      
  }

    public void agregaIndice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    


}
