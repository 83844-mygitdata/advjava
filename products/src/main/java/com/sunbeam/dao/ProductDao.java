package com.sunbeam.dao;

import com.sunbeam.entities.Products;

public interface ProductDao {
 String enterProd(Products product);
 Products getProductById(int Pid);
 }
