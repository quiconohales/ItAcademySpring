package com.init.paintingsShop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.init.paintingsShop.dto.Shop;

import com.init.paintingsShop.dto.Picture;
import com.init.paintingsShop.service.PictureServiceImpl;
import javax.persistence.EntityManager;
@RestController
@RequestMapping("/picture")
public class PictureController {
	
	@Autowired
	PictureServiceImpl pictureServiceImpl;
	

	//Afegir quadre: li donarem el nom del quadre i el del autor (POST /shops/{ID}/pictures)
	
	@PostMapping ("/post/shops/{shopid}")//{shop_id}
	public Picture savePicture (@PathVariable (value="shopid")Shop shopid,@RequestBody Picture picture) {
		if (picture.getPainter()== null) {
				picture.setPainter("Anonymous");
		}
		picture.setShop(shopid);
		return pictureServiceImpl.savePicture(picture);
	}
	
	
	// Llistar els quadres de la botiga (GET /shops/{ID}/pictures).
	
	@GetMapping("/get/shops/{id}/pictures")
	public List<Picture> listPicture(@PathVariable (value="id")Shop shopid){
		List<Picture> lista = new ArrayList<>();
		for (Picture picture:pictureServiceImpl.listPictures()) {
			if (picture.getShop().equals(shopid)) {
				//pictureServiceImpl.deletePicture(picture);
				lista.add(picture);
			}
		}
		return lista;
	
	}
	
	//Borrar tots els Cuadros de la botiga (DELETE /shops/{ID}/pictures).
	
	@DeleteMapping("/shops/{id}/pictures")
	public void deletePicture(@PathVariable(name = "id") Shop shopid) {
		for (Picture picture:pictureServiceImpl.listPictures()) {
			if (picture.getShop().equals(shopid)) {
				pictureServiceImpl.deletePicture(picture);
			}
		}

	}
	
}
