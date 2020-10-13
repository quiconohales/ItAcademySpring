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
	public List<Picture> listPicture(@PathVariable (value="id")Integer id){
		
		
		
		
		
		//  @Query("select c from picture c where c.shop = :id")
		//  Customer findByEmail(String email);
		  
		
		//return pictureServiceImpl.listPicturesbyShop(email);
		return pictureServiceImpl.listPictures();
	}
	
	
	//Borrar tots els Cuadros de la botiga (DELETE /shops/{ID}/pictures).
	
	@DeleteMapping("/shops/{id}/pictures")
	public void deletePicture(@PathVariable(name = "id") Shop shopid) {
		//List<Picture> lista = new ArrayList<>();
		//lista=pictureServiceImpl.listPictures();
	//	List<Picture> listacoincidente = new ArrayList<>();
		for (Picture picture:pictureServiceImpl.listPictures()) {
			if (picture.getShop().equals(shopid)) {
				pictureServiceImpl.deletePicture(picture);
			}
		}
		
//		
//			@Query("select c from picture c where c.shop = :id");
//			Customer findByEmail(String email);
//		  
//			 Query query = createQuery( "Select e " + "from Employee e " + "ORDER BY e.ename ASC" );
//		      List<Employee> list=(List<Employee>)query.getResultList( );
//		pictureServiceImpl.deleteAllPictureByShop(shopid);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	@GetMapping("/get/position/{enum}")
//	public ResponseEntity<List<Employee>> employeePOSITIONALL(@PathVariable(name = "enum") Integer jobenum) {
//	
//		ArrayList<Employee> listemployee;
//		ArrayList<Employee> employeePOSITION = new ArrayList();
//
//		listemployee = employeeServiceImpl.employeePOSITIONALL();
//		for (int i = 0; i < listemployee.size(); i++) {
//			// if (listemployee.get(i).getJobenum().name()==jobenum) {
//			if (listemployee.get(i).getJobenum().ordinal() == jobenum) {
//				employeePOSITION.add(listemployee.get(i));
//			}
//		}
/////		El Siguiente codigo se comenta ya que no es necesario comprobar si hay registros ,con la respuesta standar es suficiente
////		if (employeePOSITION.isEmpty()) {
////			return new ResponseEntity<>(employeePOSITION,HttpStatus.I_AM_A_TEAPOT);//////   ;)
////		}
////		 else {
////			 return new ResponseEntity<>(employeePOSITION,HttpStatus.OK);
////		}
//	
//		return new ResponseEntity<>(employeePOSITION,HttpStatus.OK);
//}
*/
}
