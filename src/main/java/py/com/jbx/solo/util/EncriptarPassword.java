package py.com.jbx.solo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		var pass="Joserba84";
		var codificado=encoder.encode(pass);
		
		System.out.println("El pass BCrypt es: " + codificado);
	}
	
	public static String encriptarPassword(String password) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		
		return encoder.encode(password);
	}

}
