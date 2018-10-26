package metodosbanco;

import java.util.List;

import javax.print.attribute.standard.NumberOfDocuments;

public class AbmCuenta extends MetodosDeValidacionAbm{
	
	public int AddCuenta(String cuit) {
		 int retorno = 1 ;
		 if( cuit!=null ){
			 if( ValidarNumero(cuit)==true) {
				 //conexion a base de datos
				 
				 //setear automaticamente el dar de alta
				 retorno=0;
			 }
		 }
		 return retorno ;
	}
	
	/*public int RemoveCuenta(String cuit , String numeroDeCuenta) {
	int retorno=1;
	int i;
	if(cuit != null & numeroDeCuenta != null)
	{
		for(i= 0 ; i < recorrerBaseDeDatos ; i++)
		{
			if(cuit.equals(recorrerBaseDeDatosYCompararElDato) & numeroDeCuenta.equals(recorrerBaseDeDatosYCompararElDato))
			{
				cliente.get(i).Alta = 0;
			}
		}
	}
	return retorno;
	}*/
	
	public int ModifyAccount(String cuit , String numeroDeCuenta)
	{
		int retorno = 1;
		if(cuit != null & numeroDeCuenta != null)
		{
			if(ValidarNumero(cuit)==true & ValidarNumero(numeroDeCuenta) == true )
			{
				//modificar todo , menos el saldo
				// llevar a la base de datos
				retorno = 0;	
			}
		}
		return	retorno;
	}
	
	
	
	public int ModifySaldoDeLaCuenta(String cuit ,String numeroDeCuenta , String monto)
	{
		int retorno = 1;
		if(cuit != null & monto != null & numeroDeCuenta != null)
		{
			if(ValidarNumero(cuit)==true & ValidarNumero(numeroDeCuenta) &
				ValidarNumero(monto)==true & 
				Integer.parseInt(monto) > 50)
			{
				//recorrer para  ver si el cuit existe
				//modificar  saldo
				// llevar a la base de datos
				retorno = 0;	
			}
		}
		return	retorno;
	}
	
	
	public List<CuentasDeBancoProvincia> ListarCuentas() 
	{
		//recorrer la base de datos , y mostrarla
		
		
		return null;
	}
	
	public CuentasDeBancoProvincia BuscarUnaCuenta(String cuit,String numeroDeCuenta)
	{
		CuentasDeBancoProvincia retorno = null;
		int i;
		if(cuit != null & numeroDeCuenta != null)
		{
			/*recorrer la base de datos y  si el campo cuit de un cliente
			es igual a el cuit ingresado , entonces devolvemos el cliente
			y si lo encuentra  el valor de retorno cambia por el cliente 
			que si lo encontro cambiar a  reotrno se pone en 0
			*/
			
		}
		
		return retorno;
	}
	
	
	

}
