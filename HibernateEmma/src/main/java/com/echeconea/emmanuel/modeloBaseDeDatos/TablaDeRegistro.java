package com.echeconea.emmanuel.modeloBaseDeDatos;
import java.io.File;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
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
	public int insertarDatosEnBaseDeDatos(String nombre , String apellido, String usuario, String contrasena) {
		int retorno=1;
		TablaDeRegistro objetoConAtributos = getDatos(nombre,apellido,usuario,contrasena);
		Session conexion = ConectarBaseDeDatos("/home/emmanuel/eclipse-workspace/HibernateEmma/src/main/resources/hibernate.cfg.xml");
		guardarDatosEnBaseDeDAtos(conexion,objetoConAtributos);
		CerrarConexionBaseDeDAtos(conexion);
		return retorno;
	}
	private TablaDeRegistro getDatos(String nombre , String apellido, String usuario, String contrasena) {
		TablaDeRegistro registro = new TablaDeRegistro();
		registro.setNombre(nombre);
		registro.setApellido(apellido);
		registro.setUsuario(usuario);
		registro.setContrasena(contrasena);
		return registro;
	}
	private Session ConectarBaseDeDatos(String rutaDeConfiguraciones) {
		// aca creamos la secion , la configuramos con lo que tenemos en nuestro documento hibernate.cfg.xml
		SessionFactory sessionFactory = new Configuration().configure(new File(rutaDeConfiguraciones))
                .buildSessionFactory();
    	Session secion = sessionFactory.openSession();
    	return secion;
	}
	private Session guardarDatosEnBaseDeDAtos(Session secion, TablaDeRegistro registro) {
		secion.beginTransaction();
        secion.save(registro);
        secion.getTransaction().commit();
        return secion;
	}
	private void CerrarConexionBaseDeDAtos(Session secion) {
		secion.close();
	}
}
