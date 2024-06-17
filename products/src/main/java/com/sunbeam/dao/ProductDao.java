package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Products;


public interface ProductDao {
 String enterProd(Products product);
 Products getProductById(int Pid);
 
 List<Products> getProductbyCategoryAndPrice(double begin , double end, Category ProdCategory);
 String applyDiscount(double discount,Category ProdCategory);  

 List<Products> purchaseProduct(int id , int quantity);
 
// String deleteProduct(String name);
  String deleteByProdName(String name);
  
  String purchaseProduct(String name , int qty);
}
