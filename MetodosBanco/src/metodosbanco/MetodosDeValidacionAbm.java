package metodosbanco;

public abstract class MetodosDeValidacionAbm {
	
	
	public boolean ValidarString(String cadenaDeCaracteres) {
		boolean validado=false;
		int i;
		if(cadenaDeCaracteres !=null) {
			validado=true;
			for(i=0;i<cadenaDeCaracteres.length();i++) {
				if(cadenaDeCaracteres.toLowerCase().charAt(i)<'a' ||
						cadenaDeCaracteres.toLowerCase().charAt(i)>'z') {
					validado=false;
					break;
				}
			}
		}
		return validado;
	}
	
	public boolean ValidarNumero(String numero) {
		boolean validado=false;
		int i;
		if(numero != null) {
			validado=true;
			for(i=0;i<numero.length();i++) {
				if(numero.charAt(i)>'9' || numero.charAt(i)<'0') {
					validado=false;
					break;
				}	
			}	
		}
		return validado;
	}

	public boolean ValidarFloat(String numeroFlotante) {
		boolean validado=false;
		int i;
		int puntos=0;
		if(numeroFlotante != null ) {
			validado=true;
			for(i=0;i<numeroFlotante.length();i++) {
				if(numeroFlotante.charAt(i)>'9' ||
					numeroFlotante.charAt(i)<'0' ||
					numeroFlotante.charAt(i)!='.' ||
					numeroFlotante.charAt(0)=='.') {
					validado=false;
					break;
				}else if(numeroFlotante.charAt(i)=='.') {
					puntos++;
					if(puntos>1) {
						validado=false;
						break;
					}
				}
			}
			
			if(puntos<1) {
				validado=false;
			}
		}
		return validado;
	}
	
	public boolean ValidarContraseña(String contrasena) {
		boolean validado=false;
		int i;
		int primeraLetraMayus=0;
		int cantNumeros=0;
		if(contrasena!=null & contrasena.length()>=8) {
				validado=true;
				for(i = 0 ; i < contrasena.length() ; i++ ) {
					if(contrasena.toLowerCase().charAt(i)<'a' ||
						contrasena.toLowerCase().charAt(i) > 'z'||
						contrasena.charAt(i)<'0' || contrasena.charAt(i)>'9') {
						validado=false;
						break;
					}else if(contrasena.charAt(0)>'A' &
							contrasena.charAt(0)<'Z' ) {
						primeraLetraMayus++;
					}else if(contrasena.charAt(i)>'0' &
							contrasena.charAt(i)<'9') {
						cantNumeros++;
					}
				}
				if(primeraLetraMayus < 1 || cantNumeros < 3) {
					validado=false;
				}
			}
		return validado;
	}

}
