package com.sunbeam.tester;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

public class DeleteProduct {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory(); 
				Scanner sc = new Scanner(System.in)) {
			
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter product name for deleting the product details");
			System.out.println(dao.deleteByProdName(sc.next()));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}


}


