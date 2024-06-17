package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;

import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.util.Scanner; 


public class addProduct {

	public static void main(String[] args) {
	try(SessionFactory sf = getFactory();
	Scanner sc = new Scanner(System.in)
			){ProductDao dao=new ProductDaoImpl();
			System.out.println("Enter Product details - Category Category , String Name, \r\n"
					+ "			Int Price, int available quantity\r\n"
					+ "			");
				
//	Refer - products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,product name(unique) , price , available quantity

			Products newProduct = new Products(Category.valueOf(sc.next().toUpperCase())
									,sc.next(), sc.nextInt(), sc.nextInt());	
			
			System.out.println(dao.enterProd(newProduct));
	} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}	

}
