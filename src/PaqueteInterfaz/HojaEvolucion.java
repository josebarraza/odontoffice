
package PaqueteInterfaz;


import PaqueteLogica.Operaciones;
import componentesGraficos.miPanel;
import componentesGraficos.panelActividades;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class HojaEvolucion extends javax.swing.JPanel {

    public String fecha,titulo,cd,tratamiento;
    public boolean b = true;
    public ArrayList<panelActividades> paneles = new ArrayList();
    public int actual;
    
  public HojaEvolucion() {
    initComponents();
    jFrame1.setLocationRelativeTo(null);
    jFrame1.setVisible(false);
    jDateChooser1.setDate(new Date());

  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  private void initComponents() {

    jFrame1 = new javax.swing.JFrame();
    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jDateChooser1 = new com.toedter.calendar.JDateChooser();
    jLabel2 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jScrollPane2 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jLabel3 = new javax.swing.JLabel();
    jButton2 = new javax.swing.JButton();
    jLabel4 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    
    comboCD = new Operaciones().llenaCombo();

    jFrame1.setMaximumSize(new java.awt.Dimension(358, 350));
    jFrame1.setMinimumSize(new java.awt.Dimension(358, 350));
    jFrame1.setPreferredSize(new java.awt.Dimension(358, 350));

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setText("Fecha");

    jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel2.setText("Título");

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.setBorder(null);
    jScrollPane2.setViewportView(jTextArea1);

    jLabel3.setText("C.D.");

    jButton2.setBackground(new java.awt.Color(51, 51, 255));
    jButton2.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
    jButton2.setForeground(new java.awt.Color(255, 255, 255));
    jButton2.setText("Guardar");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jLabel4.setText("Tratamiento");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jButton2))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(comboCD))))
              .addComponent(jLabel4))
            .addGap(0, 6, Short.MAX_VALUE)))
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(comboCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jButton2)
        .addContainerGap(35, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
    jFrame1.getContentPane().setLayout(jFrame1Layout);
    jFrame1Layout.setHorizontalGroup(
      jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jFrame1Layout.setVerticalGroup(
      jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    setBackground(new java.awt.Color(255, 255, 255));
    setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(60, 60, 60), 1, true), "Hoja de evolución", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("sansserif", 1, 18))); // NOI18N
    setPreferredSize(new java.awt.Dimension(754, 598));

    

    /*Tabla*/
    
    
    
    
    jp  = new JScrollPane(this);

    jButton1.setBackground(new java.awt.Color(51, 51, 255));
    jButton1.setFont(new java.awt.Font("sansserif", 1, 10)); // NOI18N
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setText("Agregar nuevo tratamiento");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    contenido = new JPanel();
    contenido.setLayout(new GridLayout(1000,0,0,5));
    contenido.setBackground(Color.white);
    add(jButton1);
    add(new miPanel());
    add(contenido);

  }                        

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {   
    jDateChooser1.setDate(new Date());
    jTextField1.setText("");
    jTextArea1.setText("");
    comboCD.setSelectedIndex(0);
    jFrame1.setVisible(true);
    b=true;
    
  }                                        

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    String fecha = DATE_FORMAT.format(jDateChooser1.getDate());
    String titulo = jTextField1.getText();
    String cd = comboCD.getSelectedItem().toString();                                                //!!!!
    String tratamiento = jTextArea1.getText().replaceAll("/n"," ");

    jFrame1.setVisible(false);
    jDateChooser1.setDate(new Date());
    jTextField1.setText("");
    jTextArea1.setText("");
    comboCD.setSelectedIndex(0);
    if(b){
        int n = paneles.size();
        paneles.add(new panelActividades(n,this,fecha,titulo,cd,tratamiento));
        contenido.add(paneles.get(paneles.size()-1));
    }
    else{
        paneles.get(actual).jLabel1.setText(fecha);
        paneles.get(actual).jLabel2.setText(titulo);
        paneles.get(actual).jLabel3.setText(cd);
        paneles.get(actual).t = tratamiento;
    }
    this.repaint();
    this.revalidate();
  }                                        
                 
  public  javax.swing.JButton jButton1;
  public  javax.swing.JButton jButton2;
  public com.toedter.calendar.JDateChooser jDateChooser1;
  public javax.swing.JFrame jFrame1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane2;
  public  javax.swing.JTextArea jTextArea1;
  public  javax.swing.JTextField jTextField1;
  public javax.swing.JComboBox comboCD;
  JScrollPane jp;
  public JPanel contenido;

   
 
                    
}

