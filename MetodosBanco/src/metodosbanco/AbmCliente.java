package metodosbanco;

import java.util.List;

public class AbmCliente extends MetodosDeValidacionAbm {
	

	public int AddCliente(String nombre,String apellido,String contraseña,
			String documento,String cuit) {
		 int retorno = 1 ;
		 if(nombre!=null & apellido!=null & contraseña!=null & documento != null &
				 cuit != null){
			 if(ValidarString(nombre)==true & ValidarString(apellido)==true &
				ValidarContraseña(contraseña)==true & documento.length()<=8 &
				ValidarNumero(documento)==true & ValidarNumero(cuit)==true &
				cuit.length()==11) {
				 //conexion a base de datos
				 //hay que  setearle automaticmaente el dar de alta
				 retorno=0;
			 }
		 }
		 return retorno ;
	}
	
	/*public int RemoveCliente(String cuit) {
		int retorno=1;
		int i;
		if(cuit != null)
		{
			for(i= 0 ; i < recorrerBaseDeDatos ; i++)
			{
				if(cuit.equals(recorrerBaseDeDatos))
				{
					cliente.get(i).Alta = 0;
				}
			}
		}
		return retorno;
	}*/
	
	
	public int ModifyCliente(String cuitDeCliente ,String nombre,
			String apellido,String contraseña,String documento)
	{
		int retorno = 1;
		if(cuitDeCliente != null)
		{
			if(ValidarString(nombre)==true & ValidarString(apellido)==true &
				ValidarContraseña(contraseña)==true & documento.length()<=8 &
				ValidarNumero(documento)==true )
			{
				// llevar a la base de datos
				retorno = 0;	
			}
		}
		return	retorno;
	}
	
	
	public ClientesDelBancoProvincia BuscarPorCuitAUnCliente(String cuit)
	{
		ClientesDelBancoProvincia retorno = null;
		int i;
		if(cuit != null)
		{
			/*recorrer la base de datos y  si el campo cuit de un cliente
			es igual a el cuit ingresado , entonces devolvemos el cliente
			y si lo encuentra  el valor de retorno cambia por el cliente 
			*/
		}
		
		return retorno;
	}
	
	public List<ClientesDelBancoProvincia> ListarCuentas() 
	{
		//recorrer la base de datos , y mostrarla
		
		
		return null;
	}
	
	
	
	
	
	
}
