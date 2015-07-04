package com.suntossh.data;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.suntossh.data.entities.Address;
import com.suntossh.data.entities.Bank;
import com.suntossh.data.entities.Credential;
import com.suntossh.data.entities.TimeTest;
import com.suntossh.data.entities.User;

public class Application {
	
	static Session session = HibernateUtil.getSessionFactory().openSession();
	

	
	public static void main_for_finance_user(String[] args) {

		Transaction transaction = session.beginTransaction();

		User user = new User();
			user.setBirthDate(getMyBirthDate());
			user.setCreatedBy("Santoshkumar");
			user.setCreatedDate(new Date());
			user.setEmailAddress("Suntossh.numerouno@gmail.com");
			user.setFirstName("Santosh");
			user.setLastName("Pandey");
			user.setLastUpdatedBy("Santosh");
			user.setLastUpdatedDate(new Date());

			user.setState("NJ");
			user.setCity("Jersey City");
			user.setUserAddressLine1("400 Vanilla Avnue");
			user.setUserAddressLine2("Grove St 6th Street");
			user.setZipCode("07306");
			
		Credential credential = new Credential();
			credential.setUserName("SuntosshUserName");
			credential.setPassword("Password");
			credential.setUser(user);
			
		session.save(credential);	
		
		
		transaction.commit();

		session.close();
	}
	
	public static Date getMyBirthDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,1984);
		calendar.set(Calendar.MONTH,6);
		calendar.set(Calendar.DATE,22);
		return calendar.getTime();
		
	}
	
	public static void main(String[] args) {

		main_for_finance_user(null);
	}
	
}
