package com.niit.Back.daoImpl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Back.dao.productDao;
import com.niit.Back.dto.Product;

@Repository("productdao")
@Transactional
public class productDaoImpl implements productDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public Product get(int pId) {

		try {
			return sessionfactory.getCurrentSession().get(Product.class, Integer.valueOf(pId));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {

		return sessionfactory.getCurrentSession()
				.createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionfactory.getCurrentSession().persist(product);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionfactory.getCurrentSession().update(product);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return false;
	}

	@Override
	public boolean delete(Product product) {

		try {
			product.setIs_active(false);
			return this.update(product);

		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return false;
	}

	@Override
	public List<Product> listActiveProduct() {
		String selectActiveProduct = "FROM Product WHERE is_active=:is_active";

		return sessionfactory.getCurrentSession()
				.createQuery(selectActiveProduct, Product.class)
				.setParameter("is_active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductByCategory(int cId) {
		String selectActiveProductByCategory = "FROM Product WHERE is_active=:is_active AND category_id=:category_id";

		return sessionfactory.getCurrentSession()
				.createQuery(selectActiveProductByCategory, Product.class)
				.setParameter("is_active", true)
				.setParameter("category_id", cId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		return sessionfactory.getCurrentSession()
				.createQuery("FROM Product WHERE is_active=:is_active ORDER BY pId ", Product.class)
				.setParameter("is_active", true)
				.setFirstResult(0).setMaxResults(count)
				.getResultList();
	}

	@Override
	public List<Product> getProductsByParam(String param, int count) {
	String query = "FROM Product WHERE is_active = true ORDER BY " + param + " DESC";
		
		return sessionfactory
					.getCurrentSession()
					.createQuery(query,Product.class)
					.setFirstResult(0)
					.setMaxResults(count)
					.getResultList();
					
		
	}

}
