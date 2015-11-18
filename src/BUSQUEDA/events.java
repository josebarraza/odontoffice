/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUSQUEDA;

import PaqueteLogica.Clase_Conexion;
import java.sql.*;
import javax.swing.JPanel;

/**
 *
 * @author LUPITHAG
 */
public class events {
    Clase_Conexion c;
    
    public events(){
       c = new Clase_Conexion("localhost","OdontOffice","postgres","lola00");
    }
    
   public ResultSet getAllQuery() throws SQLException{
        
      c.conectaBD();
      ResultSet r = c.ejecutaConsulta("SELECT px.id, person.nombre, person.apellido,person.fechaNacimiento, person.telefono, person.fechaInsert\n" +
"                   FROM personas person inner join pacientes px \n" +
"                   ON person.id=px.personaId");
      c.cerrarBD();
      return r;
    }
    
    ResultSet filterSearch(String condition){
        c.conectaBD();
              ResultSet r = c.ejecutaConsulta("SELECT px.id, person.nombre, person.apellido,person.fechaNacimiento, person.telefono, person.fechaInsert\n" +
"                   FROM personas person inner join pacientes px \n" +
"                   ON person.id=px.personaId \n"              
                    +condition);
              
        c.cerrarBD();
        return r;
    }
  
}
