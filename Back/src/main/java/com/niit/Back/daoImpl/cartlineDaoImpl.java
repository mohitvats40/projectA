package com.niit.Back.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Back.dao.cartlineDao;
import com.niit.Back.dto.Cart;
import com.niit.Back.dto.cartLine;


@Repository("cartlinedao")
@Transactional
public class cartlineDaoImpl implements cartlineDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public cartLine get(int id) {
		return sessionfactory.getCurrentSession().get(cartLine.class, id);

	}

	@Override
	public boolean add(cartLine cartline) {
		try {
			sessionfactory.getCurrentSession().persist(cartline);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(cartLine cartline) {
		try {
			sessionfactory.getCurrentSession().update(cartline);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(cartLine cartline) {
		try {
			sessionfactory.getCurrentSession().delete(cartline);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<cartLine> list(int crId) {
		String query = "FROM cartLine WHERE crId = :crId";

		return sessionfactory.getCurrentSession().createQuery(query, cartLine.class).setParameter("crId", crId)
				.getResultList();
	}

	@Override
	public List<cartLine> listAvailable(int crId) {
		String query = "FROM cartLine WHERE crId = :crId AND is_available = :is_available";

		return sessionfactory.getCurrentSession().createQuery(query, cartLine.class).setParameter("crId", crId)
				.setParameter("is_available", true).getResultList();
	}

	@Override
	public cartLine getByCartAndProduct(int crId, int pId) {
		String query = "FROM cartLine WHERE crId = :crId AND product.pId = :pId";
		try {
			return sessionfactory.getCurrentSession().createQuery(query, cartLine.class).setParameter("crId", crId)
					.setParameter("pId", pId).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	@Override
	public boolean updateCart(Cart cart) {
	
		try{
			sessionfactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
		
	}
}
