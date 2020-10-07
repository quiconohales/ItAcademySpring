package com.init.paintingsShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.init.paintingsShop.dao.IShopDAO;
import com.init.paintingsShop.dto.Picture;
import com.init.paintingsShop.dto.Shop;
import com.init.paintingsShop.service.ShopServiceImpl;

@RestController
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	ShopServiceImpl shopServiceImpl;
	
	
	//Crear Botiga
	@PostMapping ("/post")
	public Shop saveShop(@RequestBody Shop shop) {
		return shopServiceImpl.saveShop(shop);
	
	}
	// Read /listar
	@GetMapping("/get")
	public ResponseEntity<List<Shop>> listShop() {
		return ResponseEntity.ok(shopServiceImpl.listShops());
	}


}
