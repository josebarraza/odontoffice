
package PaqueteInterfaz;

import java.awt.Color;
import javax.swing.JScrollPane;


public class Expediente extends javax.swing.JPanel {

    MainFrame m;
     public Antecedentes a = null;
   public ExamenOral eo = null;
   public Planos_Relacion pt = null;
   public ExamenRadiologico er = null;
   public ExamenLaboratorio el = null;
   public HojaEvolucion he = null;
   
  public Expediente(MainFrame m) {
      this.m=m;
    initComponents();
    loadButtons();
    a = new Antecedentes();
    jPanelContenido.add(a);
    revalidate();
    eo = new ExamenOral(m);
    pt = new Planos_Relacion();
    er = new ExamenRadiologico();
    he = new HojaEvolucion();
    el = new ExamenLaboratorio();
    jScrollPane2 = new JScrollPane(he);
    
  }
  
  public final void loadButtons() {
    btnTexto1.lblText("  Antecedentes");
    btnTexto1.pnlColor(new Color(70,120,200));
    btnTexto2.lblText("  Examen oral");
    btnTexto2.pnlColor(new Color(70,120,200));
    btnTexto3.lblText("  Planos ter. & Relación molar");
    btnTexto3.pnlColor(new Color(70,120,200));
    btnTexto5.lblText("  Examen radiológico");
    btnTexto5.pnlColor(new Color(70,120,200));
    btnTexto6.lblText("  Examen de laboratorio");
    btnTexto6.pnlColor(new Color(70,120,200));

    btnTexto7.lblText("  Hoja de Evolución");
    btnTexto7.pnlColor(new Color(70,120,200));
  }

  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  private void initComponents() {

    jPanelMenu = new javax.swing.JPanel();
    btnTexto1 = new componentesGraficos.BtnTexto();
    btnTexto2 = new componentesGraficos.BtnTexto();
    btnTexto3 = new componentesGraficos.BtnTexto();
    jLabel1 = new javax.swing.JLabel();
    btnTexto5 = new componentesGraficos.BtnTexto();
    btnTexto6 = new componentesGraficos.BtnTexto();
    btnTexto7 = new componentesGraficos.BtnTexto();
    jScrollPane1 = new javax.swing.JScrollPane();
    jPanelContenido = new javax.swing.JPanel();

    jPanelMenu.setBackground(new java.awt.Color(255, 255, 102));

    btnTexto1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnTexto1MouseClicked(evt);
      }
    });

    btnTexto2.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnTexto2MouseClicked(evt);
      }
    });

    btnTexto3.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnTexto3MouseClicked(evt);
      }
    });

    jLabel1.setBackground(new java.awt.Color(20, 20, 20));
    jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(230, 230, 230));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("OdontOffice");
    jLabel1.setOpaque(true);

    btnTexto5.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnTexto5MouseClicked(evt);
      }
    });

    btnTexto6.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnTexto6MouseClicked(evt);
      }
    });

    btnTexto7.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        btnTexto7MouseClicked(evt);
      }
    });

    javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
    jPanelMenu.setLayout(jPanelMenuLayout);
    jPanelMenuLayout.setHorizontalGroup(
      jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(btnTexto1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(btnTexto3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(btnTexto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
      .addComponent(btnTexto5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(btnTexto6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(btnTexto7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanelMenuLayout.setVerticalGroup(
      jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelMenuLayout.createSequentialGroup()
        .addGap(17, 17, 17)
        .addComponent(btnTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnTexto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnTexto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnTexto5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnTexto6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(btnTexto7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    jPanelContenido.setBackground(new java.awt.Color(255, 255, 255));
    jScrollPane1.setViewportView(jPanelContenido);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jScrollPane1)
    );
  }// </editor-fold>                        

  private void btnTexto1MouseClicked(java.awt.event.MouseEvent evt) {                                       
    jPanelContenido.removeAll();
    jPanelContenido.add(a);
    repaint();
    revalidate();
  }                                      

  private void btnTexto2MouseClicked(java.awt.event.MouseEvent evt) {                                       
    jPanelContenido.removeAll();
    jPanelContenido.add(eo);
    repaint();
    revalidate();
  }                                      

  private void btnTexto3MouseClicked(java.awt.event.MouseEvent evt) {                                       
    jPanelContenido.removeAll();
    
    jPanelContenido.add(pt);
    repaint();
    revalidate();
  }                                      

  private void btnTexto5MouseClicked(java.awt.event.MouseEvent evt) {                                       
    jPanelContenido.removeAll();
    
    jPanelContenido.add(er);
    repaint();
    revalidate();
  }                                      

  private void btnTexto6MouseClicked(java.awt.event.MouseEvent evt) {                                       
    jPanelContenido.removeAll();
    
    jPanelContenido.add(el);
    repaint();
    revalidate();
  }                                      

  private void btnTexto7MouseClicked(java.awt.event.MouseEvent evt) {                                       
    jPanelContenido.removeAll();
   
    jPanelContenido.add(he);
    repaint();
    revalidate();       
  }   
  
                       
  private componentesGraficos.BtnTexto btnTexto1;
  private componentesGraficos.BtnTexto btnTexto2;
  private componentesGraficos.BtnTexto btnTexto3;
  private componentesGraficos.BtnTexto btnTexto5;
  private componentesGraficos.BtnTexto btnTexto6;
  private componentesGraficos.BtnTexto btnTexto7;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanelContenido;
  private javax.swing.JPanel jPanelMenu;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  // End of variables declaration                   
}

