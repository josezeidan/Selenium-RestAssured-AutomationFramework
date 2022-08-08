package api_automation.utils;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Base64;

public class Base64Utility {

	String password;
	String encrytptedPassword;
	
	
	

	public String encryptPassword(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
	

	public String decryptPassword(String encryptedPassword) {
		return new String(Base64.getDecoder().decode(encryptedPassword));
	}
	
	
	@Test
	public void encrypt() {
		password ="South123";
		System.out.println("Password: "+password);
		encrytptedPassword = encryptPassword(password);
		System.out.println("Encrypted password: "+encrytptedPassword);
	}
	
	
	@Ignore
	@Test
	public void decrypt() {
		encrytptedPassword ="V2VzdDEyMw==";
		System.out.println("Encrytpted Password : "+encrytptedPassword);
		System.out.println("Decrypted password: "+decryptPassword(encrytptedPassword));
	}
	
	
	
}
