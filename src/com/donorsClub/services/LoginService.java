package com.donorsClub.services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import com.donorsClub.daos.UserDao;
import com.donorsClub.models.User;

public class LoginService {

	/**
	 * @author Sherif
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public User authorization(String email , String password)
	{
	
		UserDao ud=new UserDao();
		System.out.println("Entring Service method");
		return (User)ud.checkUser(email,hashMd5( password)); 
	}
	
public List<String> checkPassword (User user ,String oldPassword,String newPassword,String confirmPassword ) {
	
	List<String> msg=new ArrayList<>();

	if(!user.getPassword().equals(hashMd5(oldPassword)))
	{
		msg.add("Old password is not correct");
	}
	if(!newPassword.equals(confirmPassword))
	{
		msg.add("Passwords did not match");
	}

	return msg;	
}
public boolean UpdatePassword  (User user ,String newPassword,String confirmPassword ) {
	
	user.setPassword(hashMd5(newPassword));
	UserDao uDao=new UserDao();
	return uDao.update(user);
}
	
 public String hashMd5(String str){
		    
		    MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		    md.update(str.getBytes());
		    byte[] digest = md.digest();
		    String myHash = DatatypeConverter
		      .printHexBinary(digest);
		     
		    return myHash;
}

	
}
