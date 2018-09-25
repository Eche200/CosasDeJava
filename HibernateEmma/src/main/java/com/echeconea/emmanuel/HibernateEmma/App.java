package com.echeconea.emmanuel.HibernateEmma;
import java.util.List;

import com.echeconea.emmanuel.modeloBaseDeDatos.TablaDeRegistro;
public class App 
{
    public static void main( String[] args )
    {
    	TablaDeRegistro registro = new TablaDeRegistro();
        //registro.insertarDatosEnBaseDeDatos("maria", "siria", "potus", "camaron");
        /*List<TablaDeRegistro> miLista =registro.mostrarDatos();
        
        for(TablaDeRegistro i : miLista) {
        	System.out.println("\nnombre: " + i.getNombre());
        }*/
    	
    	registro.borrarDatos();
    }
}
