package com.echeconea.emmanuel.HibernateEmma;
import com.echeconea.emmanuel.modeloBaseDeDatos.TablaDeRegistro;
public class App 
{
    public static void main( String[] args )
    {
    	TablaDeRegistro registro = new TablaDeRegistro();
        registro.insertarDatosEnBaseDeDatos("Emmanuel", "Echeconea", "admin", "root");
    }
}
