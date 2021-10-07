package com.lagou.controller;


import com.lagou.config.RoutingWith;
import com.lagou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RoutingWith("master")
	@RequestMapping("/findAllProductM")
	public String findAllProductM(){
		/*String key = "master";
		RoutingDataSourceContext routingDataSourceContext = new RoutingDataSourceContext(key);*/
		productService.findAllProductM();
		return "master";
	}

	@RoutingWith("slave")
	@RequestMapping("/findAllProductS")
	public String findAllProductS(){
		/*String key = "slave";
		RoutingDataSourceContext routingDataSourceContext = new RoutingDataSourceContext(key);*/
		productService.findAllProductS();
		return "slave";
	}


}
