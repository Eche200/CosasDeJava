package com.echeconea.emmanuel.modeloBaseDeDatos;
import java.io.File;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
@Entity
@Table(name="hibernateRegistro")
public class TablaDeRegistro implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contrasena;
	public TablaDeRegistro() {	
	}
	public TablaDeRegistro(String nombre, String apellido, String usuario, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name="apellido")
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Column(name="usuario")
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Column(name="contrasena")
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
	public void borrarDatos() {
		Session conexion = ConectarBaseDeDatos("/home/emmanuel/eclipse-workspace/HibernateEmma/src/main/resources/hibernate.cfg.xml");
		Query consultaParaBorrar = conexion.getSession().createQuery("from TablaDeRegistro where nombre='rodrigo'");
		
		TablaDeRegistro objetoABorrar = (TablaDeRegistro) consultaParaBorrar.uniqueResult();
		
		
		
		borrarDatosEnBaseDeDAtos(conexion , objetoABorrar);
		
		CerrarConexionBaseDeDAtos(conexion);
		
		/*
		 * instanciar un objeto primero
		 * registro.borrarDatos(); esto va en el main
		 */
			
	}
	
	/*
	 * 
	 */
	public void modificarDatos() {
		Session conexion = ConectarBaseDeDatos("/home/emmanuel/eclipse-workspace/HibernateEmma/src/main/resources/hibernate.cfg.xml");
		Query modificando = conexion.getSession().createQuery("from TablaDeRegistro where nombre='juan'");
		
		TablaDeRegistro registro = new TablaDeRegistro();
		
		registro.setNombre("rodrigo");
		registro.setApellido("rodolfes");
		registro.setContrasena("1234");
		registro.setUsuario("picki");
		
		guardarDatosEnBaseDeDAtos(conexion , registro);
		
		CerrarConexionBaseDeDAtos(conexion);
		
		/*
		 * instanciar un objeto primero
		 * registro.modificarDatos(); esto va en el main
		 */
			
	}
	
	
	
	
	/*
	 * aca en el CRUD , es la letra R  de READ , osea leemo , traemos los datos de la base de datos que le dijimos
	 
	 */
	
	
	public List<TablaDeRegistro> mostrarDatos() {
		Session conexion = ConectarBaseDeDatos("/home/emmanuel/eclipse-workspace/HibernateEmma/src/main/resources/hibernate.cfg.xml");
		return conexion.getSession().createQuery("from TablaDeRegistro").list();
		/*
		 * instanciar un objeto primero
		 * List<TablaDeRegistro> miLista =registro.mostrarDatos();
        
        for(TablaDeRegistro i : miLista) {
        	System.out.println("\nnombre: " + i.getNombre());
        }
        
        esto va en el main 
		 */
			
	}
	
	/*
	 * aca en el CRUD , es la letra C de create , insertamos(creamos) objeto y lo mandmaos a la base de datos a sus lugares correspondientes
	 */
	
	public int insertarDatosEnBaseDeDatos(String nombre , String apellido, String usuario, String contrasena) {
		int retorno=0;
		TablaDeRegistro objetoConAtributos = getDatos(nombre,apellido,usuario,contrasena);
		Session conexion = ConectarBaseDeDatos("/home/emmanuel/eclipse-workspace/HibernateEmma/src/main/resources/hibernate.cfg.xml");
		guardarDatosEnBaseDeDAtos(conexion,objetoConAtributos);
		CerrarConexionBaseDeDAtos(conexion);
		return retorno;
		
		/*
		 * instanciar un objeto primero
		 * registro.insertarDatosEnBaseDeDatos("maria", "siria", "potus", "camaron"); esto va en el main
		 */
	}
	
	/* 
	 * obtenemos la informacion por parametros para luego llevar a la base de datos con otra funcion
	 */
	
	private TablaDeRegistro getDatos(String nombre , String apellido, String usuario, String contrasena) {
		TablaDeRegistro registro = new TablaDeRegistro();
		registro.setNombre(nombre);
		registro.setApellido(apellido);
		registro.setUsuario(usuario);
		registro.setContrasena(contrasena);
		return registro;
	}
	/*
	 * conectamos a la base de datos y dejamos abierto para al consulta
	 */
	private Session ConectarBaseDeDatos(String rutaDeConfiguraciones) {
		// aca creamos la secion , la configuramos con lo que tenemos en nuestro documento hibernate.cfg.xml
		SessionFactory sessionFactory = new Configuration().configure(new File(rutaDeConfiguraciones))
                .buildSessionFactory();
    	Session secion = sessionFactory.openSession();
    	return secion;
	}
	
	/*
	 * guardamos la informacion en la base de datos
	 */
	private Session guardarDatosEnBaseDeDAtos(Session secion, TablaDeRegistro registro) {
		secion.beginTransaction();
        secion.save(registro);
        secion.getTransaction().commit();
        return secion;
	}
	/*
	 * borra todo de una fila en una tabla
	 */
	
	
	private Session borrarDatosEnBaseDeDAtos(Session secion, TablaDeRegistro registro) {
		secion.beginTransaction();
        secion.delete(registro);
        secion.getTransaction().commit();
        return secion;
	}
	
	
	/*
	 * cerramos la conexion con la base de datos
	 */
	
	private void CerrarConexionBaseDeDAtos(Session secion) {
		secion.close();
	}
}
