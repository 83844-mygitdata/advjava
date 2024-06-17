package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

public class ApplyDiscount {

	public static void main(String[] args) {

		try (SessionFactory sf = getFactory(); Scanner sc = new Scanner(System.in)) {
			// create dao instance
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter discount price and category");
			System.out.println(dao.applyDiscount(
					sc.nextDouble(), 
					Category.valueOf(sc.next().toUpperCase())) );
		} // JVM : sc.close() , sf.close() -> DBCP will be cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	}

