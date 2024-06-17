package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Products;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;


public class ProductDaoImpl implements ProductDao {

	@Override
	public String enterProd(Products product) {
		
		String msg = "Cant add product";
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			Serializable prodId = session.save(product);
			
			tx.commit();
			msg="Product added successfully" + prodId;
			
			
		} catch (RuntimeException e) {
			
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		
		return msg;
	}

	@Override
	public Products getProductById(int Pid) {

		Products product = null;
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			product = session.get(Products.class, Pid);
			tx.commit();
			
			
		} catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return product;
	}
	
	

}
