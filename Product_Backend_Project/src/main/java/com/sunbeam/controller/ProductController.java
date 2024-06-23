package com.sunbeam.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dto.ApiResponse;

import com.sunbeam.entities.Product;
import com.sunbeam.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	@Operation(description = "Create New product")
	public ResponseEntity<?> addProduct(@RequestBody Product newProduct) {
		System.out.println("in add Product " + newProduct);
		try {

			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addNewProduct(newProduct));

		} catch (RuntimeException e) {

			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}

	
	@GetMapping
	public ResponseEntity<?> getAllProduct() {

		try {
			return ResponseEntity.ok(productService.getAllProducts());
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));

		}

	}

	@GetMapping("/{pId}")
	public ResponseEntity<?> getProductById(@PathVariable Long pId) {

		try {
			return ResponseEntity.ok(productService.getProductDetailsById(pId));

		} catch (RuntimeException e) {
			System.out.println("e");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));

		}

	}
	
	@DeleteMapping("/{pId}")
	public ResponseEntity<?> deleteProductById(@PathVariable Long pId){
		try {
			return ResponseEntity.ok(productService.deleteProductById(pId));
			
		}
		catch (RuntimeException e) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
			
		}
	}
	
	
	
	
	@PutMapping("/{pId}")
	public ResponseEntity<?>UpdateProduct(@PathVariable Long pId, @RequestBody Product product) {
		System.out.println("in update"+ pId + product);
		
	
		
		return ResponseEntity
				.ok(productService
						.updateProductById(pId, product));
		
	}
	
	
	

}
