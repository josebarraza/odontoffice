
package PaqueteLogica;
/**  @AUTOR Barraza **/ 
import java.sql.*; 
public class Clase_Conexion { 
    String cadena ; 
    Connection conexion = null;
    
    public Clase_Conexion(String servidor,String bd,String usuario,String pw){
          cadena = "jdbc:postgresql://"+servidor+"/"+bd+"?"+"user="+usuario+"&password="+pw;  
    }
    
    public Connection conectaBD( ){
        try{
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(cadena);
          
        }catch(Exception e){
          //  System.out.println("Error en la conexion con la base de datos");
        }
        //System.out.println("Buena conexion!!");
        return conexion;
    }
	//CERRAR CONEXIÓN
	public Connection cerrarBD(){
		try { 
			conexion.close(); 
			//System.out.println("Cerrando conexion  . . . . . Ok");
			} catch (SQLException ex) { System.out.println(ex); } 
		conexion=null; 
		return conexion;  
		}
	//Select
	public ResultSet ejecutaConsulta(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
          //  System.out.println("Consulta . . . . OK!");
        } catch (SQLException e) {
          /*  System.out.println("Error con: " + sql);
	     System.out.println("SQLException: " + e.getMessage());
             System.out.println(e);*/
            return null;
        }        return resultado;
    }
	//Insert, Update , Delete
	public void ejecutaOperacion(String sql) {
	        try {
                    Statement st = conexion.createStatement();
	            st.executeUpdate(sql);
                    
	        } catch (SQLException e) {
	            System.out.println("Error con: " + sql);
	            System.out.println("SQLException: " + e.getMessage());
                    System.out.println(e);
	        }
	       
	    }
	}

