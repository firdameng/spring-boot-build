package com.lagou.service;

import com.lagou.mapper.ProductMapper;
import com.lagou.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;


	public void findAllProductM(){
		List<Product> allProductM = productMapper.findAllProductM();
		System.out.println(allProductM);
	}


	public void findAllProductS(){
		List<Product> allProductS = productMapper.findAllProductS();
		System.out.println(allProductS);
	}



}
