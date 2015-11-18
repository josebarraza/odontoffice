
package PaqueteLogica;

import java.io.FileInputStream;


public class imagen {
    String titulo;
    int longBytes;
    FileInputStream fis;
    
    public imagen(String t,int l, FileInputStream f){
        titulo=t;
        longBytes = l;
        fis = f;
    }
    
}
