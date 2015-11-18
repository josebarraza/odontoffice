package PaqueteLogica;
import PaqueteInterfaz.*;
import componentesGraficos.panelActividades;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Operaciones {
    public Clase_Conexion c;
    MainFrame mf;
    SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-yyyy");
    boolean nuevo;
    int caso = 0;
    int perfil = -1;
      //Tabla personas
      String n,a,t,fnac,e,em,s;
      Date fecha;
      int idPersona;
      //Tabla signos_vitales
      String talla,peso,temp;
      String presion ="", respiracion = "" , pulso="";
      //Tabla antecedentes familiares
      int personasCasa;
      String tipoCasa,deporte,alimentacion,mascota,riesgo,vacunas,otros;
      //Patologicos prenatales
      String embarazo,medicamento,complicacion,seguro,ultimaVisita,motivoUltimaVisita,
               alergia,discapacidad,coagulacion,medicamentosActuales,cirugias,sNervioso,
               transfuciones,sCardiovascular,sMuscular,sHematologico,sEsqueletico,
               aRespiratorio,sEndocrino,aDigestivo,aLocomotor,sTegumentario,aCirculatorio,
               otros2;
      //Patologicos Familiares
      String cancer,diabetes,hipertension,hepatitis,infancia="",otros3="";
      //Habitos Orales
      String pecho,biberon,vaso,bruxismo,onicofagia,queilofagia,digital,labial,lingual,cuticulas
                ,deglusion,respiracion2,carrillos,otros4;
      //Exploracion fisica
       String simetria,cicatrices,ganglios,lunares;
       //Antecedentes Orales
       String motivo,ultima,motivoUltima,experiencia,pasta,cantidadPasta;
        int habitosId=-1,exploracionId=-1,cepillo,ayer,hilo,enjuague;
       //Traumatismo
        String traumatismo ;
        /*Planos*/
        String planoDerecho="",planoIzq="";
        int relacionDerecho=0,relacionIzq=0;   
        /*Observaciones*/
        String tonificacion,amig,encia,carrillos2,sueloBoca,lengua,paladar,frenillos,otros5;    
        /*Examen Laboratorio*/
        String hematica,proto,trombo,otros6;  
        /*Perfil */
        imagen im ;
        /*Paciente*/
        String lugarNac,domicilio,colonia,ciudad;
        int [] referencia  = new int[11];
        /*Imagenes (radiografias) */
        ArrayList<imagen> radios = new ArrayList();
        /*Examen Radio*/
        ArrayList<examen> examenes = new ArrayList();
        ArrayList<InputStream> binarys = new ArrayList();
      
        boolean examen ;
        /*Indice Higiene*/
        ArrayList<indice> indices = new ArrayList();
        /*Indice H. Detalle*/
        ArrayList<indiceDetalle> indicesDetalle = new ArrayList();
        /*Actividades desarrolladas*/
        ArrayList<actividades> actividades = new ArrayList();
        /*Familiares*/
        ArrayList<familiar> familiares = new ArrayList();
        ArrayList<persona> personas = new ArrayList();
        /*odontogramaDetalle*/
        ArrayList<odontogramaDetalle> odontogramas = new ArrayList();
        
       
    public Operaciones(){
        this.c  = new Clase_Conexion("localhost","OdontOffice","postgres","lola00");
    }  
    public ResultSet getAll(){
        c.conectaBD();
        String sql ="SELECT px.id, person.nombre, person.apellido,person.fechaNacimiento, person.telefono, person.fechaInsert\n" +
"                   FROM personas person inner join pacientes px \n" +
"                   ON person.id=px.personaId";
        ResultSet r = c.ejecutaConsulta(sql);
        c.cerrarBD();   
        return r;
    }  
    public void guardar(MainFrame m){ 
        mf = m;
        if(!mf.sesion)
            return;
       c.conectaBD();
       String Nom  = m.exp.a.jTextField4.getText();
       String Ape  = m.exp.a.jTextField5.getText();
       String Tel  = m.exp.a.jTextField30.getText();
       Date fecha = m.exp.a.jDateChooser1.getDate();
       
       if(!Nom.equals("")&&!Ape.equals("")&&!Tel.equals("")&&fecha!=null){
             m.exp.a.jLabel22.setForeground(Color.BLACK);
             m.exp.a.jLabel10.setForeground(Color.BLACK);
             m.exp.a.jLabel11.setForeground(Color.BLACK);
             m.exp.a.jLabel13.setForeground(Color.BLACK);
            if(existe(Nom,Ape,fecha) == -1){
                if(!validarFamiliares(mf)){
                nuevo = true;
                InsertarNuevo(Nom,Ape,Tel);
                JOptionPane.showMessageDialog(mf,"Se guardó correctamente.");
                m.exp.a.click=false;
                }
                else{
                    JOptionPane.showMessageDialog(mf,"Llene los campos de los familiares.");
                }
                
            }
            else{
                if(!validarFamiliares(mf)){
                nuevo = false;
                update(existe(Nom,Ape,fecha),mf);
                InsertarNuevo(Nom,Ape,Tel);
                JOptionPane.showMessageDialog(mf,"Se guardaron los cambios correctamente.");
                m.exp.a.click=false;
                }
                else{
                    JOptionPane.showMessageDialog(mf,"Llene los campos de los familiares.");
                }
            }
           
       }
       else{
            JOptionPane.showMessageDialog(mf,"Llene los antecedentes obligatorios");
           if(Nom.equals("")){
               m.exp.a.jLabel10.setForeground(Color.red);
           }else  m.exp.a.jLabel10.setForeground(Color.black);
            if(Ape.equals("")){
                m.exp.a.jLabel13.setForeground(Color.red); 
           }else m.exp.a.jLabel13.setForeground(Color.black);
            if (Tel.equals("")){
                m.exp.a.jLabel22.setForeground(Color.red);
           }else  m.exp.a.jLabel22.setForeground(Color.black);
           if(fecha==null){
                m.exp.a.jLabel11.setForeground(Color.red);        
           }else m.exp.a.jLabel11.setForeground(Color.black);       
       }    
       c.cerrarBD();
    }
    public int existe(String n,String a,Date f){
        int id;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 
        String fe = sdf.format(f);  
        String sql = "select id from personas where nombre='"+n+"' and apellido='"+a+"' and fechaNacimiento='"+fe+"'";
        ResultSet rs = c.ejecutaConsulta(sql);
        try {
            while(rs.next()){
                id = rs.getInt("id");
                return id;
            }
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        return -1;
    } 
    public void InsertarNuevo(String no,String ap,String te){
        RecuperarDatos(no,ap,te); 
        //tabla Personas
        String sql1 = "insert into personas (nombre,apellido,fechanacimiento,"
                + "telefono,email,escolaridad,fechainsert,sexo) values ('"+n+"','"+a+"','"+fecha+"','"+t+"','"+em+"','"+e+"','"+new Date()+"','"+s+"')";
       c.ejecutaOperacion(sql1);
        //Insertar en tabla signos vitales()
        recuperarTablaSignosVitales();
        String sql2 = "insert into signos_vitales (talla,peso,temperatura,"
                + "presion,respiracion,pulso) values ('"+talla+"','"+peso+"','"+temp+"','"+presion+"','"+respiracion+"','"+pulso+"')";
        c.ejecutaOperacion(sql2);
        //Insertar antecedentes familiares
        recuperarTablaAntecedentesFamiliares();
         String sql3 = "insert into antecedentes_familiares (noPersonasCasa,tipoCasa,deporte,"
                + "alimentacion,mascota,riesgoSocioeconomico,vacunas,otros) values ("+personasCasa+",'"+tipoCasa+"','"+deporte+"','"+alimentacion+"','"+mascota+"','"+riesgo+"','"+vacunas+"','"+otros+"')";
       c.ejecutaOperacion(sql3);
       //antecedentes_patologicos_prenatales
       String sql4 = "insert into antecedentes_patologicos_prenatales "
               + "(embarazo,medicamentoEmbarazo,complicacionesEmbarazo,"
                + "seguroSocial,ultimaVisitaMedico,motivoUltimaVisita,alergia,discapacidad,coagulacion,"
               +"medicamentosactuales,cirugias,sNervioso,transfuciones,sCardiovascular,sMuscular,sHematologico,"
               + "sEsqueletico,aRespiratorio,sEndocrino,aDigestivo,aLocomotor,sTegumentario,aCirculatorio,otros ) "
               + "values ('"+embarazo+"','"+medicamento+"','"+complicacion+"','"+seguro+"','"+ultimaVisita+"','"+motivoUltimaVisita+"','"+alergia+"','"+discapacidad+"',"
               + "'"+coagulacion+"','"+medicamentosActuales+"','"+cirugias+"','"+sNervioso+"','"+transfuciones+"','"+sCardiovascular+
              "','"+sMuscular+"','"+sHematologico+"','"+sEsqueletico+"','"+aRespiratorio+"','"+sEndocrino+"','"+aDigestivo+
               "','"+aLocomotor+"','"+sTegumentario+"','"+aCirculatorio+"','"+otros2+"')";
       c.ejecutaOperacion(sql4);
     //antecedentes_patologicos_familiares
        String sql5 = "insert into antecedentes_patologicos_familiares "
               + "(cancer,diabetes,hipertension,hepatitis,Infancia,otro) values ('"+cancer+"','"+diabetes+"','"+hipertension+"','"+hepatitis+"','"+infancia+"','"+otros3+"')";
        c.ejecutaOperacion(sql5);
        //Tabla Habitos Orales
        String sql6 = "insert into habitos_orales"
               + "(pechoMaterno,biberon,vasoEntrenador,bruxismo,onicofagia,queilofagia,succionDigital"
                + ",succionLabial,succionLingual,cuticulas,deglusion,respiracion,carrillo,otros) "
                + "values ('"+pecho+"','"+biberon+"','"+vaso+"','"+bruxismo +"','"+onicofagia+"','"+queilofagia+"','"+digital+"','"
                + ""+labial+"','"+lingual+"','"+cuticulas+"','"+deglusion+"','"+respiracion2+"','"+carrillos+"','"+otros4+"')";
        c.ejecutaOperacion(sql6);
        //exploraciones_fisicas
       String sql7 = "insert into exploraciones_fisicas"
               + "(simetria,cicatricesLesiones,ganglios,lunares)"
                + "values ('"+simetria+"','"+cicatrices+"','"+ganglios+"','"+lunares +"')";       
        c.ejecutaOperacion(sql7);
        //Antecedentes orales
        habitosId = maxId("habitos_orales");
        exploracionId = maxId("exploraciones_fisicas");
      
        String sql10 = "insert into antecedentes_orales"
               + "(motivoConsulta,UltimaVisita,motivaUltimaVisita,experiencia,frecuenciaCepillado,frecuenciaCepilladoAyer"
                + ",hiloDental,enjuague,marcaPasta,cantidadPasta,habitosOralesId,exploracionFisicaId)"
                + "values ('"+motivo+"','"+ultima+"','"+motivoUltima+"','"+experiencia+"',"+cepillo+","+ayer+","+hilo+","+enjuague+","
                + "'"+pasta+"','"+cantidadPasta+"',"+habitosId+","+exploracionId+")"; 
        c.ejecutaOperacion(sql10);
        
        /*Traumatismos*/
        String sql11 = "insert into traumatismos(observaciones) values ('"+traumatismo+"')";
        c.ejecutaOperacion(sql11);
       
        /*Planos_Relación*/
        String sql12 = "insert into planos_relaciones(planoDerecho,planoIzquierdo,relacionDerecha,relacionIzquierda)"
                + " values ('"+planoDerecho+"','"+planoIzq+"','"+relacionDerecho+"','"+relacionIzq+"')";
        c.ejecutaOperacion(sql12);
        /*Observaciones*/
         String sql14 = "insert into observaciones"
               + "(tonificacionMuscula,amigdalas,encia,carrillos,sueloBoca,lengua"
                + ",paladar,frenillos,otros)"
                + "values ('"+tonificacion+"','"+amig+"','"+encia+"','"+carrillos2+"','"+sueloBoca+"','"+lengua+"','"+paladar+"','"+frenillos+"',"
                + "'"+otros5+"')"; 
        c.ejecutaOperacion(sql14);
       
        /*Laboratorio*/
        String sql15 = "insert into examenes_laboratorio (hematica,protombina,tromboplastina,otros)"
                + "values ('"+hematica+"','"+proto+"','"+trombo+"','"+otros6+"')";
        c.ejecutaOperacion(sql15);
        
        /*Perfiles*/
        if(nuevo && !mf.exp.a.click || nuevo && mf.exp.a.click || !nuevo && mf.exp.a.click){
             String sql16 = "insert into perfiles (imagen,titulo) values (?,?)";
        try{
                 PreparedStatement ps = c.conectaBD().prepareStatement(sql16);
                 ps.setBinaryStream(1,im.fis,im.longBytes);
                 ps.setString(2,im.titulo);
                 ps.execute();
                 ps.close();
        }catch(SQLException e){
            System.out.println("error al insertar imagen");
            }
        }
        
        /*PACIENTES*/
        if(nuevo && !mf.exp.a.click || nuevo && mf.exp.a.click || !nuevo && mf.exp.a.click)
            referencia[0] = maxId("perfiles");
        else referencia[0] = this.perfil;
        referencia[1] = maxId("personas");
        referencia[2] = maxId("signos_vitales");
        referencia[3] = maxId("antecedentes_familiares");
        referencia[4] = maxId("antecedentes_patologicos_prenatales");
        referencia[5] = maxId("antecedentes_patologicos_familiares");
        referencia[6] = maxId("antecedentes_orales");
        referencia[7] = maxId("observaciones");
        referencia[8] = maxId("traumatismos");
        referencia[9] = maxId("planos_relaciones");
        referencia[10] = maxId("examenes_laboratorio");
        
        String sql17 = "insert into pacientes(lugarNacimiento,domicilio,colonia,ciudad"
                + ",perfilId,personaId,signosVitalesId,antFam,antPatPre,antPatFam,antOral"
                + ",observacion,traumatismo,planosRelaciones,examenLab) values ('"+lugarNac+"','"+domicilio+"','"+colonia+"','"+ciudad+"'"
                + ","+referencia[0]+","+referencia[1]+","+referencia[2]+","+referencia[3]+""
                + ","+referencia[4]+","+referencia[5]+","+referencia[6]+","+referencia[7]+""
                + ","+referencia[8]+","+referencia[9]+","+referencia[10]+")";
        c.ejecutaOperacion(sql17);
         int paciente = maxId("pacientes");
        
        
        /*Examenes radiologicos*/
        /*
       
        for(int i=0;i<examenes.size();i++){
            try{
                String sqlRadio = "insert into examenes_radiologico (pacienteid,titulo,descripcion,titulo_imagen)"
                        + "values (?,?,?,?)";
                
                PreparedStatement ps = c.conectaBD().prepareStatement(sqlRadio);
                ps.setInt(1,paciente);
                ps.setString(2,examenes.get(i).t);
                ps.setString(3,examenes.get(i).d);
                ps.setString(4,examenes.get(i).t_im);
               // ps.setBinaryStream(5,examenes.get(i).f,examenes.get(i).l);
                ps.execute();
                String sqlUpdate = "update examenes_radiologico set imagen = ? where id = ?";
                ps = c.conectaBD().prepareStatement(sqlUpdate);
                ps.setBinaryStream(1,examenes.get(i).f, examenes.get(i).l);
                ps.setInt(2,maxId("examenes_radiologico"));
                ps.executeUpdate();
                
                ps.close();
            }
            catch(Exception e){System.out.println(e);
           
            }
        }*/
        
        
        
       /*Indice higiene*/ 
        int indicesId [] = new int[indices.size()];
        for(int i=0;i<indices.size();i++){
             String sql19 = "insert into indices_higiene_oral (pacienteId,fecha,Superior,Inferior,palatino"
                + ",lingual,total) values ("+paciente+",'"+indices.get(i).f+"',"+indices.get(i).VS+","+indices.get(i).VI+","
                     + ""+indices.get(i).P+","+indices.get(i).L+","+indices.get(i).T+")";
             c.ejecutaOperacion(sql19);
             indicesId[i] = maxId("indices_higiene_oral");
        }
        
        /*indices detalle*/
        for(int i=0;i<indicesDetalle.size();i++){
            String sql20 = "insert into indice_higiene_detalle (idIndice,pieza,carilla) values ("
                    + ""+indicesId[indicesDetalle.get(i).id]+","+indicesDetalle.get(i).p+","+indicesDetalle.get(i).c+")";
            c.ejecutaOperacion(sql20);
        }
        
        /*Actividades desarrolladas*/
        for(int i=0;i<actividades.size();i++){
            String sql21 = "insert into actividades_desarrolladas (fecha,titulo,cdId,pacienteId,descripcion)"
                    + "values ('"+actividades.get(i).f+"','"+actividades.get(i).t+"',"+actividades.get(i).cd+","+paciente+",'"+actividades.get(i).d+"')";
            c.ejecutaOperacion(sql21);
        }
        /*Familiares*/
        for(int i=0;i<familiares.size();i++){
            String sql22 = "insert into personas (nombre,apellido,fechaNacimiento,telefono,escolaridad,fechaInsert) "
                    + "values ('"+personas.get(i).n+"','"+personas.get(i).a+"','"+personas.get(i).fnac+"','"+personas.get(i).tel+"',"
                    + "'"+personas.get(i).es+"','"+new Date().toString()+"')";
            c.ejecutaOperacion(sql22);
            int p = maxId("personas");
            
            String sql23 = "insert into familiares (personaId,pacienteId,parentesco,ocupacion) "
                    + "values ("+p+","+paciente+",'"+familiares.get(i).p+"','"+familiares.get(i).o+"')  ";
            c.ejecutaOperacion(sql23);
            
        }
        
        /*Odontograma*/
        String sql24 = "insert into odontogramas (tipo,fecha,pacienteId) values ("+0+",'"+new Date()+"',"+paciente+")";
        c.ejecutaOperacion(sql24);
        
        /*Odontograma Detalle*/
        int odo = maxId("odontogramas");
        
        for(int i=0;i<odontogramas.size();i++){
            String sql25 = "insert into odontograma_detalle (idOdontograma,pieza,tratamiento,ausente) "
                    + "values("+odo+","+odontogramas.get(i).p+",'"+odontogramas.get(i).t+"',"+odontogramas.get(i).a+")";
            c.ejecutaOperacion(sql25);
        } 
    }
    public int tamanoTratamientos(){
        c.conectaBD();
        String sql1 = "Select count(*) as c from tratamientos";
        ResultSet rs1 = c.ejecutaConsulta(sql1);
        int tam = 0;
        try{
            rs1.next();
            tam = rs1.getInt("c"); 
        }catch(Exception e){
            System.out.println(e);
        }
        
        return tam;
    }
    public String []  traeTratamientos(int tam){
        c.conectaBD();
        String sql2 = "Select tratamiento as t from tratamientos order by  t asc";
        ResultSet rs2 = c.ejecutaConsulta(sql2);
        String Ve [] = new String[tam];
        int i=0;
        try{
            while(rs2.next()){
              Ve [ i ] = rs2.getString("t");
              i++;
            }
        }catch(Exception e){
        }
    
        return Ve;
    }   
    public void RecuperarDatos(String no,String ap,String te){
        recuperarTablaPersonas(no,ap,te);
        recuperarTablaSignosVitales();
        recuperarTablaAntecedentesFamiliares();
        recuperarPatologicosPrenatales();
        recuperarPatologicosFamiliares();
        recuperarHabitosOrales();
        recuperarExploracionFisica();
        recuperarAntecedentesOrales();
        recuperaTraumatismo();
        recuperarPlanos();
        recuperaObservaciones();
        recuperarLaboratorio();
        try {
            recuperaPerfil();
        } catch (FileNotFoundException ex) {
            
        }
        recuperaPaciente();
        recuperaexamenRadio();
        recuperaIndiceHigiene();
        recuperaIndiceDetalle();
        recuperaActividades();
        recuperaFamiliar();
        recuperaOdontogramaDetalle();
    }
    public void recuperarAntecedentesOrales(){
        motivo = mf.exp.a.jTextField49.getText();
        ultima =  mf.exp.a.jTextField46.getText();
        motivoUltima =  mf.exp.a.jTextField39.getText();
        experiencia =  mf.exp.a.jTextField42.getText();
        cepillo =  mf.exp.a.jTextField45.getText().equals("")?0:Integer.parseInt(mf.exp.a.jTextField45.getText());
        ayer =  mf.exp.a.jTextField47.getText().equals("")?0:Integer.parseInt(mf.exp.a.jTextField47.getText());
        hilo =  mf.exp.a.jTextField48.getText().equals("")?0:Integer.parseInt(mf.exp.a.jTextField48.getText());
        enjuague =  mf.exp.a.jTextField50.getText().equals("")?0:Integer.parseInt(mf.exp.a.jTextField50.getText());
        pasta = mf.exp.a.jTextField52.getText();
        cantidadPasta = mf.exp.a.jTextField51.getText();
 
    }
    public void recuperarExploracionFisica(){
       simetria = mf.exp.a.jTextArea1.getText().replaceAll("\n"," ");
       cicatrices = mf.exp.a.jTextArea2.getText().replaceAll("\n"," ");
       ganglios = mf.exp.a.jTextArea3.getText().replaceAll("\n"," ");
       lunares = mf.exp.a.jTextArea4.getText().replaceAll("\n"," ");
    }
    public void recuperarHabitosOrales(){
          pecho = mf.exp.a.jTextField53.getText();
        biberon = mf.exp.a.jTextField54.getText();
        vaso = mf.exp.a.jTextField55.getText();
        bruxismo = mf.exp.a.jTextField56.getText();
        onicofagia = mf.exp.a.jTextField57.getText();
        queilofagia = mf.exp.a.jTextField58.getText();
        digital = mf.exp.a.jTextField59.getText();
        labial = mf.exp.a.jTextField60.getText();
        lingual = mf.exp.a.jTextField61.getText();
        cuticulas = mf.exp.a.jTextField62.getText();
        deglusion = mf.exp.a.jTextField63.getText();
        respiracion2 = mf.exp.a.jTextField64.getText();
        carrillos = mf.exp.a.jTextField65.getText();
        otros4 = mf.exp.a.jTextField66.getText();
    }
    public void recuperarPatologicosFamiliares(){ 
       cancer =  mf.exp.a.jComboBox4.getSelectedIndex()==0?"": mf.exp.a.jComboBox4.getSelectedItem().toString();
       diabetes =  mf.exp.a.jComboBox11.getSelectedIndex()==0?"": mf.exp.a.jComboBox11.getSelectedItem().toString();
       hipertension =  mf.exp.a.jComboBox12.getSelectedIndex()==0?"": mf.exp.a.jComboBox12.getSelectedItem().toString();
       hepatitis =  mf.exp.a.jComboBox13.getSelectedIndex()==0?"": mf.exp.a.jComboBox13.getSelectedItem().toString();
          
    }
    public void recuperarPatologicosPrenatales(){
       embarazo = mf.exp.a.jTextField19.getText();
       medicamento = mf.exp.a.jTextField20.getText();
       complicacion =  mf.exp.a.jTextField16.getText();
       seguro = mf.exp.a.jTextField21.getText();
       ultimaVisita = mf.exp.a.jTextField13.getText();
       motivoUltimaVisita = mf.exp.a.jTextField14.getText();
       alergia = mf.exp.a.jTextField15.getText();
       discapacidad = mf.exp.a.jTextField22.getText();
       coagulacion = mf.exp.a.jTextField17.getText();
       medicamentosActuales = mf.exp.a.jTextField24.getText();
       cirugias = mf.exp.a.jTextField18.getText();
       sNervioso = mf.exp.a.jTextField23.getText();
       transfuciones = mf.exp.a.jTextField31.getText();
       sCardiovascular = mf.exp.a.jTextField25.getText();
       sMuscular = mf.exp.a.jTextField32.getText();
       sHematologico = mf.exp.a.jTextField26.getText();
       sEsqueletico = mf.exp.a.jTextField33.getText();
       aRespiratorio = mf.exp.a.jTextField27.getText();
       sEndocrino =  mf.exp.a.jTextField34.getText();
       aDigestivo =  mf.exp.a.jTextField28.getText();
       aLocomotor= mf.exp.a.jTextField35.getText();
       sTegumentario =  mf.exp.a.jTextField29.getText();
       aCirculatorio =  mf.exp.a.jTextField36.getText();
       otros2 = mf.exp.a.jTextField68.getText();
    }
    public void recuperarTablaAntecedentesFamiliares(){
        personasCasa = mf.exp.a.jTextField67.getText().equals("")?0:Integer.parseInt(mf.exp.a.jTextField67.getText());
        tipoCasa = mf.exp.a.jComboBox2.getSelectedItem().toString();
        deporte = mf.exp.a.jTextField10.getText();
        alimentacion = mf.exp.a.jTextField7.getText();
        mascota = mf.exp.a.jTextField11.getText();
        riesgo = mf.exp.a.jTextField8.getText();
        vacunas = mf.exp.a.jTextField12.getText();
        otros = mf.exp.a.jTextField9.getText();
    }
    public void recuperarTablaSignosVitales(){
        talla = mf.exp.a.jTextField43.getText();
        peso = mf.exp.a.jTextField44.getText();
        temp = mf.exp.a.jTextField37.getText();
        presion = mf.exp.a.jTextField38.getText();
        respiracion = mf.exp.a.jTextField40.getText(); 
        pulso = mf.exp.a.jTextField41.getText();
        
    }
    public void recuperarTablaPersonas(String no,String ap,String te){
       
        n=no;a=ap;t=te;
       em = "email-pendiente";
         fecha= mf.exp.a.jDateChooser1.getDate();
        
        
        if( mf.exp.a.jRadioButton3.isSelected() ||mf.exp.a.jRadioButton4.isSelected() )
            s = mf.exp.a.jRadioButton3.isSelected()?"M":"F";
        else    
            s = "";
        e = mf.exp.a.jComboBox8.getSelectedIndex()==0?"":mf.exp.a.jComboBox8.getSelectedItem().toString();
    }
    public void recuperaTraumatismo() {
      traumatismo = mf.exp.eo.jTextArea1.getText().replaceAll("\n","");  

    }
    public void recuperarPlanos(){

        if(mf.exp.pt.jRadioButton1.isSelected())
            planoDerecho = "PR";
        else if(mf.exp.pt.jRadioButton2.isSelected())
            planoDerecho = "EM";
        else if(mf.exp.pt.jRadioButton3.isSelected())
            planoDerecho = "ED";
        else if(mf.exp.pt.jRadioButton4.isSelected())
            planoDerecho = "EP";
        
        
        if(mf.exp.pt.jRadioButton5.isSelected())
            planoIzq = "PR";
        else if(mf.exp.pt.jRadioButton6.isSelected())
            planoIzq = "EM";
        else if(mf.exp.pt.jRadioButton7.isSelected())
            planoIzq = "ED";
        else if(mf.exp.pt.jRadioButton8.isSelected())
            planoIzq = "EP";
        
        if(mf.exp.pt.jRadioButton9.isSelected())
            relacionDerecho = 1;
        else if(mf.exp.pt.jRadioButton10.isSelected())
            relacionDerecho = 2;
        else if(mf.exp.pt.jRadioButton11.isSelected())
            relacionDerecho = 3;
        
         if(mf.exp.pt.jRadioButton12.isSelected())
            relacionIzq= 1;
        else if(mf.exp.pt.jRadioButton13.isSelected())
            relacionIzq = 2;
        else if(mf.exp.pt.jRadioButton14.isSelected())
            relacionIzq = 3;
           
        
        
        
    } 
    public void recuperaObservaciones(){
    
       
        tonificacion = mf.exp.eo.jTextArea2.getText().replaceAll("\n", " ");
        amig = mf.exp.eo.jTextArea3.getText().replaceAll("\n", " ");
        encia = mf.exp.eo.jTextArea4.getText().replaceAll("\n", " ");
        carrillos2 = mf.exp.eo.jTextArea5.getText().replaceAll("\n", " ");
        sueloBoca = mf.exp.eo.jTextArea6.getText().replaceAll("\n", " ");
        lengua = mf.exp.eo.jTextArea7.getText().replaceAll("\n", " ");
        paladar = mf.exp.eo.jTextArea8.getText().replaceAll("\n", " ");
        frenillos = mf.exp.eo.jTextArea9.getText().replaceAll("\n", " ");
        otros5 = mf.exp.eo.jTextArea10.getText().replaceAll("\n", " ");
        
    } 
    public void recuperarLaboratorio(){
        hematica = mf.exp.el.jTextField1.getText()+"";
        proto = mf.exp.el.jTextField2.getText()+"";
        trombo = mf.exp.el.jTextField3.getText()+"";
	otros6 = mf.exp.el.jTextField4.getText()+"";   
    }
    public void recuperaPerfil() throws FileNotFoundException{
        
        String t="";
        int l=0 ;
        FileInputStream f=null;
        if(nuevo && !mf.exp.a.click ){
            t = "";
            l = 0;
            f = null;
            
        }
        else if (nuevo && mf.exp.a.click || !nuevo && mf.exp.a.click){
            t = mf.exp.a.imagen.toString();
            l = mf.exp.a.longBytes;
            f = mf.exp.a.fis;
            System.out.println( mf.exp.a.fis+" "+mf.exp.a.longBytes);
            
        }
       
        im = new imagen (t,l,f);
        
    }
    public void recuperaPaciente(){
        
        lugarNac = mf.exp.a.jTextField6.getText()+"";
        domicilio  = mf.exp.a.jTextField1.getText()+"";
        colonia = mf.exp.a.jTextField2.getText()+"";
        ciudad = mf.exp.a.jTextField3.getText()+"";
              
       
    }
    public JComboBox llenaCombo(){
        c.conectaBD();
        JComboBox combo = new JComboBox();
        
        String sql = "select nombre,apellido from CD order by nombre";
        ResultSet rs = c.ejecutaConsulta(sql);
        try {
            while(rs.next()){
                combo.addItem(rs.getString("nombre")+" "+rs.getString("apellido"));
    
            }
        } catch (SQLException ex) {System.out.println(ex);}
        
        c.cerrarBD();
        return combo;
        
    }
    public void recuperaexamenRadio(){
      
        examenes.clear();
        for(int i=0;i<mf.exp.er.radiografias.size();i++){
                String t = mf.exp.er.radiografias.get(i).jTextField1.getText();
                String d = mf.exp.er.radiografias.get(i).jTextArea1.getText();
                String ti = mf.exp.er.radiografias.get(i).imagen==null?"":mf.exp.er.radiografias.get(i).imagen.toString();
                int l = mf.exp.er.radiografias.get(i).longBytes;
                FileInputStream f = mf.exp.er.radiografias.get(i).fis;
                examen e = new examen(t,d,ti,l,f);
                examenes.add(e);

        }

    }
    public int maxId(String tabla){
       String sql = "select max(id) as id from "+tabla;
       ResultSet rs =c.ejecutaConsulta(sql);
       int id;
        try {
            rs.next();
            id = rs.getInt("id");
                
        } catch (SQLException ex) {
           System.out.println(ex);
           id = -1;
        }
        return id;
    }
    public void addTratamiento(String tr){
        c.conectaBD();
        String sql1 = "insert into tratamientos (tratamiento) values ('"+tr+"')";    
        c.ejecutaOperacion(sql1);
        c.cerrarBD();
    }
    public void recuperaIndiceHigiene(){
        //Date f;
        Date fe;
        double VS,L,P,VI,T;
        
        if(mf.exp.eo.indice.size()==0){
            fe = new Date();
            VS =0.00;
            L=0.00;
            P=0.00;
            VI=0.00;
            T=0.00;
            indices.add(new indice(fe,VS,L,P,VI,T));
            return;
        }
        
        for(int i=0;i<mf.exp.eo.indice.size();i++){
            fe = mf.exp.eo.indice.get(i).jDateChooser1.getDate()==null?new Date():mf.exp.eo.indice.get(i).jDateChooser1.getDate();
            VS = Float.parseFloat(mf.exp.eo.indice.get(i).jTextField1.getText());
            L = Float.parseFloat(mf.exp.eo.indice.get(i).jTextField4.getText());
            P = Float.parseFloat(mf.exp.eo.indice.get(i).jTextField3.getText());
            VI = Float.parseFloat(mf.exp.eo.indice.get(i).jTextField2.getText());
            T = Float.parseFloat(mf.exp.eo.indice.get(i).jTextField5.getText());
            indices.add(new indice(fe,VS,L,P,VI,T));
          
        }
        
    }
    public void recuperaActividades(){
        
        
        for(int i=0;i<mf.exp.he.paneles.size();i++){
            String f,t,d,cd;
            int cdId = 0;
            f = mf.exp.he.paneles.get(i).jLabel1.getText();
            t = mf.exp.he.paneles.get(i).jLabel2.getText();
            d = mf.exp.he.paneles.get(i).t;
            
           String sql = "select id from cd where concat(nombre,' ',apellido) = '"+mf.exp.he.paneles.get(i).jLabel3.getText()+"'";
           ResultSet rs = c.ejecutaConsulta(sql);
           
            try {
                rs.next();
                cdId = rs.getInt("id");
            } catch (SQLException ex) {
                
            }
            actividades.add(new actividades(f,t,d,cdId));
        }
       
        
        
    }
    public void recuperaIndiceDetalle(){  
        if(mf.exp.eo.indice.isEmpty())
            return;
        for(int i=0;i<indices.size();i++)
             for(int j=0;j<14;j++){
                if(mf.exp.eo.indice.get(i).b1[j].b)
                    indicesDetalle.add(new indiceDetalle(i,mf.exp.eo.indice.get(i).b1[j].p,mf.exp.eo.indice.get(i).b1[j].c));
                
                if(mf.exp.eo.indice.get(i).b2[j].b)
                    indicesDetalle.add(new indiceDetalle(i,mf.exp.eo.indice.get(i).b2[j].p,mf.exp.eo.indice.get(i).b2[j].c));
                
                if(mf.exp.eo.indice.get(i).b3[j].b)
                    indicesDetalle.add(new indiceDetalle(i,mf.exp.eo.indice.get(i).b3[j].p,mf.exp.eo.indice.get(i).b3[j].c));
                
                if(mf.exp.eo.indice.get(i).b4[j].b)
                    indicesDetalle.add(new indiceDetalle(i,mf.exp.eo.indice.get(i).b4[j].p,mf.exp.eo.indice.get(i).b4[j].c));
                
        }
    }
    public void recuperaFamiliar(){    
        for(int i=0;i<mf.exp.a.familiares.size();i++){
            String n,a,fnac,tel,esc;
            n = mf.exp.a.familiares.get(i).jTextField1.getText();
            a = mf.exp.a.familiares.get(i).jTextField2.getText();
            fnac = mf.exp.a.familiares.get(i).jDateChooser1.getDate()==null?null:mf.exp.a.familiares.get(i).jDateChooser1.getDate().toString();
            tel = mf.exp.a.familiares.get(i).jTextField4.getText();
            esc = mf.exp.a.familiares.get(i).jComboBox4.getSelectedItem().toString();
            personas.add(new persona(n,a,fnac,tel,esc));
            String par,ocu;
            par = mf.exp.a.familiares.get(i).jComboBox9.getSelectedItem().toString();
            ocu = mf.exp.a.familiares.get(i).jTextField5.getText();
            familiares.add(new familiar(par,ocu));  
        } 
    }
    public boolean validarFamiliares(MainFrame mf){
        for(int i=0;i<mf.exp.a.familiares.size();i++){
            if(mf.exp.a.familiares.get(i).jDateChooser1.getDate()==null||mf.exp.a.familiares.get(i).jTextField1.getText().equals("")||mf.exp.a.familiares.get(i).jTextField2.getText().equals(""))
                return true;
        }
        return false;
    
    }
    public void recuperaOdontogramaDetalle(){
        int p = 0;
        String t = "";
        boolean a = false;
        boolean v1=false,v2=false;
        ArrayList<String> V = tratamientos();
        for(int i=0;i<16;i++){
            if(mf.exp.eo.odontograma1.dienteV1[i].ausente){
                p = Integer.parseInt(mf.exp.eo.odontograma1.dienteV1[i].jLabel1.getText());
                odontogramas.add(new odontogramaDetalle(p,"",true));
            }
            if(mf.exp.eo.odontograma1.dienteV4[i].ausente){
                p = Integer.parseInt(mf.exp.eo.odontograma1.dienteV4[i].jLabel1.getText());
                odontogramas.add(new odontogramaDetalle(p,"",true));
            }
            
            if(!mf.exp.eo.odontograma1.dienteV1[i].isEmpty() && !mf.exp.eo.odontograma1.dienteV1[i].ausente  || !mf.exp.eo.odontograma1.dienteV4[i].isEmpty() && !mf.exp.eo.odontograma1.dienteV4[i].ausente){
                for(int j=0;j<mf.exp.eo.odontograma1.dienteV1[i].checks.length;j++){
                    if(mf.exp.eo.odontograma1.dienteV1[i].checks[j].isSelected()){
                        p= Integer.parseInt(mf.exp.eo.odontograma1.dienteV1[i].jLabel1.getText());
                        t = V.get(j);
                        a = mf.exp.eo.odontograma1.dienteV1[i].ausente;
                        odontogramas.add(new odontogramaDetalle(p,t,a));
                    }
                    if(mf.exp.eo.odontograma1.dienteV4[i].checks[j].isSelected()){
                        p= Integer.parseInt(mf.exp.eo.odontograma1.dienteV4[i].jLabel1.getText());
                        t = V.get(j);
                        a = mf.exp.eo.odontograma1.dienteV4[i].ausente;
                        odontogramas.add(new odontogramaDetalle(p,t,a));
                    }    
                }
            }
        }
        for(int i=0;i<10;i++){
            
            if(mf.exp.eo.odontograma1.dienteV2[i].ausente){
                p = Integer.parseInt(mf.exp.eo.odontograma1.dienteV2[i].jLabel1.getText());
                odontogramas.add(new odontogramaDetalle(p,"",true));
            }
            if(mf.exp.eo.odontograma1.dienteV3[i].ausente){
                p = Integer.parseInt(mf.exp.eo.odontograma1.dienteV3[i].jLabel1.getText());
                odontogramas.add(new odontogramaDetalle(p,"",true));
            }
            
            if(!mf.exp.eo.odontograma1.dienteV2[i].isEmpty() && !mf.exp.eo.odontograma1.dienteV2[i].ausente || !mf.exp.eo.odontograma1.dienteV3[i].isEmpty() && !mf.exp.eo.odontograma1.dienteV3[i].ausente){
                for(int j=0;j<mf.exp.eo.odontograma1.dienteV2[i].checks.length;j++){
                    if(mf.exp.eo.odontograma1.dienteV2[i].checks[j].isSelected()){
                        p= Integer.parseInt(mf.exp.eo.odontograma1.dienteV2[i].jLabel1.getText());
                        t = V.get(j);
                        a = mf.exp.eo.odontograma1.dienteV2[i].ausente;
                        odontogramas.add(new odontogramaDetalle(p,t,a));
                    
                    }
                    if(mf.exp.eo.odontograma1.dienteV3[i].checks[j].isSelected()){
                        p= Integer.parseInt(mf.exp.eo.odontograma1.dienteV3[i].jLabel1.getText());
                        t = V.get(j);
                        a = mf.exp.eo.odontograma1.dienteV3[i].ausente;
                        odontogramas.add(new odontogramaDetalle(p,t,a));

                    }
                    
                }
            }
        }
        
    }
    public ArrayList tratamientos(){
        String sql = "select tratamiento from tratamientos order by tratamiento asc";
        ResultSet rs = c.ejecutaConsulta(sql);
        ArrayList<String> V = new ArrayList();
        try {
            while(rs.next())
                V.add(rs.getString("tratamiento"));
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        return V;
    }
    
    public void update(int idPersona,MainFrame m){
      String sql = "select pa.id as id from pacientes pa join personas pe on pa.personaId=pe.id where pe.id = "+idPersona ;
      ResultSet rs = c.ejecutaConsulta(sql);
       int paciente = 0;
        try {
            rs.next();
             paciente = rs.getInt("id");
        } catch (SQLException ex) {
           
        }
     /*delete*/
        /*odontograma detalle*/
     String sql1 = "delete from odontograma_detalle where idOdontograma = "
             + "(select id from odontogramas where pacienteId = "+paciente+")";
     c.ejecutaOperacion(sql1);
     /*odontograma*/
     String sql2 = "delete from odontogramas where pacienteId = "+paciente+"";
     c.ejecutaOperacion(sql2);
     /*familiares*/
     String sql3 = "delete from familiares where pacienteId = "+paciente;
     c.ejecutaOperacion(sql3);
     /*Actividades desarrolladas*/
     String sql4 = "delete from actividades_desarrolladas where pacienteId = "+paciente;
     c.ejecutaOperacion(sql4);
     
     /*Examen radiologico*/
     /*
      sql4 = "delete from examenes_radiologico where pacienteid="+paciente;
     c.ejecutaOperacion(sql4);
     */
     
     /*indice higiene detalle*/
      String sql26 = "select id from indices_higiene_oral where pacienteId = "+paciente;
      ResultSet rs4 = c.ejecutaConsulta(sql26);
        try {
            while(rs4.next()){
                String sql6 = "delete from indice_higiene_detalle where idIndice ="+rs4.getInt("id");
                c.ejecutaOperacion(sql6);
            } } catch (SQLException ex) {
            
        }
     /*indice de higiene*/
     String sql25 = "delete from indices_higiene_oral where pacienteId="+paciente;
     c.ejecutaOperacion(sql25);
    
     /*Aqui guardo todas las referencias del paciente*/
     String sql7 = "select * from pacientes where id="+paciente+" and personaid = "+idPersona;
     ResultSet rs1 = c.ejecutaConsulta(sql7);
     int exaLab=0,planosRel=0,traumatismo=0,observacion=0,antOral=0,antPatFam=0,antPatPre=0,antFam=0
             ,signosV=0,perfil=0;
     
        try {
            while(rs1.next()){
                exaLab = rs1.getInt("examenLab");
                planosRel = rs1.getInt("planosRelaciones");
                traumatismo = rs1.getInt("traumatismo");
                observacion = rs1.getInt("observacion");
                antOral = rs1.getInt("antOral");
                antPatFam = rs1.getInt("antPatFam");
                antPatPre = rs1.getInt("antPatPre");
                antFam = rs1.getInt("antFam");
                signosV = rs1.getInt("signosVitalesId");
                perfil = rs1.getInt("perfilId");
            }  } catch (SQLException ex) {
           
        }
         /*Borro paciente*/
        String sql8="delete from pacientes where id="+paciente;
        c.ejecutaOperacion(sql8);

        /*examen laboratorio*/
        String sql9="delete from examenes_laboratorio where id="+exaLab;
        c.ejecutaOperacion(sql9);
        /*planosRelaciones*/
        String sql10="delete from planos_relaciones where id="+planosRel;
        c.ejecutaOperacion(sql10);
        /*traumatismo*/
        String sql11="delete from traumatismos where id="+traumatismo;
        c.ejecutaOperacion(sql11);
         /*observaciones*/
        String sql12="delete from observaciones where id="+observacion;
        c.ejecutaOperacion(sql12);

        /*antecedentes orale*/
        String sql18 = "select habitosOralesId,exploracionFisicaId from antecedentes_orales where id="+antOral+"";
        ResultSet rs2 = c.ejecutaConsulta(sql18);
        int habitos = 0,exploraciones=0;
        try {
            while(rs.next()){
                habitos=rs.getInt("habitosOralesId");
                exploraciones=rs.getInt("exploracionFisicaId");
            }
        } catch (SQLException ex) {
           
        }
        String sql13="delete from antecedentes_orales where id="+antOral;
        c.ejecutaOperacion(sql13);
        /*habitos y exploracionFisica*/
        String sql19="delete from exploraciones_fisicas where id="+exploraciones;
        c.ejecutaOperacion(sql19);
        String sql20="delete from habitos_orales where id="+habitos;
        c.ejecutaOperacion(sql20);
        /*antecedentes_patologicos_familiares*/
        String sql14="delete from antecedentes_patologicos_familiares where id="+antPatFam;
        c.ejecutaOperacion(sql14);
        /*Antecedentes familiares*/
        String sql15="delete from antecedentes_familiares where id="+antFam;
        c.ejecutaOperacion(sql15);
        /*signos vitales*/
        String sql16="delete from signos_vitales where id="+signosV;
        c.ejecutaOperacion(sql16);
        
        /*perfiles*/
        if(nuevo && !mf.exp.a.click || nuevo && mf.exp.a.click || !nuevo && mf.exp.a.click){
            String sql17="delete from perfiles where id="+perfil;
            c.ejecutaOperacion(sql17);
        }
        else
           this.perfil=perfil;

        /*persona*/
        String sql24 = "delete from personas where id = "+idPersona;
        c.ejecutaOperacion(sql24);
        
    }

    public void mandarDatos(int idPaciente,MainFrame main) throws SQLException {
       
        
       main.pnl_contenedor.removeAll();
       main.pnl_contenedor.add(main.exp);
       main.revalidate();
       main.sesion=true;
       main.exp.a.jLabel10.setForeground(Color.black);
       main.exp.a.jLabel13.setForeground(Color.black);
       main.exp.a.jLabel22.setForeground(Color.black);
       main.exp.a.jLabel11.setForeground(Color.black);
       main.exp.a.jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos/photo.png")));
        
       c.conectaBD();
       
       /*tabla persona*/
        String sql1 = "select * from personas pe join pacientes pa on pe.id=pa.personaId where"
                + " pa.id ="+idPaciente;
        ResultSet rs1 = c.ejecutaConsulta(sql1);

           rs1.next();
           main.exp.a.jTextField4.setText(rs1.getString("nombre"));
           main.exp.a.jTextField5.setText(rs1.getString("apellido"));
           main.exp.a.jDateChooser1.setDate(rs1.getDate("fechaNacimiento"));
           main.exp.a.jTextField30.setText(rs1.getString("telefono"));
           for(int i=0;i<main.exp.a.jComboBox8.getItemCount();i++){
               if(main.exp.a.jComboBox8.getItemAt(i).toString().equals(rs1.getString("escolaridad"))){
                   main.exp.a.jComboBox8.setSelectedIndex(i);
                   break;
               }
           }
           if(rs1.getString("sexo").equals("M"))
                main.exp.a.jRadioButton3.setSelected(true);
           else
               main.exp.a.jRadioButton4.setSelected(true);
           
           /*signos vitales*/
           String sql2 = "select * from signos_vitales s join pacientes p on s.id=p.signosVitalesId where p.id = "+idPaciente;
           ResultSet rs2 = c.ejecutaConsulta(sql2);
           rs2.next();
           main.exp.a.jTextField43.setText(rs2.getString("talla"));
           main.exp.a.jTextField37.setText(rs2.getString("temperatura"));
           main.exp.a.jTextField40.setText(rs2.getString("respiracion"));
           main.exp.a.jTextField44.setText(rs2.getString("peso"));
           main.exp.a.jTextField38.setText(rs2.getString("presion"));
           main.exp.a.jTextField41.setText(rs2.getString("pulso"));
           
           
           /*Antecedentes Familiares*/
           String sql3 = "select * from antecedentes_familiares  a join pacientes p on a.id=p.antFam where p.id = "+idPaciente;
           ResultSet rs3 = c.ejecutaConsulta(sql3);
           rs3.next();
           main.exp.a.jTextField67.setText(rs3.getString("noPersonasCasa")+"");
           if( rs3.getString("tipoCasa").equals("Propia"))
              main.exp.a.jComboBox2.setSelectedIndex(0);
           else
              main.exp.a.jComboBox2.setSelectedIndex(1);
           main.exp.a.jTextField10.setText(rs3.getString("deporte"));
           main.exp.a.jTextField7.setText(rs3.getString("alimentacion"));
           main.exp.a.jTextField11.setText(rs3.getString("mascota"));
           main.exp.a.jTextField8.setText(rs3.getString("riesgoSocioeconomico"));
           main.exp.a.jTextField12.setText(rs3.getString("vacunas"));
           main.exp.a.jTextField9.setText(rs3.getString("otros"));
        
           /*antecedentes patologico prenatales*/
           String sql4= "select * from antecedentes_patologicos_prenatales  a join pacientes p on a.id=p.antPatPre where p.id = "+idPaciente;
           ResultSet rs4 = c.ejecutaConsulta(sql4);
           rs4.next();
           
           main.exp.a.jTextField19.setText(rs4.getString("embarazo"));
           main.exp.a.jTextField16.setText(rs4.getString("complicacionesEmbarazo"));
           main.exp.a.jTextField20.setText(rs4.getString("medicamentoEmbarazo"));
           main.exp.a.jTextField21.setText(rs4.getString("seguroSocial"));
           main.exp.a.jTextField13.setText(rs4.getString("ultimaVisitaMedico"));
           main.exp.a.jTextField14.setText(rs4.getString("motivoUltimaVisita"));
           main.exp.a.jTextField15.setText(rs4.getString("alergia"));
           main.exp.a.jTextField22.setText(rs4.getString("discapacidad"));
           main.exp.a.jTextField17.setText(rs4.getString("coagulacion"));
           main.exp.a.jTextField24.setText(rs4.getString("medicamentosactuales"));
           main.exp.a.jTextField18.setText(rs4.getString("cirugias"));
           main.exp.a.jTextField23.setText(rs4.getString("sNervioso"));
           main.exp.a.jTextField31.setText(rs4.getString("transfuciones"));
           main.exp.a.jTextField25.setText(rs4.getString("sCardiovascular"));
           main.exp.a.jTextField32.setText(rs4.getString("sMuscular"));
           main.exp.a.jTextField26.setText(rs4.getString("sHematologico"));
           main.exp.a.jTextField33.setText(rs4.getString("sEsqueletico"));
           main.exp.a.jTextField27.setText(rs4.getString("aRespiratorio"));
           main.exp.a.jTextField28.setText(rs4.getString("aDigestivo"));
           main.exp.a.jTextField34.setText(rs4.getString("sEndocrino"));
           main.exp.a.jTextField29.setText(rs4.getString("sTegumentario"));
           main.exp.a.jTextField35.setText(rs4.getString("aLocomotor"));
           main.exp.a.jTextField36.setText(rs4.getString("aCirculatorio"));
           main.exp.a.jTextField68.setText(rs4.getString("otros"));

          /*antecedentes_patologicos_familiares*/  
          String sql5= "select * from antecedentes_patologicos_familiares  a join pacientes p on a.id=p.antPatFam where p.id = "+idPaciente;
           ResultSet rs5 = c.ejecutaConsulta(sql5);
           rs5.next();
           
           for(int i=1;i<main.exp.a.jComboBox11.getItemCount()-1;i++){
               if(main.exp.a.jComboBox11.getItemAt(i).equals(rs5.getString("diabetes")))
                   main.exp.a.jComboBox11.setSelectedIndex(i);
               if(main.exp.a.jComboBox4.getItemAt(i).equals(rs5.getString("cancer")))
                   main.exp.a.jComboBox4.setSelectedIndex(i);
               if(main.exp.a.jComboBox12.getItemAt(i).equals(rs5.getString("hipertension")))
                   main.exp.a.jComboBox12.setSelectedIndex(i);
               if(main.exp.a.jComboBox13.getItemAt(i).equals(rs5.getString("hepatitis")))
                   main.exp.a.jComboBox13.setSelectedIndex(i);
               
           }
           
           /*Habitos orales*/
            String sql6= "select * from habitos_orales h join antecedentes_orales a  on h.id=a.habitosOralesId"
                    + " join pacientes p on a.id=p.antOral where p.id = "+idPaciente;
           ResultSet rs6 = c.ejecutaConsulta(sql6);
           rs6.next();
           
           main.exp.a.jTextField53.setText(rs6.getString("pechoMaterno"));
           main.exp.a.jTextField54.setText(rs6.getString("biberon"));
           main.exp.a.jTextField55.setText(rs6.getString("vasoEntrenador"));
           main.exp.a.jTextField56.setText(rs6.getString("bruxismo"));
           main.exp.a.jTextField57.setText(rs6.getString("onicofagia"));
           main.exp.a.jTextField58.setText(rs6.getString("queilofagia"));
           main.exp.a.jTextField59.setText(rs6.getString("succionDigital"));
           main.exp.a.jTextField60.setText(rs6.getString("succionLabial"));
           main.exp.a.jTextField61.setText(rs6.getString("succionLingual"));
           main.exp.a.jTextField62.setText(rs6.getString("cuticulas"));
           main.exp.a.jTextField63.setText(rs6.getString("deglusion"));
           main.exp.a.jTextField64.setText(rs6.getString("respiracion"));
           main.exp.a.jTextField65.setText(rs6.getString("carrillo"));
           main.exp.a.jTextField66.setText(rs6.getString("otros"));
           
           /*Exploraciones fisicas*/
            String sql7= "select * from exploraciones_fisicas h join antecedentes_orales a  on h.id=a.exploracionFisicaId"
                    + " join pacientes p on a.id=p.antOral where p.id = "+idPaciente;
           ResultSet rs7 = c.ejecutaConsulta(sql7);
           rs7.next();
           
           main.exp.a.jTextArea1.setText(rs7.getString("simetria"));
           main.exp.a.jTextArea2.setText(rs7.getString("cicatricesLesiones"));
           main.exp.a.jTextArea3.setText(rs7.getString("ganglios"));
           main.exp.a.jTextArea4.setText(rs7.getString("lunares"));
           
           /*Antecedentes orales*/
            String sql8= "select * from antecedentes_orales  a join pacientes p on a.id=p.antOral where p.id = "+idPaciente;
           ResultSet rs8 = c.ejecutaConsulta(sql8);
           rs8.next();
           
           main.exp.a.jTextField49.setText(rs8.getString("motivoConsulta"));
           main.exp.a.jTextField46.setText(rs8.getString("UltimaVisita"));
           main.exp.a.jTextField39.setText(rs8.getString("motivaUltimaVisita"));
           main.exp.a.jTextField42.setText(rs8.getString("experiencia"));
           main.exp.a.jTextField45.setText(rs8.getString("frecuenciaCepillado"));
           main.exp.a.jTextField47.setText(rs8.getString("frecuenciaCepilladoAyer"));
           main.exp.a.jTextField52.setText(rs8.getString("marcaPasta"));
           main.exp.a.jTextField51.setText(rs8.getString("cantidadPasta"));
           
           String hilo = rs8.getString("hiloDental");
           String en = rs8.getString("enjuague");
                   
           if(hilo.equals("0"))
                main.exp.a.jRadioButton2.setSelected(true);
           else
               main.exp.a.jRadioButton1.setSelected(true);
           if(en.equals("0"))
                main.exp.a.jRadioButton6.setSelected(true);
           else
               main.exp.a.jRadioButton5.setSelected(true);
           main.exp.a.jTextField48.setText(hilo);
           main.exp.a.jTextField50.setText(en);
       
           /*Traumatismos*/
           String sql9= "select * from traumatismos  a join pacientes p on a.id=p.traumatismo where p.id = "+idPaciente;
           ResultSet rs9 = c.ejecutaConsulta(sql9);
           rs9.next();
           
           main.exp.eo.jTextArea1.setText(rs9.getString("observaciones"));
           
           /*planos relaciones*/
           String sql10= "select * from planos_relaciones  a join pacientes p on a.id=p.planosRelaciones where p.id = "+idPaciente;
           ResultSet rs10 = c.ejecutaConsulta(sql10);
           rs10.next();
           
           switch(rs10.getString("planoDerecho")){
               case "PR": main.exp.pt.jRadioButton1.setSelected(true);
               
                   break;
               case "EM": main.exp.pt.jRadioButton2.setSelected(true);
              break;
               case "ED":  main.exp.pt.jRadioButton3.setSelected(true);
               break;
               case "EP":  main.exp.pt.jRadioButton4.setSelected(true);
              break;
           }
           switch(rs10.getString("planoIzquierdo")){
               case "PR": main.exp.pt.jRadioButton5.setSelected(true);
                   break;
               case "EM": main.exp.pt.jRadioButton6.setSelected(true); break;
               case "ED":  main.exp.pt.jRadioButton7.setSelected(true); break;
               case "EP":  main.exp.pt.jRadioButton8.setSelected(true);break;
           }
           switch(rs10.getString("relacionDerecha")){
               case "1": main.exp.pt.jRadioButton9.setSelected(true);
                   break;
               case "2": main.exp.pt.jRadioButton10.setSelected(true); break;
               case "3":  main.exp.pt.jRadioButton11.setSelected(true); break;
              
           }
           switch(rs10.getString("relacionIzquierda")){
               case "1": main.exp.pt.jRadioButton12.setSelected(true);
                   break;
               case "2": main.exp.pt.jRadioButton13.setSelected(true); break;
               case "3":  main.exp.pt.jRadioButton14.setSelected(true); break;
           }
           
           /*Observaciones*/
             
           String sql11= "select * from observaciones  a join pacientes p on a.id=p.observacion where p.id = "+idPaciente;
           ResultSet rs11 = c.ejecutaConsulta(sql11);
           rs11.next();
           
             main.exp.eo.jTextArea2.setText(rs11.getString("tonificacionMuscula"));
             main.exp.eo.jTextArea3.setText(rs11.getString("amigdalas"));
             main.exp.eo.jTextArea4.setText(rs11.getString("encia"));
             main.exp.eo.jTextArea5.setText(rs11.getString("carrillos"));
             main.exp.eo.jTextArea6.setText(rs11.getString("sueloBoca"));
             main.exp.eo.jTextArea7.setText(rs11.getString("lengua"));
             main.exp.eo.jTextArea8.setText(rs11.getString("paladar"));
             main.exp.eo.jTextArea9.setText(rs11.getString("frenillos"));
             main.exp.eo.jTextArea10.setText(rs11.getString("otros"));
           
          /*examen  laboratorio*/    
              String sql12= "select * from examenes_laboratorio   a join pacientes p on a.id=p.examenLab where p.id = "+idPaciente;
           ResultSet rs12 = c.ejecutaConsulta(sql12);
           rs12.next();
           
             main.exp.el.jTextField1.setText(rs12.getString("hematica"));
             main.exp.el.jTextField2.setText(rs12.getString("protombina"));
             main.exp.el.jTextField3.setText(rs12.getString("tromboplastina"));
             main.exp.el.jTextField4.setText(rs12.getString("otros"));
          
             /*Perfiles*/
             
            String sql13= "select a.imagen im from perfiles   a join pacientes p on a.id=p.perfilId where p.id = "+idPaciente;
           ResultSet rs13 = c.ejecutaConsulta(sql13);
           rs13.next();
           
           ImageIcon im ;
           InputStream is;
           
           is = rs13.getBinaryStream("im");

           if(is!=null){
        try {
            BufferedImage bi = ImageIO.read(is);
            im = new ImageIcon(bi);
             main.exp.a.jLabel12.setIcon(new ImageIcon(im.getImage().getScaledInstance(main.exp.a.jLabel12.getWidth(),main.exp.a.jLabel12.getHeight(),Image.SCALE_SMOOTH)));
        } catch (IOException ex) {
            
            }
        }
           /*PACIENTES*/
           String sql14= "select lugarNacimiento l,domicilio d,colonia c,ciudad ci from pacientes where id = "+idPaciente;
           ResultSet rs14 = c.ejecutaConsulta(sql14);
           rs14.next();
           
             main.exp.a.jTextField6.setText(rs14.getString("l"));
             main.exp.a.jTextField1.setText(rs14.getString("d"));
             main.exp.a.jTextField2.setText(rs14.getString("c"));
             main.exp.a.jTextField3.setText(rs14.getString("ci")); 
             
         /*TABLA Indicde de higiene*/  
          String sql15 = "select * from indices_higiene_oral where pacienteId = "+idPaciente;  
          ResultSet rs15 = c.ejecutaConsulta(sql15);
          int i=0;
          main.exp.eo.indice.removeAll(main.exp.eo.indice);
          main.exp.eo.jPanel3.removeAll();
          main.exp.eo.cntIndice=0;
          while(rs15.next()){
              
              main.exp.eo.nuevoIndice();
              main.exp.eo.validate();
              main.exp.eo.repaint();
              
              String s = rs15.getString("Superior").length()>9?rs15.getString("Superior").substring(0,9):rs15.getString("Superior");
              String in = rs15.getString("Inferior").length()>9?rs15.getString("Inferior").substring(0,9):rs15.getString("Inferior");
              String p = rs15.getString("palatino").length()>9?rs15.getString("palatino").substring(0,9):rs15.getString("palatino");
              String l = rs15.getString("lingual").length()>9?rs15.getString("lingual").substring(0,9):rs15.getString("lingual");
              String t = rs15.getString("total").length()>9?rs15.getString("total").substring(0,9):rs15.getString("total");
              
               main.exp.eo.indice.get(i).jDateChooser1.setDate(rs15.getDate("fecha"));
               main.exp.eo.indice.get(i).jTextField1.setText(s);
               main.exp.eo.indice.get(i).jTextField2.setText(in);
               main.exp.eo.indice.get(i).jTextField3.setText(p);
               main.exp.eo.indice.get(i).jTextField4.setText(l);
               main.exp.eo.indice.get(i).jTextField5.setText(t);
               i++;       
  
          }
          
          /*indices detalles
          */
          String sql16="select d.idindice,d.pieza,d.carilla from indice_higiene_detalle d join  indices_higiene_oral i on d.idindice=i.id join pacientes p on i.pacienteid=p.id where p.id="+idPaciente;
          ResultSet rs16 = c.ejecutaConsulta(sql16);
          i=0;
          int currentId = -1;
          if(rs16.next()){
              currentId=rs16.getInt("idindice");
               switch(rs16.getInt("carilla")){
                  case 1: 
                      main.exp.eo.indice.get(i).b1[ rs16.getInt("pieza") -1 ].b = true;
                      main.exp.eo.indice.get(i).b1[ rs16.getInt("pieza") -1 ].setBackground(new Color(51,51,255));
                      break;
                  case 2: 
                      main.exp.eo.indice.get(i).b2[ rs16.getInt("pieza") -1 ].b = true;
                      main.exp.eo.indice.get(i).b2[ rs16.getInt("pieza") -1 ].setBackground(new Color(51,51,255));
                      break;
                  case 3 : 
                      main.exp.eo.indice.get(i).b3[ rs16.getInt("pieza") -1 ].b = true;
                      main.exp.eo.indice.get(i).b3[ rs16.getInt("pieza") -1 ].setBackground(new Color(51,51,255));
                      break;
                  case 4: 
                      main.exp.eo.indice.get(i).b4[ rs16.getInt("pieza") -1 ].b = true;
                      main.exp.eo.indice.get(i).b4[ rs16.getInt("pieza") -1 ].setBackground(new Color(51,51,255));
                      break;       
              }
          }
          while(rs16.next()){
              if(currentId!=rs16.getInt("idindice")){
                  i++;
                  currentId=rs16.getInt("idindice");
              }
              switch(rs16.getInt("carilla")){
                  case 1: 
                      main.exp.eo.indice.get(i).b1[ rs16.getInt("pieza") -1 ].b = true;
                      main.exp.eo.indice.get(i).b1[ rs16.getInt("pieza") -1 ].setBackground(new Color(51,51,255));
                      break;
                  case 2: 
                      main.exp.eo.indice.get(i).b2[ rs16.getInt("pieza") -1 ].b = true;
                      main.exp.eo.indice.get(i).b2[ rs16.getInt("pieza") -1 ].setBackground(new Color(51,51,255));
                      break;
                  case 3 : 
                      main.exp.eo.indice.get(i).b3[ rs16.getInt("pieza") -1 ].b = true;
                      main.exp.eo.indice.get(i).b3[ rs16.getInt("pieza") -1 ].setBackground(new Color(51,51,255));
                      break;
                  case 4: 
                      main.exp.eo.indice.get(i).b4[ rs16.getInt("pieza") -1 ].b = true;
                      main.exp.eo.indice.get(i).b4[ rs16.getInt("pieza") -1 ].setBackground(new Color(51,51,255));
                      break;         
              }
          }
          /*mandar radiografias*/
          
          String sql17 = "select  id,pacienteid,titulo,descripcion,imagen from examenes_radiologico where pacienteid="+idPaciente;
          ResultSet rs17 = c.ejecutaConsulta(sql17);
          main.exp.er.radiografias.clear();
          main.exp.er.jPanel1.removeAll();
          main.exp.er.cntRadiografia=0;
          i = 0;
          if(rs17!=null)
          while(rs17.next()){

                main.exp.er.nuevoExamen();
                main.exp.er.jPanel1.validate();
                main.exp.er.jPanel1.repaint();
                main.exp.er.radiografias.get(i).jTextField1.setText(rs17.getString("titulo"));
                main.exp.er.radiografias.get(i).jTextArea1.setText(rs17.getString("descripcion"));

            is = rs17.getBinaryStream("imagen");

           if(is!=null){
            try {
            File f=new File("Archivo.txt");
            OutputStream salida=new FileOutputStream(f);
            byte[] buf =new byte[1024];
            int len;
            while((len=is.read(buf))>0){
                 salida.write(buf,0,len);
            }
             salida.close();
             is.close();
             int longBytes = (int)f.length();
             main.exp.er.radiografias.get(i).longBytes = longBytes;
             main.exp.er.radiografias.get(i).fis = new FileInputStream(f);
             f.deleteOnExit();
             f.delete();
                
                
            BufferedImage bi = ImageIO.read(rs17.getBinaryStream("imagen"));
            im = new ImageIcon(bi);
            main.exp.er.radiografias.get(i).jLabel3.setText("");
            main.exp.er.radiografias.get(i).jLabel3.setIcon(new ImageIcon(im.getImage().getScaledInstance(136,186,Image.SCALE_SMOOTH)));
             
        } catch (IOException ex) {
            System.out.println(ex+" error al cargar radiografia");
            }
        }
           i++;   
          }
        /*Mandar actividades*/
          String sql18 = "select fecha,titulo,cdId,descripcion from actividades_desarrolladas where pacienteid="+idPaciente;
          ResultSet rs18 = c.ejecutaConsulta(sql18); 
          
          main.exp.he.contenido.removeAll();
          
          if(rs18!=null)
              while(rs18.next()){
                  int n = main.exp.he.paneles.size();
                  SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
                  String fecha =  DATE_FORMAT.format(rs18.getDate("fecha"));
                  String sql = "select nombre,apellido from cd where id = "+rs18.getInt("cdId");
                  ResultSet rs = c.ejecutaConsulta(sql);
                  rs.next();
                  String cd = rs.getString("nombre")+" "+rs.getString("apellido");
                 
                  main.exp.he.paneles.add(new panelActividades(n,main.exp.he,fecha,rs18.getString("titulo"),cd,rs18.getString("descripcion")));
                  main.exp.he.contenido.add(main.exp.he.paneles.get(main.exp.he.paneles.size()-1));
                  main.exp.he.revalidate();
                  main.exp.he.repaint();

       }
          /*Mandar familiares*/
          String sqlFamiliares = "select personaid,parentesco,ocupacion from familiares where pacienteid = "+idPaciente;
          ResultSet rsFam = c.ejecutaConsulta(sqlFamiliares);
          i=0;
          main.exp.a.familiares.clear();
          main.exp.a.cntFamiliares = 0;
          main.exp.a.jPanel7.removeAll();
          if(rsFam!=null)
          while(rsFam.next()){
              String sqlPer  = "select nombre,apellido,fechanacimiento,telefono,escolaridad from personas where id = "+rsFam.getInt("personaid");
              ResultSet rsPer = c.ejecutaConsulta(sqlPer);
              rsPer.next();
              
              main.exp.a.nuevoFamiliar();
              main.exp.a.jPanel7.repaint();
              main.exp.a.jPanel7.validate();
              main.exp.a.familiares.get(i).jTextField1.setText(rsPer.getString("nombre"));
              main.exp.a.familiares.get(i).jTextField2.setText(rsPer.getString("apellido"));
              main.exp.a.familiares.get(i).jTextField5.setText(rsFam.getString("ocupacion"));
              main.exp.a.familiares.get(i).jTextField4.setText(rsPer.getString("telefono"));
              
              switch(rsFam.getString("parentesco")){
                  case "Madre": main.exp.a.familiares.get(i).jComboBox9.setSelectedIndex(0);break;
                  case "Padre": main.exp.a.familiares.get(i).jComboBox9.setSelectedIndex(1);break;
                  case "Tio" : main.exp.a.familiares.get(i).jComboBox9.setSelectedIndex(2);break;
                  case "Hermano": main.exp.a.familiares.get(i).jComboBox9.setSelectedIndex(3);break;
                  case "otro": main.exp.a.familiares.get(i).jComboBox9.setSelectedIndex(4);break;
                  default : main.exp.a.familiares.get(i).jComboBox9.setSelectedIndex(0);break;
                }
              switch(rsPer.getString("escolaridad")){
                  case "Kinder": main.exp.a.familiares.get(i).jComboBox4.setSelectedIndex(0);break;
                  case "Primaria": main.exp.a.familiares.get(i).jComboBox4.setSelectedIndex(1);break;
                  case "Secundaria" : main.exp.a.familiares.get(i).jComboBox4.setSelectedIndex(2);break;
                  case "Preparatoria": main.exp.a.familiares.get(i).jComboBox4.setSelectedIndex(3);break;
                  case "Profesional": main.exp.a.familiares.get(i).jComboBox4.setSelectedIndex(4);break;
                  default : main.exp.a.familiares.get(i).jComboBox4.setSelectedIndex(0);break;
                }
              main.exp.a.familiares.get(i).jDateChooser1.setDate(rsPer.getDate("fechanacimiento"));
              i++;
          }
          /*Mandar Odontograma*/
          String sqlOdo = "select id from odontogramas where pacienteid="+idPaciente;
          ResultSet rsOdo = c.ejecutaConsulta(sqlOdo);
          
          if(rsOdo!=null)
          while(rsOdo.next()){
              String detalle = "select pieza,tratamiento,ausente from odontograma_detalle where idOdontograma="+rsOdo.getInt("id");
              ResultSet rsDetalle = c.ejecutaConsulta(detalle);
              if(rsDetalle!=null)
                  while(rsDetalle.next()){
                      
                      //v1
                      if(rsDetalle.getInt("pieza")>=11 && rsDetalle.getInt("pieza")<=28){
                          for(int j=0;j<16;j++){
                              
                              if(rsDetalle.getInt("pieza") == Integer.parseInt(main.exp.eo.odontograma1.dienteV1[j].jLabel1.getText())){
                                  
                                  // esta ausente
                                  if(rsDetalle.getBoolean("ausente")){
                                      main.exp.eo.odontograma1.dienteV1[j].ausente=true;
                                      main.exp.eo.odontograma1.dienteV1[j].jLabel1.setForeground(Color.white);
                                      main.exp.eo.odontograma1.dienteV1[j].jLabel1.setOpaque(true);
                                      main.exp.eo.odontograma1.dienteV1[j].jCheckBoxMenuItem1.setSelected(true);
                                      main.exp.eo.odontograma1.dienteV1[j].changeUpdate();
                                      break;
                                  }
                                  else{
                                      for(int k=0;k<main.exp.eo.odontograma1.dienteV1[j].checks.length;k++){
                                          if(rsDetalle.getString("tratamiento").equals(main.exp.eo.odontograma1.dienteV1[j].checks[k].getText())){
                                              main.exp.eo.odontograma1.dienteV1[j].checks[k].setSelected(true);
                                              main.exp.eo.odontograma1.dienteV1[j].lista.add(rsDetalle.getString("tratamiento"));
                                              main.exp.eo.odontograma1.dienteV1[j].ausente=false;
                                              main.exp.eo.odontograma1.dienteV1[j].changeUpdate();
                                              main.exp.eo.odontograma1.dienteV1[j].pnlDientes.validaDientes();
                                              break;
                                          }
                                      }
                                     
                                  }
                              }
                          }
                      }
                      //v4
                      if(rsDetalle.getInt("pieza")>=31 && rsDetalle.getInt("pieza")<=48){
                          for(int j=0;j<16;j++){
                              
                              if(rsDetalle.getInt("pieza") == Integer.parseInt(main.exp.eo.odontograma1.dienteV4[j].jLabel1.getText())){
                                 
                                  // esta ausente
                                  if(rsDetalle.getBoolean("ausente")){
                                      main.exp.eo.odontograma1.dienteV4[j].ausente=true;
                                      main.exp.eo.odontograma1.dienteV4[j].jLabel1.setForeground(Color.white);
                                      main.exp.eo.odontograma1.dienteV4[j].jLabel1.setOpaque(true);
                                      main.exp.eo.odontograma1.dienteV4[j].jCheckBoxMenuItem1.setSelected(true);
                                      main.exp.eo.odontograma1.dienteV4[j].changeUpdate();
                                      break;
                                  }
                                  else{
                                      for(int k=0;k<main.exp.eo.odontograma1.dienteV4[j].checks.length;k++){
                                          if(rsDetalle.getString("tratamiento").equals(main.exp.eo.odontograma1.dienteV4[j].checks[k].getText())){
                                              main.exp.eo.odontograma1.dienteV4[j].checks[k].setSelected(true);
                                              main.exp.eo.odontograma1.dienteV4[j].lista.add(rsDetalle.getString("tratamiento"));
                                              main.exp.eo.odontograma1.dienteV4[j].ausente=false;
                                              main.exp.eo.odontograma1.dienteV4[j].changeUpdate();
                                              main.exp.eo.odontograma1.dienteV4[j].pnlDientes.validaDientes();
                                              break;
                                          }
                                      }
                                     
                                  }
                              }
                          }
                      
                      }
                      //v2
                      if(rsDetalle.getInt("pieza")>=51 && rsDetalle.getInt("pieza")<=65){
                          for(int j=0;j<10;j++){
                              
                              if(rsDetalle.getInt("pieza")==Integer.parseInt(main.exp.eo.odontograma1.dienteV2[j].jLabel1.getText())){
                                 
                                  // esta ausente
                                  if(rsDetalle.getBoolean("ausente")){
                                      main.exp.eo.odontograma1.dienteV2[j].ausente=true;
                                      main.exp.eo.odontograma1.dienteV2[j].jLabel1.setForeground(Color.white);
                                      main.exp.eo.odontograma1.dienteV2[j].jLabel1.setOpaque(true);
                                      main.exp.eo.odontograma1.dienteV2[j].jCheckBoxMenuItem1.setSelected(true);
                                      main.exp.eo.odontograma1.dienteV2[j].changeUpdate();
                                      break;
                                  }
                                  else{
                                      for(int k=0;k<main.exp.eo.odontograma1.dienteV2[j].checks.length;k++){
                                          if(rsDetalle.getString("tratamiento").equals(main.exp.eo.odontograma1.dienteV2[j].checks[k].getText())){
                                              main.exp.eo.odontograma1.dienteV2[j].checks[k].setSelected(true);
                                              main.exp.eo.odontograma1.dienteV2[j].lista.add(rsDetalle.getString("tratamiento"));
                                              main.exp.eo.odontograma1.dienteV2[j].ausente=false;
                                              main.exp.eo.odontograma1.dienteV2[j].changeUpdate();
                                              main.exp.eo.odontograma1.dienteV2[j].pnlDientes.validaDientes();
                                              break;
                                          }
                                      }
                                     
                                  }
                              }
                          }
                      }
                      //v3
                      if(rsDetalle.getInt("pieza")>=71 && rsDetalle.getInt("pieza")<=85){
                          for(int j=0;j<10;j++){
                              
                              if(rsDetalle.getInt("pieza")==Integer.parseInt(main.exp.eo.odontograma1.dienteV3[j].jLabel1.getText())){
                                 
                                  // esta ausente
                                  if(rsDetalle.getBoolean("ausente")){
                                      main.exp.eo.odontograma1.dienteV3[j].ausente=true;
                                      main.exp.eo.odontograma1.dienteV3[j].jLabel1.setForeground(Color.white);
                                      main.exp.eo.odontograma1.dienteV3[j].jLabel1.setOpaque(true);
                                      main.exp.eo.odontograma1.dienteV3[j].jCheckBoxMenuItem1.setSelected(true);
                                      main.exp.eo.odontograma1.dienteV3[j].changeUpdate();
                                      break;
                                  }
                                  else{
                                      for(int k=0;k<main.exp.eo.odontograma1.dienteV3[j].checks.length;k++){
                                          if(rsDetalle.getString("tratamiento").equals(main.exp.eo.odontograma1.dienteV3[j].checks[k].getText())){
                                              main.exp.eo.odontograma1.dienteV3[j].checks[k].setSelected(true);
                                              main.exp.eo.odontograma1.dienteV3[j].lista.add(rsDetalle.getString("tratamiento"));
                                              main.exp.eo.odontograma1.dienteV3[j].ausente=false;
                                              main.exp.eo.odontograma1.dienteV3[j].changeUpdate();
                                              main.exp.eo.odontograma1.dienteV3[j].pnlDientes.validaDientes();
                                              break;
                                          }
                                      }
                                     
                                  }
                              }
                          }
                      }
                  }
          }
          
          
          
                   
       c.cerrarBD();
    }
    
    public void nuevoCD(MainFrame m){
        c.conectaBD();
        String nom = m.configuraciones.txtNombre.getText();
        String ape = m.configuraciones.txtApellido.getText();
        String tel = m.configuraciones.txtTelefono.getText();
        boolean b = false;
        for(int i=0;i<tel.length();i++)
            if(tel.charAt(i) < 48 ||  tel.charAt(i) > 57){
                b = true;
                System.out.println(i);
            }
        
        if(nom.equals("") || ape.equals("") || tel.equals("") || b){
            JOptionPane.showMessageDialog(m,"Llene los datos correctamente");
            return;
        }
            
              
        
        String sql = "insert into CD (nombre,apellido,telefono) values ('"+nom+"','"+ape+"','"+tel+"')";
        c.ejecutaOperacion(sql);
        c.cerrarBD();
        JOptionPane.showMessageDialog(m,"Datos guardados");
        m.configuraciones.txtNombre.setText("");
        m.configuraciones.txtApellido.setText("");
        m.configuraciones.txtTelefono.setText("");
    }
   
    
}
