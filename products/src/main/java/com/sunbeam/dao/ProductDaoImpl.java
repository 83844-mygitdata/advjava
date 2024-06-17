package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;


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

	@Override
	public List<Products> getProductbyCategoryAndPrice(double begin, double end, Category ProdCategory) {
		
		String jpql = "select p from Products p where p.price between :start and :end and p.category=:cat";
		List<Products> product = null;
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			product = session.createQuery(jpql, Products.class) 
					.setParameter("start", begin)
					.setParameter("end", end)
					.setParameter("cat", ProdCategory)
					.getResultList();
			
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		return product;
	}

	@Override
	public String applyDiscount(double discount,Category ProdCategory) {

		String msg = "Applying Discount Failed...";
		String jpql = "update Products p set p.price = p.price- :discnt where p.category = :cat";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			int rows = session.createQuery(jpql)
					.setParameter("discnt", discount)
					.setParameter("cat", ProdCategory)
					.executeUpdate();
			tx.commit();
			msg = "Discount Applied !!! " + rows + " Products Updated";
			
		} catch (RuntimeException e) {
			
			if(tx!=null)
				tx.rollback();
			throw e;
			
		}
		
		return msg;
	}

	@Override
	public List<Products> purchaseProduct(int id, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	

//	@Override
//	public List<Products> purchaseProduct(int id, int quantity) {
//		
//		String msg = "Cant buy at time :< ";
//		List<Products> product = null;
//		String jpql = " select p from Products p where p.id = :id and p.availableQuantity = :quan";
//	//"select new com.sunbeam.entities.Products(id,availableQuantity) from Products p where u.role=:rl";
//		
//		Products product = null;
//		Session session = getFactory().getCurrentSession()
//	
//		Transaction tx = session.beginTransaction();
//		
//		try {
//			product = session.get(Products.class, Pid);
//			tx.commit();
//			
//		} catch (RuntimeException e) {
//
//			if(tx!=null)
//				tx.rollback();
//			throw e;
//		}
//		return null;
	//}
	
//	@Override
//	public String deleteProduct(String name) {
//		String msg = "Deletion Failed";
//		Session session = getFactory().getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		
//		try {
//			Products product = session.get(Products.class, name);
//			if(product != null ) {
//				session.delete(product);
//				msg = "Deleted Successfully";
//			}
//			tx.commit();
//			
//		} catch (RuntimeException e) {
//
//			if(tx!=null)
//				tx.rollback();
//			throw e;
//		} 
//		
//		return msg;
//	}
//	
	
	public String deleteByProdName(String name) {
		String msg = "Delete failled" ;
		Products p=null;
		
		String jpql= "select p from Products p where p.name=:pn";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			p=	session.createQuery(jpql,Products.class).setParameter("pn", name).getSingleResult();
		session.delete(p);
		tx.commit();
		msg="delete sucessfully";
			
		}
		catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
			
		}
		
		
		return msg;
	}

	@Override
	public String purchaseProduct(String name, int qty) {
		String msg = "Cant purchae rn... :<";
		String jpql = "select p from Products p where name = :name";
		Products product = null;
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			product = session.createQuery(jpql, Products.class)
					.setParameter("name", name)
					.getSingleResult();
			
			if(product != null && product.getAvailableQuantity()>=qty) {
				product.setAvailableQuantity(product.getAvailableQuantity()-(qty));
				msg = "Successfully Purchased";
			}else
			{
				msg = "Product is not Available..  :(";
			}
			tx.commit();
		} catch (RuntimeException e) {
			
			if(tx!=null)
			throw e;
			
		}
		return msg;
	}
	
}
