
package PaqueteInterfaz;


import BUSQUEDA.Buscar;
import PaqueteLogica.Operaciones;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.event.*;



public class MainFrame extends JFrame implements MouseListener , ActionListener{
  
 

    public int tam ; 
    public String[] V ;

  public MainFrame() {
    initComponents();
    setLocationRelativeTo(null);
    loadIcons();
    escuchas();
    updateVar();
  }
  
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnImagen1 = new componentesGraficos.BtnImagen();
        btnImagen3 = new componentesGraficos.BtnImagen();
        btnImagen2 = new componentesGraficos.BtnImagen();
        btnImagen4 = new componentesGraficos.BtnImagen();
        btnImagen5 = new componentesGraficos.BtnImagen();
        btnImagen6 = new componentesGraficos.BtnImagen();
        pnl_contenedor = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OdontOffice");
        setBackground(new java.awt.Color(223, 223, 223));
        setPreferredSize(new java.awt.Dimension(1000, 700));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(70, 120, 200));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario X");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Cerrar sesión");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
       

        btnImagen1.setToolTipText("Crear una nueva historia clínica");
        

        btnImagen3.setToolTipText("Buscar una historia clínica existente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImagen6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImagen5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImagen6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImagen5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImagen4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImagen2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImagen3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnl_contenedor.setBackground(new java.awt.Color(238, 238, 238));
        pnl_contenedor.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(217, 217, 217));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dienteFondo.jpg"))); // NOI18N
        jLabel3.setText("OdontOffice");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        pnl_contenedor.add(jLabel3, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Archivo");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Nuevo");
       
        jMenu1.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Guardar");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Guardar como...");
        jMenu1.add(jMenuItem5);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Buscar");
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Salir");
        
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Edición");

        jMenuItem6.setText("Preferencias");
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Ayuda");

        jMenu4.setText("Acerca de...");
        jMenu2.add(jMenu4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnl_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 503, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(75, 75, 75)
                    .addComponent(pnl_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        pack();
    }// </editor-fold>                        

    public void escuchas(){
        btnImagen6.addMouseListener(this);
        btnImagen5.addMouseListener(this);
        btnImagen1.addMouseListener(this);
        btnImagen3.addMouseListener(this);
        jLabel1.addMouseListener(this);
        jMenuItem1.addActionListener(this);
        jMenuItem2.addActionListener(this);
    }
  private void formComponentShown(java.awt.event.ComponentEvent evt) {                                    
    exp = new Expediente(this);
  }                                   
  public final void loadIcons() {
    btnImagen1.lblIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/new_file.png")));
    btnImagen1.lblText("Nueva");
    
    btnImagen2.lblIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/agenda.png")));
    btnImagen2.lblText("Agenda");
    
    btnImagen3.lblIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/search.png")));
    btnImagen3.lblText("Buscar");
    
    btnImagen4.lblIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/backup.png")));
    btnImagen4.lblText("Respaldo");
    
    btnImagen5.lblIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/config.png")));
    btnImagen5.lblText("Configuración");
    
    btnImagen6.lblIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/save.png")));
    btnImagen6.lblText("Guardar");
  }
  
    public Expediente exp = new Expediente(this);
    public config configuraciones = new config(this);
    public Buscar bus ;
    public boolean ft = true;
    public boolean sesion = false;                  
    private componentesGraficos.BtnImagen btnImagen1;
    private componentesGraficos.BtnImagen btnImagen2;
    private componentesGraficos.BtnImagen btnImagen3;
    private componentesGraficos.BtnImagen btnImagen4;
    private componentesGraficos.BtnImagen btnImagen5;
    private componentesGraficos.BtnImagen btnImagen6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    public javax.swing.JPanel pnl_contenedor;
                     

    public int traeTamano(){
        
        return new Operaciones().tamanoTratamientos();
    }
    public String[] traeTrata(int n){
        return  new Operaciones().traeTratamientos(n);
    } 
    public void updateVar(){
        
        tam = traeTamano();
        V = traeTrata(tam);
    }
    public void actionPerformed(ActionEvent e) {
         
         if(e.getSource()== jMenuItem1)                                         
             System.exit(0);
         if(e.getSource() == jMenuItem2){
              pnl_contenedor.removeAll();
              pnl_contenedor.add(new Expediente(this));
              this.revalidate(); 
         }
  }                                          
    public void mouseClicked(MouseEvent e) {
        
            //Guardar
           if(e.getSource() == btnImagen6){
              new Operaciones().guardar(this);
           }
           
           //Nueva
           if(e.getSource() == btnImagen1){
               sesion=true;
               pnl_contenedor.removeAll();
               repaint();
               validate();
                ft=false;
            if(!ft) {
                 exp = null;
                 exp = new Expediente(this);
             }
                 pnl_contenedor.add(exp);
                 this.revalidate();
                  ft = false;
           }
           //Buscar
           if(e.getSource() == btnImagen3){
                   pnl_contenedor.setLayout(new BorderLayout());
                   bus = new Buscar(this);
                   pnl_contenedor.removeAll();
                   pnl_contenedor.add(bus);
                   this.exp.he.paneles.clear();
                   this.revalidate();
                   repaint();
           }
           //Configuraciones
           if(e.getSource()== btnImagen5){
           pnl_contenedor.removeAll();
           pnl_contenedor.add(configuraciones);
           repaint();
           this.revalidate();
           
           }

           //Tachita de Cerrar
           if(e.getSource() == jLabel1){
                dispose();
                  new LoginFrame().setVisible(true);
           }

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
