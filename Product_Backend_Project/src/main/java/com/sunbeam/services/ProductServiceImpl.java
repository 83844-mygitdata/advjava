package com.sunbeam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.dao.ProductDao;
import com.sunbeam.dto.ApiResponse;
import com.sunbeam.entities.Product;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product addNewProduct(Product product) {
		Product persistantProduct= productDao.save(product);
		
		return persistantProduct;
	}

	
	public List<Product> getAllProducts(){
		
		return productDao.findAll();
		
	}


	
	
	@Override
	public Product getProductDetailsById(Long ProductId) {
	
		return productDao.findById(ProductId).
				orElseThrow(() -> new ResourceNotFoundException("dds") );
	}


	@Override
	public ApiResponse deleteProductById(Long ProductId) {
		if(productDao.existsById(ProductId)) {
		 productDao.deleteById(ProductId);
		return new ApiResponse("product deleted");
		}else
			return new ApiResponse("product deleted failed");
		
		
	}


	@Override
	public ApiResponse updateProductById(Long ProductId , Product exisitingProduct) {
		
		String msg= "product update failed";
		
		if(productDao.existsById(ProductId)) {
			
			productDao.save(exisitingProduct);
			
			msg="updated successfully";
			
		}
		return new ApiResponse(msg);
		
		
		
	}
	
	
	
	
	
}
