package com.niit.Back.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Back.dao.categoryDao;
import com.niit.Back.dto.Category;

@Repository("categorydao")
@Transactional
public class categoryDaoImpl implements categoryDao {

	@Autowired
	private SessionFactory sessionfactory;

	private static List<Category> categories = new ArrayList<>();

	@Override
	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active= :active";
		Query q= sessionfactory.getCurrentSession().createQuery(selectActiveCategory);
		q.setParameter("active",true);
		
		return q.getResultList();
	}

	@Override
	public Category get(int cId) {
		return sessionfactory.getCurrentSession().get(Category.class, Integer.valueOf(cId));
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionfactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {

		try {
			sessionfactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {
			sessionfactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
