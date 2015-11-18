
package PaqueteLogica;

import java.io.FileInputStream;
public class examen {
    
    public String t,d,t_im;
    int l;
    FileInputStream f;
    
    public examen(String t,String d,String t_im,int l, FileInputStream f){
        this.d=d;
        this.t=t;
        this.t_im=t_im;
        this.l=l;
        this.f=f;
        
    }
}
