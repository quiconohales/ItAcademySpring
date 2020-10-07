package com.init.paintingsShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.init.paintingsShop.dto.Picture;
import com.init.paintingsShop.service.PictureServiceImpl;

@RestController
@RequestMapping("/picture")
public class PictureController {
	
	@Autowired
	PictureServiceImpl pictureServiceImpl;
	
	//Crear Cuadro
	//Afegir quadre: li donarem el nom del quadre i el del autor (POST /shops/{ID}/pictures)
	@PostMapping ("/post/shops/{shopid}")//{shop_id}
	public Picture savePicture (@PathVariable (value="shopid")Integer shopid,@Validated @RequestBody Picture picture) {
	//public Picture savePicture (@RequestParam (value="shop_id")Integer shop_id,@Validated @RequestBody Picture picture) {
		
		return pictureServiceImpl.savePicture(picture);
	
	
	}

//	 @PostMapping("tesista/{tesistaId}/asesor/{asesorId}/tesis")
//	    public Tesis createTesis(@PathVariable (value = "tesistaId") Integer tesistaId,@PathVariable (value = "asesorId") Integer asesorId,
//	                                 @Valid @RequestBody Tesis tesis) {
//	        this.tesis = tesis;
//	        tesistaRepositorio.findById(tesistaId).map(tesista -> {
//	            this.tesis.setTesista(tesista);
//	            return this.tesis;
//	        }).orElseThrow(() -> new ResourceNotFoundException("Tesista ","id",tesistaId));
//	        
//	        asesorRepositorio.findById(asesorId).map(asesor -> {
//	            this.tesis.setAsesor(asesor);
//	            return this.tesis;
//	        }).orElseThrow(() -> new ResourceNotFoundException("Asesor ","id",asesorId));
//	        
//	        return tesisRepositorio.save(tesis);
//	    }
	
	
	
	
	
	// Llistar els quadres de la botiga (GET /shops/{ID}/pictures).
	//Listar cuadros
	@GetMapping("/get/shops/{id}/pictures")
	public List<Picture> listPicture(@PathVariable (value="id")Integer id){
		
		
		return pictureServiceImpl.listPicturesbyShop(id);
		//return pictureServiceImpl.listPictures();
	}

	//Llistar els quadres de la botiga (GET /shops/{ID}/pictures).
	//Borrar Cuadros
	
}
