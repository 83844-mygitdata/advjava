package com.sunbeam.services;

import java.util.List;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;

public interface ProductService {
	public Product addNewProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductDetailsById(Long ProductId);

	public ApiResponse deleteProductById(Long ProductId);

	public ApiResponse updateProductById(Long ProductId, Product exisitingProduct);

}
