package com.niit.Back.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Back.dao.userDao;
import com.niit.Back.dto.Address;
import com.niit.Back.dto.Cart;
import com.niit.Back.dto.User;


@Repository("userdao")
@Transactional
public class userDaoImpl implements userDao {
	
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public boolean addUser(User user) {
		
		try{
			sessionfactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception ex){
			//ex.printStackTrace();
			return false;
		}
	
	}

	@Override
	public boolean addAddress(Address address) {
		try{
			sessionfactory.getCurrentSession().persist(address);
			return true;
		}
		catch(Exception ex){
			//ex.printStackTrace();
			return false;
		}
		
	}

	

	@Override 
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try{
			return sessionfactory.getCurrentSession()
					.createQuery(selectQuery,User.class)
					.setParameter("email",email)
					.getSingleResult();
		}
		catch(Exception ex){
			//ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND billing = :billing";
		try{
			return sessionfactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("user", user)
					.setParameter("billing", true)
					.getSingleResult();
					
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddress(User user) {
		String selectQuery = "FROM Address WHERE user = :user AND shipping = :shipping";
		try{
			return sessionfactory.getCurrentSession()
					.createQuery(selectQuery, Address.class)
					.setParameter("user", user)
					.setParameter("shipping", true)
					.getResultList();
					
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public User get(User user) {
		try {			
			return sessionfactory.getCurrentSession().get(User.class, user);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public Address getAddress(Address address) {
		try {			
			return sessionfactory.getCurrentSession().get(Address.class, address);			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		try {			
			sessionfactory.getCurrentSession().update(address);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

}
