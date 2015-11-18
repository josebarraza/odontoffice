
package componentesGraficos;

import java.awt.Color;
import PaqueteInterfaz.DienteListener;
import PaqueteInterfaz.MainFrame;
import PaqueteInterfaz.Odontograma;
import PaqueteLogica.Operaciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;

public class Diente extends javax.swing.JPanel implements ActionListener{

  MainFrame m;
  Odontograma o;
  
  private String numero;
  public boolean vacio = true;
  public boolean ausente = false;
  public DienteListener pnlDientes;
  private Color colorActual;
  public DienteGrande dg;
  
  /*Variables nuevas*/
   String Sel [];
   boolean b=false;
   public ArrayList <String> lista = new ArrayList<String>();
  
  
  public JCheckBoxMenuItem checks [] ;
  public javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
  public javax.swing.JLabel jLabel1;
  private javax.swing.JMenuItem jMenuItemOtro;
  public javax.swing.JPopupMenu jPopupMenu1;
  private javax.swing.JPopupMenu.Separator jSeparator1;
  private javax.swing.JDialog jDialog;
  private javax.swing.JPanel jPanel;
  private javax.swing.JTextField jTxt;
  private javax.swing.JButton jButton;
  
  public Diente(MainFrame m,Odontograma o) {
     this.m=m;
     this.o=o;
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
  private void initComponents() {

    jPopupMenu1 = new javax.swing.JPopupMenu();
    jMenuItemOtro = new javax.swing.JMenuItem();
    jSeparator1 = new javax.swing.JPopupMenu.Separator();
    jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
    jLabel1 = new javax.swing.JLabel();
    jDialog = new javax.swing.JDialog();
          jDialog.setTitle("Agregar Nuevo Tratamiento");
          jDialog.setSize(250,150);
          jDialog.setModal(true);
          jDialog.setBackground(new Color(190,190,255));
          jDialog.setResizable(false);
          jDialog.setLocationRelativeTo(null);
          
          jPanel = new javax.swing.JPanel();
          jTxt = new javax.swing.JTextField(20);
          jButton = new javax.swing.JButton("Agregar");
          jButton.addActionListener(this);
          jPanel.add(jTxt);
          jPanel.add(jButton);
          jDialog.add(jPanel);
 
    jMenuItemOtro.setText("Otro");
    jMenuItemOtro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
          jDialog.setVisible(true);
          jTxt.setFocusable(true);  
      }
    });
    
   llena();
    

    jCheckBoxMenuItem1.setText("Ausente");
    jCheckBoxMenuItem1.setToolTipText("Selecciona si la pieza se encuentra ausente");
    jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jCheckBoxMenuItem1ActionPerformed(evt);
      }
    });
    

    setBackground(new java.awt.Color(255, 255, 255));
    setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
    setToolTipText("Utilice clic derecho para agregar un procedimiento en la pieza seleccionada");
    setMaximumSize(new java.awt.Dimension(32, 32));
    setMinimumSize(new java.awt.Dimension(32, 32));
    setPreferredSize(new java.awt.Dimension(32, 32));
    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        formMouseEntered(evt);
        
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        formMouseExited(evt);
      }
      public void mouseReleased(java.awt.event.MouseEvent evt) {
        formMouseReleased(evt);
      }
    });

    jLabel1.setBackground(new java.awt.Color(255, 100, 100));
    jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(51, 51, 51));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
    );
  }   

  public void llena(){
      
      int n = m.tam;
      String V [] = m.V;
      
      checks = new JCheckBoxMenuItem [ n ];
      for(int i=0;i<checks.length;i++){
          checks[i] = new JCheckBoxMenuItem();
          checks[i].addActionListener(this);
          checks[i].setText(""+V[i]);
          jPopupMenu1.add(checks[i]);
      }
     
      for(int i=0;i<checks.length;i++)
          for(int j=0;j<lista.size();j++)
              if(checks[i].getText().equals(lista.get(j)))
                  checks[i].setSelected(true);
 
      
      
    jPopupMenu1.add(jMenuItemOtro);
    jPopupMenu1.add(jSeparator1);
    jPopupMenu1.add(jCheckBoxMenuItem1);  
 
  }
  
  public void clear(){
      for(int i=0;i<checks.length+3;i++)
          jPopupMenu1.removeAll();
                  
  }
  
  private void formMouseReleased(java.awt.event.MouseEvent evt) {                                   
    if(evt.isPopupTrigger()) {
      jPopupMenu1.show(this,evt.getX(), evt.getY());
      
    }
    
  }                                  

  private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                                   
    if(jCheckBoxMenuItem1.isSelected()) {
      ausente = true;
      jLabel1.setForeground(Color.white);
      jLabel1.setOpaque(true);
      
    }
    else {
      ausente = false;
      jLabel1.setForeground(new Color(51,51,51));
      jLabel1.setIcon(null);
      jLabel1.setOpaque(false);
    }
    changeUpdate();
  }                                                  

  private void formMouseEntered(java.awt.event.MouseEvent evt) {                                  
    colorActual = this.getBackground();
    this.setBackground(new Color(190,190,255));
  }                                 

  private void formMouseExited(java.awt.event.MouseEvent evt) {                                 
    this.setBackground(colorActual);
  }                                
                                          
  public void setText(String text) {
    dg = new DienteGrande(text);
    jLabel1.setText(text);
  }
  
  public void changeUpdate() {
      //error de interfaz 
      
    dg.removeAll();
        if(!ausente)
        for(int i=0;i<checks.length;i++){
            if(checks[i].isSelected()){
                dg.addElement(checks[i].getText());
            } 
        }
        else
            dg.addElement("AUSENTE");
    colorUpdate();
    pnlDientes.updatePanelDientes();
  }
  
  public void colorUpdate() {
      if(!ausente)
      for(int i=0;i<checks.length;i++){
          if(checks[i].isSelected()){
              this.setBackground(new Color(150,255,150));
               vacio = false;
               break;
          }
          else{
              this.setBackground(Color.white);
              vacio = true;
          }
      }

  }

  public boolean isEmpty() {
    return vacio;
  }
  
  public void addListener(DienteListener dl) {
    pnlDientes = dl;
    
  }
  
  public void removeListener(){
      for(int i=0;i<checks.length;i++)
        checks[i].removeActionListener(this);
      jPopupMenu1.removeAll();
      
  }
  public void actualizaListener(){
      for(int i=0;i<checks.length;i++){
        checks[i].addActionListener(this);
        jPopupMenu1.add(checks[i]);
      }
      
  }
  

    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==jButton){
            if(!jTxt.getText().equals("")){
            
                /*todo este pedazo es nuevo*/
               // int  x = JOptionPane.showConfirmDialog(this,"Está seguro en agregar "+jTxt.getText());
               // if(x == JOptionPane.YES_OPTION)
                //{
                      new Operaciones().addTratamiento(jTxt.getText());
                      m.updateVar();
                      lista.add(jTxt.getText());
                      jTxt.setText("");
                      b=true;
                      
                      o.actualiza();
                      changeUpdate();
                      pnlDientes.validaDientes();
                      
                     
               // }
            
            }
                else
                    JOptionPane.showMessageDialog(m,"Llene el campo");
        }
        else{
            System.out.println("click");
            for(int i=0;i<lista.size();i++)
                lista.remove(i);
            for(int i=0;i<checks.length;i++)
                if(checks[i].isSelected())
                    lista.add(checks[i].getText());
            
            
            changeUpdate();
            pnlDientes.validaDientes();

        }
    }
}

