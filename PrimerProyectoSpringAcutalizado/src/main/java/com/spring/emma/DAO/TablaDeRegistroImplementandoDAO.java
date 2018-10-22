/*
 * preguntarle a SERGIO , si en la funcion findAllUsuarios  y findByName
 * esta bien que le pegue (vaya a buscar) a la tabla que esta mapeada con
 * la base de datos o si hay que pegarle a la base de datos directo.
 * 
 */

package com.spring.emma.DAO;

import java.util.List;

import com.spring.model.TablaDeRegistro;





//aca hereda la clase abstract para poder llevar  la session a todas las clases dao
//en todas las funciones esta GETSESSION eso es lo que traemos de la clase
//abstracta , para no estar  instanciado , le dejamos todo a SPRING.
public class TablaDeRegistroImplementandoDAO extends AbstractSession implements TablaDeRegistroDAO {

	/*llevar los datos  que quiero guardar a la base de datos .
	 *\param TablaDeRegistro usuario : pide como parametro un objeto de tipo
	 *tablaDeRegistro , el cual trae los datos de lo que vamos a llevar
	 *a la base de datos, este debe ser cambiado por la clase que contenga
	 *todos los atributos mapeados a la base de datos con Hibernate
	 *\return : no retorna nada 
	 */
	@Override
	public void saveTablaDeRegistro(TablaDeRegistro usuario) {
		
		getSession().persist(usuario);
	}
	
	
	/*guarda la respuesta de que si el ID que le pasamos existe , y si es
	 * diferente a null  ,  entonces borraremos a esa persona de la base
	 * de datos. de lo contrario no pasara nada
	 * 
	 */
	

	@Override
	public void deleteTablaDeRegistroById(long idUsuario) {
		TablaDeRegistro objetoUsuario = findById(idUsuario);
		
		if(objetoUsuario != null)
		{
			getSession().delete(idUsuario);
		}
		
		
		
	}
	
	

	/*actualiza los datos de una perosna en la base de datos
	 *\param TablaDeRegistro usuario : le pasamos como parametro un objeto
	 *de tipo TablaDeregistro para llevar a la base de datos
	 *\return : no retorna nada
	 */
	@Override
	public void updateTablaDeRegistro(TablaDeRegistro usuario) {
		
		
		getSession().update(usuario);
		
	}

	
	/*Trae todos los usuarios de la base de datos.
	 *en la parte de FROM , ponemos la clase donde esta todo mapeado
	 *ya que el query no va hacia la base de datos sino contra el objeto
	 *\return : retorna todo los usuarios de la BD
	 */
	@Override
	public List<TablaDeRegistro> findAllUsuarios() {
		
		return getSession().createQuery("from TablaDeRegistro").list();
	}
	
	
	/*recibe un ID , deberia validar si existe , y si existe bueno 
	 * devuelve el objeto en este caso de tipo TABLADEREGISTRo que debe
	 * ser cambiado por la clase mapeada con la base de datos
	 * \param long idUsuario : aqui va el id del usuario que deseamos buscar
	 * \return : recorta un objeto de tipo TablaDeRegistro 
	 */
	@Override
	public TablaDeRegistro findById(long idUsuario) {
		
		return (TablaDeRegistro)getSession().get(TablaDeRegistro.class, idUsuario);
	}
	
	
	/*en esta funcion vamos a usar HQL  , crearemos la consulta necesaria
	 * pegandole a la clase donde tengo mapeado y no a la base de datos directo
	 * en el query , ponemos :name para decirle que yo le voy a pasar algo 
	 * como parametro, y luego con .setParameter le decimos que donde este name
	 * lo cambie por lo que le pasare por parametro. y que nos traiga un unico resultado
	 * \param String name: le pasaremos un nombre para que haga un busqueda
	 * 
	 * \return : nos retorna un unico resultado
	 * 
	 */
	
	@Override
	public TablaDeRegistro findByName(String name) {
		
		return (TablaDeRegistro)getSession().createQuery(
				"from TablaDeRegistro where name= :name")
				.setParameter("name", name).uniqueResult();
	}
	
	
	

}
